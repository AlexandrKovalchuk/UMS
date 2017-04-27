<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 04/02/2017
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Create Group Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Create Group Page (<c:out value="${requestScope.department.getLongName()}"/>)
    <br />
    Please fill form:
</div>
<br />

<div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
    <form action="${pageContext.request.contextPath}/Employee/CreateGroupPageController" method="post" accept-charset="UTF-8">
        <input type="hidden"  name="fillForm" value="yes">
        <table>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Group name:</td>
                <td>
                    <label>
                        <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text"
                               name="fullGroupName" maxlength="30" required/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Course Number:</td>
                <td>
                    <label>
                        <input class="inputSettings inputEmployee numericInput2" type="number" name="courseNumber"
                               maxlength="1" required/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <button class="controlButton controlButtonEmployeePage">Create</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<div>
    <form action="${pageContext.request.contextPath}/Employee/CreateGroupPageController" method="post">
        <input type="hidden"  name="fillForm" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
