package servlets;

import java.io.*;
import java.util.*;
import ccdebug.*;
import static appService.LoginService.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserLogin extends HttpServlet {

    static final long serialVersionUID = 90112244460330L;
    static final String FAIL_COUNT_STR_NAME = "failCount";
    static final String UID_STR_NAME = "uID";
    static final String UPW_STR_NAME = "uPW";

    /**
     * uID uPW handler. TODO put the fail counter to filter if possible
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Enumeration<String> attrs = session.getAttributeNames();
        Set<String> attrsSet = new HashSet<>();
        Integer failCountsWrapper = 0;
        // limit total login attemps in one session.
        while (attrs.hasMoreElements()) {
            attrsSet.add(attrs.nextElement());
        }
        if (!attrsSet.contains(FAIL_COUNT_STR_NAME)) {
            session.setAttribute(FAIL_COUNT_STR_NAME, failCountsWrapper);
        } else {
            Object o = session.getAttribute(FAIL_COUNT_STR_NAME);
            if (o instanceof Integer) {
                failCountsWrapper = (Integer) o;
            } else {
                log("unknown error on getting fail count from session");
            }
        }

        String userID = req.getParameter(UID_STR_NAME);
        String userPW = req.getParameter(UPW_STR_NAME);
        session.setAttribute(UID_STR_NAME, userID);
        session.setAttribute(UPW_STR_NAME, userPW);
        boolean loginIsValid = loginValidate(userID, userPW); // Hash the pw, and compare with DB value.
        String rspURL = null;
        if (!loginIsValid) {
            failCountsWrapper++; 
            rspURL = "/web/login-reg.html"; 
            RequestDispatcher dispatcher = req.getRequestDispatcher(rspURL);
            dispatcher.forward(req, res); 
        } else{
            rspURL = "/WEB-INF/jsp/login-success-welcome.jsp"; 
            RequestDispatcher dispatcher = req.getRequestDispatcher(rspURL);
            dispatcher.forward(req, res); 
        }
    }
}