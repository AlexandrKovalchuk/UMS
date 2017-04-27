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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body style="background-color:#45250d;">

<div class = "pageTitleText pageTitleTextEmployee">
    View Timetable Page
</div>
<br />

<c:if test = "${requestScope.step eq 'step0'}">
    <c:if test = "${requestScope.timetablePresent eq 'no'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Time Table does not exist!
        </div>
    </c:if>
    <c:if test = "${requestScope.timetablePresent eq 'yes'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Time Table:
        </div>
        <c:set var="count" value="0" scope="page" />
        <table class = "studentTable">
            <tr class = "studentTable">
                <td class = "studentTable">
                </td>
                <c:set var="countCourse" value="1" scope="page" />
                <jsp:useBean id="groupNamesByCourse" scope="request" type="java.util.List"/>
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
            <c:forEach items="${requestScope.week}"  var="dayItem">
                <tr class = "studentTable">
                    <td class = "studentTable">
                        <table class = "studentTable">
                            <tr class = "studentTable">
                                <td class = "studentTable" width="120">
                                    <div class ="textLabel textLabelEmployeePage">
                                        <c:out value="${requestScope.dayNames.get(count)}"/>
                                    </div>
                                </td>
                                <td class = "studentTable">
                                    <table class = "studentTable">
                                        <c:forEach items="${requestScope.lessonsTime}"  var="lessonTime">
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
                                <c:set var="countlessonsTime" value="1" scope="page" />
                                <jsp:useBean id="lessonsTime" scope="request" type="java.util.List"/>
                                <c:forEach items="${lessonsTime}"  var="lessonTime">
                                    <tr>
                                        <c:forEach items="${groupsItem}"  var="group">

                                            <c:set var="lesson" value="${requestScope.lessons.getLesson(group.getID(),count,countlessonsTime)}"/>
                                            <td>
                                                <form action="${pageContext.request.contextPath}/Employee/UpdateTimetablePageController" method="post">
                                                    <input type="hidden"  name="step" value="step1">
                                                    <input type="hidden"  name="lessonID" value="${lesson.getID()}">
                                                    <button class="timeTableButton timeTableButtonEmployeePage"><c:out value="${lesson.getDiscipline().getNameOfDiscipline()}"/><br>
                                                            <c:out value="${lesson.getTeacher().getSecondName()}"/>
                                                        </button>
                                                </form>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                    <c:set var="countlessonsTime" value="${countlessonsTime + 1}" scope="page"/>
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
    <form action="${pageContext.request.contextPath}/Employee/UpdateTimetablePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Done</button>
    </form>
</div>

</body>
</html>
