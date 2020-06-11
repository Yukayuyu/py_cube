package common.dataIO;

import java.util.*;
import java.util.stream.Collectors;

import dataObjects.Record;

// parse comm.txt: employee_name, address1, address2, (tele)phone, mobile phone , email
public class DOPPraser02 implements DataObjectParser<Record> {
	public List<Record> parse(String[] oneEntry, List<Record> dstList) {
		Record selectEntry = this.selectRecordByName(oneEntry, dstList);
		selectEntry.setEmployee_name(oneEntry[0].trim());
		selectEntry.setAddress(oneEntry[1].trim()+oneEntry[2].trim());
		selectEntry.setFixed_line_phone(oneEntry[3].trim());
		selectEntry.setMobile_phone(oneEntry[4].trim());
		selectEntry.setEmail(oneEntry[5].trim());
		return dstList;
	}
}