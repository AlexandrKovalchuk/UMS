<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28/11/2016
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
    <title>Delete Institute Page</title>
</head>
<body class = "backgroundImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Delete Institute Page
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute to delete:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="institutesList" scope="request" type="java.util.List"/>
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/DeleteInstitutePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.selected eq 'yes'}">
    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <c:if test = "${requestScope.possible_to_remove eq 'yes'}">
            <div class = "textLabelParagraph textLabelAdminPage">
                Please Confirm Delete: <c:out value="${requestScope.institute.getLongName()}"/>
            </div>

            <div>
                <form action="${pageContext.request.contextPath}/Admin/DeleteInstitutePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="instituteID" value="${requestScope.institute.getID()}">
                    <button class="controlButton controlButtonAdminPage">Delete</button>
                </form>
            </div>
        </c:if>

        <c:if test = "${requestScope.possible_to_remove eq 'no'}">
            <div class = "pageTitleText  pageTitleTextBad">
                Impossible to Delete: <c:out value="${requestScope.institute.getLongName()}"/> , there is still some faculties present!
            </div>
        </c:if>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Admin/DeleteInstitutePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonAdminPage">Cancel</button>
    </form>
</div>

</body>
</html>
