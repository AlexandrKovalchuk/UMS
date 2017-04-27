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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>
<body class = "backgroundImageAdmin">
<div class = "pageTitleText pageTitleTextAdmin">
    Create Institute Page
    <br />
    Please fill form:
</div>
<br />
<div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
    <form action="${pageContext.request.contextPath}/Admin/CreateInstitutePageController" method="post" accept-charset="UTF-8">
        <input type="hidden"  name="fillForm" value="yes">
        <table>
            <tr>
                <td class = "textLabel textLabelAdminPage">Long name:</td>
                <td>
                    <label>
                        <input class="inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="longName"
                               maxlength="70" required/>
                    </label>
                </td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Short name:</td>
                <td>
                    <label>
                        <input class="inputSettings inputAdminPage" type="text" name="shortName" maxlength="10"
                               required/>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <button class="controlButton controlButtonAdminPage">Create</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<div>
    <form action="${pageContext.request.contextPath}/Admin/CreateInstitutePageController" method="post">
        <input type="hidden"  name="fillForm" value="cancel">
        <button class="controlButton controlButtonAdminPage">Cancel</button>
    </form>
</div>
<br />
</body>
</html>

