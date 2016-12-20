<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 01/12/2016
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Admin/css/admin_styles.css">
    <title>Move Faculty Page</title>
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Move Faculty Page!
        <br />
    </h5>
    <c:if test = "${selected eq 'no'}">
        Select Faculty to Move:
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <h2><c:out value="${institute.getLongName()}"/></h2>
                <c:forEach items="${institute.getFacultys()}" var="faculty">
                    <form action="/MoveFacultyPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                        <button onclick="submit" class="itemButton" ><c:out value="${faculty.getLongName()}"/></button>
                    </form>
                </c:forEach>
            </div>
        </c:forEach>
    </c:if>
    <c:if test = "${selected eq 'yes'}">
        Select Institute where to move <c:out value="${faculty.getLongName()}"/>:
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="/MoveFacultyPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                    <button onclick="submit" class="itemButton" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </c:if>
    <c:if test = "${selected eq 'yes2'}">
        Confirm moving <c:out value="${faculty.getLongName()}"/> to <c:out value="${institute.getLongName()}"/>
        <div>
            <form action="/MoveFacultyPageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
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
        <form action="MoveFacultyPageController" method="post">
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
