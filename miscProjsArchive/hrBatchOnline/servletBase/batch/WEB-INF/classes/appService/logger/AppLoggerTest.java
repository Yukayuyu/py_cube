package appService.logger;

import static appService.logger.AppLogLevels.*;
import static appService.logger.AppLogger.log;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppLoggerTest {
    @Test
    public void consoleLogTest() {
        log("hi, logtest", INFO); // passed
    }

    @Test
    public void javaSystemProperty() {
        System.setProperty("key", "value");
        assertEquals("value", System.getProperty("key"));
    }
    @Test
    public void setLog4j2ConfigFilePathTest(){
        //This text seems had to implement in vscode.
    }
}
