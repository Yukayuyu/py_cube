package common.dataIO;

import java.util.List;
import java.util.stream.Collectors;

import dataObjects.Record;

// parse base.txt: 姓名、振り仮名、性別、生年月日
public class DOPPraser01 implements DataObjectParser<Record> {
	public List<Record> parse(String[] oneEntry, List<Record> dstList) {
		Record selectEntry = this.selectRecordByName(oneEntry, dstList);
		selectEntry.setEmployee_name(oneEntry[0].trim());
		selectEntry.setKana_name(oneEntry[1].trim());
		selectEntry.setSex(oneEntry[2].trim());
		selectEntry.setBirthdate(oneEntry[3].trim());
		return dstList;
	}
}
