package appService;

import appDAO.UserLoginInfoDAO;
import static appService.util.Hash.*;

public class LoginService {
    /**
     * Check the id and password,
     * return true if match is find, 
     * return false if record does not exist.
     * @param uID id
     * @param uPW password
     * @return
     */
    public static boolean loginValidate (String uID, String uPW){
        //TODO null check
        UserLoginInfoDAO dao = new UserLoginInfoDAO();
        String uPWHash = hashWithoutSalt(uPW);
        boolean validatePassed = dao.userLoginSuccess(uID, uPWHash);
        return validatePassed; 
    } 
}