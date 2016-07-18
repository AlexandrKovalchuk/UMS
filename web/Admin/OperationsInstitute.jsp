<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 23:27
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
    <title>Create University Credentials</title>
    <%
    }else if(request.getParameter("action").equals("update")){
    %>
    <title>Update University Credentials</title>
    <%
    }else if(request.getParameter("action").equals("delete")){
    %>
    <title>Delete University Credentials</title>
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
        University Credentials Page!
    </h5>
</div>
<br />
<div class = "pageTitleText">
    <%
    if(request.getParameter("action").equals("create")){
    %>
        <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="tableNameParameter" value="Institute">
                <tr>
                    <td><h2>Long name:</h2></td>
                    <td>
                        <input type="text" name="longName" data-hint=" please enter name of institute">
                    </td>
                </tr>
                <tr>
                    <td><h2>Short name:</h2></td>
                    <td>
                        <input type="text" name="shortName" data-hint=" please ABR">
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button onclick="submit" value="Log In" class="controlButton"><h2>Add</h2></button>
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
</div>
</body>
</html>
