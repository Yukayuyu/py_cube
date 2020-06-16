package common.util;
import java.io.File;

/**
 * Utilities to simplify path building.
 * @author cc
 *
 */
public class FilePath {
	public static String getDefaultRootDir() {
		String defaultRoot = new File("").getAbsolutePath();
		return defaultRoot;
	} 
	public static String getResourcesDir() {
		String defaultRoot = FilePath.getDefaultRootDir();
		String dir = defaultRoot + File.separator + "src" + File.separator + "main" + File.separator + "resources";
		return dir;
	} 
	public static String parsePathFromProperties(String propertyStringEntry) {
		String[] s = propertyStringEntry.split("/"); 
		StringBuilder x = new StringBuilder();
		for(String ss : s) {
			x.append(ss);
			x.append(File.separator); 
		}
		int index = x.lastIndexOf(File.separator);
		return x.substring(0, index);
	} 
}
