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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
    <title>Action Result Page</title>
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Action Result Page
</div>
<br />

<c:if test = "${requestScope.result eq 'success'}">
    <div class = "pageTitleText pageTitleTextGood">
        Operation was success!
    </div>
</c:if>

<c:if test = "${requestScope.result eq 'unsuccess'}">
    <div class = "pageTitleText pageTitleTextBad">
        Operation was not success!
    </div>
</c:if>

<c:if test = "${requestScope.result eq 'noAccessToArea'}">
    <div class = "pageTitleText pageTitleTextBad">
        No access to area!
    </div>
</c:if>

<form action="${pageContext.request.contextPath}/Employee/ActionResultEmployeeMenuPageController" method="post">
    <input type="hidden"  name="redirectTo" value="${requestScope.menu}">
    <button class="controlButton controlButtonEmployeePage">OK</button>
</form>

</body>
</html>
