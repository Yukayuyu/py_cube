package servlets.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationPage extends HttpServlet {
    static final long serialVersionUID = 91998900312300212L;

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            String rspURL = "/web/reg-login.html"; 
            RequestDispatcher dispatcher = req.getRequestDispatcher(rspURL);
            dispatcher.forward(req, res); 
    }
} 