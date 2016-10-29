<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 29/09/2016
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        String result = sl.sessionControl(cookies,"employee");
        if(!result.equals("success")){
            response.sendRedirect(result);
        }
    %>
    <title>Department Page</title>
    <link rel="stylesheet" type="text/css" href="sources\employee_css.css">
</head>

<body>

<div class = "pageTitleText">
    <h5>
        Welcome to Department Page!
        <br />
        Please choose action:
    </h5>
</div>

<c:set var="step" value="${0}" scope="page"/>
<c:set var="action" value="none" scope="page"/>

<div class="itemsBlock">
    <div>
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='ManageDiscipline.jsp?step=0&action='" class="topicButton" >
                        <h1>Manage Discipline Credentials</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='ManageTeacherCredentials.jsp?step=0&action='" class="topicButton" >
                        <h1>Manage Teacher Credentials</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='SelectOperation.jsp?type=chair'" class="topicButton" >
                        <h1>Manage Tmetable</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <form action="ManageGroupCredentials.jsp" method="post">
                <input type="hidden"  name="action" value="none">
                <input type="hidden"  name="step" value="0">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Manage Group Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='SelectOperation.jsp?type=emploee'" class="topicButton" >
                        <h1>Manage Student Credentials</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='MainInfo.jsp'" class="controlButton" >
                        <h1>Main Info</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="document.location.href='/LogOutServlet'" class="controlButton" >
                        <h1>Log Out</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
    </div>
</div>

</body>
</html>
