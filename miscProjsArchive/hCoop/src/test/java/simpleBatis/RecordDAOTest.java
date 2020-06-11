package simpleBatis;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dataObjects.Record;

public class RecordDAOTest {
	RecordDAO x = new RecordDAO();
	List<Record> l = new ArrayList<>();
	Record record1 = new Record();
	@Before
	public void ppr() {
		l.add(record1);
		record1.setPosition_id("P31");
		record1.setPosition_name("superMario"); 
		record1.setId("E0031");
		record1.setDepartment_id("D31");
		record1.setDepartment_name("Moon");
		record1.setEmployee_name("kinopio");
	} 

	@Test
	public void insertPositionTEST() {
//		x.insertDepartment(record1); //passed
//		x.insertPosition(record1);  //passed
}
	
	@Test
	public void insertEmployeeTest() {
//		x.insertEmployee(record1); //passed 
	} 
	@Test
	public void getAllEmpInfoJoinedTEST() {
		List<Record> result = new ArrayList<Record>();
		result = x.getAllEmpInfoJoined();
//		System.out.println(result); //passed
	}
}
