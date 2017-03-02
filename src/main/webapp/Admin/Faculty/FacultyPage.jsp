<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23/11/2016
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Faculty Menu Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>
<body class = "backgroungImageAdmin">
<div class = "pageTitleText pageTitleTextAdmin">
        Welcome to Faculty Menu Page!
        <br />
        Please choose action:
</div>
<br />
<div class="itemsBlock">
    <div>
        <form action="FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="create">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage"><h2>Create New Faculty</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="update">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage"><h2>Update Faculty</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="move">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage"><h2>Move Faculty</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="delete">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage"><h2>Delete Faculty</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="showInfo">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage"><h2>Show Info about Faculty</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="FacultyPageController" method="post">
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
