<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 02/02/2017
  Time: 08:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Update Discipline Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Update Discipline Page (<c:out value="${department.getLongName()}"/>)
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Discipline to update:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelEmployeePage">Connected with current department</div>
        <c:forEach items="${disciplinesConnectedWithDepartment}" var="discipline">
            <div>
                <form action="UpdateDisciplinePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                    <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                </form>
            </div>
        </c:forEach>

        <div class = "textLabelParagraph textLabelEmployeePage">Not connected with current department</div>

        <c:forEach items="${disciplinesNotConnectedWithDepartment}" var="discipline">
            <div>
                <form action="UpdateDisciplinePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                    <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Please fill form:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
        <form action="UpdateDisciplinePageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}" >
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Discipline name:</td>
                        <td>
                            <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="nameOfDiscipline" value="${discipline.getNameOfDiscipline()}" required/>
                        </td>
                    </tr>

                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Number Of Lessons:</td>
                        <td>
                            <input class = "inputSettings inputEmployee" type="number" name="countOfLessons" value="${discipline.getCountOfLessons()}" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Exam:</td>
                        <td class ="textLabel textLabelEmployeePage">
                            <input type="radio" name="exam" value="yes" <c:if test = "${discipline.isExam() eq 'yes'}">checked</c:if>>yes<br>
                            <input type="radio" name="exam" value="no" <c:if test = "${discipline.isExam() eq 'no'}">checked</c:if>>no
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Update</button>
                        </td>
                    </tr>
                </table>
        </form>
    </div>
</c:if>

<div>
    <form action="UpdateDisciplinePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
