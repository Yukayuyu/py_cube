package simpleBatis.Mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dataObjects.Record;
import simpleBatis.RecordDAO;

/**
 * RecordDAO UnitTest
 * 
 * @author cc
 */
public class UserMapperTest {
	RecordDAO x = new RecordDAO();
	Record record;
	List<Record> resultList = new ArrayList<>();
	String strResult;
	Record aNewRecord = new Record();

	@Before
	public void before() {
	}

	@Test
	public void getAllRecordsFromTableTEST() {
		resultList = x.getAllRecordsFromTable("employee");
//		System.out.println(resultList); //passed
	}

	@Test
	public void getARecordWithPKTEST() {
		record = x.getARecordWithPK("E0001");
//		System.out.println(record); //passed
	}

	@Test
	public void getdeptIDTEST() {
		strResult = x.getDeptID("Head Office");
		assertEquals(strResult, "D01");
	}

	@Test
	public void getPositionIDTEST() {
		strResult = x.getPositionID("Boss"); //passed
	}

	@Test
	public void insertEmployeeTEST() {
		//passed
		}

	@Test
	public void updateEmployeeTEST() {
		//passed
	}

	@Test
	public void deleteEmployeeTEST() {
	}

	@Test
	public void getAllEmpInfoJoinedTEST() {
		List<Record> list = new ArrayList<Record>();
		list = x.getAllEmpInfoJoined(); // passed?
	}
}
