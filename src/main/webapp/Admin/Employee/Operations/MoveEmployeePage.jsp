<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 12/12/2016
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Move Employee Page</title>
</head>
<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Move Employee Page
</div>
<br />

<c:if test = "${step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute from Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step1'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Faculty from Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${faculty.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step2'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Department from Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="departmentID" value="${department.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step3'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Employee to Update:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${employeesList}" var="employee">
            <div>
                <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step4">
                    <input type="hidden"  name="employeeID" value="${employee.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step4'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step5">
                    <input type="hidden"  name="employeeID" value="${employeeID}">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step5'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Faculty Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step6">
                    <input type="hidden"  name="employeeID" value="${employeeID}">
                    <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${faculty.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step6'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Department Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step7">
                    <input type="hidden"  name="employeeID" value="${employeeID}">
                    <input type="hidden"  name="departmentID" value="${department.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step7'}">
    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <div class = "pageTitleText pageTitleTextAdmin">
            Confirm moving  <c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/> to <c:out value="${department.getLongName()}"/>
        </div>

        <div>
            <form action="MoveEmployeePageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step8">
                    <input type="hidden"  name="employeeID" value="${employee.getID()}">
                    <input type="hidden"  name="departmentID" value="${department.getID()}" >
                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton controlButtonAdminPage">Move</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</c:if>

<div>
    <form action="MoveEmployeePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
