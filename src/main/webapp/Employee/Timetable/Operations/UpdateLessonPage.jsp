<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 04/04/2017
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Update Lesson Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body style="background-color:#45250d;">

<div class = "pageTitleText pageTitleTextEmployee">
    Update Lesson Page
</div>
<br />

<c:if test = "${requestScope.operation eq 'step1'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Discipline:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div>
            <form action="${pageContext.request.contextPath}/Employee/UpdateLessonPageController" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="operation" value="step2">
                <input type="hidden"  name="lessonID" value="${requestScope.lessonID}">
                <input type="hidden"  name="disciplineID" value="NULL">
                <button class="itemButton itemButtonEmployeePages" >NONE</button>
            </form>
        </div>

        <jsp:useBean id="disciplines" scope="request" type="java.util.List"/>
        <c:forEach items="${disciplines}" var="discipline">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/UpdateLessonPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="operation" value="step1">
                    <input type="hidden"  name="lessonID" value="${requestScope.lessonID}">
                    <input type="hidden"  name="disciplineID" value="${discipline.getID()}">
                    <button  class="itemButton itemButtonEmployeePages" ><c:out value="${discipline.getNameOfDiscipline()}"/></button>
                </form>
            </div>
        </c:forEach>

    </div>

</c:if>
<c:if test = "${requestScope.operation eq 'step2'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Discipline:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">

        <jsp:useBean id="teachers" scope="request" type="java.util.List"/>
        <c:forEach items="${teachers}" var="teacher">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/UpdateLessonPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="operation" value="step2">
                    <input type="hidden"  name="lessonID" value="${requestScope.lessonID}">
                    <input type="hidden"  name="disciplineID" value="${requestScope.disciplineID}">
                    <input type="hidden"  name="teacherID" value="${teacher.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${teacher.getSecondName()}"/> <c:out value="${teacher.getName()}"/></button>
                </form>
            </div>
        </c:forEach>

    </div>

</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/UpdateLessonPageController" method="post">
        <input type="hidden"  name="operation" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
