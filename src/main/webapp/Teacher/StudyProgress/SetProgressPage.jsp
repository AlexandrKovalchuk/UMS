<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 21/03/2017
  Time: 08:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Progress Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageTeacher">

<div class = "pageTitleText pageTitleTextTeacher">
    Welcome Progress Page
</div>
<br />

<c:if test = "${requestScope.select eq 'select0'}">
    <div class = "pageTitleText pageTitleTextTeacher">
        Select Discipline:
    </div>
    <div class = "pageContent pageContentTeacherPages pageContentAdminPages500px">
        <c:forEach items="${requestScope.teacher.getDisciplines()}" var="discipline">
            <div>
                <form action="${pageContext.request.contextPath}/Teacher/SetProgressPageController" method="post" accept-charset="UTF-8">
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
        <c:forEach items="${requestScope.groups}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Teacher/SetProgressPageController" method="post" accept-charset="UTF-8">
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
        Set Progress :
    </div>
    <div class = "pageContent pageContentTeacherPages pageContentAdminPages500px">
        <form action="${pageContext.request.contextPath}/Teacher/SetProgressPageController" method="post">
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
                    <td class = "textLabel textLabelTeacherPage attendanceProgress">
                        <c:out value="Exam"/>
                    </td>
                </tr>
                <jsp:useBean id="students" scope="request" type="java.util.List"/>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td class = "textLabel textLabelTeacherPage attendanceProgress"><c:out value="${student.getSecondName()}"/> <c:out value="${student.getName()}"/></td>
                        <c:forEach var="saoItem" items="${student.getProgress()}">
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="progress" items="${saoItem.value.getProgress()}">
                                <td class = "textLabel textLabelTeacherPage attendanceProgress">
                                    <label>
                                        <input class="inputAttendanceProgress" type="text"
                                               name="${student.getID()}#${saoItem.value.getDisciplineID()}#${count}"
                                               value="${progress}">
                                    </label>
                                </td>
                                <c:set var="count" value="${count + 1}" scope="page"/>
                            </c:forEach>
                            <td class = "textLabel textLabelTeacherPage attendanceProgress">
                                <label>
                                    <input class="inputAttendanceProgressExam" type="text"
                                           name="${student.getID()}#${saoItem.value.getDisciplineID()}#exam"
                                           value="${saoItem.value.getExamResult()}">
                                </label>
                            </td>
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
    <form action="${pageContext.request.contextPath}/Teacher/SetProgressPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonTeacherPage">Cancel</button>
    </form>
</div>
<br />

</body>
</html>
