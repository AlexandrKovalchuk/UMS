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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Set Discipline Department Dependency Page (<c:out value="${requestScope.department.getLongName()}"/>)
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Discipline to Set Dependency:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelEmployeePage">Connected with current department</div>
        <c:forEach items="${requestScope.disciplinesConnectedWithDepartment}" var="discipline">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/SetDisciplineDepartmentDependencyPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="state" value="connected">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                </form>
            </div>
        </c:forEach>

        <div class = "textLabelParagraph textLabelEmployeePage">Not connected with current department</div>

        <c:forEach items="${requestScope.disciplinesNotConnectedWithDepartment}" var="discipline">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/SetDisciplineDepartmentDependencyPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="state" value="notConnected">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${requestScope.selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Please fill form:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
    <c:if test = "${requestScope.state eq 'connected'}">
        <form action="${pageContext.request.contextPath}/Employee/SetDisciplineDepartmentDependencyPageController" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="step" value="step2">
            <input type="hidden"  name="action" value="update">
            <input type="hidden"  name="disciplineID" value="${requestScope.discipline.getID()}" >
            <table>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Course Number:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="number" name="courseNumber" maxlength="1"
                                   value="${requestScope.dependencyObject.getCourseNumber()}" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Semester Number:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="number" name="semesterNumber" maxlength="1"
                                   value="${requestScope.dependencyObject.getSemesterNumber()}" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button class="controlButton controlButtonEmployeePage">Update</button>
                    </td>
                </tr>
            </table>
        </form>
        <form action="${pageContext.request.contextPath}/Employee/SetDisciplineDepartmentDependencyPageController" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="step" value="step2">
            <input type="hidden"  name="action" value="remove">
            <input type="hidden"  name="disciplineID" value="${requestScope.discipline.getID()}" >
            <table>
                <tr>
                    <td colspan=2>
                        <button class="controlButton controlButtonEmployeePage">Remove</button>
                    </td>
                </tr>
            </table>
        </form>
    </c:if>
    <c:if test = "${requestScope.state eq 'notConnected'}">
        <form action="${pageContext.request.contextPath}/Employee/SetDisciplineDepartmentDependencyPageController" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="step" value="step2">
            <input type="hidden"  name="action" value="new">
            <input type="hidden"  name="disciplineID" value="${requestScope.discipline.getID()}" >
            <table>
               <tr>
                    <td class = "textLabel textLabelEmployeePage">Course Number:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="number" name="courseNumber" maxlength="1"
                                   required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Semester Number:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="number" name="semesterNumber" maxlength="1"
                                   required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button class="controlButton controlButtonEmployeePage">Set</button>
                    </td>
                </tr>
            </table>
        </form>
    </c:if>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/SetDisciplineDepartmentDependencyPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
