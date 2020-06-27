package appService.logger;


import java.io.File;
// import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import appService.util.FilePath;

/**
 * the app wise customized logger. call its "log" function within the app to
 * log. Log the String/stackTrace using Log4j.
 */
public final class AppLogger {
    private static AppLogLevels DEFAULT_LEVEL = AppLogLevels.INFO;
    /**
     * which will be instentiated in the following static block.
     */
    static final Logger apacheLogger; 
    /**
     * A Holder to ensure that, the PATH points to the Log4j2 configuration file,
     * will be declared first, in the system property, before the logger initiate.
     * It is a workaround to ensure that the log4j2.xml file read by the logger.
     */
    private static class LoggerHolder {
        static final Logger apacheLogger = LogManager.getLogger(); 
    }
    private AppLogger(){}

    /**
     * Set the Log4j2 config file path, in system property. 
     * Specified in apache Log4j2 documentation.
     * https://logging.apache.org/log4j/2.x/manual/configuration.html#SystemProperties
     */
    static void setLog4j2ConfigFilePath(){
        String confDir = FilePath.getConfigDir() + File.separator + "log4j2.xml";
        System.setProperty("log4j2.configurationFile", confDir); 
    }

    private static Logger getLogger(){
        setLog4j2ConfigFilePath(); 
        return LoggerHolder.apacheLogger; 
    } 
    static{
        apacheLogger = getLogger();
    }

    public static final void log(String info) {
        log(info, DEFAULT_LEVEL);
    }

    public static final void log(String info, AppLogLevels level) {
        switch (level) {
            case TRACE:
                apacheLogger.trace(info);
                break;
            case DEBUG:
                apacheLogger.debug(info);
                break;
            case INFO:
                apacheLogger.info(info);
                break;
            case WARN:
                apacheLogger.warn(info);
                break;
            case ERROR:
                apacheLogger.error(info);
                break;
            case FATAL:
                apacheLogger.fatal(info);
                break;
            default:
                apacheLogger.info("log level error in AppLogger.java, logging at INFO(default) level" + info);
                break;
        }
    }

    public static final void log(Exception e) {
        log(e, DEFAULT_LEVEL);
    }

    public static final void log(Exception e, AppLogLevels level) {
        switch (level) {
            case TRACE:
                apacheLogger.trace(e);
                break;
            case DEBUG:
                apacheLogger.debug(e);
                break;
            case INFO:
                apacheLogger.info(e);
                break;
            case WARN:
                apacheLogger.warn(e);
                break;
            case ERROR:
                apacheLogger.error(e);
                break;
            case FATAL:
                apacheLogger.fatal(e);
                break;
            default:
                apacheLogger.info("log level error in AppLogger.java, logging at INFO(default) level" + e);
                break;
        }
    }
    // public static void main(String[] args) {
    //     AppLogger.setLog4j2ConfigFilePath();
    //     String s = System.getProperty("log4j2.configurationFile"); 
    //     System.out.println(s);
    //     System.out.println(FilePath.getConfigDir());
    //     File file = new File(s);
    //     List<String> outList = FileReadLineToList.readFileToLine(file);
    //     System.out.println(outList);
    // }
}