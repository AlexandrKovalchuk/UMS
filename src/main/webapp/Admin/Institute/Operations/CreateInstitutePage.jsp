<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23/11/2016
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Create Institute Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>
<body class = "backgroungImageAdmin">
<div class = "pageTitleText pageTitleTextAdmin">
    Create Institute Page
    <br />
    Please fill form:
</div>
<br />
<div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
    <form action="CreateInstitutePageController" method="post" accept-charset="UTF-8">
        <table>
            <input type="hidden"  name="fillForm" value="yes">
            <tr>
                <td class = "textLabel textLabelAdminPage">Long name:</td>
                <td>
                    <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="longName" required/>
                </td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Short name:</td>
                <td>
                    <input class = "inputSettings inputAdminPage" type="text" name="shortName" required/>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <button onclick="submit"  class="controlButton controlButtonAdminPage">Create</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<div>
    <form action="CreateInstitutePageController" method="post">
        <input type="hidden"  name="fillForm" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>

        </td>
    </form>
</div>
<br />
</body>
</html>

