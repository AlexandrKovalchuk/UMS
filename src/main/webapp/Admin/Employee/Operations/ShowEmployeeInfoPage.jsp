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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Show Info Employee Page</title>
</head>
<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Show Employee Info Page
</div>
<br />


<c:if test = "${step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute where to Show Info Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="ShowEmployeeInfoPageController" method="post" accept-charset="UTF-8">
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
        Select Faculty where to Show Info Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="ShowEmployeeInfoPageController" method="post" accept-charset="UTF-8">
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
        Select Department to Show Info Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="ShowEmployeeInfoPageController" method="post" accept-charset="UTF-8">
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
        Select Employee to Show Info:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${employeesList}" var="employee">
            <div>
                <form action="ShowEmployeeInfoPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step4">
                    <input type="hidden"  name="employeeID" value="${employee.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step4'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Employee Info:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <table>
            <tr>
                <td class = "textLabel textLabelAdminPage">Ім'я:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Прізвище:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getSecondName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">По Батькові:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getSurname()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Ідентифікаційний код:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getPersonalID()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Стать:</td>
                <td class = "textLabel textLabelAdminPage"><c:if test = "${employee.getSex() eq 'm'}">Чоловіча</c:if><c:if test = "${employee.getSex() eq 'f'}">Жіноча</c:if></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Дата народження:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getDayOfBorn()}"/> - <c:out value="${employee.getMonthOfBorn()}"/> - <c:out value="${employee.getYearOfBorn()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Пошта:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getEmail()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Телефон:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getPhoneNumber()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Адресса:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getAddress()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Паспортні данні:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getPasport()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">Посада:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getOffice()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelAdminPage">LogIn:</td>
                <td class = "textLabel textLabelAdminPage"><c:out value="${employee.getLogin()}"/></td>
            </tr>
        </table>
    </div>
</c:if>

<div>
    <form action="ShowEmployeeInfoPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
