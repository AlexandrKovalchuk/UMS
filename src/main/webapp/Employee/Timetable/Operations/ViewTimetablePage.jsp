<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28/02/2017
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>View Timetable Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body style="background-color:#45250d;">

<div class = "pageTitleText pageTitleTextEmployee">
    View Timetable Page
</div>
<br />

<c:if test = "${step eq 'step0'}">
    <c:if test = "${timetablePresent eq 'no'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Time Table does not exist!
        </div>
    </c:if>
    <c:if test = "${timetablePresent eq 'yes'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Time Table:
        </div>
        <c:set var="count" value="0" scope="page" />
        <table class = "studentTable">
            <tr class = "studentTable">
                <td class = "studentTable">
                </td>
                <c:set var="countCourse" value="1" scope="page" />
                <c:forEach items="${groupNamesByCourse}"  var="groupsItem">
                    <td class = "studentTable">
                        <table class = "studentTable">
                            <tr class = "textLabel textLabelEmployeePage studentTable">
                                <div class ="textLabel textLabelEmployeePage">
                                     <c:out value="Course #${countCourse}"/>
                                </div>
                            </tr>
                            <tr class = "studentTable">
                                <c:forEach items="${groupsItem}"  var="group">
                                    <td class = "textLabel textLabelEmployeePage studentTable" width="126">
                                        <c:out value="${group.getFullGroupName()}"/>
                                    </td>
                                </c:forEach>
                            </tr>
                        </table>
                    </td>
                    <c:set var="countCourse" value="${countCourse + 1}" scope="page"/>
                </c:forEach>
            </tr>
            <c:set var="countCourse" value="1" scope="page" />
            <c:forEach items="${week}"  var="dayItem">
                <tr class = "studentTable">
                    <td class = "studentTable">
                        <table class = "studentTable">
                            <tr class = "studentTable">
                                <td class = "studentTable" width="120">
                                    <div class ="textLabel textLabelEmployeePage">
                                        <c:out value="${dayNames.get(count)}"/>
                                    </div>
                                </td>
                                <td class = "studentTable">
                                    <table class = "studentTable">
                                        <c:forEach items="${lessonsTime}"  var="lessonTime">
                                            <tr class = "studentTable">
                                                <td class = "textLabel textLabelEmployeePage studentTable" height="123">
                                                    <c:out value="${lessonTime}"/>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <c:set var="count" value="${count + 1}" scope="page"/>
                    </td>
                    <c:forEach items="${groupNamesByCourse}"  var="groupsItem">
                        <td class = "studentTable">
                            <table>
                                <c:forEach items="${lessonsTime}"  var="lessonTime">
                                    <tr>
                                        <c:forEach items="${groupsItem}"  var="group">
                                            <td>
                                                <form action="UpdateTimetablePageController" method="post">
                                                    <input type="hidden"  name="step" value="cancel">
                                                    <input type="hidden"  name="ID" value="cancel">
                                                    <td colspan=2>
                                                        <button onclick="submit"  class="timeTableButton timeTableButtonEmployeePage"></button>
                                                    </td>
                                                </form>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                </c:forEach>

                            </table>
                        </td>
                    </c:forEach>
                </tr>
                <c:set var="countCourse" value="${countCourse + 1}" scope="page"/>
            </c:forEach>
        </table>
    </c:if>
</c:if>

<div>
    <form action="UpdateTimetablePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Done</button>
        </td>
    </form>
</div>

</body>
</html>