package app;

import static org.junit.Assert.*;

import org.junit.Before;
import java.util.*; 
import dataObjects.Record; 
import org.junit.Test;

public class UserInsertionTest {
	UserInsertion x = new UserInsertion();
	List<Record> inList = new ArrayList<>();
	Record record1 = new Record();
	Record record2 = new Record();

	@Before
	public void prepare() {
		record1.setDepartment_name("Head Office"); 
		record1.setPosition_name("NotBoss");
		record1.setEmployee_name("猿るる");
		record2.setDepartment_name("the newCore"); 
		record2.setPosition_name("BatMan");
		inList.add(record1);
		inList.add(record2);
	} 

	@Test
	public void deptMergeInsertTest() {
		x.insertMergeDepts(inList); 
		assertEquals(inList.get(0).getDepartment_id(), "D01");
		assertEquals(inList.get(0).getDepartment_name(), "Head Office");
		assertEquals(inList.get(1).getDepartment_id(), "D05");
		assertEquals(inList.get(1).getDepartment_name(), "the newCore");
	} 
	@Test
	public void posMergeInsertTest() {
		x.insertMergePos(inList);
		assertEquals(inList.get(0).getPosition_id(), "P32");
		assertEquals(inList.get(0).getPosition_name(), "NotBoss");
		assertEquals(inList.get(1).getPosition_id(), "P33");
		assertEquals(inList.get(1).getPosition_name(), "BatMan");
	}
	@Test
	public void pplMergeInsertTest() {
		x.insertMergeEmployee(inList);
		
	}
}
