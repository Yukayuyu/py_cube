package appService.util;
import java.io.File;

/**
 * Utilities to simplify path building.
 * @author cc
 *
 */
public class FilePath {
    /**
     * return the default rootDir, start with File.separator and does not end with File.separator
     * @return
     */
	public static String getDefaultRootDir() {
		String defaultRoot = new File("").getAbsolutePath();
		return defaultRoot;
    } 
    /**
     * return resources folder path, 
     * e.g. for finding the .properties file in  ${projectroot}/src/main/resources 
     * @return
     */
	public static String getResourcesDir() {
		String defaultRoot = FilePath.getDefaultRootDir();
		String dir = defaultRoot + File.separator + "config";
		return dir;
    } 
    /**
     * TODO: modify this function
     * @param propertyStringEntry
     * @return
     */
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