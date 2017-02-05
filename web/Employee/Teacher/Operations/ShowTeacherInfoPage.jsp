<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/02/2017
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Show Teacher Info Page</title>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Show Teacher Info Page!
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Teacher :
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <c:forEach items="${departments}" var="department">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>
            <c:forEach items="${department.getTeachers()}" var="teacher">
                <div>
                    <form action="/ShowInfoTeacherPageController" method="post" accept-charset="UTF-8">
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
        Teacher Info:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
        <table>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Ім'я:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Прізвище:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getSecondName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">По Батькові:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getSurname()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Ідентифікаційний код:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getPersonalID()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Стать:</td>
                <td class = "textLabel textLabelEmployeePage"><c:if test = "${teacher.getSex() eq 'm'}">Чоловіча</c:if><c:if test = "${teacher.getSex() eq 'f'}">Жіноча</c:if></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Дата народження:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getDayOfBorn()}"/> - <c:out value="${teacher.getMonthOfBorn()}"/> - <c:out value="${teacher.getYearOfBorn()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Пошта:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getEmail()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Телефон:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getPhoneNumber()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Адресса:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getAddress()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Паспортні данні:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getPasport()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Посада:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getOffice()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Звання:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getLevel()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">LogIn:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${teacher.getLogin()}"/></td>
            </tr>

            <tr>
                <td class = "textLabel textLabelEmployeePage">Disciplines:</td>
            </tr>

            <tr>
                <td  class = "textLabel textLabelEmployeePage">
                    <c:forEach items="${teacher.getDisciplines()}" var="discipline">
                        - <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                    </c:forEach>
                </td>
            </tr>
        </table>
    </div>
</c:if>


<div>
    <form action="ShowInfoTeacherPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>
</body>
</html>
