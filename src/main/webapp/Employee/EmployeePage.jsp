<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
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
    <title>Employee Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
        Welcome to Employee Page
        <br />
        Please choose action:
</div>
<br />

<c:set var="step" value="${0}" scope="page"/>
<c:set var="action" value="none" scope="page"/>

<div class="itemsBlock">
    <div>
        <div>
            <form action="${pageContext.request.contextPath}/Employee/EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="discipline">
                <button class="topicButton topicButtonEmployeePage">Manage Discipline Credentials</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}/Employee/EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="group">
                <button class="topicButton topicButtonEmployeePage">Manage Group Credentials</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}/Employee/EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="teacher">
                <button class="topicButton topicButtonEmployeePage">Manage Teacher Credentials</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}/Employee/EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="student">
                <button class="topicButton topicButtonEmployeePage">Manage Student Credentials</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}/Employee/EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="timetable">
                <button class="topicButton topicButtonEmployeePage">Manage Timetable Credentials</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}/Employee/EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="dayRequirements">
                <button class="topicButton topicButtonEmployeePage">Set Day Requirements</button>
            </form>
        </div>
        <br />

        <div>
            <form action="${pageContext.request.contextPath}\LogOutServlet" method="post">
                <button class="controlButton controlButtonEmployeePage">Log Out</button>
            </form>
        </div>
        <br />

    </div>
</div>

</body>
</html>
