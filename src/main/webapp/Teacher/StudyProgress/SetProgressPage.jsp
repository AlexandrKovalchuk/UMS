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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageTeacher">

<div class = "pageTitleText pageTitleTextTeacher">
    Welcome Progress Page!
</div>
<br />

<c:if test = "${select eq 'select0'}">
    <div class = "pageTitleText pageTitleTextTeacher">
        Select Discipline:
    </div>
    <div class = "pageContent pageContentTeacherPages pageContentAdminPages500px">
        <c:forEach items="${teacher.getDisciplines()}" var="discipline">
            <div>
                <form action="SetProgressPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                    <button onclick="submit" class="itemButton itemButtonTeacherPages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${select eq 'select1'}">
    <div class = "pageTitleText pageTitleTextTeacher">
        Select Group:
    </div>
    <div class = "pageContent pageContentTeacherPages pageContentAdminPages500px">
        <c:forEach items="${groups}" var="group">
            <div>
                <form action="SetProgressPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button onclick="submit" class="itemButton itemButtonTeacherPages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${select eq 'select2'}">
    <div class = "pageTitleText pageTitleTextTeacher">
        <c:out value="${discipline.getNameOfDiscipline()}"/>
        <br>
        Set Progress :
    </div>
    <div class = "pageContent pageContentTeacherPages pageContentAdminPages500px">
        <table class="ProgressProgress">
            <tr>
                <td class = "textLabel textLabelTeacherPage attendanceProgress">
                    <c:out value="Lesson #"/>
                </td>
                <c:forEach var="i" begin="1" end="${discipline.getCountOfLessons()}">
                    <td class = "textLabel textLabelTeacherPage attendanceProgress">
                        <c:out value="${i}"/>
                    </td>
                </c:forEach>
            </tr>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td class = "textLabel textLabelTeacherPage attendanceProgress"><c:out value="${student.getSecondName()}"/> <c:out value="${student.getName()}"/></td>
                    <c:forEach var="saoItem" items="${student.getProgress()}">
                        <c:forEach var="progress" items="${saoItem.value.getProgress()}">
                            <td class = "textLabel textLabelTeacherPage attendanceProgress">
                                <input class = "inputAttendanceProgress" type="text" name="name" required value="${progress}">
                            </td>
                        </c:forEach>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </div>

</c:if>

<div>
    <form action="SetAttendancePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonTeacherPage">Cancel</button>
        </td>
    </form>
</div>
<br />


</body>
</html>
