package servlets.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage extends HttpServlet {
    static final long serialVersionUID = 9199890031230002L;

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            String rspURL = "/web/login-reg.html"; 
            RequestDispatcher dispatcher = req.getRequestDispatcher(rspURL);
            dispatcher.forward(req, res); 
    }
}