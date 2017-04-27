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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageStudent">

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
            <form action="${pageContext.request.contextPath}/Student/StudentMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="attendance">
                <button class="topicButton topicButtonStudentPage">Show Attendance</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}/Student/StudentMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="progress">
                <button class="topicButton topicButtonStudentPage">Show Progress</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}/Student/StudentMenuPageController" method="post">
                <input type="hidden"  name="operationType" value="timeTable">
                <button class="topicButton topicButtonStudentPage">Time Table</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}\LogOutServlet" method="post">
                <button class="controlButton controlButtonStudentPage">Log Out</button>
            </form>
        </div>
        <br />
    </div>
</div>
</body>
</html>
