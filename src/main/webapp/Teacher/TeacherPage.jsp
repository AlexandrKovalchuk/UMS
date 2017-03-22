<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Teacher Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageTeacher">

<div class = "pageTitleText pageTitleTextTeacher">
    Welcome to Teacher Page!
    <br />
    Please choose action:
</div>
<br />

<c:set var="step" value="${0}" scope="page"/>
<c:set var="action" value="none" scope="page"/>

<div class="itemsBlock">
    <div>
        <div>
            <form action="TeacherMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="attendance">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonTeacherPage">Update Attendance</button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="TeacherMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="progress">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonTeacherPage">Update Progress</button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="TeacherMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="timeTable">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonTeacherPage">Time Table</button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="LogOutServlet" method="post">
                <td colspan=2>
                    <button onclick="submit"  class="controlButton controlButtonTeacherPage">Log Out</button>
                </td>
            </form>
        </div>
        <br />

    </div>
</div>

</body>

</html>
