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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>
<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
        Welcome to Administrator Page
        <br />
        Please choose action:
</div>
<br />

<div class="itemsBlock">
    <div>
        <form action="AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="institute">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage">Manage University Credentials</button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="faculty">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage">Manage Faculty Credentials</button>
            </td>
        </form>
    </div>
    <br />
    <div>
    <form action="AdminPageController" method="post">
        <input type="hidden"  name="elementType" value="department">
        <td colspan=2>
            <button onclick="submit"  class="topicButton topicButtonAdminPage">Manage Department Credentials</button>
        </td>
    </form>
    </div>
    <br />
    <div>
        <form action="AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="employee">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage">Manage Employee Credentials</button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="mainInfo">
            <td colspan=2>
                <button onclick="submit"  class="topicButton topicButtonAdminPage">Main Info</button>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="generateBaseDate">
            <td colspan=2>
                    <tr>
                        <button onclick="submit"  class="topicButton topicButtonAdminPage">Generate base date</button>
                    </tr>
                    <tr>
                        <div class = "pageTitleTextBad">
                            Option disabled!
                        </div>
                    </tr>
            </td>
        </form>
    </div>
    <br />
    <div>
        <form action="AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="clearAllDate">
            <td colspan=2>
                <tr>
                    <button onclick="submit"  class="topicButton topicButtonAdminPage">Clear all date</button>
                </tr>
                <tr>
                    <div class = "pageTitleTextBad">
                        Option disabled!
                    </div>
                </tr>
            </td>
        </form>
    </div>
    <br />

        <div>
            <form action="LogOutServlet" method="post">
                <td colspan=2>
                    <button onclick="submit"  class="controlButton controlButtonAdminPage">Log Out</button>
                </td>
            </form>
        </div>
        <br />

    </div>
</div>
</body>
</html>
