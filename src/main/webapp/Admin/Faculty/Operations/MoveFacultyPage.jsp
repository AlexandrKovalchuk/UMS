<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 01/12/2016
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
    <title>Move Faculty Page</title>
</head>
<body class = "backgroundImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Move Faculty Page
</div>
<br />

<c:if test = "${requestScope.step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute From Which to Move Faculty:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="institutesList" scope="request" type="java.util.List"/>
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/MoveFacultyPageController" method="post" accept-charset="UTF-8">
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
        Select Which Faculty move:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="facultiesList" scope="request" type="java.util.List"/>
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/MoveFacultyPageController" method="post" accept-charset="UTF-8">
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
        Select Institute where to move <c:out value="${requestScope.faculty.getLongName()}"/>:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="institutes" scope="request" type="java.util.List"/>
        <c:forEach items="${institutes}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/MoveFacultyPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <input type="hidden"  name="facultyID" value="${requestScope.faculty.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step3'}">
    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <div class = "pageTitleText pageTitleTextAdmin">
            Confirm moving <c:out value="${requestScope.faculty.getLongName()}"/> to <c:out value="${requestScope.institute.getLongName()}"/>
        </div>
        <form action="${pageContext.request.contextPath}/Admin/MoveFacultyPageController" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="step" value="step4">
            <input type="hidden"  name="instituteID" value="${requestScope.institute.getID()}">
            <input type="hidden"  name="facultyID" value="${requestScope.faculty.getID()}" >
            <button class="controlButton controlButtonAdminPage">Move</button>
        </form>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Admin/MoveFacultyPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonAdminPage">Cancel</button>
    </form>
</div>

</body>
</html>
