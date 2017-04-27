<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 20/12/2016
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
    <title>Show Info Institute Page</title>
</head>

<body class = "backgroundImageAdmin">


<div class = "pageTitleText pageTitleTextAdmin">
    Show Institute Info Page
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute to View:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="institutesList" scope="request" type="java.util.List"/>
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/ShowInstituteInfoPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Institute Info: <c:out value="${requestScope.institute.getLongName()}"/>
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${requestScope.institute.getFacultys()}" var="faculty">
            <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${faculty.getLongName()}"/></div>
            <c:forEach items="${faculty.getDepartments()}" var="department">
                <div class = "textLabelParagraph textLabelAdminPage">-    <c:out value="${department.getLongName()}"/></div>
            </c:forEach>
        </c:forEach>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Admin/ShowInstituteInfoPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonAdminPage">Cancel</button>
    </form>
</div>

</body>
</html>
