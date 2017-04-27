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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Move Teacher Page (<c:out value="${requestScope.department.getLongName()}"/>)
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Teacher to Move:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <jsp:useBean id="departments" scope="request" type="java.util.List"/>
        <c:forEach items="${departments}" var="department">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>
            <c:forEach items="${department.getTeachers()}" var="teacher">
                <div>
                    <form action="${pageContext.request.contextPath}/Employee/MoveTeacherPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="teacherID" value="${teacher.getID()}">
                        <button class="itemButton itemButtonEmployeePages" ><c:out value="${teacher.getSecondName()}"/> <c:out value="${teacher.getName()}"/></button>
                    </form>
                </div>
            </c:forEach>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${requestScope.selected eq 'yes'}">
    <div class = "pageContent pageContentEmployeePages pageContentAdminPagesTwoFieldsSize">
        <div class = "textLabelParagraph textLabelEmployeePage">
            Please Confirm Move: <c:out value="${requestScope.teacher.getSecondName()}"/> <c:out value="${requestScope.teacher.getName()}"/>
            <br />from <c:out value="${requestScope.currentDepartment.getLongName()}"/> to <c:out value="${requestScope.moveToDepartment.getLongName()}"/>
        </div>

        <div>
            <form action="${pageContext.request.contextPath}/Employee/MoveTeacherPageController" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="step" value="step2">
                <input type="hidden"  name="departmentID" value="${requestScope.moveToDepartment.getID()}">
                <input type="hidden"  name="teacherID" value="${requestScope.teacher.getID()}">
                <button class="controlButton controlButtonEmployeePage">Move</button>
            </form>
        </div>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/MoveTeacherPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
