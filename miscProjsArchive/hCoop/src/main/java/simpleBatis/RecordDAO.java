package simpleBatis;

import simpleBatis.Mapper.*;

import java.security.KeyStore.Entry;
import java.util.*;
import dataObjects.Record;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * このクラスを用いて、myBatisORMでDBを操作する
 * @author cc
 */
public class RecordDAO {
	public final static SqlSessionFactory theFactory = MySessionFactory.buildTheFactory();


	/**
	 * テーブル名を入力、テーブルの全内容を出力
	 * @param tableName テーブル名
	 * @return
	 */
	public List<Record> getAllRecordsFromTable(String tableName) {
		List<Record> result = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);

			switch(tableName) {
			case "employee":
				result = mapper.getAllRecordsFromEmployee();
				break;
			case "department":
				result = mapper.getAllRecordsFromDepartment();
				break;
			case "position":
				result = mapper.getAllRecordsFromPosition();
				break; 
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}

	public List<Record> getAllEmpInfoJoined() {
		List<Record> result = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);
			result = mapper.getAllEmpInfoJoined();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
		
	}
	/**
	 * PKを指定しemailを取得 -->
	 * @param userID (Primary Key)
	 * @return
	 */
	public String getTheEmail(String userID) {
		String result = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);

			result = mapper.getTheEmail(userID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
	
	/**
	 * PKを指定、それに関する全情報をまとめて出す -->
	 * @param userID (Primary Key)
	 * @return
	 */
	public Record getARecordWithPK(String userID) {
		Record result = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);

			result = mapper.getARecordWithPK(userID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
	
	/**
	 *  指定したdepartment名でそのdepartment.idを特定する-->
	 * @param deptName 部門名
	 * @return
	 */
	public  String getDeptID(String deptName) {
		String result = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);
			result = mapper.getDeptID(deptName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}

	/**
	 *  指定したposition名でそのposition.idを特定する-->
	 * @param positionName 職位名
	 * @return
	 */
	 public String getPositionID(String positionName) {
		String result = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);
			result = mapper.getPositionID(positionName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result; 
	 }
	 
	 /**
	  * 指定したれコートをemployeeテーブルに登録
	  * @param record
	  * @return
	  */
	 public String insertEmployee(Record record) {
		 String lastInsertID = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);
			mapper.insertEmployee(record);
			aSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		} 
		lastInsertID = record.getId();
		 return lastInsertID; 
	 }
	 
	 /**
	  *  insert, レコードをdepartmentテーブルに追加 
	  * @param record
	  * @return
	  */
	 public String insertDepartment(Record record) {
		 String lastInsertID = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);
			mapper.insertDepartment(record);
			aSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		} 
		lastInsertID = record.getId();
		 return lastInsertID; 
	 } 
	 
	 /**
	  * insert, レコードをpositionテーブルに追加
	  * @param record
	  * @return
	  */
	 public String insertPosition(Record record) {
		 String lastInsertID = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);
			mapper.insertPosition(record);
			aSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		} 
		lastInsertID = record.getId();
		 return lastInsertID; 
	 }

	 /**
	  * employeeテーブルに指定したレコードを更新する
	  * @param record
	  * @return
	  */
	 public String updateEmployee(Record record) {
		 String lastInsertID = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);
			mapper.updateEmployee(record);
			aSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		} 
		lastInsertID = record.getId();
		 return lastInsertID; 
	 }

	 /**
	  * employee テーブルに指定したレコードを削除
	  * @param record
	  * @return
	  */
	 public String deleteEmployee(Record record) {
		 String lastDeleteID = null;
		try (SqlSession aSession = theFactory.openSession()) {
			UserMapper mapper = aSession.getMapper(UserMapper.class);
			mapper.deleteEmployee(record);
			aSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		} 
		lastDeleteID = record.getId();
		 return lastDeleteID; 
	 }
}






















