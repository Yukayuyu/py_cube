package appService.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * read and return a java.util.Properties object.
 * @author cc
 */
public final class GetProperties {

	/**
	 * read the .properties file.
	 * the path is hard coded.
	 * Since the location remain unchange for one whole project.
	 * @return return a java.util.Properties object.
	 */
	public static final Properties readGlobalProps() {
		Properties globalProps = new Properties();
		FileInputStream in = null;
		try {
			String resDir = FilePath.getConfigDir();
			File f = new File(resDir + File.separator + "batch.properties");
			in = new FileInputStream(f);
			globalProps.load(in);
		} catch (FileNotFoundException e1) {
			System.err.println("property file not found");
			e1.printStackTrace();
		} catch (IOException e2) {
			System.err.println("unable to load property file, check file permission"); 
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