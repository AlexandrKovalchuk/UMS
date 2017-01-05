<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/01/2017
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Admin/css/admin_styles.css">
    <title>Show Info Institute Page</title>
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Show Faculty Info Page!
        <br />
        <c:if test = "${selected ne 'yes'}">
            Select Faculty to View:
            <c:forEach items="${institutesList}" var="institute">
                <div>
                    <h2><c:out value="${institute.getLongName()}"/></h2>
                    <c:forEach items="${institute.getFacultys()}" var="faculty">
                        <form action="/ShowInfoFacultyPageController" method="post" accept-charset="UTF-8">
                            <input type="hidden"  name="step" value="step1">
                            <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                            <button onclick="submit" class="itemButton" ><c:out value="${faculty.getLongName()}"/></button>
                        </form>
                    </c:forEach>
                </div>
            </c:forEach>
        </c:if>
        <c:if test = "${selected eq 'yes'}">
            Faculty Info: <c:out value="${faculty.getLongName()}"/>
            <br />
                <c:forEach items="${faculty.getDepartments()}" var="department">
                    <c:out value="${department.getLongName()}"/>
                </c:forEach>
        </c:if>
    </h5>
</div>
<div>
    <form action="/ShowInfoFacultyPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Cancel</h2></button>
        </td>
    </form>
</div>
<br />
</body>
</html>
