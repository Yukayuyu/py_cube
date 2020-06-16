package common.util;

import java.util.Properties;

import org.junit.Test;

public class HrPropertiesTest {

	@Test
	public void test() {
		Properties globalProps = HrProperties.readGlobalProps();
//		System.out.println(globalProps.get("senderMailAddress")); //passed
//		System.out.println(globalProps.getProperty("senderMailAddress")); //passed
	} 
}
