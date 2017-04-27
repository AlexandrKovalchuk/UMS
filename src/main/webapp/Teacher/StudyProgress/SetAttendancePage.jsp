<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 21/03/2017
  Time: 08:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Attendance Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageTeacher">

<div class = "pageTitleText pageTitleTextTeacher">
    Welcome Attendance Page
</div>
<br />

<c:if test = "${requestScope.select eq 'select0'}">
    <div class = "pageTitleText pageTitleTextTeacher">
        Select Discipline:
    </div>
    <div class = "pageContent pageContentTeacherPages pageContentAdminPages500px">
        <c:forEach items="${requestScope.teacher.getDisciplines()}" var="discipline">
                <div>
                    <form action="${pageContext.request.contextPath}/Teacher/SetAttendancePageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                        <button class="itemButton itemButtonTeacherPages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                    </form>
                </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.select eq 'select1'}">
    <div class = "pageTitleText pageTitleTextTeacher">
        Select Group:
    </div>
    <div class = "pageContent pageContentTeacherPages pageContentAdminPages500px">
        <jsp:useBean id="groups" scope="request" type="java.util.List"/>
        <c:forEach items="${groups}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Teacher/SetAttendancePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonTeacherPages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${requestScope.select eq 'select2'}">
    <div class = "pageTitleText pageTitleTextTeacher">
        <c:out value="${requestScope.discipline.getNameOfDiscipline()}"/>
        <br>
        Set Attendance :
    </div>
    <div class = "pageContent pageContentTeacherPages pageContentAdminPages500px">
        <form action="${pageContext.request.contextPath}/Teacher/SetAttendancePageController" method="post">
            <input type="hidden"  name="step" value="step3">
            <input type="hidden"  name="groupID" value="${requestScope.groupID}">
        <table class="attendanceProgress">
            <tr>
                <td class = "textLabel textLabelTeacherPage attendanceProgress">
                    <c:out value="Lesson #"/>
                </td>
                <c:forEach var="i" begin="1" end="${requestScope.discipline.getCountOfLessons()}">
                    <td class = "textLabel textLabelTeacherPage attendanceProgress">
                        <c:out value="${i}"/>
                    </td>
                </c:forEach>
            </tr>
            <jsp:useBean id="students" scope="request" type="java.util.List"/>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td class = "textLabel textLabelTeacherPage attendanceProgress"><c:out value="${student.getSecondName()}"/> <c:out value="${student.getName()}"/></td>
                    <c:forEach var="saoItem" items="${student.getAttendance()}">
                        <c:set var="count" value="0" scope="page" />
                        <c:forEach var="attendance" items="${saoItem.value.getAttendance()}">
                            <td class = "textLabel textLabelTeacherPage attendanceProgress">
                                <label>
                                    <input class="inputAttendanceProgress" type="text"
                                           name="${student.getID()}#${saoItem.value.getDisciplineID()}#${count}"
                                           value="${attendance}">
                                </label>
                            </td>
                            <c:set var="count" value="${count + 1}" scope="page"/>
                        </c:forEach>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
            <div>
                    <button class="controlButton controlButtonTeacherPage">Done</button>
            </div>
        </form>
    </div>

</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Teacher/SetAttendancePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonTeacherPage">Cancel</button>
    </form>
</div>

</body>
</html>
