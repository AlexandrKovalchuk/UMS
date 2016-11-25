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
    <link rel="stylesheet" type="text/css" href="main_css\styles_for_LogIn_page.css">
    <title>Action Result Page</title>
</head>

<body>
<div class = "pageTitleText">
    <h5>
        Action Result Page!
    </h5>
</div>

<c:if test = "${result eq 'success'}">
    <div class = "payAttention">
        <h5>
            Operation was not success!
        </h5>
    </div>
</c:if>

<c:if test = "${result eq 'unsuccess'}">
    <div class = "payAttention">
        <h5>
            Operation was not success!
        </h5>
    </div>
</c:if>

<form action="LogInServlet" method="post">
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
