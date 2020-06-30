package appDAO;

import java.util.ArrayList;
import java.util.List;
import static appDAO.MariaJDBCConnect.*;
import appDAO.dataObjects.*;

/**
 * DAO to the userInfo Database;
 */
public final class UserInfoDAO {
    final static String COLUMN_NAME_UID_STR = "uID";

    public final static List<String> getAllValueInColumn(String columnName) {
        List<String> resultList = new ArrayList<>();
        // List<UserDO> DOList = new ArrayList<>();
        // DOList = getAllUsers();
        // TODO
        if (columnName.equals("uID")) {
        resultList.add("admin");
        resultList.add("root");
        } else{
        resultList.add("admin@admin");
        resultList.add("root@root");
        }
        // for (UserDO usr : DOList) {
        //     switch (columnName) {
        //         case COLUMN_NAME_UID_STR:
        //             resultList.add(usr.getId());
        //             break;
        //         default:
        //             resultList.add(usr.getEmail());
        //             break;
        //     }
        // }

        return resultList;
    }
}