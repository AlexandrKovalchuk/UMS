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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>

<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Day Requirements Page!
</div>
<br />

<c:if test = "${step eq 'step0'}">
<c:if test = "${requirementsPresent eq 'no'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Set day parameters:
    </div>
    <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
        <form action="/DayRequirementsPageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="step" value="step1">
                <input type="hidden"  name="requirementsPresent" value="no">
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Count Of Days In Week:</td>
                    <td>
                        <input class = "inputSettings inputEmployee " type="int" name="countOfDaysInWeek" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Count Of Lessons In A Day:</td>
                    <td>
                        <input class = "inputSettings inputEmployee " type="int" name="countOfLessonsInADay" required/>
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button onclick="submit"  class="controlButton controlButtonEmployeePage">Create</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</c:if>

<c:if test = "${requirementsPresent eq 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Update day parameters:
    </div>
    <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
        <form action="/DayRequirementsPageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="step" value="step1">
                <input type="hidden"  name="requirementsPresent" value="yes">
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Count Of Days In Week:</td>
                    <td>
                        <input class = "inputSettings inputEmployee " type="int" name="countOfDaysInWeek"  value="${dayRequirementsObject.getCountOfDaysInWeek()}" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Count Of Lessons In A Day:</td>
                    <td>
                        <input class = "inputSettings inputEmployee " type="int" name="countOfLessonsInADay" value="${dayRequirementsObject.getCountOfLessonsInADay()}" required/>
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
</c:if>

<c:if test = "${step eq 'step1'}">
    <c:if test = "${requirementsPresent eq 'no'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Set day parameters:
        </div>
        <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
            <form action="/DayRequirementsPageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="requirementsPresent" value="no">
                    <c:forEach var="i" begin="0" end="${dayRequirementsObject.getCountOfLessonsInADay()-1}">
                        <tr>
                            <td class = "textLabel textLabelEmployeePage">Time for Lesson #<c:out value="${i+1}"/>:</td>
                            <td>
                                <input class = "inputSettings inputEmployee" type="text" name="timeForLesson<c:out value="${i+1}"/>" required/>
                            </td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Set</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </c:if>

    <c:if test = "${requirementsPresent eq 'yes'}">
        <div class = "pageTitleText pageTitleTextEmployee">
            Update day parameters:
        </div>
        <div class = "pageContent pageContentEmployeePages pageContentEmployeePages300px">
            <form action="/DayRequirementsPageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="requirementsPresent" value="yes">

                    <c:forEach var="i" begin="0" end="${dayRequirementsObject.getCountOfLessonsInADay()-1}">
                        <tr>
                            <td class = "textLabel textLabelEmployeePage">Time for Lesson #<c:out value="${i+1}"/>:</td>
                            <td>
                                <input class = "inputSettings inputEmployee" type="text" name="timeForLesson<c:out value="${i+1}"/>" value="${dayRequirementsObject.getLessonsTime().get(i)}" required/>
                            </td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Update</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </c:if>
</c:if>

<div>
    <form action="DayRequirementsPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
