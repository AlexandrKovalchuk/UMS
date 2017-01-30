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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
        Welcome to Employee Page!
        <br />
        Please choose action:
</div>
<br />

<c:set var="step" value="${0}" scope="page"/>
<c:set var="action" value="none" scope="page"/>

<div class="itemsBlock">
    <div>
        <div>
            <form action="EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="discipline">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Manage Discipline Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="group">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Manage Group Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="teacher">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Manage Teacher Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="student">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Manage Student Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="EmployeeMenuPageController" method="post">
                <input type="hidden"  name="elementType" value="timetable">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Manage Timetable Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="LogOutServlet" method="post">
                <td colspan=2>
                    <button onclick="submit"  class="controlButton controlButtonEmployeePage">Log Out</button>
                </td>
            </form>
        </div>
        <br />

    </div>
</div>

</body>
</html>
