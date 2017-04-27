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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
    <title>Move Employee Page</title>
</head>
<body class = "backgroundImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Move Employee Page
</div>
<br />

<c:if test = "${requestScope.step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute from Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="institutesList" scope="request" type="java.util.List"/>
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step1'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Faculty from Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="facultiesList" scope="request" type="java.util.List"/>
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${faculty.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step2'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Department from Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="departmentsList" scope="request" type="java.util.List"/>
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="departmentID" value="${department.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step3'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Employee to Update:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="employeesList" scope="request" type="java.util.List"/>
        <c:forEach items="${employeesList}" var="employee">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step4">
                    <input type="hidden"  name="employeeID" value="${employee.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step4'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step5">
                    <input type="hidden"  name="employeeID" value="${requestScope.employeeID}">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step5'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Faculty Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step6">
                    <input type="hidden"  name="employeeID" value="${requestScope.employeeID}">
                    <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${faculty.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step6'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Department Where to Move Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">

        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/MoveEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step7">
                    <input type="hidden"  name="employeeID" value="${requestScope.employeeID}">
                    <input type="hidden"  name="departmentID" value="${department.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step7'}">
    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <div class = "pageTitleText pageTitleTextAdmin">
            Confirm moving  <c:out value="${requestScope.employee.getSecondName()}"/> <c:out value="${requestScope.employee.getName()}"/> to <c:out value="${requestScope.department.getLongName()}"/>
        </div>

        <div>
            <form action="${pageContext.request.contextPath}/Admin/MoveEmployeePageController" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="step" value="step8">
                <input type="hidden"  name="employeeID" value="${requestScope.employee.getID()}">
                <input type="hidden"  name="departmentID" value="${requestScope.department.getID()}" >
                <button class="controlButton controlButtonAdminPage">Move</button>
            </form>
        </div>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Admin/MoveEmployeePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
            <button class="controlButton controlButtonAdminPage">Cancel</button>
    </form>
</div>

</body>
</html>
