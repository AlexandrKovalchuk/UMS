<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 01/02/2017
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Create Group Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Create Discipline Page (<c:out value="${department.getLongName()}"/>)
    <br />
    Please fill form:
</div>
<br />

<div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
    <form action="CreateDisciplinePageController" method="post" accept-charset="UTF-8">
        <table>
            <input type="hidden"  name="fillForm" value="yes">
            <tr>
                <td class = "textLabel textLabelEmployeePage">Discipline name:</td>
                <td>
                    <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="nameOfDiscipline" required/>
                </td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Number Of Lessons:</td>
                <td>
                    <input class = "inputSettings inputEmployee" type="number" name="countOfLessons" required/>
                </td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Exam:</td>
                <td class ="textLabel textLabelEmployeePage">
                    <input type="radio" name="exam" value="yes" checked>yes<br>
                    <input type="radio" name="exam" value="no">no
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <button onclick="submit"  class="controlButton controlButtonEmployeePage">Create</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<div>
    <form action="CreateDisciplinePageController" method="post">
        <input type="hidden"  name="fillForm" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
