package appDAO;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import static appDAO.MariaJDBCConnect.*;
import appDAO.dataObjects.*;

public final class UserLoginInfoDAO {
    final static String COLUMN_NAME_UID_STR = "uID";
    /**
     * SELECT * FROM table WHERE id=uID, pwHash = upwHash;
     * return a data object. but for simplicity
     * return true or false.
     * if true, login pass.
     */
    public boolean userLoginSuccess (String uID, String uPWHash){
        return userLoginSuccessDummy(uID, uPWHash);
        // return userLoginSuccessImplement(uID, uPWHash);
    } 
    public boolean userLoginSuccessDummy (String uID, String uPWHash){
        //TODO Unimplemented. All dummy data.
        Map<String, String[]> uInfoMap = new HashMap<>();
        String[] tmpStrArrary = new String[]{"adminHashed", "salt"}; //admin pw, temp
        uInfoMap.put("admin", tmpStrArrary);
        tmpStrArrary = new String[]{"rootHashed", "salt"}; //admin pw, temp
        uInfoMap.put("root",tmpStrArrary);
        if(uInfoMap.containsKey(uID)){
            if( uInfoMap.get(uID)[0].equals(uPWHash)){
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }

    } 
    public boolean userLoginSuccessImplement(String uID, String uPWHash){
        List<UserDO> DOList = new ArrayList<>();
        DOList = getAllUsers();
        Map<String, String> uInfoMap = new HashMap<>();
        for (UserDO usr : DOList) {
            String value = usr.getUPWHashed();
            uInfoMap.put(usr.getId(), value); 
        }
        
        if(uInfoMap.containsKey(uID)){
            if( uInfoMap.get(uID).equals(uPWHash)){
                return true;
            } else{
                System.err.println("inputuID="+uID + "get(uID)="+uInfoMap.get(uID)+"uPWHASH="+uPWHash);
                return false;
            }
        } else{
            return false;
        }
    }
}