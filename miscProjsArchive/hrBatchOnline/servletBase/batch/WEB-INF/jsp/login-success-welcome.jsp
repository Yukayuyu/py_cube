<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ page import="java.util.*, static constPool.APP_CONST.*" %>
<%-- <%@ taglib uri="/WEB-INF/lib/jstl-1.2.jar" prefix="c" %> --%>
<%-- <%@ taglib prefix="c" [tagdir=/WEB-INF/lib/jstl-1.2.jar | uri=URI ] %> --%>
<%-- <%@ taglib uri="/WEB-INF/lib/META-INF/c.tld" prefix="c" %> --%>

<!DOCTYPE html>
<html lang="en">
<!-- <link rel="stylesheet" type="text/css" href=".css"> -->

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    ${pageContext.request.contextPath}
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/login-success-welcome.css"/>
    <title>Welcome</title>
</head>
<body>
<div>
Welcome, ${sessionScope.uID}, your password was ${sessionScope.uPW}.
<br/>
<%-- Username has been captalized using filter, the result is: ${sessionScope.uIDCapped}. --%>
<%-- <c:if test="${2 < 1}" > count：<c:out value="true, ${sessionScope.uID}"/></c:if> --%>
<%

    String uIDCappedFromReqPara = request.getParameter(UID_CAPPED_NAME_STRING);
    out.println("<br/>");
    Integer s = (Integer) session.getAttribute("failCount");
    out.print("Fail accounts:" + s);
    String strPre = "Congratulation, <em>" + uIDCappedFromReqPara + "</em>, you have successfully <br/>";
    if(s > 2) {
        strPre = strPre.concat("<em>Cheated your way in.</em>");
    }else{
        strPre = strPre.concat("<em>Logged in</em>");
    }
    out.println("<br/>");
    out.println(strPre);
    out.println("and Yes, your name has been CAPTALIZED because a filter told so.");

    out.println("<br/>");
    Enumeration<String> attributes = request.getSession(false).getAttributeNames();
    
    while (attributes.hasMoreElements()) {
    String attribute = (String) attributes.nextElement();
    out.println(attribute+" : "+request.getSession().getAttribute(attribute));
}
%>
</div>
</body>

</html>