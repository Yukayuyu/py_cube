import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import ccdebug.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class formLoginDispatch extends HttpServlet {
    static final long serialVersionUID = 00002L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String uID = req.getParameter("uID");
        String uPW = req.getParameter("uPW");
        String rspURL;

        // userMap<uID, password>
        Map<String, String> userMap = new HashMap<>();
        userMap.put("admin", "admin");
        if (!userMap.containsKey(uID)) {
            out.write(ServletCDB.htmlHead());
            out.write("<p>login fail</p>");
            String incURL = "/WEB-INF/jsp/hello.jsp";
            RequestDispatcher dispatcher2 = req.getRequestDispatcher(incURL);
            dispatcher2.include(req, res);

            String loginURL = "../../tomcatForm.html";
            RequestDispatcher dispatcher = req.getRequestDispatcher(loginURL);
            dispatcher.include(req, res);

            out.write(ServletCDB.htmlTail());
        } else if (!(uPW.equals(userMap.get(uID)))) {
            rspURL = "/login-fail.html";
        } else {
            rspURL = "/login-success.html";
            RequestDispatcher dispatcher = req.getRequestDispatcher(rspURL);
            dispatcher.forward(req, res);
        }
    }
}