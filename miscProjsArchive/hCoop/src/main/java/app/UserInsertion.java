package app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import common.util.KeyIncrement;
import common.util.batchSort;
import common.util.getMap;
import dataObjects.Record;
import simpleBatis.RecordDAO;

/**
 * @author cc
 */
public class UserInsertion {
	/**
	 * txt部門名 -> 部門テーブル。重複チェック、記録がテーブルに既に存在する場合、部門IDをdataObjectに戻す。 存在しない場合はidを計算し、新しいrecordをinsertする。
	 * 
	 * @param records
	 */
	void insertMergeDepts(List<Record> records) {
		RecordDAO x = new RecordDAO();
		// DBに既存の部門情報を取り出す。
		// その結果をSortし、最も大きいなKeyを見つけ出す。
		List<Record> existingDepts = x.getAllRecordsFromTable("department");
		batchSort.sortByDeptIdAscend(existingDepts);
		final Map<String, String> deptsInfoFromDB;
		String biggestKey = null;
		String newKey = null;

		try {
			if (existingDepts.size() == 0) { // deptテーブルは空白の場合に、最初の行にD00, null をinsert
				Record line0 = new Record();
				newKey = "D00";
				line0.setDepartment_id(newKey);
				x.insertDepartment(line0); // insert
				existingDepts = x.getAllRecordsFromTable("department");
			}
		} finally {
			// <name, id> Mapを構築
			deptsInfoFromDB = getMap.getDeptMap(existingDepts);
		}

		// Find the departmentNames already Registered in the DB, then fetch and set their id.
		// 入力されたdataObjectsの部門名が登録済みの場合において、既知の部門idをそれらに設定する。
		List<Record> deptsRegistered = records.stream()
		        .filter(record -> deptsInfoFromDB.containsKey(record.getDepartment_name()))
		        .collect(Collectors.toList());
		for (Record record : deptsRegistered) {
			record.setDepartment_id(deptsInfoFromDB.get(record.getDepartment_name()));
		}

		// Find those NOT Registered, pull the Biggest Key and Increment it, set it as the newKey.
		// まだDBに未登録の部門名を発見した場合、それにKeyを付け、DB及びdataObjectsに登録する。
		List<Record> deptsNotRegistered = records.stream().filter(record -> !deptsRegistered.contains(record))
		        .collect(Collectors.toList());
		Set<String> newDeptNames = new HashSet<>(); // Remove redundancy.
		deptsNotRegistered.stream().forEach(record -> newDeptNames.add(record.getDepartment_name()));
		// Build <newDeptName, newDeptID> map.
		Map<String, String> newDeptNamesMap = new HashMap<>();
		// The Initial Biggest Key is the last element in the existingDepts list, since it was sorted by Key
		// e.g. in incremental key order (D01, D02..., D09, D12...).
		biggestKey = existingDepts.get(existingDepts.size() - 1).getDepartment_id();
		for (String newDeptName : newDeptNames) {
			biggestKey = KeyIncrement.deptKeyIncrement(biggestKey);
			newDeptNamesMap.put(newDeptName, biggestKey);
			// insert to the department table.
			Record record = new Record();
			record.setDepartment_id(biggestKey);
			record.setDepartment_name(newDeptName);
			x.insertDepartment(record);
		}
		// insert the generated id to the dataObjects.
		for (Record record : deptsNotRegistered) {
			record.setDepartment_id(newDeptNamesMap.get(record.getDepartment_name()));
		}
		// TODO Delete D00
	}

