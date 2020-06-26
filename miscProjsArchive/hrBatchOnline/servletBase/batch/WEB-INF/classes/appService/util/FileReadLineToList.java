package appService.util;

import java.util.Properties;

public class FileReadLineToList {
    Properties p = GetProperties.readGlobalProps();
    String pathToUserDB = p.getProperty("userDB"); 
    
}