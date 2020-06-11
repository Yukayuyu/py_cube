package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import common.dataIO.DOPParser03;
import common.dataIO.DOPPraser01;
import common.dataIO.DOPPraser02;
import common.dataIO.DataObjectParser;
import common.dataIO.FileParser01;
import common.dataIO.TXTParser;
import common.exceptions.wrappedExceptions;
import dataObjects.Record;

/**
 * @author cc
 */
public class ReadTXT {
	public List<Record> readTXTs(){
		List<Record> dstList = new ArrayList<Record>();
		ReadTXT x = new ReadTXT();
		try {
		x.readTXT(dstList, "base.txt");
		x.readTXT(dstList, "comm.txt");
		x.readTXT(dstList, "dept.txt");
		} catch (IOException e) {
			// catch IO Exception, wrapped it in a runtimeException
			wrappedExceptions.throwRunTimeException("ERROR_001");
		}
		return dstList; 
	}
	/**
	 * Read base.txt or comm.txt or dept.txt, splitterRegex as columnSplitter,
	 * Output to a dstList, which holds dataObject
	 * @param dstList where the result be saved 
	 * @param whichTXT "base.txt", "comm.txt", or "dept.txt"
	 * @return 
	 * @throws IOException
	 */
	public List<Record> readTXT(List<Record> dstList, String whichTXT) throws IOException {
		// get the relative path
		String relativeRoot = common.util.FilePath.getDefaultRootDir();
		String fileName = (relativeRoot + File.separator + "qResult" + File.separator + "inputTXTs" +File.separator + whichTXT);

		String splitterRegex = ",";
		BufferedReader in = new BufferedReader(new FileReader(fileName));

		String switchString = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
		DataObjectParser<Record> dataObjectParser;

		// decide the DataObjectParser;
		try {
			switch (switchString) {
			case "base.txt":
				System.out.println("scanning base.txt");
				dataObjectParser = new DOPPraser01();
				break;
			case "comm.txt":
				System.out.println("scanning comm.txt");
				dataObjectParser = new DOPPraser02();
				break;
			case "dept.txt":
				System.out.println("scanning dept.txt");
				dataObjectParser = new DOPParser03();
				break;
			default:
				System.out.println("TXTName=" + switchString);
				throw new RuntimeException(
				        "file is not Detected or with the wrong name,\n,i.e. base.txt comm.txt dept.txt");
			}

			// read line by line, update the dataObject list.
			String aLine;
			while ((aLine = in.readLine()) != null) {
				aLine = aLine.trim(); // trim special chars
				String[] oneEntry = aLine.split(splitterRegex);
				dstList = dataObjectParser.parse(oneEntry, dstList);
			}
		} finally {
			in.close();
		}
		return dstList;
	}
	
	public void writeTXTs(List<Record> list) { 
		TXTParser x = new FileParser01();
		x.parse(list);
	}
}
