<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 12/01/2017
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Delete Employee Page</title>
</head>
<body class = "backgroungImageAdmin">
<div class = "pageTitleText">
    <h5>
        Delete Employee Page!
        <br />
        <c:if test = "${selected ne 'yes'}">
            Select Employee to delete:
            <c:forEach items="${institutesList}" var="institute">
                <div>
                    <h2><c:out value="${institute.getLongName()}"/></h2>
                    <c:forEach items="${institute.getFacultys()}" var="faculty">
                        <h2><c:out value="${faculty.getLongName()}"/></h2>
                        <c:forEach items="${faculty.getDepartments()}" var="department">
                            <h2><c:out value="${department.getLongName()}"/></h2>
                            <c:forEach items="${department.getEmployees()}" var="employee">
                                <form action="/DeleteEmployeePageController" method="post" accept-charset="UTF-8">
                                    <input type="hidden"  name="step" value="step1">
                                    <input type="hidden"  name="employeeID" value="${employee.getID()}">
                                    <button onclick="submit" class="itemButton" ><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></button>
                                </form>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </div>
            </c:forEach>
        </c:if>
        <c:if test = "${selected eq 'yes'}">
            Delete Employee: <h5><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></h5>
            <div>
                <form action="/DeleteDepartmentPageController" method="post" accept-charset="UTF-8">
                    <table>
                        <input type="hidden"  name="step" value="step2">
                        <input type="hidden"  name="employeeID" value="${employee.getID()}">
                        <tr>
                            <td colspan=2>
                                <button onclick="submit"  class="controlButton"><h2>Delete</h2></button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </c:if>
    </h5>
</div>
<div>
    <form action="DeleteDepartmentPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Cancel</h2></button>
        </td>
    </form>
</div>
<br />
</body>
</html>
