<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30/01/2017
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Welcome to Student Page!
    <br />
    Please choose action:
</div>
<br />

<c:set var="step" value="${0}" scope="page"/>
<c:set var="action" value="none" scope="page"/>

<div class="itemsBlock">
    <div>
        <div>
            <form action="StudentPageController" method="post">
                <input type="hidden"  name="operationType" value="create">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Create Student</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="StudentPageController" method="post">
                <input type="hidden"  name="operationType" value="update">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Update  Student</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="StudentPageController" method="post">
                <input type="hidden"  name="operationType" value="delete">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Delete  Student</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="StudentPageController" method="post">
                <input type="hidden"  name="operationType" value="move">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Move Student</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="StudentPageController" method="post">
                <input type="hidden"  name="operationType" value="showInfo">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Show Student Info</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="StudentPageController" method="post">
                <input type="hidden"  name="operationType" value="cancel">
                <td colspan=2>
                    <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
                </td>
            </form>
        </div>
        <br />

    </div>
</div>
</body>
</html>
