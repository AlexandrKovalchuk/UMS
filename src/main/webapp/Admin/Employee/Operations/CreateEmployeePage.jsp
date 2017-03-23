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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>
<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
        Create Employee Page
</div>
<br />

    <c:if test = "${selected ne 'yes'}">
        <div class = "pageTitleText pageTitleTextAdmin">
            Select Department where to add Employee:
        </div>

        <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
            <c:forEach items="${institutesList}" var="institute">
                <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${institute.getLongName()}"/></div>
                <c:forEach items="${institute.getFacultys()}" var="faculty">
                    <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${faculty.getLongName()}"/></div>
                    <c:forEach items="${faculty.getDepartments()}" var="department">
                        <div>
                            <form action="CreateEmployeePageController" method="post" accept-charset="UTF-8">
                                <input type="hidden"  name="step" value="step1">
                                <input type="hidden"  name="departmentID" value="${department.getID()}">
                                <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                            </form>
                        </div>
                    </c:forEach>
                </c:forEach>
            </c:forEach>
        </div>
    </c:if>

    <c:if test = "${selected eq 'yes'}">
        <div class = "pageTitleText pageTitleTextAdmin">
            Please fill form:
        </div>

        <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
            <form action="CreateEmployeePageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="departmentID" value="${departmentID}">
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Ім'я:</td>
                        <td>
                            <input class = "inputSettings inputAdminPage" type="text" name="name" maxlength="40" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Прізвище:</td>
                        <td>
                            <input class = "inputSettings inputAdminPage" type="text" name="lastName" maxlength="50" required/>
                        </td>
                    </tr>
                    <tr >
                        <td class = "textLabel textLabelAdminPage">По Батькові:</td>
                        <td>
                            <input class = "inputSettings inputAdminPage" type="text" name="fathersName" maxlength="40" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Ідентифікаційний код:</td>
                        <td>
                            <input class = "inputSettings inputAdminPage" type="text" name="personalID" maxlength="10" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Стать:</td>
                        <td class ="textLabel textLabelAdminPage">
                            <input type="radio" name="sex" value="m" checked>Чоловіча<br>
                            <input type="radio" name="sex" value="f">Жіноча
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Дата народження:</td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">День</td>
                        <td>
                            <input class = "inputSettings inputAdminPage" type="int" name="bday" maxlength="2" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">   Місяць</td>
                        <td>
                            <input class = "inputSettings inputAdminPage" type="int" name="bmonth" maxlength="2" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">   Рік</td>
                        <td>
                            <input class = "inputSettings inputAdminPage" type="int" name="byear" maxlength="4" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Пошта:</td>
                        <td>
                            <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="email" maxlength="100" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Телефон:</td>
                        <td>
                            <input class = "inputSettings inputAdminPage" type="text" name="phoneNumber" maxlength="20" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Адресса:</td>
                        <td>
                            <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="address" maxlength="200" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelAdminPage">Паспортні данні:</td>
                        <td>
                            <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="pasport" maxlength="200" required/>
                        </td>
                    </tr>

                    <tr>
                        <td class = "textLabel textLabelAdminPage">Посада:</td>
                        <td>
                            <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="office" maxlength="100" required/>
                        </td>
                    </tr>

                    <tr>
                        <td class = "textLabel textLabelAdminPage">LogIn:</td>
                        <td>
                            <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="login" maxlength="70" required/>
                        </td>
                    </tr>

                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton controlButtonAdminPage">Create</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </c:if>
</div>

<div>
    <form action="CreateEmployeePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
        </td>
    </form>
</div>
</body>
</html>
