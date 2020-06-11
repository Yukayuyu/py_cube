package common.dataIO;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import dataObjects.Record;
import java.io.IOException;

public class FileParser01 implements TXTParser {

	public void parse(List<Record> list) {
		if(list.size()==0) {
			throw new RuntimeException ("input list.size() ==  0");
		}
		String line0DeptName = list.get(0).getDepartment_name();
		String dirBase = new File("").getAbsolutePath();
		String path = dirBase + File.separator + "qResult" + File.separator + "employee_inf_"
		        + line0DeptName + ".txt";
		File file = new File(path);
		try {
			if (file.createNewFile()) {
				System.out.println("ファイルの作成に成功しました");
				if (checkBeforeWritefile(file)) {
					FileWriter filewriter = new FileWriter(file);
					for (int i = 0; i < list.size(); i++) {
						Record line = list.get(i);
						filewriter.write(line.toString());
					}
					filewriter.close();
					System.out.println("ファイルに書き込めました");
				} else {
					System.out.println("ファイルに書き込めません");
				}
			} else {
				System.out.println("ファイルの作成に失敗, File may already exist.");
			}
		} catch (IOException e) {
			System.out.println("Fail to Write /Fail to create folder, trying to write at path:" + path);
			e.printStackTrace();
		}
	}

	private static boolean checkBeforeWritefile(File file) {
		if (file.exists()) {
			if (file.isFile() && file.canWrite()) {
				return true;
			}
		}
		return false;
	}

}
