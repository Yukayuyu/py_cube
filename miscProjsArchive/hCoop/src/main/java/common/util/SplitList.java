package common.util;
import java.util.*;
import java.util.stream.Collectors;

import dataObjects.Record;

public class SplitList {
	public static List<List<Record>>splitListByDept(List<Record> inList) {
		List<List<Record>> outList = new ArrayList<>();
		// TODO sort inList by deptName to greatly increase efficiency? how 
		HashSet<String> nameSet = new HashSet<>();
		inList.stream().forEach(record -> nameSet.add(record.getDepartment_name()));
		nameSet.remove(null);
		for(String name:nameSet) {
			List<Record> subList = new ArrayList<>();
			subList = inList.stream().filter(record -> name.equals(record.getDepartment_name()))
					.collect(Collectors.toList()); 
			inList.removeAll(subList);
			outList.add(subList);
		} 
		return outList; 
	}

}
