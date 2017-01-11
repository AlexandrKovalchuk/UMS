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
    <link rel="stylesheet" type="text/css" href="Admin/css/admin_styles.css">
    <title>Update Employee Page</title>
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Update Employee Page!
        <br />
        <c:if test = "${selected ne 'yes'}">
            Select Employee to update:
            <c:forEach items="${institutesList}" var="institute">
                <div>
                    <h2><c:out value="${institute.getLongName()}"/></h2>
                    <c:forEach items="${institute.getFacultys()}" var="faculty">
                        <h2><c:out value="${faculty.getLongName()}"/></h2>
                        <c:forEach items="${faculty.getDepartments()}" var="department">
                            <h2><c:out value="${department.getLongName()}"/></h2>
                            <c:forEach items="${department.getEmployees()}" var="employee">
                                <form action="/UpdateEmployeePageController" method="post" accept-charset="UTF-8">
                                    <input type="hidden"  name="step" value="step1">
                                    <input type="hidden"  name="employeeID" value="${employee.getID()}">
                                    <button onclick="submit" class="itemButton" ><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></button>
                                </form>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </div>
            </c:forEach>
        </c:if>
        <c:if test = "${selected eq 'yes'}">
            Please fill form:
            <div>
                <form action="/UpdateEmployeePageController" method="post" accept-charset="UTF-8">
                    <table>
                        <input type="hidden"  name="step" value="step2">
                        <input type="hidden"  name="employeeID" value="${employee.getID()}">
                        <input type="hidden"  name="departmentID" value="${employee.getDepartmentID()}">
                        <tr class = "textInputLabel">
                            <td>Ім'я:</td>
                            <td>
                                <input type="text" name="name" required value=${employee.getName()}>
                            </td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>Прізвище:</td>
                            <td>
                                <input type="text" name="lastName" required value=${employee.getSecondName()}>
                            </td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>По Батькові:</td>
                            <td>
                                <input type="text" name="fathersName" required value=${employee.getSurname()}>
                            </td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>Ідентифікаційний код:</td>
                            <td>
                                <input type="text" name="personalID" required value=${employee.getPersonalID()}>
                            </td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>Стать:</td>
                            <td>
                                <input type="radio" name="sex" value="m" <c:if test = "${employee.getSex() eq 'm'}">checked</c:if>>Чоловіча<br>
                                <input type="radio" name="sex" value="f" <c:if test = "${employee.getSex() eq 'f'}">checked</c:if>>Жіноча<br>
                            </td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>Дата народження:</td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>День</td>
                            <td>
                                <input type="int" name="bday" required value=${employee.getDayOfBorn()}>
                            </td>
                            <td>   Місяць</td>
                            <td>
                                <input type="int" name="bmonth" required value=${employee.getMonthOfBorn()}>
                            </td>
                            <td>   Рік</td>
                            <td>
                                <input type="int" name="byear" required value=${employee.getYearOfBorn()}>
                            </td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>Пошта:</td>
                            <td>
                                <input type="text" name="email" required value=${employee.getEmail()}>
                            </td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>Телефон:</td>
                            <td>
                                <input type="text" name="phoneNumber" required value=${employee.getPhoneNumber()}>
                            </td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>Адресса:</td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>
                                <input type="text" name="address" required value=${employee.getAddress()}>
                            </td>
                        </tr>
                        <tr class = "textInputLabel">
                            <td>Паспортні данні:</td>
                            <td>
                                <input type="text" name="pasport" required value=${employee.getPasport()}>
                            </td>
                        </tr>

                        <tr class = "textInputLabel">
                            <td>Посада:</td>
                            <td>
                                <input type="text" name="office" required value=${employee.getOffice()}>
                            </td>
                        </tr>

                        <tr class = "textInputLabel">
                            <td>LogIn:</td>
                            <td>
                                <input type="text" name="login" required value=${employee.getLogin()}>
                            </td>
                        </tr>

                        <tr>
                            <td colspan=2>
                                <button onclick="submit"  class="controlButton"><h2>Update</h2></button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </c:if>
    </h5>
</div>
<div>
    <form action="UpdateEmployeePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="topicButton"><h2>Cancel</h2></button>
        </td>
    </form>
</div>
<br />
</body>
</html>
