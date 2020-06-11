package common.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dataObjects.Record;

public class batchSortTest {
	List<Record> recList = new ArrayList<>();
	@Before
	public void bf() {
	Record record1 = new Record();
	record1.setDepartment_id("D01");
	Record record2 = new Record();
	record2.setDepartment_id("D09");
	Record record3 = new Record();
	record3.setDepartment_id("D07"); 
	recList.add(record1);
	recList.add(record2);
	recList.add(record3);
	} 

	@Test
	public void sortRecordsByDeptID() {
		batchSort.sortByDeptIdAscend(recList);  //Result: D01, D07, D09 passed
	} 
}
