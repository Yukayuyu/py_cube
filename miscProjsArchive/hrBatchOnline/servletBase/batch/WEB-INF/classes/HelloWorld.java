import java.io.*;//(1) 
import javax.servlet.*;
import javax.servlet.http.*;
public class HelloWorld extends HttpServlet {//(2) 
    static final long serialVersionUID = 00001L;
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {//(3) 
        PrintWriter out = res.getWriter();//(4)   
        out.println("<HTML>");//(5) 
        out.println("<BODY>"); 
        out.println("<H3>Hello World!</H3>"); 
        out.println("</BODY>"); 
        out.println("</HTML>"); 
    }
}