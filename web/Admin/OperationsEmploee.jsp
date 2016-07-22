<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css\admin_styles.css">
<html>
<head>
    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        System.out.println("cookies size " + cookies.length);
        String result = sl.sessionControl(cookies,"admin");
        if(!result.equals("success")){
            response.sendRedirect(result);
        }
    %>
    <%
        if(request.getParameter("action").equals("create")){
    %>
    <title>Create Emploee Credentials</title>
    <%
    }else if(request.getParameter("action").equals("update")){
    %>
    <title>Update Emploee Credentials</title>
    <%
    }else if(request.getParameter("action").equals("delete")){
    %>
    <title>Delete Emploee Credentials</title>
    <%
    }else{
    %>
    <title>Warning</title>
    <%
        }
    %>
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Welcome to
        <%out.print(request.getParameter("action").equals("create")?"Create":"");%>
        <%out.print(request.getParameter("action").equals("update")?"Update":"");%>
        <%out.print(request.getParameter("action").equals("delete")?"Delete":"");%>
        Emploee Credentials Page!
        <br />
        Please choose action:
    </h5>
</div>
<br />
<%
    if(request.getParameter("action").equals("create")){
%>
<input type="hidden"  name="operation" value="create">
<%
}else if(request.getParameter("action").equals("update")){
%>

<%
}else if(request.getParameter("action").equals("delete")){
%>

<%
}else{
%>
<title>Warning</title>
<%
    }
%>
</body>
</html>
