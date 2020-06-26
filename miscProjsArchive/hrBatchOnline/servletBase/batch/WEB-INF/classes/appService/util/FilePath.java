package appService.util;
import java.io.File;

/**
 * Utilities to simplify path building.
 * @author chnnn
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
	 * 
     */
	public static String getResourcesDir() {
		String defaultRoot = FilePath.getDefaultRootDir();
		String dir = defaultRoot + File.separator + "config";
		return dir;
    } 
    /**
     * Used to parse the DIR in .properties file.
	 * Because File.separator might differ among systems.
	 * However we write /dir/to/file in the .properties file. 
	 * Thus it could be handy to replace the "/" with java.io.File.separator.
     * @param propertyStringEntry
	 * @author chnnn
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