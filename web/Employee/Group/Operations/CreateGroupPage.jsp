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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Create Group Page! (<c:out value="${department.getLongName()}"/>)
    <br />
    Please fill form:
</div>
<br />

<div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
    <form action="/CreateGroupPageController" method="post" accept-charset="UTF-8">
        <table>
            <input type="hidden"  name="fillForm" value="yes">
            <tr>
                <td class = "textLabel textLabelEmployeePage">Group name:</td>
                <td>
                    <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="fullGroupName" required/>
                </td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Course Number:</td>
                <td>
                    <input class = "inputSettings inputEmployee" type="number" name="courseNumber" required/>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <button onclick="submit"  class="controlButton controlButtonEmployeePage">Create</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<div>
    <form action="CreateGroupPageController" method="post">
        <input type="hidden"  name="fillForm" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
