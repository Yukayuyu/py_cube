package common.util;

public class KeyIncrement {
	public static String  deptKeyIncrement(String deptKey){
		int offset =1;
		int i = Integer.parseInt(deptKey.substring(offset));
		i++;
		String digit = Integer.toString(i) ;
		int zerosPaddingCount = deptKey.length()-digit.length() - offset;
		String newKey = deptKey.substring(0, offset); 
		for (; zerosPaddingCount>0; zerosPaddingCount-- )
			newKey = newKey.concat("0"); 
		newKey = newKey.concat(digit);
		return newKey;
	} 
	public static String  posKeyIncrement(String posKey){
		int offset =1;
		int i = Integer.parseInt(posKey.substring(offset));
		i++;
		String digit = Integer.toString(i) ;
		int zerosPaddingCount = posKey.length()-digit.length() - offset;
		String newKey = posKey.substring(0, offset); 
		for (; zerosPaddingCount>0; zerosPaddingCount-- )
			newKey = newKey.concat("0"); 
		newKey = newKey.concat(digit);
		return newKey;
	} 
	public static String  employeeIdIncrement(String id){
		int offset =1;
		int i = Integer.parseInt(id.substring(offset));
		i++;
		String digit = Integer.toString(i) ;
		int zerosPaddingCount = id.length()-digit.length() - offset;
		String newKey = id.substring(0, offset); 
		for (; zerosPaddingCount>0; zerosPaddingCount-- )
			newKey = newKey.concat("0"); 
		newKey = newKey.concat(digit);
		return newKey;
	} 
}
