package common.util;

import java.util.*;
import java.util.stream.Collectors;

import dataObjects.Record;

public class SplitList {
	/**
	 * input a sorted inList by dept would greatly increase the efficiency. Hence
	 * ORDER BY dept.id or name is suggested before calling this function;
	 * 
	 * @param inList
	 * @author cc
	 * @return
	 */
	public static List<List<Record>> splitListByDept(List<Record> inList) {
		List<List<Record>> outList = new ArrayList<>();
		// TODO how to sort by deptName in java (though possible to srot in dept.id, but
		// for intuitive understanding)? 
		HashSet<String> nameSet = new HashSet<>();
		inList.stream().forEach(record -> nameSet.add(record.getDepartment_name()));
		nameSet.remove(null);
		for (String name : nameSet) {
			List<Record> subList = new ArrayList<>();
			subList = inList.stream().filter(record -> name.equals(record.getDepartment_name()))
					.collect(Collectors.toList());
			inList.removeAll(subList);
			outList.add(subList);
		}
		return outList;
	}

}
