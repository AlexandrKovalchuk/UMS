<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 29/10/2016
  Time: 07:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<head>
    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        String result = sl.sessionControl(cookies,"teacher");
        if(!result.equals("success")){
            response.sendRedirect(result);
        }
    %>
    <title>Teacher Page</title>
    <link rel="stylesheet" type="text/css" href="sources\teacher_css.css">
</head>
</head>
<body>

<div class = "pageTitleText">
    <h5>
        Welcome to Teachers Page!
        <br />
        Please choose action:
    </h5>
</div>
<div>
    <form action="TeachersMail.jsp" method="post">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Mail</h2></button>
        </td>
    </form>
</div>
<br />
<div>
    <form action="ManageStudentsProgress.jsp" method="post">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Manage students progress</h2></button>
        </td>
    </form>
</div>
<br />
<div>
    <form action="ManageTopic.jsp" method="post">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Manage Topic</h2></button>
        </td>
    </form>
</div>
<br />
<div>
    <tr>
        <td colspan=2>
            <button onclick="document.location.href='/LogOutServlet'" class="controlButton" >
                <h2>Log Out</h2>
            </button>
        </td>
    </tr>
</div>
<br />
</body>

</html>
