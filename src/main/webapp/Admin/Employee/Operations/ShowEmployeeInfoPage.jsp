<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/01/2017
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
    <title>Show Info Employee Page</title>
</head>
<body class = "backgroundImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Show Employee Info Page
</div>
<br />


<c:if test = "${requestScope.step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute where to Show Info Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="institutesList" scope="request" type="java.util.List"/>
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/ShowEmployeeInfoPageController" method="post" accept-charset="UTF-8">
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
        Select Faculty where to Show Info Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="facultiesList" scope="request" type="java.util.List"/>
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/ShowEmployeeInfoPageController" method="post" accept-charset="UTF-8">
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
        Select Department to Show Info Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="departmentsList" scope="request" type="java.util.List"/>
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/ShowEmployeeInfoPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="departmentID" value="${department.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step3'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Employee to Show Info:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="employeesList" scope="request" type="java.util.List"/>
        <c:forEach items="${employeesList}" var="employee">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/ShowEmployeeInfoPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step4">
                    <input type="hidden"  name="employeeID" value="${employee.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step4'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Employee Info:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <table>
            <tr>
                <td class = "textLabel textLabelAdminPage">Name:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Surname:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getSecondName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Middle Name:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getSurname()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Identification code:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getPersonalID()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Sex:</td>
                <td class = "textLabel textLabelAdminPage"><c:if test = "${requestScope.employee.getSex() eq 'm'}">Male</c:if><c:if test = "${requestScope.employee.getSex() eq 'f'}">Female</c:if></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Date of birth:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getDayOfBorn()}"/> - <c:out value="${requestScope.employee.getMonthOfBorn()}"/> - <c:out value="${requestScope.employee.getYearOfBorn()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Email:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getEmail()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Phone Number:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getPhoneNumber()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Address:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getAddress()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Passport data:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getPasport()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Position:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getOffice()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">LogIn:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${requestScope.employee.getLogin()}"/></td>
            </tr>
        </table>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Admin/ShowEmployeeInfoPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonAdminPage">Cancel</button>
    </form>
</div>

</body>
</html>
