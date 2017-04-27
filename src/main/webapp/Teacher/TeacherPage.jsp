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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageTeacher">

<div class = "pageTitleText pageTitleTextTeacher">
    Welcome to Teacher Page
    <br />
    Please choose action:
</div>
<br />

<c:set var="step" value="${0}" scope="page"/>
<c:set var="action" value="none" scope="page"/>

<div class="itemsBlock">
    <div>
        <div>
            <form action="${pageContext.request.contextPath}/Teacher/TeacherMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="attendance">
                <button class="topicButton topicButtonTeacherPage">Update Attendance</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}/Teacher/TeacherMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="progress">
                <button class="topicButton topicButtonTeacherPage">Update Progress</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}/Teacher/TeacherMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="timeTable">
                <button class="topicButton topicButtonTeacherPage">Time Table</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}\LogOutServlet" method="post">
                <button class="controlButton controlButtonTeacherPage">Log Out</button>
            </form>
        </div>
        <br />

    </div>
</div>

</body>
</html>
