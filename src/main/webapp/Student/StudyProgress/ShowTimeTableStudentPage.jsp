<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23/04/2017
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Time Table Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body style="background-color:rgba(20, 20, 20, 0.82);">

<div class = "pageTitleText pageTitleTextStudent">
    Welcome Time Table Page
</div>
<br />

<c:if test = "${requestScope.timetablePresent eq 'no'}">
    <div class = "pageTitleText pageTitleTextStudent">
        Time Table does not exist!
    </div>
</c:if>

<c:if test = "${requestScope.timetablePresent eq 'yes'}">
    <div class = "pageTitleText pageTitleTextStudent">
        Time Table:
    </div>
    <c:set var="count" value="0" scope="page" />
    <table class = "timetable">
        <tr class = "timetable">
            <td class = "timetable">
            </td>
            <c:set var="countCourse" value="1" scope="page" />
            <jsp:useBean id="groupNamesByCourse" scope="request" type="java.util.List"/>
            <c:forEach items="${groupNamesByCourse}"  var="groupsItem">
                <td class = "timetable">
                    <table class = "timetable">
                        <tr class = "textLabel textLabelTimeTablePage timetable">
                            <div class ="textLabel textLabelTimeTablePage">
                                <c:out value="Course #${countCourse}"/>
                            </div>
                        </tr>
                        <tr class = "timetable">
                            <c:forEach items="${groupsItem}"  var="group">
                                <td class = "textLabel textLabelTimeTablePage timetable" width="126">
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
        <jsp:useBean id="week" scope="request" type="java.util.List"/>
        <c:forEach items="${week}"  var="dayItem">
            <tr class = "timetable">
                <td class = "timetable">
                    <table class = "timetable">
                        <tr class = "timetable">
                            <td class = "timetable" width="120">
                                <div class ="textLabel textLabelTimeTablePage">
                                    <c:out value="${requestScope.dayNames.get(count)}"/>
                                </div>
                            </td>
                            <td class = "timetable">
                                <table class = "timetable">
                                    <c:forEach items="${requestScope.lessonsTime}"  var="lessonTime">
                                        <tr class = "timetable">
                                            <td class = "textLabel textLabelTimeTablePage timetable" height="123">
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
                    <td class = "timetablelessonPlate">
                        <table>
                            <c:set var="countlessonsTime" value="1" scope="page" />
                            <jsp:useBean id="lessonsTime" scope="request" type="java.util.List"/>
                            <c:forEach items="${lessonsTime}"  var="lessonTime">
                                <tr>
                                    <c:forEach items="${groupsItem}"  var="group">

                                        <c:set var="lesson" value="${requestScope.lessons.getLesson(group.getID(),count,countlessonsTime)}"/>
                                        <td>
                                        <td colspan=2 class = "timetablelessonPlate">
                                            <c:out value="${lesson.getDiscipline().getNameOfDiscipline()}"/><br>
                                            <c:out value="${lesson.getTeacher().getSecondName()}"/>
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

<div>
    <form action="${pageContext.request.contextPath}/Student/ShowTimetableStudentPageController " method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonStudentPage">Done</button>
    </form>
</div>
<br />


</body>
</html>
