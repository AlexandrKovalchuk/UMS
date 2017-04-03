<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 12/12/2016
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Delete Department Page</title>
</head>

<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Delete Department Page
</div>
<br />

<c:if test = "${step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute where to Delete Department:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="DeleteDepartmentPageController" method="post" accept-charset="UTF-8">
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
        Select Faculty where to Delete Department:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="DeleteDepartmentPageController" method="post" accept-charset="UTF-8">
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
        Select Department to Delete:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="DeleteDepartmentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="departmentID" value="${department.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step3'}">
    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <c:if test = "${possible_to_remove eq 'yes'}">
            <div class = "textLabelParagraph textLabelAdminPage">
                Please Confirm Delete: <c:out value="${department.getLongName()}"/>
            </div>

            <div>
                <form action="DeleteDepartmentPageController" method="post" accept-charset="UTF-8">
                    <table>
                        <input type="hidden"  name="step" value="step4">
                        <input type="hidden"  name="departmentID" value="${department.getID()}" >
                        <tr>
                            <td colspan=2>
                                <button onclick="submit"  class="controlButton controlButtonAdminPage">Delete</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </c:if>
        <c:if test = "${possible_to_remove eq 'no'}">
            <div class = "pageTitleText  pageTitleTextBad">
                Impossible to Delete: <c:out value="${department.getLongName()}"/> , there is still some date present!
            </div>
        </c:if>
    </div>
</c:if>

<div>
    <form action="DeleteDepartmentPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
