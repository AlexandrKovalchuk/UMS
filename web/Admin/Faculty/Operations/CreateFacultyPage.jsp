<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 29/11/2016
  Time: 08:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<head lang="en">
    <meta charset="UTF-8">
    <title>Create Faculty Page</title>
    <link rel="stylesheet" type="text/css" href="Admin/css/admin_styles.css">
</head>
<body class = "backgroungImageAdmin">
<div class = "pageTitleText">
    <h5>
        Create Faculty Page!
        <br />
        Please fill form:
    </h5>
</div>
<div>
    <c:if test = "${selected ne 'yes'}">
        Select Institute where to add faculty:
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="/CreateFacultyPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button onclick="submit" class="itemButton" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </c:if>
    <c:if test = "${selected eq 'yes'}">
        Please fill form:
        <div>
            <form action="/CreateFacultyPageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="instituteID" value="${instituteID}">
                    <tr class = "textInputLabel">
                        <td>Long name:</td>
                        <td>
                            <input type="text" name="longName" required/>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Short name:</td>
                        <td>
                            <input type="text" name="shortName" required/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton"><h2>Create</h2></button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </c:if>
</div>
<div>
    <form action="CreateFacultyPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Cancel</h2></button>
        </td>
    </form>
</div>
<br />
</body>
</html>
