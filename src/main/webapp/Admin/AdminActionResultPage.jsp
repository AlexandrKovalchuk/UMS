<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 25/11/2016
  Time: 08:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Action Result Page</title>
</head>

<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Action Result Page!
</div>
<br />

<c:if test = "${result eq 'success'}">
    <div class = "pageTitleText pageTitleTextGood">
            Operation was success!
    </div>
</c:if>

<c:if test = "${result eq 'unsuccess'}">
    <div class = "pageTitleText pageTitleTextBad">
            Operation was not success!
    </div>
</c:if>

<form action="ActionResultPageController" method="post">
    <input type="hidden"  name="redirectTo" value="${menu}">
    <tr>
        <td >
            <button onclick="submit"  class="controlButton controlButtonAdminPage">OK</button>
            <br>
        </td>
    </tr>
</form>

</body>
</html>
