package common.util;
import java.io.*;

public class FilePath {
	public static String getDefaultRootDir() {
		String defaultRoot = new File("").getAbsolutePath();
		return defaultRoot;
	} 
}
