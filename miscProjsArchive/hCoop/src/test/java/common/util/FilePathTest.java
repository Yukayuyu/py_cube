package common.util;

import java.util.Properties;

import org.junit.Test;

public class FilePathTest {
	Properties p = HrProperties.readGlobalProps();

	@Test
	public void test() {
		String zipout = p.getProperty("zipOut");
		String result = FilePath.parsePathFromProperties(zipout); //passed
	}

}
