package common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * read and return properties.
 * property file location: .../src/main/resources/hrbatch.properties
 * @author cc
 */
public class HrProperties {
	public static Properties readGlobalProps() {
		Properties globalProps = new Properties();
		FileInputStream in = null;
		try {
			String resDir = FilePath.getResourcesDir();
			File f = new File(resDir + File.separator + "hrbatch.properties");
			in = new FileInputStream(f);
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
		return globalProps;
	} 
}
