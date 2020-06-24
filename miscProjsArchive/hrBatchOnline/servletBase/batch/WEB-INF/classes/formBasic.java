import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class formBasic extends HttpServlet {
    static final long serialVersionUID = 00002L;
    
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {// (3)
        PrintWriter out = res.getWriter();
        // String name = req.getParameter("name");
        // String email = req.getParameter("email");
        String reqBody = null;
        List<String> reqList = null;
        // reqBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        // String line;

        BufferedReader reqReader = req.getReader();
        reqList = reqReader.lines().collect(Collectors.toList());

        out.println("<html>");
        out.println("<body>");
        out.println("<div>");
        // out.println("name=" + name + "email=" + email);
        out.println("request body:");
        out.println(reqBody);
        out.println(reqList);
        // while((line = reqReader.readLine()) != null){
        //     out.println(line);
        // }
        out.println("</div>");
        out.println("</body>");
        out.println("</html>"); 
    }
}
