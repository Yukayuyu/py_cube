package appService.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static appService.logger.AppLogger.*;
import static appService.logger.AppLogLevels.*;

public class FileReadLineToList {
    Properties p = GetProperties.readGlobalProps();

    public List<String> readUserDB() {
        String relPathToFile = p.getProperty("userDB");
        String absPathToFile = FilePath.parsePathFromProperties(relPathToFile);
        File file = new File(absPathToFile);
        return readFileToLine(file);
    }

    /**
     * read a File, 
     * return a List<String>.
     * 
     * @param file: input file.
     * @return
     */
    public static List<String> readFileToLine(File file) {
        List<String> outList = new ArrayList<>();
        BufferedReader x = null;
        try{
            x = new BufferedReader(new FileReader(file));
            String line;
            while ((line = x.readLine()) != null){
                outList.add(line.trim()); 
            }

        } catch(FileNotFoundException e){ 
            log(e, ERROR);
            throw new RuntimeException("FileNotFound, check the application log.");
        } catch(IOException e){
            log(e, ERROR);
            throw new RuntimeException("IOException, check the application log.");
        } finally{
            try{
            if (x != null)
                x.close(); 
            } catch (IOException e){
                log(e, WARN);
            }
        }

        return outList; 
    }
}