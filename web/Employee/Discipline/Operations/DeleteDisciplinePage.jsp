<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 03/02/2017
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Delete Discipline Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Delete Discipline Page! (<c:out value="${department.getLongName()}"/>)
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Discipline to Delete:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <c:forEach items="${departments}" var="department">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>
            <c:forEach items="${department.getDisciplines()}" var="discipline">
                <div>
                    <form action="/DeleteDisciplinePageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                    </form>
                </div>
            </c:forEach>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageContent pageContentEmployeePages pageContentAdminPagesTwoFieldsSize">
        <c:if test = "${possible_to_remove eq 'yes'}">
            <div class = "textLabelParagraph textLabelEmployeePage">
                Please Confirm Delete: <c:out value="${discipline.getNameOfDiscipline()}"/>
            </div>

            <div>
                <form action="/DeleteDisciplinePageController" method="post" accept-charset="UTF-8">
                    <table>
                        <input type="hidden"  name="step" value="step2">
                        <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                        <tr>
                            <td colspan=2>
                                <button onclick="submit"  class="controlButton controlButtonEmployeePage">Delete</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </c:if>

        <c:if test = "${possible_to_remove eq 'no'}">
            <div class = "pageTitleText  pageTitleTextBad">
                Impossible to Delete: <c:out value="${institute.getLongName()}"/> , there is still some Teachers depended!
            </div>
        </c:if>
    </div>
</c:if>

<div>
    <form action="DeleteDisciplinePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
