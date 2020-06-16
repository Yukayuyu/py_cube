package common.util;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.junit.Test;

public class PropertiesFileReadTest {

	@Test
	public void test() {
		Properties globalProps = new Properties();
		FileInputStream in = null;
		try {
//			String resDir = FilePath.getResourcesDir();
			File f = new File("hrbatch.properties");
			in = new FileInputStream("hrbatch.properties");
			InputStreamReader in2 = new InputStreamReader(in);
			BufferedReader in3 = new BufferedReader(in2);
			System.out.println(in3.readLine()); 
//			assertEquals("hello = 1;" , in3.readLine()); //passed
			globalProps.load(in);
		} catch (FileNotFoundException e1) {
			System.out.println("property file not found");
			e1.printStackTrace();
		} catch (IOException e2) {
			System.out.println("unable to load property file, check file permission"); 
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}

}
