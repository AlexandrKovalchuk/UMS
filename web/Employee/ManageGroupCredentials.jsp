<%@ page import="servlets.Session" %>
<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 18/10/2016
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        String result = sl.sessionControl(cookies,"employee");
        int areaID = 0;
        if(!result.equals("success")){
            response.sendRedirect(result);
        }
        Session s = sl.getSession(cookies);
        s.sessionInfo();
        areaID = s.getAreaAccessID();
        int step = 0;
        step = Integer.parseInt(request.getParameter("step"));
    %>
    <title>Manage Group Page</title>
    <link rel="stylesheet" type="text/css" href="sources\employee_css.css">

</head>
<body>
<div class = "pageTitleText">
    <h5>
        Welcome to Manage Group Page!
        <br />
        <%if(step == 0){%>Please choose action:<%}%>
        <%if(!(request.getParameter("action").equals("create"))){%>Please select Group:<%}%>
    </h5>
</div>

</body>
</html>
