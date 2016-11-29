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
<body>
<div class = "pageTitleText">
    <h5>
        Create Faculty Page!
        <br />
        Please fill form:
    </h5>
</div>
<div>
    <form action="/CreateFacultyPageController" method="post" accept-charset="UTF-8">
        <table>
            <input type="hidden"  name="fillForm" value="yes">
            <tr class = "textInputLabel">
                <td>Long name:</td>
                <td>
                    <input type="text" name="longName" data-hint=" please enter name of faculty">
                </td>
            </tr>
            <tr class = "textInputLabel">
                <td>Short name:</td>
                <td>
                    <input type="text" name="shortName" data-hint=" please ABR">
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <button onclick="submit"  class="controlButton"><h2>Add</h2></button>
                </td>
            </tr>
        </table>
    </form>
</div>
<div>
    <form action="CreateFacultyPageController" method="post">
        <input type="hidden"  name="fillForm" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Cancel</h2></button>
        </td>
    </form>
</div>
<br />
</body>
</html>
