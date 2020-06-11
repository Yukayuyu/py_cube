package common.util;

import java.util.*;
import dataObjects.Record;

public class getMap {
	public static Map<String, String> getDeptMap(List<Record> records) {
		Map<String, String> deptMap = new HashMap<String, String>();
		for (Record record : records) {
			deptMap.put(record.getDepartment_name(), record.getDepartment_id());
		}
		return deptMap;
	}

	public static Map<String, String> getPositionMap(List<Record> records) {
		Map<String, String> posMap = new HashMap<String, String>();
		for (Record record : records) {
			posMap.put(record.getPosition_name(), record.getPosition_id());
		}
		return posMap;
	}

	public static Map<String, String> getPplMap(List<Record> records) {
		Map<String, String> pplMap = new HashMap<String, String>();
		for (Record record : records) {
			pplMap.put(record.getEmployee_name(), record.getId());
		}
		return pplMap;
	}
}
