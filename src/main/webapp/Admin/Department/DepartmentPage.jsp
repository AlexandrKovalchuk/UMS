<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23/11/2016
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Department Menu Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>
<body class = "backgroungImageAdmin">
<div class = "pageTitleText pageTitleTextAdmin">
        Welcome to Department Menu Page!
        <br />
        Please choose action:
</div>
<br />
<div class="itemsBlock">
    <div>
        <form action="DepartmentPageController" method="post">
            <input type="hidden"  name="operationType" value="create">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage">Create New Department</button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="DepartmentPageController" method="post">
            <input type="hidden"  name="operationType" value="update">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage">Update Department</button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="DepartmentPageController" method="post">
            <input type="hidden"  name="operationType" value="move">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage">Move Department</button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="DepartmentPageController" method="post">
            <input type="hidden"  name="operationType" value="delete">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage">Delete Department</button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="DepartmentPageController" method="post">
            <input type="hidden"  name="operationType" value="showInfo">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage">Show Info about Department</button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="DepartmentPageController" method="post">
            <input type="hidden"  name="operationType" value="cancel">
            <td colspan=2>
                <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
            </td>
        </form>
    </div>
    <br />
</div>
</body>
</html>
