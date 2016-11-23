<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 17/07/2016
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Administrator Page</title>
    <link rel="stylesheet" type="text/css" href="Admin/css/admin_styles.css">
</head>
<body>

<div class = "pageTitleText">
    <h5>
        Welcome to Administrator Page!
        <br />
        Please choose action:
    </h5>
</div>

<div class="itemsBlock">
    <div>
        <form action="AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="institute">
            <td colspan=2>
                <button onclick="submit"  class="topicButton"><h2>Manage University Credentials</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="faculty">
            <td colspan=2>
                <button onclick="submit"  class="topicButton"><h2>Manage Faculty Credentials</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
    <form action="AdminPageController" method="post">
        <input type="hidden"  name="elementType" value="department">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Manage Department Credentials</h2></button>
        </td>
    </form>
    </div>
    <br />
    <div>
        <form action="AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="employee">
            <td colspan=2>
                <button onclick="submit"  class="topicButton"><h2>Manage Employee Credentials</h2></button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="mainInfo">
            <td colspan=2>
                <button onclick="submit"  class="topicButton"><h2>Main Info</h2></button>
            </td>
        </form>
    </div>
    <br />
        <div>
            <form action="LogOutServlet" method="post">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Log Out</h2></button>
                </td>
            </form>
        </div>
        <br />
    </div>
</div>
</body>
</html>
