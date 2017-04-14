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

<c:if test = "${step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute where to Update Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="UpdateEmployeePageController" method="post" accept-charset="UTF-8">
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
        Select Faculty where to Update Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="UpdateEmployeePageController" method="post" accept-charset="UTF-8">
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
        Select Department where to Update Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="UpdateEmployeePageController" method="post" accept-charset="UTF-8">
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
        Select Employee to Update:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${employeesList}" var="employee">
            <div>
                <form action="UpdateEmployeePageController" method="post" accept-charset="UTF-8">
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
       Please fill form:
   </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <form action="UpdateEmployeePageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="step" value="step5">
                <input type="hidden"  name="employeeID" value="${employee.getID()}">
                <input type="hidden"  name="departmentID" value="${employee.getDepartmentID()}">
                <tr>
                    <td class = "textLabel textLabelAdminPage">Name:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="name" maxlength="40" required value="${employee.getName()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Surname:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="lastName" maxlength="50" required value="${employee.getSecondName()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Middle Name:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="fathersName" maxlength="40" required value="${employee.getSurname()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Identification code:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="number" name="personalID" maxlength="10" required value="${employee.getPersonalID()}">
                    </td>
                </tr>
                <tr>
                    <td class ="textLabel textLabelAdminPage" >Sex:</td>
                    <td class ="textLabel textLabelAdminPage">
                        <input type="radio" name="sex" value="m" <c:if test = "${employee.getSex() eq 'm'}">checked</c:if>>Male<br>
                        <input type="radio" name="sex" value="f" <c:if test = "${employee.getSex() eq 'f'}">checked</c:if>>Female<br>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Date of birth:</td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Day</td>
                    <td>
                        <input class = "inputSettings inputAdminPage numericInput2" type="number" name="bday" maxlength="2" required value="${employee.getDayOfBorn()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Month</td>
                    <td>
                        <input class = "inputSettings inputAdminPage numericInput2" type="number" name="bmonth" maxlength="2" required value="${employee.getMonthOfBorn()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Year</td>
                    <td>
                        <input class = "inputSettings inputAdminPage numericInput4" type="number" name="byear" maxlength="4" required value="${employee.getYearOfBorn()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Email:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="email" maxlength="100" required value="${employee.getEmail()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Phone Number:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage" type="text" name="phoneNumber" maxlength="20" required value="${employee.getPhoneNumber()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Address:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="address" maxlength="200" required value="${employee.getAddress()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Passport data:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="pasport" maxlength="200" required value="${employee.getPasport()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">Position:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="office" maxlength="100" required value="${employee.getOffice()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelAdminPage">LogIn:</td>
                    <td>
                        <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="login" maxlength="70" required value="${employee.getLogin()}">
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
