<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23/11/2016
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Institute Menu Page</title>
    <link rel="stylesheet" type="text/css" href="Admin/css/admin_styles.css">
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Welcome to Institute Menu Page!
        <br />
        Please choose action:
    </h5>
</div>

<div class="itemsBlock">
    <div>
        <form action="InstitutePageController" method="post">
            <input type="hidden"  name="operationType" value="create">
            <td colspan=2>
                <button onclick="submit"  class="topicButton"><h2>Create New Institute</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="InstitutePageController" method="post">
            <input type="hidden"  name="operationType" value="update">
            <td colspan=2>
                <button onclick="submit"  class="topicButton"><h2>Update Institute</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="InstitutePageController" method="post">
            <input type="hidden"  name="operationType" value="delete">
            <td colspan=2>
                <button onclick="submit"  class="topicButton"><h2>Delete Institute</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="InstitutePageController" method="post">
            <input type="hidden"  name="operationType" value="showInfo">
            <td colspan=2>
                <button onclick="submit"  class="topicButton"><h2>Show Info about Institute</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="InstitutePageController" method="post">
            <input type="hidden"  name="operationType" value="cancel">
            <td colspan=2>
                <button onclick="submit"  class="topicButton"><h2>Cancel</h2></button>
            </td>
        </form>
    </div>
    <br />
</div>
</body>
</html>
