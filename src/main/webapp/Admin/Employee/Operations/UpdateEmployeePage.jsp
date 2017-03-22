<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 10/01/2017
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Update Employee Page</title>
</head>
<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
        Update Employee Page
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
            Select Employee to update:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${institute.getLongName()}"/>:</div>
            <c:forEach items="${institute.getFacultys()}" var="faculty">
                <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${faculty.getLongName()}"/>:</div>
                <c:forEach items="${faculty.getDepartments()}" var="department">
                    <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${department.getLongName()}"/>:</div>
                    <c:forEach items="${department.getEmployees()}" var="employee">
                        <div>
                            <form action="UpdateEmployeePageController" method="post" accept-charset="UTF-8">
                                <input type="hidden"  name="step" value="step1">
                                <input type="hidden"  name="employeeID" value="${employee.getID()}">
                                <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></button>
                            </form>
                        </div>
                    </c:forEach>
                </c:forEach>
            </c:forEach>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${selected eq 'yes'}">
   <div class = "pageTitleText pageTitleTextAdmin">
       Please fill form:
   </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <form action="UpdateEmployeePageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="step" value="step2">
                <input type="hidden"  name="employeeID" value="${employee.getID()}">
                <input type="hidden"  name="departmentID" value="${employee.getDepartmentID()}">
                <tr>
                    <td class = "textLabel textLabelAdminPage">Ім'я:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="name" required value="${employee.getName()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Прізвище:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="lastName" required value="${employee.getSecondName()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">По Батькові:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="fathersName" required value="${employee.getSurname()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Ідентифікаційний код:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="personalID" required value="${employee.getPersonalID()}">
                    </td>
                </tr>
                <tr>
                    <td class ="textLabel textLabelAdminPage" >Стать:</td>
                    <td class ="textLabel textLabelAdminPage">
                        <input type="radio" name="sex" value="m" <c:if test = "${employee.getSex() eq 'm'}">checked</c:if>>Чоловіча<br>
                        <input type="radio" name="sex" value="f" <c:if test = "${employee.getSex() eq 'f'}">checked</c:if>>Жіноча<br>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Дата народження:</td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">День</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="int" name="bday" required value="${employee.getDayOfBorn()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Місяць</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="int" name="bmonth" required value="${employee.getMonthOfBorn()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Рік</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="int" name="byear" required value="${employee.getYearOfBorn()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Пошта:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="email" required value="${employee.getEmail()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Телефон:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="phoneNumber" required value="${employee.getPhoneNumber()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Адресса:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="address" required value="${employee.getAddress()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Паспортні данні:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="pasport" required value="${employee.getPasport()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Посада:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="office" required value="${employee.getOffice()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">LogIn:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="login" required value="${employee.getLogin()}">
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
    <form action="UpdateEmployeePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
