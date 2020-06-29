package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appDAO.UserInfoDAO;

import static constPool.APP_CONST.*;

enum ParamAllowed{
    uID{
        public String toString(){
            return "uID";
        }
    }, email{ 
        public String toString(){
            return "email";
        }
    } ;

    @Override
    public abstract String toString(); 
}
/**
 * Check if UID already exist, return 1 (true in jS) if exist, 0 (false in JS) if not exist. *
 */
public class DoesUIDOrEmailAlreadyExist extends HttpServlet {
    static final long serialVersionUID = 9000123499182L;

    /**
     * Format for get: 
     * String qStr 
     * String ParamName // "uID" or "email"
     * 
     * The retun can be further parsed using packages, e.g. Gson
     * 
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String paramName = req.getParameter("paramName");
        PrintWriter out = res.getWriter();
        String qStr;
        List<String> legalQueryParams = new ArrayList<>();

        for (ParamAllowed param : ParamAllowed.values()){
            legalQueryParams.add(param.toString());
        }

        /**
         * If the param does not exist, return a Message with special character from the constant pool.
         * the reply should contain a special character that in a input is not allowed. 
         * In this case, the input text should not contains "%"
         * 
         * ** out.write(0) will leads to an error in the frond end. Return a String instead of a primitive.
         */
        if (!legalQueryParams.contains(paramName)){
            out.write("unable to resolve" + paramName);
            out.write(ILLEGAL_PARAM_REPLY_STRING);
            return;
        } else {
            qStr = req.getParameter(paramName); 
            List<String> resultList = UserInfoDAO.getAllValueInColumn(paramName);
            boolean alreadyExist = resultList.contains(qStr);
            if (alreadyExist){
                out.write("1");
                return;
            } else{
                out.write("0");
            }
        } 
    } 
}