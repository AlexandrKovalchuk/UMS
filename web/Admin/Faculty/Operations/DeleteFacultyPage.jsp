<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30/11/2016
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Admin/css/admin_styles.css">
    <title>Delete Faculty Page</title>
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Delete Faculty Page!
        <br />
        <c:if test = "${selected ne 'yes'}">
            Select Faculty to Delete:
            <c:forEach items="${institutesList}" var="institute">
                <div>
                    <h2><c:out value="${institute.getLongName()}"/></h2>
                    <c:forEach items="${institute.getFacultys()}" var="faculty">
                        <form action="/DeleteFacultyPageController" method="post" accept-charset="UTF-8">
                            <input type="hidden"  name="step" value="step1">
                            <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                            <button onclick="submit" class="itemButton" ><c:out value="${faculty.getLongName()}"/></button>
                        </form>

                    </c:forEach>
                </div>
            </c:forEach>
        </c:if>
        <c:if test = "${selected eq 'yes'}">
            <c:if test = "${possible_to_remove eq 'yes'}">
                Please Confirm Delete: <c:out value="${faculty.getLongName()}"/>
                <div>
                    <form action="/DeleteFacultyPageController" method="post" accept-charset="UTF-8">
                        <table>
                            <input type="hidden"  name="step" value="step2">
                            <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                            <tr>
                                <td colspan=2>
                                    <button onclick="submit"  class="controlButton"><h2>Delete</h2></button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </c:if>
            <c:if test = "${possible_to_remove eq 'no'}">
                <div class = "pageTitleTextBad">
                    Impossible to Delete: <c:out value="${faculty.getLongName()}"/> , there is still some depatments present!
                </div>
                <div>
                    <form action="/DeleteFacultyPageController" method="post" accept-charset="UTF-8">
                        <table>
                            <input type="hidden"  name="step" value="step2">
                        </table>
                    </form>
                </div>
            </c:if>
        </c:if>
    </h5>
</div>
<div>
    <form action="DeleteFacultyPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Cancel</h2></button>
        </td>
    </form>
</div>
<br />

</body>
</html>
