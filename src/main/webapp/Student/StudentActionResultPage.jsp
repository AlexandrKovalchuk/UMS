<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 20/04/2017
  Time: 08:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Action Result Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageStudent">

<div class = "pageTitleText pageTitleTextStudent">
    Student Action Result Page
</div>
<br />

<c:if test = "${requestScope.result eq 'wrongParameter'}">
    <div class = "pageTitleText pageTitleTextBad">
        Wrong Parameter. Please contact Your Admin!
    </div>
</c:if>

<c:if test = "${requestScope.result eq 'noAccessToArea'}">
    <div class = "pageTitleText pageTitleTextBad">
        No access to area!
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Student/ActionResultStudentMenuPageController" method="post">
        <input type="hidden"  name="redirectTo" value="${requestScope.menu}">
        <button class="controlButton controlButtonStudentPage">Ok</button>
    </form>
</div>
<br />

</body>
</html>
