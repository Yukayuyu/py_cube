package simpleBatis.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import dataObjects.Record;

/**
 * @author cc
 */
public interface UserMapper {

	List<Record> getAllRecordsFromEmployee();

	List<Record> getAllRecordsFromDepartment();

	List<Record> getAllRecordsFromPosition();

	List<Record> getAllEmpInfoJoined();

    //	<!-- 指定したPKからメールアドレスを出す -->
	String getTheEmail(String userID);
	
	// <!-- 指定したPKに関する全情報を出す -->
	Record getARecordWithPK(String userID);

	// <!-- dept名でdeptIDを引き出す-->
	String getDeptID(String deptName);

	// <!-- position名でpositionIDを引き出す-->
	String getPositionID(String positionName);

	// <!-- insert, レコードをemployeeテーブルに追加-->
	void insertEmployee(Record record);

	// <!-- insert, レコードをdepartmentテーブルに追加 //no test-->
	void insertDepartment(Record record);

	// <!-- insert, レコードをpositionテーブルに追加 //no test-->
	void insertPosition(Record record);

	// <!-- Employeeテーブルの指定レコードを変更-->
	void updateEmployee(Record record);

	// <!-- Employeeテーブルの指定レコードを削除 -->
	void deleteEmployee(Record record);
}