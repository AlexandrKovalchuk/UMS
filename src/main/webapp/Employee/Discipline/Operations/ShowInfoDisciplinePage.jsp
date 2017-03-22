<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 03/02/2017
  Time: 08:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Show Discipline Info Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Show Discipline Info Page
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Discipline :
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <c:forEach items="${departments}" var="department">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>
            <c:forEach items="${department.getDisciplines()}" var="discipline">
                <div>
                    <form action="ShowInfoDisciplinePageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                    </form>
                </div>
            </c:forEach>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Discipline Info: <c:out value="${discipline.getNameOfDiscipline()}"/>
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
        <table>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Discipline name:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${discipline.getNameOfDiscipline()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Count Of Lessons:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${discipline.getCountOfLessons()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Exam:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${discipline.isExam()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Department Dependency:</td>
            </tr>

            <c:forEach items="${departmentsDependency}" var="department">
                <tr>
                    <td class = "textLabel textLabelEmployeePage"><c:out value="${department.getLongName()}"/></td>
                </tr>
            </c:forEach>

            <tr>
                <td class = "textLabel textLabelEmployeePage">Teacher Dependency:</td>
            </tr>

            <c:forEach items="${teachersDependency}" var="teacher">
                <tr>
                    <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getSecondName()}"/> <c:out value="${teacher.getName()}"/></td>
                </tr>
            </c:forEach>

        </table>
    </div>
</c:if>


<div>
    <form action="ShowInfoDisciplinePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>
</body>
</html>
