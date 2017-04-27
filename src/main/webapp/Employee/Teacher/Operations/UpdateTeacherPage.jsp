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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Update Teacher Page (<c:out value="${requestScope.department.getLongName()}"/>)
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Teacher to Update:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <jsp:useBean id="departments" scope="request" type="java.util.List"/>
        <c:forEach items="${departments}" var="department">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>
            <c:forEach items="${department.getTeachers()}" var="teacher">
                <div>
                    <form action="${pageContext.request.contextPath}/Employee/UpdateTeacherPageController" method="post" accept-charset="UTF-8">
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
        Please fill form:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <form action="${pageContext.request.contextPath}/Employee/UpdateTeacherPageController" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="step" value="step2">
            <input type="hidden"  name="teacherID" value="${requestScope.teacher.getID()}">
            <input type="hidden"  name="departmentID" value="${requestScope.teacher.getDepartmentID()}">
            <table>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Name:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="text" name="name" maxlength="40" required
                                   value="${requestScope.teacher.getName()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Surname:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="text" name="lastName" maxlength="50"
                                   required value="${requestScope.teacher.getSecondName()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Middle Name:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="text" name="fathersName" maxlength="40"
                                   required value="${requestScope.teacher.getSurname()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Identification code:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="number" name="personalID" maxlength="10"
                                   required value="${requestScope.teacher.getPersonalID()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class ="textLabel textLabelEmployeePage" >Sex:</td>
                    <td class ="textLabel textLabelEmployeePage">
                        <label>
                            <input type="radio" name="sex" value="m" <c:if
                                test="${requestScope.teacher.getSex() eq 'm'}">checked</c:if>>
                        </label>Male<br>
                        <label>
                            <input type="radio" name="sex" value="f" <c:if
                                test="${requestScope.teacher.getSex() eq 'f'}">checked</c:if>>
                        </label>Female<br>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Date of birth:</td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Day</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee numericInput2" type="number" name="bday"
                                   maxlength="2" required value="${requestScope.teacher.getDayOfBorn()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Month</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee numericInput2" type="number" name="bmonth"
                                   maxlength="2" required value="${requestScope.teacher.getMonthOfBorn()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Year</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee numericInput4" type="number" name="byear"
                                   maxlength="4" required value="${requestScope.teacher.getYearOfBorn()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Email:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text" name="email"
                                   maxlength="100" required value="${requestScope.teacher.getEmail()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Phone Number:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="text" name="phoneNumber" maxlength="20"
                                   required value="${requestScope.teacher.getPhoneNumber()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Address:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text"
                                   name="address" maxlength="200" required value="${requestScope.teacher.getAddress()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Passport data:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text"
                                   name="pasport" maxlength="200" required value="${requestScope.teacher.getPasport()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Position:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text" name="office"
                                   maxlength="100" required value="${requestScope.teacher.getOffice()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Academic Title:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text" name="level"
                                   maxlength="100" required value="${requestScope.teacher.getLevel()}">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">LogIn:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text" name="login"
                                   maxlength="70" required value="${requestScope.teacher.getLogin()}">
                        </label>
                    </td>
                </tr>
            </table>

            <table>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Disciplines:</td>
                </tr>

                <tr>
                    <td  class = "textLabel textLabelEmployeePage">
                        <c:forEach items="${requestScope.teacher.getDisciplines()}" var="discipline">
                            <label>
                                <input type="checkbox" name="discipline" value="<c:out value="${discipline.getID()}"/>"
                                checked>
                            </label> <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Current department:</td>
                </tr>

                <tr>
                    <td  class = "textLabel textLabelEmployeePage">
                        <jsp:useBean id="disciplines" scope="request" type="java.util.List"/>
                        <c:forEach items="${disciplines}" var="discipline">
                            <label>
                                <input type="checkbox" name="discipline" value="<c:out value="${discipline.getID()}"/>"
                                >
                            </label> <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Not current department:</td>
                </tr>

                <tr>
                    <td  class = "textLabel textLabelEmployeePage">
                        <c:forEach items="${requestScope.disciplinesNotConnected}" var="discipline">
                            <label>
                                <input type="checkbox" name="discipline" value="<c:out value="${discipline.getID()}"/>"
                                >
                            </label> <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td colspan=2>
                        <button class="controlButton controlButtonEmployeePage">Update</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/UpdateTeacherPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
