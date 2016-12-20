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
    <link rel="stylesheet" type="text/css" href="Admin/css/admin_styles.css">
    <title>Action Result Page</title>
</head>

<body>
<div class = "pageTitleText">
    <h5>
        Action Result Page!
    </h5>
</div>

<c:if test = "${result eq 'success'}">
    <div class = "pageTitleTextGood">
        <h5>
            Operation was success!
        </h5>
    </div>
</c:if>

<c:if test = "${result eq 'unsuccess'}">
    <div class = "pageTitleTextBad">
        <h5>
            Operation was not success!
        </h5>
    </div>
</c:if>

<form action="ActionResultPageController" method="post">
    <input type="hidden"  name="redirectTo" value="${menu}">
    <tr>
        <td >
            <button onclick="submit"  class="controlButton"><h2>OK</h2></button>
            <br>
        </td>
    </tr>
</form>
</body>
</html>
