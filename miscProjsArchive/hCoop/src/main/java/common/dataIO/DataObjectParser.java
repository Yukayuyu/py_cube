package common.dataIO;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import dataObjects.Record;

public interface DataObjectParser<E> {
	/** 
	 * parse a String[] into a DataObject.
	 * @param aLine: input String[]
	 * @param dstList destination List 
	 * @return
	 * @throws IOException
	 */
	List<E> parse(String[] aLine, List<E> dstList) throws IOException;
	
	/**
	 * Return a *pointer*, which points to an existing Record r, 
	 * if (r.getEmployee_name().equals(aNewEntry[0])) holds true. The aNewEntry[0] is a Name.
	 * Or create a new record, append it to the dstList, then return its pointer.
	 * @param aNewEntry
	 * @param dstList
	 * @return 
	 */
	default Record selectRecordByName(String[] aNewEntry, List<Record> dstList){
		String nameInputted = aNewEntry[0].trim();
		// check the existing records, find records with the same name.
		List<Record> dupList = dstList.stream().filter(record -> record.getEmployee_name().equals(nameInputted))
		        .collect(Collectors.toList());
		if (dupList.size() > 1) {
			System.out.println(dupList);
			throw new RuntimeException("duplicate names exist, need human interaction");
		}
		// 1. The dstList<Record> holds *pointers* to a specific Record dataObject.
		// 2. The pointer value is added to the dupList<Record> to see if multiple entries exist.
		// 3. Hence, by modifying the fields of an element whose pointer is "dupList<Record>.get(0)",
		// we modified the dstList.
		// 4. However, if no existing Record found in the dstList, an "dstList.add" operation is necessary.
		if (dupList.isEmpty()) {
			dupList.add(new Record());
			dstList.add(dupList.get(0));
		}
		Record selectEntry = dupList.get(0); 
		return selectEntry;
	}
}
