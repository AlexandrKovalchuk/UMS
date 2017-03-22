<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 06/12/2016
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Update Faculty Page</title>
</head>
<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Update Department Page
</div>
<br />


<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Department to update:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${institute.getLongName()}"/></div>
            <c:forEach items="${institute.getFacultys()}" var="faculty">
                <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${faculty.getLongName()}"/></div>
                <c:forEach items="${faculty.getDepartments()}" var="department">
                    <div>
                        <form action="UpdateDepartmentPageController" method="post" accept-charset="UTF-8">
                            <input type="hidden"  name="step" value="step1">
                            <input type="hidden"  name="departmentID" value="${department.getID()}">
                            <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                        </form>
                    </div>
                </c:forEach>
            </c:forEach>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Please fill form:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <form action="UpdateDepartmentPageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="step" value="step2">
                <input type="hidden"  name="departmentID" value="${department.getID()}" >
                <tr>
                    <td class = "textLabel textLabelAdminPage">Long name:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="longName"  required value="${department.getLongName()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Short name:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="shortName" required value="${department.getShortName()}">
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button onclick="submit"  class="controlButton controlButtonAdminPage">Update</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</c:if>

<div>
    <form action="UpdateDepartmentPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
