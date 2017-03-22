<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 15/02/2017
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Move Teacher Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Move Teacher Page (<c:out value="${department.getLongName()}"/>)
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Teacher to Move:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <c:forEach items="${departments}" var="department">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>
            <c:forEach items="${department.getTeachers()}" var="teacher">
                <div>
                    <form action="MoveTeacherPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="teacherID" value="${teacher.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${teacher.getSecondName()}"/> <c:out value="${teacher.getName()}"/></button>
                    </form>
                </div>
            </c:forEach>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageContent pageContentEmployeePages pageContentAdminPagesTwoFieldsSize">
        <div class = "textLabelParagraph textLabelEmployeePage">
            Please Confirm Move: <c:out value="${teacher.getSecondName()}"/> <c:out value="${teacher.getName()}"/>
            <br />from <c:out value="${currentDepartment.getLongName()}"/> to <c:out value="${moveToDepartment.getLongName()}"/>
        </div>

        <div>
            <form action="MoveTeacherPageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="departmentID" value="${moveToDepartment.getID()}">
                    <input type="hidden"  name="teacherID" value="${teacher.getID()}">
                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Move</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</c:if>

<div>
    <form action="MoveTeacherPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
