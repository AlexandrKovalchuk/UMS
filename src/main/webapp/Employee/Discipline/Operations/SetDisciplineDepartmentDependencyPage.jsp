<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 04/02/2017
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Set Discipline Department Dependency Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Set Discipline Department Dependency Page! (<c:out value="${department.getLongName()}"/>)
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Discipline to Set Dependency:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelEmployeePage">Connected with current department</div>
        <c:forEach items="${disciplinesConnectedWithDepartment}" var="discipline">
            <div>
                <form action="/SetDisciplineDepartmentDependencyPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="state" value="connected">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                    <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                </form>
            </div>
        </c:forEach>

        <div class = "textLabelParagraph textLabelEmployeePage">Not connected with current department</div>

        <c:forEach items="${disciplinesNotConnectedWithDepartment}" var="discipline">
            <div>
                <form action="/SetDisciplineDepartmentDependencyPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="state" value="notConnected">
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
    <c:if test = "${state eq 'connected'}">
        <form action="/SetDisciplineDepartmentDependencyPageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="step" value="step2">
                <input type="hidden"  name="action" value="update">
                <input type="hidden"  name="disciplineID" value="${discipline.getID()}" >

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Course Number:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="number" name="courseNumber"  value="${dependencyObject.getCourseNumber()}" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Semester Number:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="number" name="semesterNumber"  value="${dependencyObject.getSemesterNumber()}" required/>
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button onclick="submit"  class="controlButton controlButtonEmployeePage">Update</button>
                    </td>
                </tr>
            </table>
        </form>
        <form action="/SetDisciplineDepartmentDependencyPageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="step" value="step2">
                <input type="hidden"  name="action" value="remove">
                <input type="hidden"  name="disciplineID" value="${discipline.getID()}" >
                <tr>
                    <td colspan=2>
                        <button onclick="submit"  class="controlButton controlButtonEmployeePage">Remove</button>
                    </td>
                </tr>
            </table>
        </form>
    </c:if>
    <c:if test = "${state eq 'notConnected'}">
        <form action="/SetDisciplineDepartmentDependencyPageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="step" value="step2">
                <input type="hidden"  name="action" value="new">
                <input type="hidden"  name="disciplineID" value="${discipline.getID()}" >

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Course Number:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="number" name="courseNumber"  required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Semester Number:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="number" name="semesterNumber"  required/>
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button onclick="submit"  class="controlButton controlButtonEmployeePage">Set</button>
                    </td>
                </tr>
            </table>
        </form>
    </c:if>
    </div>
</c:if>

<div>
    <form action="SetDisciplineDepartmentDependencyPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
