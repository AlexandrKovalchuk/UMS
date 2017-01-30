<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30/01/2017
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discipline Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Welcome to Discipline Page!
    <br />
    Please choose action:
</div>
<br />

<c:set var="step" value="${0}" scope="page"/>
<c:set var="action" value="none" scope="page"/>

<div class="itemsBlock">
    <div>
        <div>
            <form action="DisciplinePageController" method="post">
                <input type="hidden"  name="operationType" value="create">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Create Discipline</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="DisciplinePageController" method="post">
                <input type="hidden"  name="operationType" value="update">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Update  Discipline</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="DisciplinePageController" method="post">
                <input type="hidden"  name="operationType" value="delete">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Delete  Discipline</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="DisciplinePageController" method="post">
                <input type="hidden"  name="operationType" value="move">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Move Discipline</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="DisciplinePageController" method="post">
                <input type="hidden"  name="operationType" value="showInfo">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton topicButtonEmployeePage"><h2>Show Discipline Info</h2></button>
                </td>
            </form>
        </div>
        <br />

        <div>
            <form action="DisciplinePageController" method="post">
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
