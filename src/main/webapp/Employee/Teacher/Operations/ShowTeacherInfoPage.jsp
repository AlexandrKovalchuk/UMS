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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Show Teacher Info Page
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Teacher :
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <jsp:useBean id="departments" scope="request" type="java.util.List"/>
        <c:forEach items="${departments}" var="department">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>
            <c:forEach items="${department.getTeachers()}" var="teacher">
                <div>
                    <form action="${pageContext.request.contextPath}/Employee/ShowInfoTeacherPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="teacherID" value="${teacher.getID()}">
                        <button class="itemButton itemButtonEmployeePages" ><c:out value="${teacher.getSecondName()}"/> <c:out value="${teacher.getName()}"/></button>
                    </form>
                </div>
            </c:forEach>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${requestScope.selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Teacher Info:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
        <table>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Name:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Surname:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getSecondName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Middle Name:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getSurname()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Identification code:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getPersonalID()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Sex:</td>
                <td class = "textLabel textLabelEmployeePage"><c:if test = "${requestScope.teacher.getSex() eq 'm'}">Male</c:if><c:if test = "${requestScope.teacher.getSex() eq 'f'}">Female</c:if></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Date of birth:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getDayOfBorn()}"/> - <c:out value="${requestScope.teacher.getMonthOfBorn()}"/> - <c:out value="${requestScope.teacher.getYearOfBorn()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Email:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getEmail()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Phone Number:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getPhoneNumber()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Address:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getAddress()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Passport data:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getPasport()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Position:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getOffice()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Academic Title:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getLevel()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">LogIn:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.teacher.getLogin()}"/></td>
            </tr>

            <tr>
                <td class = "textLabel textLabelEmployeePage">Disciplines:</td>
            </tr>

            <tr>
                <td  class = "textLabel textLabelEmployeePage">
                    <c:forEach items="${requestScope.teacher.getDisciplines()}" var="discipline">
                        - <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                    </c:forEach>
                </td>
            </tr>
        </table>
    </div>
</c:if>


<div>
    <form action="${pageContext.request.contextPath}/Employee/ShowInfoTeacherPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>
</body>
</html>
