<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 23/11/2016
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Faculty Menu Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>
<body class = "backgroundImageAdmin">
<div class = "pageTitleText pageTitleTextAdmin">
        Welcome to Faculty Menu Page
        <br />
        Please choose action:
</div>
<br />
<div class="itemsBlock">
    <div>
        <form action="${pageContext.request.contextPath}/Admin/FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="create">
            <button class="topicButton topicButtonAdminPage">Create New Faculty</button>
        </form>
    </div>
    <br />
    <div>
        <form action="${pageContext.request.contextPath}/Admin/FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="update">
            <button class="topicButton topicButtonAdminPage">Update Faculty</button>
        </form>
    </div>
    <br />
    <div>
        <form action="${pageContext.request.contextPath}/Admin/FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="move">
            <button class="topicButton topicButtonAdminPage">Move Faculty</button>
        </form>
    </div>
    <br />
    <div>
        <form action="${pageContext.request.contextPath}/Admin/FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="delete">
            <button class="topicButton topicButtonAdminPage">Delete Faculty</button>
        </form>
    </div>
    <br />
    <div>
        <form action="${pageContext.request.contextPath}/Admin/FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="showInfo">
            <button class="topicButton topicButtonAdminPage">Show Info about Faculty</button>
        </form>
    </div>
    <br />
    <div>
        <form action="${pageContext.request.contextPath}/Admin/FacultyPageController" method="post">
            <input type="hidden"  name="operationType" value="cancel">
            <button class="controlButton controlButtonAdminPage">Cancel</button>
        </form>
    </div>
    <br />
</div>
</body>
</html>
