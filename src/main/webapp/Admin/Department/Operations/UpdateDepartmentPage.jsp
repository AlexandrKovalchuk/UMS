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

<c:if test = "${step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute where to Update Department:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="UpdateDepartmentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step1'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Faculty where to Update Department:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="UpdateDepartmentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${faculty.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step2'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Department to Update:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="UpdateDepartmentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="departmentID" value="${department.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step3'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Please fill form:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <form action="UpdateDepartmentPageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="step" value="step4">
                <input type="hidden"  name="departmentID" value="${department.getID()}" >
                <tr>
                    <td class = "textLabel textLabelAdminPage">Long name:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="longName" maxlength="70" required value="${department.getLongName()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Short name:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="shortName" maxlength="10" required value="${department.getShortName()}">
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
