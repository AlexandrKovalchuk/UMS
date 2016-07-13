<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 06/06/2016
  Time: 01:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="net.ukr.vixtibon.Institute" %>

<html>
<head>
    <title>Create University Credentials</title>
    <link rel="stylesheet" type="text/css" href="css\admin_styles.css">
</head>
<body>
Wlcome to Create University Credentials Page  JSP

<br />
<form action="FormReaderServlet" method="post">
    <table>
        <input type="hidden"  name="tableNameParameter" value="Institute">

        <tr>
            <td>long name:</td>
            <td>

                <input name="longName" type="text">

            </td>
        </tr>
        <tr>
            <td>short name:</td>
            <td>

                <input name="shortName" type="text">

            </td>
        </tr>

        <input type="hidden"  name="ID" value="">
        <tr>
            <td colspan=2>
                <input type="submit" value="Додати">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
