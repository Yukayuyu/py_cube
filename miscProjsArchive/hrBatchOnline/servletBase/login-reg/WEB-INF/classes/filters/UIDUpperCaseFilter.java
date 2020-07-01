package filters;

import static appService.logger.AppLogger.log;
import static constPool.APP_CONST.UID_CAPPED_NAME_STRING;
import static constPool.APP_CONST.UID_NAME_STRING;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UIDUpperCaseFilter implements Filter {

    // FilterConfig filterConfig = null;

    // public void init(FilterConfig filterConfig) throws ServletException {
    //     this.filterConfig = filterConfig;
    // }

    // public void destroy() {
    // }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        filterChain.doFilter(caseModifiedRequest((HttpServletRequest)servletRequest), servletResponse);
    } 
    private HttpServletRequest caseModifiedRequest(final HttpServletRequest req){
        Map<String, String[]> paraMap = new HashMap<>(req.getParameterMap());
        final String uIDCap;
        if (paraMap.containsKey(UID_NAME_STRING) && !paraMap.containsKey(UID_CAPPED_NAME_STRING)){
            uIDCap = req.getParameter(UID_NAME_STRING).toUpperCase();
            String[] uIDCapArray = new String[1];
            uIDCapArray[0] = uIDCap;
            paraMap.put(UID_CAPPED_NAME_STRING, uIDCapArray);

            System.err.println("uIDCaped by filter.".concat(uIDCapArray[0]));
            log("uIDCaped by filter.".concat(uIDCap));
        }else{
            uIDCap = null;
            log("No uID in the request.");
        }

        return new HttpServletRequestWrapper(req){
            @Override
            public Map<String, String[]> getParameterMap() {
                return paraMap;
            }
            @Override
            public String getParameter(String name) {
                if (name.equals(UID_CAPPED_NAME_STRING) && !uIDCap.isEmpty()){
                    System.err.println("Filtered request: received getParameter request. on:" + uIDCap);
                    return uIDCap;
                }else{
                    return super.getParameter(name); 
                }
            }
        };
    }
}