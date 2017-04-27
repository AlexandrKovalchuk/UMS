<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 26/11/2016
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
    <title>Update Institute Page</title>
</head>
<body class = "backgroundImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Update Institute Page
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute to update:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="institutesList" scope="request" type="java.util.List"/>
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/UpdateInstitutePageController" method="post" accept-charset="UTF-8">
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
        Please fill form:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <form action="${pageContext.request.contextPath}/Admin/UpdateInstitutePageController" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="step" value="step2">
            <input type="hidden"  name="instituteID" value="${requestScope.institute.getID()}" >
            <table>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Long name:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputAdminPage inputAdminPageLongNames" type="text"
                                   name="longName" maxlength="70" value="${requestScope.institute.getLongName()}" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Short name:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputAdminPage" type="text" name="shortName" maxlength="10"
                                   required value="${requestScope.institute.getShortName()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button class="controlButton controlButtonAdminPage">Update</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Admin/UpdateInstitutePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonAdminPage">Cancel</button>
    </form>
</div>

</body>
</html>
