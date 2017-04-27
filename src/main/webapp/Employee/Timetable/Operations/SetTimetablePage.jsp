<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 27/02/2017
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Set Timetable Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Set Timetable Page
</div>
<br />

<c:if test = "${requestScope.step eq 'step0'}">
    <c:if test = "${requestScope.timetablePresent eq 'no'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Set timetable:
        </div>
            <form action="${pageContext.request.contextPath}/Employee/SetTimetablePageController" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="step" value="step1">
                <input type="hidden"  name="timetablePresent" value="no">
                <table>
                    <tr>
                        <td colspan=2>
                            <button class="controlButton controlButtonEmployeePage">Set</button>
                        </td>
                    </tr>
                </table>
            </form>
    </c:if>

    <c:if test = "${requestScope.timetablePresent eq 'yes'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Reset timetable:
        </div>
            <form action="${pageContext.request.contextPath}/Employee/SetTimetablePageController" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="step" value="step1">
                <input type="hidden"  name="timetablePresent" value="yes">
                <table>
                    <tr>
                        <td colspan=2>
                            <button class="controlButton controlButtonEmployeePage">Reset</button>
                        </td>
                    </tr>
                </table>
            </form>
    </c:if>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/SetTimetablePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
