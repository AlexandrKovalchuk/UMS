<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/12/2016
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<head lang="en">
    <meta charset="UTF-8">
    <title>Create Department Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>
<body class = "backgroundImageAdmin">
<div class = "pageTitleText pageTitleTextAdmin">
        Create Department Page
</div>
<br />

<c:if test = "${requestScope.step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute where to Create Department:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="institutesList" scope="request" type="java.util.List"/>
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/CreateDepartmentPageController" method="post" accept-charset="UTF-8">
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
        Select Faculty where to Create Department:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="facultiesList" scope="request" type="java.util.List"/>
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/CreateDepartmentPageController" method="post" accept-charset="UTF-8">
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
            Please fill form:
        </div>

        <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
            <form action="${pageContext.request.contextPath}/Admin/CreateDepartmentPageController" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="step" value="step3">
                <input type="hidden"  name="facultyID" value="${requestScope.faculty.getID()}">
                <table>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Long name:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage inputAdminPageLongNames" type="text"
                                       name="longName" maxlength="70" required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Short name:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage" type="text" name="shortName" maxlength="10"
                                       required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>
                            <button class="controlButton controlButtonAdminPage">Create</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </c:if>

<div>
    <form action="${pageContext.request.contextPath}/Admin/CreateDepartmentPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonAdminPage">Cancel</button>
    </form>
</div>
<br />
</body>
</html>
