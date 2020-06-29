package filters;

import java.io.IOException;
import java.util.Map;
import static constPool.APP_CONST.*;
import static appService.logger.AppLogger.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UIDUpperCaseFilter implements Filter {

    FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(wrapper, servletResponse);
        Map<String, String[]> paraMap = wrapper.getParameterMap();
        String uIDCap = null;
        uIDCap = wrapper.getParameter(UID_NAME_STRING);
        if (paraMap.containsKey(UID_NAME_STRING)){
            uIDCap = uIDCap.toUpperCase();
            wrapper.setAttribute(UID_CAPPED_NAME_STRING, uIDCap);
            System.err.println("uIDCaped by filter.");
            log("uIDCaped by filter.");
        }else{
            log("No uID in the request.");
            System.err.println("No uID in the request.");
        }
    } 
}