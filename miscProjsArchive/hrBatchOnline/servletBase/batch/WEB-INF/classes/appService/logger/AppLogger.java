package appService.logger; 

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import appService.util.FilePath;
import static constPool.APP_CONST.*;

/**
 * This class provide a simpler Logger interface or implementation than log4j2.
 * It is a wrap-up of the log4j2-core and log4j2-api.
 * **It use the system property to specify some log4j2 behavior, before its initialization.**
 * **e.g. customized log4j2.xml location, debugging.**
 * **The log4j2.xml location setting is useful but might be buggy in some virtual environment,
 * **For example vscode Junit test.
 * 
 * Usage: Import the package, call its "log" function to log.
 */
public final class AppLogger {
    private static AppLogLevels DEFAULT_LEVEL = AppLogLevels.INFO;
    /**
     * which will be instentiated in the following static block.
     */
    static final Logger apacheLogger = getLogger(); 
    /**
     * A Holder to ensure that, the PATH points to the Log4j2 configuration file,
     * will be declared first, in the system property, before the logger initiate.
     * It is a workaround to ensure that the log4j2.xml file read by the logger.
     * The following has been tested and is also legal:
     * import org.apache.logging.log4j.core.Logger;
     *   static final Logger apacheLogger = (Logger) LogManager.getLogger();
     */
    private static class LoggerHolder {
        static final Logger apacheLogger = LogManager.getLogger("AppLogger");
    }
    private AppLogger(){}

    /**
     * Internal use. returns the logger with property set ahead.
     * Comment out the debug line when debugging is necessary.
     * Use this method to get logger. 
     * It works properly.
     * For more information, check out apache Log4j2 documentation:
     * https://logging.apache.org/log4j/2.x/manual/configuration.html#SystemProperties
     * @return
     */
    private static Logger getLogger(){
        // System.setProperty("log4j2.debug", "1");
        String confDir = FilePath.getConfigDir() + File.separator + LOG4J2_XML_NAME;
        System.setProperty(LOG4J2_SYS_CONFIG_FILE_LOC, confDir); 
        return LoggerHolder.apacheLogger; 
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
    //     log("info?2", INFO);
    // }
}