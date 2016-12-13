<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 29/11/2016
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Admin/css/admin_styles.css">
    <title>Update Faculty Page</title>
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Update Faculty Page!
        <br />
        <c:if test = "${selected ne 'yes'}">
            Select Faculty to update:
            <c:forEach items="${institutesList}" var="institute">
                <div>
                    <h5><c:out value="${institute.getLongName()}"/></h5>
                        <c:forEach items="${institute.getFacultys()}" var="faculty">
                            <form action="/UpdateFacultyPageController" method="post" accept-charset="UTF-8">
                                <input type="hidden"  name="step" value="step1">
                                <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                                <button onclick="submit" class="itemButton" ><h2><c:out value="${faculty.getLongName()}"/></h2></button>
                            </form>

                        </c:forEach>
                </div>
            </c:forEach>
        </c:if>
        <c:if test = "${selected eq 'yes'}">
            Please fill form:
            <div>
                <form action="/UpdateFacultyPageController" method="post" accept-charset="UTF-8">
                    <table>
                        <input type="hidden"  name="step" value="step2">
                        <input type="hidden"  name="facultyID" value="${faculty.getID()}" >
                        <tr class = "textInputLabel">
                            <td>Long name:</td>
                            <td>
                                <input type="text" name="longName"  required value=${faculty.getLongName()}>
                            </td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>Short name:</td>
                            <td>
                                <input type="text" name="shortName" required value=${faculty.getShortName()}>
                            </td>
                        </tr>
                        <tr>
                            <td colspan=2>
                                <button onclick="submit"  class="controlButton"><h2>Update</h2></button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </c:if>
    </h5>
</div>
<div>
    <form action="UpdateFacultyPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Cancel</h2></button>
        </td>
    </form>
</div>
<br />

</body>
</html>
