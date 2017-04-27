<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/01/2017
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
    <title>Show Info Department Page</title>
</head>
<body class = "backgroundImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Show Department Info Page
</div>
<br />

<c:if test = "${requestScope.step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute where to Show Department:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="institutesList" scope="request" type="java.util.List"/>
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/ShowInfoDepartmentPageController" method="post" accept-charset="UTF-8">
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
        Select Faculty where to Show Department:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="facultiesList" scope="request" type="java.util.List"/>
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/ShowInfoDepartmentPageController" method="post" accept-charset="UTF-8">
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
        Select Department to Show:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="departmentsList" scope="request" type="java.util.List"/>
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/ShowInfoDepartmentPageController" method="post" accept-charset="UTF-8">
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
        Department Info: <c:out value="${requestScope.department.getLongName()}"/>
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelAdminPage">Employees:</div>
        <c:forEach items="${requestScope.department.getEmployees()}" var="employee">
            <div class = "textLabelParagraph textLabelAdminPage">- <c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></div>
        </c:forEach>

        <div class = "textLabelParagraph textLabelAdminPage">Teachers:</div>
        <c:forEach items="${requestScope.department.getTeachers()}" var="teacher">
            <div class = "textLabelParagraph textLabelAdminPage">- <c:out value="${teacher.getSecondName()}"/> <c:out value="${teacher.getName()}"/></div>
        </c:forEach>

        <div class = "textLabelParagraph textLabelAdminPage">Disciplines:</div>
        <c:forEach items="${requestScope.department.getDisciplines()}" var="discipline">
            <div class = "textLabelParagraph textLabelAdminPage">- <c:out value="${discipline.getNameOfDiscipline()}"/></div>
        </c:forEach>

        <div class = "textLabelParagraph textLabelAdminPage">Groups:</div>
        <div class = "textLabelParagraph textLabelAdminPage">Course 1:</div>
        <c:forEach items="${requestScope.department.getGroups1()}" var="group">
            <div class = "textLabelParagraph textLabelAdminPage">- <c:out value="${group.getFullGroupName()}"/></div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelAdminPage">Course 2:</div>
        <c:forEach items="${requestScope.department.getGroups2()}" var="group">
            <div class = "textLabelParagraph textLabelAdminPage">- <c:out value="${group.getFullGroupName()}"/></div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelAdminPage">Course 3:</div>
        <c:forEach items="${requestScope.department.getGroups3()}" var="group">
            <div class = "textLabelParagraph textLabelAdminPage">- <c:out value="${group.getFullGroupName()}"/></div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelAdminPage">Course 4:</div>
        <c:forEach items="${requestScope.department.getGroups4()}" var="group">
            <div class = "textLabelParagraph textLabelAdminPage">- <c:out value="${group.getFullGroupName()}"/></div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelAdminPage">Course 5:</div>
        <c:forEach items="${requestScope.department.getGroups5()}" var="group">
            <div class = "textLabelParagraph textLabelAdminPage">- <c:out value="${group.getFullGroupName()}"/></div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelAdminPage">Course 6:</div>
        <c:forEach items="${requestScope.department.getGroups6()}" var="group">
            <div class = "textLabelParagraph textLabelAdminPage">- <c:out value="${group.getFullGroupName()}"/></div>
        </c:forEach>

    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Admin/ShowInfoDepartmentPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonAdminPage">Cancel</button>
    </form>
</div>

</body>
</html>
