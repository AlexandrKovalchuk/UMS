<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23/03/2017
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageStudent">

<div class = "pageTitleText pageTitleTextStudent">
    Welcome to Student Page
    <br />
    Please choose action:
</div>
<br />

<c:set var="step" value="${0}" scope="page"/>
<c:set var="action" value="none" scope="page"/>

<div class="itemsBlock">
    <div>
        <div>
            <form action="StudentMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="attendance">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonStudentPage">Show Attendance</button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="StudentMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="progress">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonStudentPage">Show Progress</button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="StudentMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="timeTable">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonStudentPage">Time Table</button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="LogOutServlet" method="post">
                <td colspan=2>
                    <button onclick="submit"  class="controlButton controlButtonStudentPage">Log Out</button>
                </td>
            </form>
        </div>
        <br />
    </div>
</div>
</body>
</html>
