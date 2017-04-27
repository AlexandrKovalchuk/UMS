<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 03/02/2017
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Delete Discipline Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Delete Discipline Page (<c:out value="${requestScope.department.getLongName()}"/>)
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Discipline to Delete:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelEmployeePage">Connected with current department</div>
        <c:forEach items="${requestScope.disciplinesConnectedWithDepartment}" var="discipline">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/DeleteDisciplinePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                </form>
            </div>
        </c:forEach>

        <div class = "textLabelParagraph textLabelEmployeePage">Not connected with current department</div>

        <c:forEach items="${requestScope.disciplinesNotConnectedWithDepartment}" var="discipline">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/DeleteDisciplinePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${requestScope.selected eq 'yes'}">
    <div class = "pageContent pageContentEmployeePages pageContentAdminPagesTwoFieldsSize">
        <c:if test = "${requestScope.possible_to_remove eq 'yes'}">
            <div class = "textLabelParagraph textLabelEmployeePage">
                Please Confirm Delete: <c:out value="${requestScope.discipline.getNameOfDiscipline()}"/>
            </div>

            <div>
                <form action="${pageContext.request.contextPath}/Employee/DeleteDisciplinePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="disciplineID" value="${requestScope.discipline.getID()}">
                    <table>
                        <tr>
                            <td colspan=2>
                                <button class="controlButton controlButtonEmployeePage">Delete</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </c:if>

        <c:if test = "${requestScope.possible_to_remove eq 'no'}">
            <div class = "pageTitleText  pageTitleTextBad">
                Impossible to Delete: <c:out value="${requestScope.institute.getLongName()}"/> , there is still some dependency present!
            </div>
        </c:if>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/DeleteDisciplinePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
