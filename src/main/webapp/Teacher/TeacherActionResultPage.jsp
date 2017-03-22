<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 21/03/2017
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher Action Result Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageTeacher">

<div class = "pageTitleText pageTitleTextTeacher">
    Teacher Action Result Page
</div>
<br />

<c:if test = "${result eq 'wrongParameter'}">
    <div class = "pageTitleText pageTitleTextBad">
        Wrong Parameter. Please contact Your Admin!
    </div>
</c:if>

<div>
    <form action="ActionResultTeacherMenuPageController" method="post">
        <input type="hidden"  name="redirectTo" value="${menu}">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonTeacherPage">Ok</button>
        </td>
    </form>
</div>
<br />

</body>
</html>
