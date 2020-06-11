package app;
import java.util.*;
import dataObjects.Record;
import simpleBatis.RecordDAO;

public class UserPullFromDB {
	public List<Record> getAllEmpInfoFromDB(){
		List<Record> resultList = new ArrayList<>();
		RecordDAO x = new RecordDAO();
		resultList = x.getAllEmpInfoJoined(); 
		return resultList; 
	} 
}
