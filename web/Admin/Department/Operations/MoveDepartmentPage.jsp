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
    <title>Move Department Page</title>
</head>
<body class = "backgroungImageAdmin">
<div class = "pageTitleText">
    <h5>
        Move Department Page!
        <br />
    </h5>
    <c:if test = "${selected eq 'no'}">
        Select Department to Move:
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <h2><c:out value="${institute.getLongName()}"/></h2>
                <c:forEach items="${institute.getFacultys()}" var="faculty">
                    <h2><c:out value="${faculty.getLongName()}"/></h2>
                    <c:forEach items="${faculty.getDepartments()}" var="department">
                        <form action="/MoveDepartmentPageController" method="post" accept-charset="UTF-8">
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
        Select Faculty where to move <c:out value="${department.getLongName()}"/>:
        <c:forEach items="${institutesList}" var="institute">
            <h2><c:out value="${institute.getLongName()}"/></h2>
            <c:forEach items="${institute.getFacultys()}" var="faculty">
                <div>
                    <form action="/MoveDepartmentPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step2">
                        <input type="hidden"  name="departmentID" value="${department.getID()}">
                        <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                        <button onclick="submit" class="itemButton" ><c:out value="${faculty.getLongName()}"/></button>
                    </form>
                </div>
            </c:forEach>
        </c:forEach>
    </c:if>
    <c:if test = "${selected eq 'yes2'}">
        Confirm moving <c:out value="${department.getLongName()}"/> to <c:out value="${faculty.getLongName()}"/>
        <div>
            <form action="/MoveDepartmentPageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="departmentID" value="${department.getID()}">
                    <input type="hidden"  name="facultyID" value="${faculty.getID()}" >
                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton"><h2>Move</h2></button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </c:if>
    <div>
        <form action="MoveDepartmentPageController" method="post">
            <input type="hidden"  name="step" value="cancel">
            <td colspan=2>
                <button onclick="submit"  class="topicButton"><h2>Cancel</h2></button>
            </td>
        </form>
    </div>
    <br />
</div>
</body>
</html>
