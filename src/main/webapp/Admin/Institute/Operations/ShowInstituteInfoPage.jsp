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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Show Info Institute Page</title>
</head>

<body class = "backgroungImageAdmin">


<div class = "pageTitleText pageTitleTextAdmin">
    Show Institute Info Page
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute to View:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="ShowInstituteInfoPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Institute Info: <c:out value="${institute.getLongName()}"/>
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institute.getFacultys()}" var="faculty">
            <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${faculty.getLongName()}"/></div>
            <c:forEach items="${faculty.getDepartments()}" var="department">
                <div class = "textLabelParagraph textLabelAdminPage">-    <c:out value="${department.getLongName()}"/></div>
            </c:forEach>
        </c:forEach>
    </div>
</c:if>

<div>
    <form action="ShowInstituteInfoPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>

        </td>
    </form>
</div>

</body>
</html>
