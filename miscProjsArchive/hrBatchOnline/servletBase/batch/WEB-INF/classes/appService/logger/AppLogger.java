package appService.logger; 
import static appService.logger.AppLogLevels.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * the app wise customized logger. call its "log" function within the app to
 * log. Log the String/stackTrace using Log4j.
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

    private static Logger getLogger(){
        System.setProperty("log4j2.debug", "1");
        // setLog4j2ConfigFilePath(); 
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
 
    public static void main(String[] args) {
        log("info?", INFO);
    }
}