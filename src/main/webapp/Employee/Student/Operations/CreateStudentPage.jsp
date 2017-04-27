<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 16/02/2017
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>
<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Create Student Page (<c:out value="${requestScope.department.getLongName()}"/>)
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Group to add student:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${requestScope.department.getLongName()}"/></div>

            <div class = "textLabelParagraph textLabelEmployeePage">Course 1:</div>
            <c:forEach items="${requestScope.department.getGroups1()}" var="group">
                <div>
                    <form action="${pageContext.request.contextPath}/Employee/CreateStudentPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 2:</div>
        <c:forEach items="${requestScope.department.getGroups2()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/CreateStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 3:</div>
        <c:forEach items="${requestScope.department.getGroups3()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/CreateStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 4:</div>
        <c:forEach items="${requestScope.department.getGroups4()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/CreateStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 5:</div>
        <c:forEach items="${requestScope.department.getGroups5()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/CreateStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 6:</div>
        <c:forEach items="${requestScope.department.getGroups6()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/CreateStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${requestScope.selected eq 'yes'}">
    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelEmployeePage">
            Please fill form:
        </div>

        <div>
            <form action="${pageContext.request.contextPath}/Employee/CreateStudentPageController" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="step" value="step2">
                <input type="hidden"  name="groupID" value="${requestScope.groupID}">
                <table>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Name:</td>
                        <td>
                            <label>
                                <input type="text" name="name" maxlength="40" required
                                       class="inputSettings inputEmployee"/>
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
                                <input class="inputSettings inputEmployee" type="number" name="personalID"
                                       maxlength="10" required/>
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
                                <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text"
                                       name="email" maxlength="100" required/>
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
                        <td class = "textLabel textLabelEmployeePage">Students book:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputEmployee" type="text" name="indexBook" maxlength="100"
                                       required/>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class = "textLabel textLabelEmployeePage">LogIn:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputEmployee inputAdminPageLongNames" type="text"
                                       name="login" maxlength="70" required/>
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
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/CreateStudentPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
