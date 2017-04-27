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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Update Discipline Page (<c:out value="${requestScope.department.getLongName()}"/>)
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Discipline to update:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelEmployeePage">Connected with current department</div>
        <c:forEach items="${requestScope.disciplinesConnectedWithDepartment}" var="discipline">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/UpdateDisciplinePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                </form>
            </div>
        </c:forEach>

        <div class = "textLabelParagraph textLabelEmployeePage">Not connected with current department</div>

        <c:forEach items="${requestScope.disciplinesNotConnectedWithDepartment}" var="discipline">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/UpdateDisciplinePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
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
        <form action="${pageContext.request.contextPath}/Employee/UpdateDisciplinePageController" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="step" value="step2">
            <input type="hidden"  name="disciplineID" value="${requestScope.discipline.getID()}" >
            <table>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Discipline name:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text"
                                       maxlength="200" name="nameOfDiscipline"
                                       value="${requestScope.discipline.getNameOfDiscipline()}" required/>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Number Of Lessons:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputEmployee numericInput2" type="number" maxlength="2"
                                       name="countOfLessons" value="${requestScope.discipline.getCountOfLessons()}" required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Exam:</td>
                        <td class ="textLabel textLabelEmployeePage">
                            <label>
                                <input type="radio" name="exam" value="yes" <c:if
                                    test="${requestScope.discipline.isExam() eq 'yes'}">checked</c:if>>
                            </label>yes<br>
                            <label>
                                <input type="radio" name="exam" value="no" <c:if test="${requestScope.discipline.isExam() eq 'no'}">checked</c:if>>
                            </label>no
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>
                            <button class="controlButton controlButtonEmployeePage">Update</button>
                        </td>
                    </tr>
                </table>
        </form>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/UpdateDisciplinePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
