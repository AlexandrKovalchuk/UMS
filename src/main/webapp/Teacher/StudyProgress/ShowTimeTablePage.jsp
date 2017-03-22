<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 21/03/2017
  Time: 08:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Time Table Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageTeacher">

<div class = "pageTitleText pageTitleTextTeacher">
    Welcome Time Table Page!
</div>
<br />

<div>
    <form action="ShowTimetablePageController " method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonTeacherPage">Cancel</button>
        </td>
    </form>
</div>
<br />


</body>
</html>
