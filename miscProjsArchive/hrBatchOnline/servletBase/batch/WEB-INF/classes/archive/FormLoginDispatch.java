package archive;
import java.io.*;
import java.util.*;
import ccdebug.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormLoginDispatch extends HttpServlet {
    static final long serialVersionUID = 00002L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String uID = req.getParameter("uID");
        String uPW = req.getParameter("uPW");
        String rspURL;
        HttpSession session = null;

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
            Boolean getCurrentOrCreate = false;
            session = req.getSession(getCurrentOrCreate);
            if (session == null){
                session = req.getSession(); // establish a new session
                // System.err.println("login success"); // goes to ConsoleHandler -> sys.err, which is the system log. accessable in journalctl
                // session.getServletContext().log("logging in session.getServletcontext() at info level"); //suppose to go to app level, but instead showed in journalctl
                System.err.println("session was null, new session:" + session); 
            } else {
                System.err.println("session was not null, session:" + session);
            }
            session.setAttribute("uID", uID);
            session.setAttribute("uPW", uPW);

            rspURL = "/WEB-INF/jsp/Welcome.jsp"; 
            RequestDispatcher dispatcher = req.getRequestDispatcher(rspURL);
            dispatcher.forward(req, res); 
        }
    }
}