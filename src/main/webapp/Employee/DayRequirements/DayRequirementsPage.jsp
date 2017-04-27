<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 24/02/2017
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Day Requirements Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Day Requirements Page
</div>
<br />

<c:if test = "${requestScope.step eq 'step0'}">
<c:if test = "${requestScope.requirementsPresent eq 'no'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Set day parameters:
    </div>
    <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
        <form action="${pageContext.request.contextPath}/Employee/DayRequirementsPageController" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="step" value="step1">
            <input type="hidden"  name="requirementsPresent" value="no">
            <table>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Count Of Days In Week:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee  numericInput2" type="number"
                                   name="countOfDaysInWeek" maxlength="1" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Count Of Lessons In A Day:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee  numericInput2" type="number"
                                   name="countOfLessonsInADay" maxlength="2" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button class="controlButton controlButtonEmployeePage">Create</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</c:if>

<c:if test = "${requestScope.requirementsPresent eq 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Update day parameters:
    </div>
    <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
        <form action="${pageContext.request.contextPath}/Employee/DayRequirementsPageController" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="step" value="step1">
            <input type="hidden"  name="requirementsPresent" value="yes">
            <table>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Count Of Days In Week:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee  numericInput2" type="number"
                                   name="countOfDaysInWeek" maxlength="1"
                                   value="${requestScope.dayRequirementsObject.getCountOfDaysInWeek()}" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Count Of Lessons In A Day:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee numericInput2 " type="number"
                                   name="countOfLessonsInADay" maxlength="2"
                                   value="${requestScope.dayRequirementsObject.getCountOfLessonsInADay()}" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button  class="controlButton controlButtonEmployeePage">Update</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</c:if>
</c:if>

<c:if test = "${requestScope.step eq 'step1'}">
    <c:if test = "${requestScope.requirementsPresent eq 'no'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Set day parameters:
        </div>
        <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
            <form action="${pageContext.request.contextPath}/Employee/DayRequirementsPageController" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="step" value="step2">
                <input type="hidden"  name="requirementsPresent" value="no">
                <table>
                    <c:forEach var="i" begin="0" end="${requestScope.dayRequirementsObject.getCountOfLessonsInADay()-1}">
                        <tr>
                            <td class = "textLabel textLabelEmployeePage">Time for Lesson #<c:out value="${i+1}"/>:</td>
                            <td>
                                <label>
                                    <input class="inputSettings inputEmployee" type="text" maxlength="5"
                                           name="timeForLesson<c:out value="${i+1}"/>" required/>
                                </label>
                            </td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td colspan=2>
                            <button class="controlButton controlButtonEmployeePage">Set</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </c:if>

    <c:if test = "${requestScope.requirementsPresent eq 'yes'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Update day parameters:
        </div>
        <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
            <form action="${pageContext.request.contextPath}/Employee/DayRequirementsPageController" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="step" value="step2">
                <input type="hidden"  name="requirementsPresent" value="yes">
                <table>
                    <c:forEach var="i" begin="0" end="${requestScope.dayRequirementsObject.getCountOfLessonsInADay()-1}">
                        <tr>
                            <td class = "textLabel textLabelEmployeePage">Time for Lesson #<c:out value="${i+1}"/>:</td>
                            <td>
                                <label>
                                    <input class="inputSettings inputEmployee" type="text" maxlength="5"
                                           name="timeForLesson<c:out value="${i+1}"/>"
                                    value="${requestScope.dayRequirementsObject.getLessonsTime().get(i)}" required/>
                                </label>
                            </td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td colspan=2>
                            <button class="controlButton controlButtonEmployeePage">Update</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </c:if>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/DayRequirementsPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
