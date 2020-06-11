package app;

import static org.junit.Assert.*;
import org.junit.Before;

import java.io.IOException;
import java.util.*;
import dataObjects.Record;
import org.junit.Test;

import org.junit.Test;

public class UserIOOperationsTest {
	ReadTXT x = new ReadTXT();
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
	public void writeTXTTEXT() {
		x.writeTXTs(inList);
	}

	@Test
	public void readTXTTEST() throws IOException {
		ReadTXT x = new ReadTXT();
		List<Record> dstList = x.readTXTs();
		System.out.println(dstList);
	} 
}
