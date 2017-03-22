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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Set Timetable Page
</div>
<br />

<c:if test = "${step eq 'step0'}">
    <c:if test = "${timetablePresent eq 'no'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Set timetable:
        </div>
            <form action="SetTimetablePageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="timetablePresent" value="no">
                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Set</button>
                        </td>
                    </tr>
                </table>
            </form>
    </c:if>

    <c:if test = "${timetablePresent eq 'yes'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Reset timetable:
        </div>
            <form action="SetTimetablePageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="timetablePresent" value="yes">
                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Reset</button>
                        </td>
                    </tr>
                </table>
            </form>
    </c:if>
</c:if>

<div>
    <form action="SetTimetablePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
