package common.util;
import dataObjects.Record;
import java.util.*;

public interface Processable {
	/**
	 *  modify the list content. 
	 * @param list is the list or record to be modified
	 * @return
	 */
	List<Record> process(List<Record> list); 
}
