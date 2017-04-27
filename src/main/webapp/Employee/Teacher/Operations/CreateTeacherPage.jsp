<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 04/02/2017
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Teacher Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>
<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Create Teacher Page
    <br />
    Please fill form:
</div>
<br />

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <form action="${pageContext.request.contextPath}/Employee/CreateTeacherPageController" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="fillForm" value="yes">
            <input type="hidden"  name="departmentID" value="${requestScope.departmentID}">
            <table>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Name:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="text" name="name" maxlength="40" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Surname:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="text" name="lastName" maxlength="50"
                                   required/>
                        </label>
                    </td>
                </tr>
                <tr >
                    <td class = "textLabel textLabelEmployeePage">Middle Name:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="text" name="fathersName" maxlength="40"
                                   required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Identification code:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="number" name="personalID" maxlength="10"
                                   required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Sex:</td>
                    <td class ="textLabel textLabelEmployeePage">
                        <label>
                            <input type="radio" name="sex" value="m" checked>
                        </label>Male<br>
                        <label>
                            <input type="radio" name="sex" value="f">
                        </label>Female
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
                                   maxlength="2" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">   Month</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee numericInput2" type="number" name="bmonth"
                                   maxlength="2" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">   Year</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee numericInput4" type="number" name="byear"
                                   maxlength="4" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Email:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text" name="email"
                                   maxlength="100" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Phone Number:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee" type="text" name="phoneNumber" maxlength="20"
                                   required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Address:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text"
                                   name="address" maxlength="200" required/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Passport data:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text"
                                   name="pasport" maxlength="200" required/>
                        </label>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Position:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text" name="office"
                                   maxlength="100" required/>
                        </label>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Academic Title:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text" name="level"
                                   maxlength="100" required/>
                        </label>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">LogIn:</td>
                    <td>
                        <label>
                            <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text" name="login"
                                   maxlength="70" required/>
                        </label>
                    </td>
                </tr>
            </table>

            <table>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Disciplines:</td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Current Department</td>
                </tr>

                <tr>
                    <td  class = "textLabel textLabelEmployeePage">
                        <c:forEach items="${requestScope.disciplinesConnectedWithDepartment}" var="discipline">
                            <label>
                                <input type="checkbox" name="discipline" value="<c:out value="${discipline.getID()}"/>">
                            </label> <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Not Current Department</td>
                </tr>

                <tr>
                    <td  class = "textLabel textLabelEmployeePage">
                        <c:forEach items="${requestScope.disciplinesNotConnectedWithDepartment}" var="discipline">
                            <label>
                                <input type="checkbox" name="discipline" value="<c:out value="${discipline.getID()}"/>">
                            </label> <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                        </c:forEach>
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

<div>
    <form action="${pageContext.request.contextPath}/Employee/CreateTeacherPageController" method="post">
        <input type="hidden"  name="fillForm" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>
</body>
</html>
