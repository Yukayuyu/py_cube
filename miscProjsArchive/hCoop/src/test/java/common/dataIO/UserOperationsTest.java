package common.dataIO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import app.ReadTXT;

import java.util.*;
import dataObjects.Record;

public class UserOperationsTest {
		List<Record> dstList = new ArrayList<Record>();
	@Before
	public void aNewdstListWithRecords() {
		Record record01 = new  Record();
		record01.setEmployee_name("渡辺");
		Record record02 = new  Record();
		record02.setEmployee_name("朝比奈");
		dstList.add(record01);
		dstList.add(record02);
//		System.out.println(dstList);
	}

	@Test
	public void appendExistingRecord() throws IOException {
		// A record with the same Employee_name is detected, write directly into it. 
//		ReadTXT x = new ReadTXT();
//		int lengthBefore = dstList.size();
//		dstList= x.readTXT();
//		System.out.println(dstList);
//		int lengthAfter = dstList.size(); 
//		assertEquals(lengthBefore, lengthAfter);
	}

}
