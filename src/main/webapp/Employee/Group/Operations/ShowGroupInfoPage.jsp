<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 04/02/2017
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Show Group Info Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Show Group Info Page!
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Group :
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <c:forEach items="${departments}" var="department">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #1</div>
            <c:forEach items="${department.getGroups1()}" var="group">
                <div>
                    <form action="/ShowInfoGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #2</div>
            <c:forEach items="${department.getGroups2()}" var="group">
                <div>
                    <form action="/ShowInfoGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #3</div>
            <c:forEach items="${department.getGroups3()}" var="group">
                <div>
                    <form action="/ShowInfoGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #4</div>
            <c:forEach items="${department.getGroups4()}" var="group">
                <div>
                    <form action="/ShowInfoGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #5</div>
            <c:forEach items="${department.getGroups5()}" var="group">
                <div>
                    <form action="/ShowInfoGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #6</div>
            <c:forEach items="${department.getGroups6()}" var="group">
                <div>
                    <form action="/ShowInfoGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Group Info: <c:out value="${group.getFullGroupName()}"/>
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <table>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Group name:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${group.getFullGroupName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Course Number:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${group.getCourseNumber()}"/></td>
            </tr>
            <br />
            <tr>
                <td class = "textLabel textLabelEmployeePage">Students:</td>
            </tr>

            <tr>
                <c:forEach items="${group.getStudents()}" var="student">
                    <td class = "textLabel textLabelEmployeePage"><c:out value="${student.getSecondName()}"/> <c:out value="${student.getName()}"/></td>
                </c:forEach>
            </tr>
        </table>
    </div>
</c:if>


<div>
    <form action="ShowInfoGroupPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>
</body>
</html>
