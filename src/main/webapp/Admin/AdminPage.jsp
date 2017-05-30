<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 17/07/2016
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Administrator Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>
<body class = "backgroundImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
        Welcome to Administrator Page
        <br />
        Please choose action:
</div>
<br />

<div class="itemsBlock">
    <div>
        <form action="${pageContext.request.contextPath}/Admin/AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="institute">
            <button class="topicButton topicButtonAdminPage">Manage University Credentials</button>
        </form>
    </div>
    <br />
    <div>
        <form action="${pageContext.request.contextPath}/Admin/AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="faculty">
            <button class="topicButton topicButtonAdminPage">Manage Faculty Credentials</button>
        </form>
    </div>
    <br />
    <div>
        <form action="${pageContext.request.contextPath}/Admin/AdminPageController" method="post">
        <input type="hidden"  name="elementType" value="department">
        <button class="topicButton topicButtonAdminPage">Manage Department Credentials</button>
    </form>
    </div>
    <br />
    <div>
        <form action="${pageContext.request.contextPath}/Admin/AdminPageController" method="post">
            <input type="hidden"  name="elementType" value="employee">
            <button class="topicButton topicButtonAdminPage">Manage Employee Credentials</button>
        </form>
    </div>
    <br />
<%--
<div>
    <form action="${pageContext.request.contextPath}/Admin/AdminPageController" method="post">
        <input type="hidden"  name="elementType" value="mainInfo">
        <button class="topicButton topicButtonAdminPage">Main Info</button>
    </form>
</div>
<br />
<div>
    <form action="${pageContext.request.contextPath}/Admin/AdminPageController" method="post">
        <input type="hidden"  name="elementType" value="generateBaseDate">
        <button class="topicButton topicButtonAdminPage">Generate base date</button>

        <div class = "pageTitleTextBad">
            Option disabled!
        </div>

    </form>
</div>
<br />
<div>
    <form action="${pageContext.request.contextPath}/Admin/AdminPageController" method="post">
        <input type="hidden"  name="elementType" value="clearAllDate">
        <button  class="topicButton topicButtonAdminPage">Clear all date</button>

        <div class = "pageTitleTextBad">
            Option disabled!
        </div>

    </form>
</div>
<br />
--%>

    <div>
        <form action="${pageContext.request.contextPath}\LogOutServlet" method="post">
            <button class="controlButton controlButtonAdminPage">Log Out</button>
        </form>
    </div>
    <br />

</div>
</body>
</html>