	void insertMergePos(List<Record> records) {
		RecordDAO x = new RecordDAO();
		final Map<String, String> possInfoFromDB;
		List<Record> existingPositions = x.getAllRecordsFromTable("position");
		batchSort.sortByPosIdAscend(existingPositions);
		String biggestKey = null;
		String newKey = null;

		try {
			if (existingPositions.size() == 0) {
				Record line0 = new Record();
				newKey = "E00";
				line0.setPosition_id(newKey);
				x.insertPosition(line0); // insert line0
				existingPositions = x.getAllRecordsFromTable("position");
			}
		} finally {
			// <name, id> build map
			possInfoFromDB = getMap.getPositionMap(existingPositions);
		}

		// 入力されたdataObjectsの職種名は既知の場合において、既知の職種idをそれらに設定する。
		List<Record> possRegistered = records.stream()
		        .filter(record -> possInfoFromDB.containsKey(record.getPosition_name())).collect(Collectors.toList());
		for (Record record : possRegistered) {
			record.setPosition_id(possInfoFromDB.get(record.getPosition_name()));
		}

		// Find those NOT Registered, pull the Biggest Key and Increment it, set it as the newKey.
		// まだDBに未登録の職種名を発見した場合、それにKeyを付け、DB及びdataObjectsに登録する。
		List<Record> possNotRegistered = records.stream().filter(record -> !possRegistered.contains(record))
		        .collect(Collectors.toList());
		Set<String> newPosNames = new HashSet<>(); // Remove redundancy.
		possNotRegistered.stream().forEach(record -> newPosNames.add(record.getPosition_name()));
		// Build <newDeptName, newDeptID> map.
		Map<String, String> newPossNamesMap = new HashMap<>();
		// The Initial Biggest Key is the last element in the existingDepts list, since it was sorted by Key
		// e.g. in incremental key order (D01, D02..., D09, D12...).
		biggestKey = existingPositions.get(existingPositions.size() - 1).getPosition_id();
		for (String newPosName : newPosNames) {
			biggestKey = KeyIncrement.posKeyIncrement(biggestKey);
			newPossNamesMap.put(newPosName, biggestKey);
			// insert to the position table.
			Record record = new Record();
			record.setPosition_id(biggestKey);
			record.setPosition_name(newPosName);
			x.insertPosition(record);
		}
		// insert the generated id to the dataObjects.
		for (Record record : possNotRegistered) {
			record.setPosition_id(newPossNamesMap.get(record.getPosition_name()));
		}
	}

	/**
	 * TODO 姓名＋誕生日で同一個人かどうかを判断する、今は姓名のみ
	 * 
	 * @param records
	 */
	void insertMergeEmployee(List<Record> records) {
		RecordDAO x = new RecordDAO();
		final Map<String, String> pplInfoFromDB;
		List<Record> existingEmployees = x.getAllRecordsFromTable("employee");
		batchSort.sortByIdAscend(existingEmployees);
		String biggestKey = null;
		String newKey = null;

		try {
			if (existingEmployees.size() == 0) {
				Record line0 = new Record();
				newKey = "E0000";
				line0.setId(newKey);
				x.insertPosition(line0); // insert line0
				existingEmployees = x.getAllRecordsFromTable("employee");
			}
		} finally {
			// <name, id> String id == map.get(name);
			pplInfoFromDB = getMap.getPplMap(existingEmployees);
		}

		// DBに該当職員はidが既存する場合、dataObjectにidを追加、
		// そして該当職員の新しい情報があればDBにUPDATEする
		List<Record> pplRegistered = records.stream()
		        .filter(record -> pplInfoFromDB.containsKey(record.getEmployee_name())).collect(Collectors.toList());
		for (Record record : pplRegistered) {
			record.setId(pplInfoFromDB.get(record.getEmployee_name()));
			x.updateEmployee(record);
		}

		// Find those NOT Registered, pull the Biggest Key and Increment it, set it as the newKey.
		// DBに未登録の職員名を含める記録をまとめる。
		List<Record> pplNotRegistered = records.stream().filter(record -> !pplRegistered.contains(record))
		        .collect(Collectors.toList());

		// HashMap で重複入力を処理. // Resolve redundancy.
		Set<String> newNames = new HashSet<>();
		pplNotRegistered.stream().forEach(record -> newNames.add(record.getEmployee_name()));
		Map<String, String> newNamesMap = new HashMap<>();
		// The Initial Biggest Key is the last element in the existingDepts list, since it was sorted by Key
		// e.g. in incremental key order (D01, D02..., D09, D12...).
		biggestKey = existingEmployees.get(existingEmployees.size() - 1).getId();
		for (String newName : newNames) {
			biggestKey = KeyIncrement.employeeIdIncrement(biggestKey);
			newNamesMap.put(newName, biggestKey);
		}
		// insert the generated id to the dataObjects.
		pplNotRegistered.stream().forEach(record -> record.setId(newNamesMap.get(record.getEmployee_name())));
		// 未登録者をDBに登録
		pplNotRegistered.stream().forEach(record -> x.insertEmployee(record));
	}
}
