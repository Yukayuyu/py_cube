package servlets;

import static appService.LoginService.loginValidate;
import static constPool.APP_CONST.*;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogin extends HttpServlet {

    static final long serialVersionUID = 90112244460330L;
    static final String FAIL_COUNT_STR_NAME = "failCount";
    static final String UID_STR_NAME = "uID";
    static final String UPW_STR_NAME = "uPW";
    static final String LOGIN_PAGE_DIR = "/web/login-reg.html";
    static final String SUCCESS_PAGE_DIR = "/WEB-INF/jsp/login-success-welcome.jsp";

    /**
     * uID uPW handler. TODO put the fail counter to filter if possible
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String rspURL = null;
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
        System.err.println("fail count" + failCountsWrapper.toString());
        if (failCountsWrapper > 2){
            rspURL = SUCCESS_PAGE_DIR; 
            RequestDispatcher dispatcher = req.getRequestDispatcher(rspURL);
            dispatcher.forward(req, res); 
        }else {
            log("failcounts = " + failCountsWrapper.toString()) ;
            System.err.println("fail count" + failCountsWrapper.toString());
        }

        String userID = req.getParameter(UID_STR_NAME);
        String userPW = req.getParameter(UPW_STR_NAME);
        String userIDCaped = (String) req.getAttribute(UID_CAPPED_NAME_STRING);
        System.err.println("UserLogin: userIDCaped="+userIDCaped);
        session.setAttribute(UID_STR_NAME, userID);
        session.setAttribute(UPW_STR_NAME, userPW);
        session.setAttribute(UID_CAPPED_NAME_STRING, userIDCaped);
        boolean loginIsValid = loginValidate(userID, userPW); // Hash the pw, and compare with DB value.
        if (!loginIsValid) {
            failCountsWrapper++; 
            rspURL = LOGIN_PAGE_DIR; 
            RequestDispatcher dispatcher = req.getRequestDispatcher(rspURL);
            dispatcher.forward(req, res); 
        } else{
            rspURL = SUCCESS_PAGE_DIR; 
            RequestDispatcher dispatcher = req.getRequestDispatcher(rspURL);
            dispatcher.forward(req, res); 
        }
        session.setAttribute(FAIL_COUNT_STR_NAME, failCountsWrapper);
    }
}