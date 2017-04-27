<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 13/03/2017
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Main Info Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>
<body class = "backgroundImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Welcome to Main Info Page
</div>
<br />

<div class="itemsBlock">
    <div>
        <form action="${pageContext.request.contextPath}/Admin/MainInfoPageController" method="post">
            <input type="hidden"  name="step" value="cancel">
            <button class="controlButton controlButtonAdminPage">Done</button>
        </form>
    </div>
    <br />

</div>
</body>
</html>
