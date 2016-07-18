<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 23:45
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
    <title>Create Chair Credentials</title>
    <%
    }else if(request.getParameter("action").equals("update")){
    %>
    <title>Update Chair Credentials</title>
    <%
    }else if(request.getParameter("action").equals("delete")){
    %>
    <title>Delete Chair Credentials</title>
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
        Chair Credentials Page!
        <br />
        Please choose action:
    </h5>
</div>
<br />
<%
    if(request.getParameter("action").equals("create")){
%>

<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <table>
        <input type="hidden"  name="tableNameParameter" value="chair">
        <input type="hidden"  name="facultyID" value=<%out.print(request.getParameter("ID"));%>>
        <tr>
            <td>long name:</td>
            <td>
                <input type="text" name="longName" data-hint=" please enter name of chair">
            </td>
        </tr>
        <tr>
            <td>short name:</td>
            <td>
                <input type="text" name="shortName" data-hint=" please ABR">
            </td>
        </tr>
        <tr>
            <td colspan=2>
                <input type="submit" value="Додати" >
            </td>
        </tr>
    </table>
</form>

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
