<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 06/02/2017
  Time: 00:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Update Teacher Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Update Teacher Page (<c:out value="${department.getLongName()}"/>)
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Teacher to Update:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <c:forEach items="${departments}" var="department">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>
            <c:forEach items="${department.getTeachers()}" var="teacher">
                <div>
                    <form action="UpdateTeacherPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="teacherID" value="${teacher.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${teacher.getSecondName()}"/> <c:out value="${teacher.getName()}"/></button>
                    </form>
                </div>
            </c:forEach>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Please fill form:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <form action="UpdateTeacherPageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="step" value="step2">
                <input type="hidden"  name="teacherID" value="${teacher.getID()}">
                <input type="hidden"  name="departmentID" value="${teacher.getDepartmentID()}">
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Ім'я:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="text" name="name" maxlength="40" required value="${teacher.getName()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Прізвище:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="text" name="lastName" maxlength="50" required value="${teacher.getSecondName()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">По Батькові:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="text" name="fathersName" maxlength="40" required value="${teacher.getSurname()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Ідентифікаційний код:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="text" name="personalID" maxlength="10" required value="${teacher.getPersonalID()}">
                    </td>
                </tr>
                <tr>
                    <td class ="textLabel textLabelEmployeePage" >Стать:</td>
                    <td class ="textLabel textLabelEmployeePage">
                        <input type="radio" name="sex" value="m" <c:if test = "${teacher.getSex() eq 'm'}">checked</c:if>>Чоловіча<br>
                        <input type="radio" name="sex" value="f" <c:if test = "${teacher.getSex() eq 'f'}">checked</c:if>>Жіноча<br>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Дата народження:</td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">День</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="int" name="bday" maxlength="2" required value="${teacher.getDayOfBorn()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Місяць</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="int" name="bmonth" maxlength="2" required value="${teacher.getMonthOfBorn()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Рік</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="int" name="byear" maxlength="4" required value="${teacher.getYearOfBorn()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Пошта:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="email" maxlength="100" required value="${teacher.getEmail()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Телефон:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="text" name="phoneNumber" maxlength="20" required value="${teacher.getPhoneNumber()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Адресса:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="address" maxlength="200" required value="${teacher.getAddress()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Паспортні данні:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="pasport" maxlength="200" required value="${teacher.getPasport()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Посада:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="office" maxlength="100" required value="${teacher.getOffice()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Звання:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="level" maxlength="100" required value="${teacher.getLevel()}">
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">LogIn:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="login" maxlength="70" required value="${teacher.getLogin()}">
                    </td>
                </tr>
            </table>

            <table>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Disciplines:</td>
                </tr>

                <tr>
                    <td  class = "textLabel textLabelEmployeePage">
                        <c:forEach items="${teacher.getDisciplines()}" var="discipline">
                            <input type="checkbox" name="discipline" value="<c:out value="${discipline.getID()}"/>" checked> <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Current department:</td>
                </tr>

                <tr>
                    <td  class = "textLabel textLabelEmployeePage">
                        <c:forEach items="${disciplines}" var="discipline">
                            <input type="checkbox" name="discipline" value="<c:out value="${discipline.getID()}"/>" > <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Not current department:</td>
                </tr>

                <tr>
                    <td  class = "textLabel textLabelEmployeePage">
                        <c:forEach items="${disciplinesNotConnected}" var="discipline">
                            <input type="checkbox" name="discipline" value="<c:out value="${discipline.getID()}"/>" > <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td colspan=2>
                        <button onclick="submit"  class="controlButton controlButtonEmployeePage">Update</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</c:if>

<div>
    <form action="UpdateTeacherPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
