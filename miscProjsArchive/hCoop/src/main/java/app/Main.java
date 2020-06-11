package app;
import java.io.IOException;
import java.util.*;

import common.dataIO.FileParser01;
import common.dataIO.TXTParser;
import common.dataIO.Zipper;
import common.util.SplitList;
import dataObjects.Record;

/**
 * プログラムのEntry Point 
 * @author cc
 */
public class Main { 
	/**
	 * Step1: txtファイルを読み込み
	 * @return a list of dataObjects
	 * @throws IOException
	 */
	public static List<Record> readTXTs() throws IOException{
		ReadTXT x = new ReadTXT();
		List<Record> dstList = x.readTXTs();
		return dstList;
	}

	/**
	 * Step2: TEXT ファイル から得られたdataObjectを処理：
	 *  DBに従来の記録を持つdataObjectにおいて、それの新しい情報(non-null fields)をDBにUPDATEし、
	 *  null fieldsについては、DBの既存情報をもって補完。
	 *  制限：引数のdataObjectに名前、部門名、職位名は !null でなければいけない。 
	 * @param a list of dataObjects
	 */
	public static void readToDB(List<Record> list){
		UserInsertion x = new UserInsertion();
		x.insertMergeDepts(list);
		x.insertMergePos(list);
		x.insertMergeEmployee(list);
	} 

	/**
	 * Step3: DBから職員の記録を取り出し、dataObjectに保存する。
	 * @return
	 */
	public static List<Record> pullFromDB() {
		UserPullFromDB x = new UserPullFromDB();
		return(x.getAllEmpInfoFromDB()); //tested
	}
	
	/**
	 * Step4: dataObjects を部門別に分類し、TXT ファイルに出力する。
	 * 制限：予めに(javaのデフォルトhome)/qResult フォルダーを作る必要がある
	 * 結果は"employee_info_部門名.txt"の形になる。
	 * @param list: List<dataObject> 
	 */
	public static void writeToTXT(List<Record> list) {
		TXTParser x = new FileParser01();
		List<List<Record>> outList = SplitList.splitListByDept(list);
		for(List<Record> l:outList) {
			x.parse(l);
		}
	}
	
	/**
	 * Step5: qResult フォルダーにある全ファイルを圧縮し、qResult/zipResult/EMPInfo.zip に保存
	 * @throws IOException
	 */
	public static void zip() throws IOException {
		Zipper.zip();
	}

	public static void main(String[] args) throws IOException{ 
		List<Record> dstList = Main.readTXTs(); //tested
		Main.readToDB(dstList); //tested 
		dstList=Main.pullFromDB();
		Main.writeToTXT(dstList);
		Zipper.zip();
	}
}








