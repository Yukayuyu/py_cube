package common.dataIO;

import java.util.*;
import dataObjects.Record;


public interface TXTParser {
	/**
	 * take a list of dataObjects as input, output it to txt. One record per line.
	 * @param list 
	 */
	void parse(List<Record> list);

}
