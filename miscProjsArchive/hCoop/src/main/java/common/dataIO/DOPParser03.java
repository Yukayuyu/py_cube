package common.dataIO;

import java.util.*;
import java.util.stream.Collectors;

import dataObjects.Record;

// parse dept.txt: employee_name, department_name, position_name, hired_date
public class DOPParser03 implements DataObjectParser<Record> {
	public List<Record> parse(String[] oneEntry, List<Record> dstList) {
		Record selectEntry = this.selectRecordByName(oneEntry, dstList);
		selectEntry.setEmployee_name(oneEntry[0].trim());
		selectEntry.setDepartment_name(oneEntry[1].trim());
		selectEntry.setPosition_name(oneEntry[2].trim());
		selectEntry.setHired_date(oneEntry[3].trim());
		return dstList;
	}
}