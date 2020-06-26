package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

//@WebListener
public class AppHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se){
        System.err.println("new session created." + se);
        se.getSession().getServletContext().log("login count ++");
        //File io, write counter file. 
    } 
}