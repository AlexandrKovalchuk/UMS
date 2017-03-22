<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 12/12/2016
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Move Employee Page</title>
</head>
<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Move Employee Page
</div>
<br />

<c:if test = "${selected eq 'no'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Employee to Move:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${institute.getLongName()}"/></div>
            <c:forEach items="${institute.getFacultys()}" var="faculty">
                <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${faculty.getLongName()}"/></div>
                <c:forEach items="${faculty.getDepartments()}" var="department">
                    <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${department.getLongName()}"/></div>
                    <c:forEach items ="${department.getEmployees()}" var="employee">
                        <div>
                            <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                                <input type="hidden"  name="step" value="step1">
                                <input type="hidden"  name="employeeID" value="${employee.getID()}">
                                <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></button>
                            </form>
                        </div>
                    </c:forEach>
                </c:forEach>
            </c:forEach>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Employee where to move <c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/>:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${institute.getLongName()}"/></div>
            <c:forEach items="${institute.getFacultys()}" var="faculty">
                <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${faculty.getLongName()}"/></div>
                <c:forEach items="${faculty.getDepartments()}" var="department">
                    <div>
                        <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                            <input type="hidden"  name="step" value="step2">
                            <input type="hidden"  name="employeeID" value="${employee.getID()}">
                            <input type="hidden"  name="departmentID" value="${department.getID()}">
                            <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                        </form>
                    </div>
                </c:forEach>
            </c:forEach>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${selected eq 'yes2'}">
    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <div class = "pageTitleText pageTitleTextAdmin">
            Confirm moving  <c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/> to <c:out value="${department.getLongName()}"/>
        </div>

        <div>
            <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="employeeID" value="${employee.getID()}">
                    <input type="hidden"  name="departmentID" value="${department.getID()}" >
                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton controlButtonAdminPage">Move</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</c:if>

<div>
    <form action="MoveEmployeePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
