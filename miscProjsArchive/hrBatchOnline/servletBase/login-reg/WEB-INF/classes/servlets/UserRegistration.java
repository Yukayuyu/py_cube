package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static ccdebug.ServletCDB.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistration extends HttpServlet {

    static final long serialVersionUID = 90112244464330L;
    static final String FAIL_COUNT_STR_NAME = "failCount";
    static final String UID_STR_NAME = "uID";
    static final String UPW_STR_NAME = "uPW";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();

        List<String> inList = new ArrayList<>();
        Map<String, String[]> resultMap = req.getParameterMap();
        for (Map.Entry<String, String[]> e : resultMap.entrySet()){
            String str = e.getKey().toString() + ": " +  Arrays.asList(e.getValue()).toString() + "\n";
            inList.add(str);
        }
        out.write(htmlFromList(inList));
    }
}