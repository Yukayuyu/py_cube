package appService.util;

import java.io.File;

/**
 * Utilities to simplify path building.
 * 
 * @author chnnn
 *
 */
public final class FilePath {
	/**
	 * Return the absolute path points to the project's rootDir.
	 * 
	 * @return Return the absolute path points to the project's rootDir. Start with
	 *         a File.separator, end with the name of the Dir.
	 */
	public static final String getAbsProjRootDir() {
		String absProjRoot = new File("").getAbsolutePath();
		return absProjRoot;
	}
	/**
	 * Return the absolute path points to the *JAR file*, within which the target class is located.
	 * @param tgrClass the target class whose JAR path is desired. Use getClass() to get the current class. Or getEnclosingClass() to get the enclosing class from an anonymous class.
	 * @return a File object points to the jar file.
	 */
	public static final File getAbsJarPath(Class<?> tgrClass){
		final File f = new File(tgrClass.getProtectionDomain().getCodeSource().getLocation().getPath());
		return f;
	}

	/**
	 * Consider replace this function with a const?
	 * Return the absolute path points to the Config folder. This Function need to
	 * be modified in each project depending on each file structure
	 * 
	 * @return the absolute path points to the resource folder. Start with a
	 *         File.separator, end with the name of the Dir.
	 * 
	 */
	public static final String getConfigDir() {
		String absProjRoot = FilePath.getAbsProjRootDir();
		String dir = absProjRoot + File.separator + "servletBase" + File.separator + "batch" + File.separator
				+ "WEB-INF" + File.separator + "classes" + File.separator + "config";
		return dir;
	}

	/**
	 * Internal use within package. Parse the DIR fetched from the .properties file.
	 * Which is /dir/to/file in the .properties file. Then replace all "/" with
	 * java.io.File.separator. Intended for internal use by GetProperties.java
	 * 
	 * @param aPropertyValueInString
	 * @author chnnn
	 * @return
	 */
	static final String parsePathFromProperties(String aPropertyValueInString) {
		String[] s = aPropertyValueInString.split("/");
		StringBuilder x = new StringBuilder();
		for (String ss : s) {
			x.append(ss);
			x.append(File.separator);
		}
		int index = x.lastIndexOf(File.separator);
		return x.substring(0, index);
	}
}