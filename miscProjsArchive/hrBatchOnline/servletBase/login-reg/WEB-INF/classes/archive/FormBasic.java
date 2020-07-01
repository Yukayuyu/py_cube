package archive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import static ccdebug.ServletCDB.htmlFromList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormBasic extends HttpServlet {
    static final long serialVersionUID = 00002L;
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {// (3)
        PrintWriter out = res.getWriter();
        // String name = req.getParameter("name");
        // String email = req.getParameter("email");
        String reqBody = null;
        List<String> reqList = null;
        // String line;

        BufferedReader reqReader = req.getReader();
        reqBody = reqReader.lines().collect(Collectors.joining(System.lineSeparator()));
        //the later one will be empty. Auto-flushed;
        reqList = reqReader.lines().collect(Collectors.toList());

        List<String> inList = new ArrayList<>();
        inList.add("reqBody: within inList");
        inList.add(reqBody);
        inList.add(reqList.toString());
        String strout = htmlFromList(inList);
        out.write(strout);
    }
    public static void main(String[] args) {
        List<String> inList = new ArrayList<>();
        inList.add("reqBody: within inList");
        System.out.printf(htmlFromList(inList));
    }
}
