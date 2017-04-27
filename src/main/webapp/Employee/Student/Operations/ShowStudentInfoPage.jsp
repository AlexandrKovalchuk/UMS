<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 21/02/2017
  Time: 07:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Student Info Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>
<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Show Student Info Page
</div>
<br />

<c:if test = "${requestScope.selected eq 'no'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Group to show students info:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${requestScope.department.getLongName()}"/></div>

        <div class = "textLabelParagraph textLabelEmployeePage">Course 1:</div>
        <c:forEach items="${requestScope.department.getGroups1()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/ShowInfoStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 2:</div>
        <c:forEach items="${requestScope.department.getGroups2()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/ShowInfoStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 3:</div>
        <c:forEach items="${requestScope.department.getGroups3()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/ShowInfoStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 4:</div>
        <c:forEach items="${requestScope.department.getGroups4()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/ShowInfoStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 5:</div>
        <c:forEach items="${requestScope.department.getGroups5()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/ShowInfoStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 6:</div>
        <c:forEach items="${requestScope.department.getGroups6()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/ShowInfoStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${requestScope.selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Student to Show:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <jsp:useBean id="students" scope="request" type="java.util.List"/>
        <c:forEach items="${students}" var="student">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/ShowInfoStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="studentID" value="${student.getID()}">
                    <button class="itemButton itemButtonEmployeePages" > <c:out value="${student.getSecondName()}"/> <c:out value="${student.getName()}"/></button>
                </form>
            </div>
        </c:forEach>

    </div>
</c:if>

<c:if test = "${requestScope.selected eq 'studentyes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Student Info:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <table>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Name:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Surname:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getSecondName()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Middle Name:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getSurname()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Identification code:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getPersonalID()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Sex:</td>
                <td class = "textLabel textLabelEmployeePage"><c:if test = "${requestScope.student.getSex() eq 'm'}">Male</c:if><c:if test = "${requestScope.teacher.getSex() eq 'f'}">Female</c:if></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Date of birth:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getDayOfBorn()}"/> - <c:out value="${requestScope.student.getMonthOfBorn()}"/> - <c:out value="${requestScope.student.getYearOfBorn()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Email:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getEmail()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Phone Number:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getPhoneNumber()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Address:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getAddress()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Passport data:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getPasport()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">Students book:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getIndexBook()}"/></td>
            </tr>
            <tr>
                <td class = "textLabel textLabelEmployeePage">LogIn:</td>
                <td class = "textLabel textLabelEmployeePage"><c:out value="${requestScope.student.getLogin()}"/></td>
            </tr>

        </table>

        <div class = "pageTitleText pageTitleTextEmployee">
            Attendance:
        </div>
        <c:set var="count" value="1" scope="page" />
        <c:forEach begin="1" end="6" varStatus="loop">
            <div class = "pageTitleText pageTitleTextEmployee">
                Course #<c:out value="${count}"/>
            </div>
            <table  class = "studentTable">
                <c:forEach var="saoItem" items="${requestScope.student.getAttendance()}">
                    <c:if test = "${requestScope.student.getDisciplines().get(saoItem.value.getDisciplineID()).getCourseNumber() == count}">
                        <tr  class = "studentTable">
                        <td class = "textLabel textLabelEmployeePage studentTable"><c:out value="${requestScope.student.getDisciplines().get(saoItem.value.getDisciplineID()).getNameOfDiscipline()}"/></td>
                            <c:forEach var="attendance" items="${saoItem.value.getAttendance()}">
                                <td class = "textLabel textLabelEmployeePage studentTable studentTableWidth"><c:out value="${attendance}"/></td>
                            </c:forEach>
                        </tr>
                    </c:if>
                </c:forEach>

            </table>
            <c:set var="count" value="${count + 1}" scope="page"/>
        </c:forEach>

        <div class = "pageTitleText pageTitleTextEmployee">
            Progress:
        </div>
        <c:set var="count" value="1" scope="page" />
        <c:forEach begin="1" end="6" varStatus="loop">
            <div class = "pageTitleText pageTitleTextEmployee">
                Course #<c:out value="${count}"/>
            </div>
            <table class = "studentTable">
                <c:forEach var="saoItem" items="${requestScope.student.getProgress()}">
                    <c:if test = "${requestScope.student.getDisciplines().get(saoItem.value.getDisciplineID()).getCourseNumber() == count}">
                        <tr class = "studentTable">
                            <td class = "textLabel textLabelEmployeePage studentTable"><c:out value="${requestScope.student.getDisciplines().get(saoItem.value.getDisciplineID()).getNameOfDiscipline()}"/></td>
                            <c:forEach var="progress" items="${saoItem.value.getProgress()}">
                                <td class = "textLabel textLabelEmployeePage studentTable studentTableWidth"><c:out value="${progress}"/></td>
                            </c:forEach>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            <c:set var="count" value="${count + 1}" scope="page"/>
        </c:forEach>
    </div>
</c:if>


<div>
    <form action="${pageContext.request.contextPath}/Employee/ShowInfoStudentPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>
</body>
</html>
