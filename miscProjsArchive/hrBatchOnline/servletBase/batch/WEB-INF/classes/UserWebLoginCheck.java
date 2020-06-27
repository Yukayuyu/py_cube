import java.io.*;
import java.util.*;
import ccdebug.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserWebLoginCheck extends HttpServlet {
    static final long serialVersionUID = 90112244460330L;

    /**
     * TODO: Change it to doPost instead later
     */
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // boolean loginIsValid = false;
        String userID = req.getParameter("uID");
        String userPW = req.getParameter("uPW");
        
        session.setAttribute("uID", userID);
        session.setAttribute("uPW", userPW);

        
        
        

    }

}