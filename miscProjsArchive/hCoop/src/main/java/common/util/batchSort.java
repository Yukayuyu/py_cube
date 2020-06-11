package common.util;

import java.util.*;
import dataObjects.Record;

public class batchSort {
	public static void sortByDeptIdAscend(List<Record> existingDepts) {
		existingDepts.sort((dept1, dept2) -> {
			if (Integer.parseInt(dept1.getDepartment_id().substring(1)) > Integer .parseInt(dept2.getDepartment_id().substring(1))) {
				return 1;
			} else {
				return -1;
			}
		});
	}
	public static void sortByPosIdAscend(List<Record> existingPositions) {
		existingPositions.sort((pos1, pos2) -> {
			if (Integer.parseInt(pos1.getPosition_id().substring(1)) > Integer .parseInt(pos2.getPosition_id().substring(1))) {
				return 1;
			} else {
				return -1;
			}
		});
	}
	public static void sortByIdAscend(List<Record> existingEmployees) {
		existingEmployees.sort((ppl1, ppl2) ->{
			if (Integer.parseInt(ppl1.getId().substring(1)) > Integer .parseInt(ppl2.getId().substring(1))) {
				return 1;
			} else {
				return -1;
			} 
		});
		
	}
}
