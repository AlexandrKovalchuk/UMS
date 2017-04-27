<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 12/12/2016
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>
<body class = "backgroundImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
        Create Employee Page
</div>
<br />

<c:if test = "${requestScope.step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute where to Create Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="institutesList" scope="request" type="java.util.List"/>
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/CreateEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step1'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Faculty where to Create Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="facultiesList" scope="request" type="java.util.List"/>
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/CreateEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${faculty.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step2'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Department where to Create Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <jsp:useBean id="departmentsList" scope="request" type="java.util.List"/>
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="${pageContext.request.contextPath}/Admin/CreateEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="departmentID" value="${department.getID()}">
                    <button class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.step eq 'step3'}">
        <div class = "pageTitleText pageTitleTextAdmin">
            Please fill form:
        </div>

        <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
            <form action="${pageContext.request.contextPath}/Admin/CreateEmployeePageController" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="step" value="step4">
                <input type="hidden"  name="departmentID" value="${requestScope.departmentID}">
                <table>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Name:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage" type="text" name="name" maxlength="40"
                                       required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Surname:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage" type="text" name="lastName" maxlength="50"
                                       required/>
                            </label>
                        </td>
                    </tr>
                    <tr >
                        <td class = "textLabel textLabelAdminPage">Middle Name:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage" type="text" name="fathersName"
                                       maxlength="40" required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Identification code:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage" type="number" name="personalID"
                                       maxlength="10" required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Sex:</td>
                        <td class ="textLabel textLabelAdminPage">
                            <label>
                                <input type="radio" name="sex" value="m" checked>
                            </label>Male<br>
                            <label>
                                <input type="radio" name="sex" value="f">
                            </label>Female
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Date of birth:</td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Day</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage numericInput2" type="number" name="bday"
                                       maxlength="2" required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">   Month</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage numericInput2" type="number" name="bmonth"
                                       maxlength="2" required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">   Year</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage numericInput4" type="number" name="byear"
                                       maxlength="4" required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Email:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage inputAdminPageLongNames" type="text"
                                       name="email" maxlength="100" required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Phone Number:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage" type="text" name="phoneNumber"
                                       maxlength="20" required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Address:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage inputAdminPageLongNames" type="text"
                                       name="address" maxlength="200" required/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Passport data:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage inputAdminPageLongNames" type="text"
                                       name="pasport" maxlength="200" required/>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class = "textLabel textLabelAdminPage">Position:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage inputAdminPageLongNames" type="text"
                                       name="office" maxlength="100" required/>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class = "textLabel textLabelAdminPage">LogIn:</td>
                        <td>
                            <label>
                                <input class="inputSettings inputAdminPage inputAdminPageLongNames" type="text"
                                       name="login" maxlength="70" required/>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td colspan=2>
                            <button class="controlButton controlButtonAdminPage">Create</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </c:if>

<div>
    <form action="${pageContext.request.contextPath}/Admin/CreateEmployeePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonAdminPage">Cancel</button>
    </form>
</div>
</body>
</html>
