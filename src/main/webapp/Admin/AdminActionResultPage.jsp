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

<body class = "backgroundImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
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

<c:if test = "${requestScope.error eq 'incorrectValue'}">
    <div class = "pageTitleText pageTitleTextBad">
        Incorrect parameter on page. Please contact your Admin!
    </div>
</c:if>

<form action="${pageContext.request.contextPath}/Admin/ActionResultPageController" method="post">
    <input type="hidden"  name="redirectTo" value="${requestScope.menu}">
    <button class="controlButton controlButtonAdminPage">OK</button>
</form>

</body>
</html>
