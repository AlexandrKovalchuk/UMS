<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 04/04/2017
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Attendance Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageStudent">

<div class = "pageTitleText pageTitleTextStudent">
    Welcome to Student Attendance Page
</div>
<br />

<div class = "pageTitleText pageTitleTextStudent">
    Attendance:
</div>
<div class = "pageContent pageContentStudentPages pageContentAdminPages500px">
<c:set var="count" value="1" scope="page" />
<c:forEach begin="1" end="6" varStatus="loop">
    <div class = "pageTitleText pageTitleTextStudent">
        Course #<c:out value="${count}"/>
    </div>
    <table  class = "studentTable">
        <c:forEach var="saoItem" items="${student.getAttendance()}">
            <c:if test = "${student.getDisciplines().get(saoItem.value.getDisciplineID()).getCourseNumber() == count}">
                <tr  class = "studentTable">
                    <td class = "textLabel textLabelStudentPage studentTable"><c:out value="${student.getDisciplines().get(saoItem.value.getDisciplineID()).getNameOfDiscipline()}"/></td>
                    <c:forEach var="attendance" items="${saoItem.value.getAttendance()}">
                        <td class = "textLabel textLabelStudentPage studentTable studentTableWidth"><c:out value="${attendance}"/></td>
                    </c:forEach>
                </tr>
            </c:if>
        </c:forEach>

    </table>
    <c:set var="count" value="${count + 1}" scope="page"/>
</c:forEach>
</div>

<div>
    <form action="ShowAttendancePageController" method="post">
        <input type="hidden"  name="step" value="ok">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonStudentPage">OK</button>
        </td>
    </form>
</div>

</body>
</html>
