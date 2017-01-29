<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 12/12/2016
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Delete Department Page</title>
</head>
<body class = "backgroungImageAdmin">
<div class = "pageTitleText">
    <h5>
        Delete Department Page!
        <br />
        <c:if test = "${selected ne 'yes'}">
            Select Department to Delete:
            <c:forEach items="${institutesList}" var="institute">
                <div>
                    <h2><c:out value="${institute.getLongName()}"/></h2>
                    <c:forEach items="${institute.getFacultys()}" var="faculty">
                        <h2><c:out value="${faculty.getLongName()}"/></h2>
                        <c:forEach items="${faculty.getDepartments()}" var="department">
                            <form action="/DeleteDepartmentPageController" method="post" accept-charset="UTF-8">
                                <input type="hidden"  name="step" value="step1">
                                <input type="hidden"  name="departmentID" value="${department.getID()}">
                                <button onclick="submit" class="itemButton" ><c:out value="${department.getLongName()}"/></button>
                            </form>
                        </c:forEach>
                    </c:forEach>
                </div>
            </c:forEach>
        </c:if>
        <c:if test = "${selected eq 'yes'}">
            Delete Department: <h5><c:out value="${department.getLongName()}"/></h5>
            <div>
                <form action="/DeleteDepartmentPageController" method="post" accept-charset="UTF-8">
                    <table>
                        <input type="hidden"  name="step" value="step2">
                        <input type="hidden"  name="departmentID" value="${department.getID()}" >
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
