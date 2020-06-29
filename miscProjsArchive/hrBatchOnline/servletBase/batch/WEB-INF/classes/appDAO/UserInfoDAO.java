package appDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO to the userInfo Database;
 */
public final class UserInfoDAO {

    public final static List<String> getAllValueInColumn(String columnName) {
        List<String> resultList = new ArrayList<>();
        // TODO
        if (columnName.equals("uID")) {
            resultList.add("admin");
            resultList.add("root");
        } else{
            resultList.add("admin@admin");
        }
        return resultList;
    }
}