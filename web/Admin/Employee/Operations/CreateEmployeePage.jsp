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
<head lang="en">
    <meta charset="UTF-8">
    <title>Create Employee Page</title>
    <link rel="stylesheet" type="text/css" href="Admin/css/admin_styles.css">
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Create Employee Page!
        <br />
        Please fill form:
    </h5>
</div>
<div>
    <c:if test = "${selected ne 'yes'}">
        Select Institute where to add Employee:
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <h5><c:out value="${institute.getLongName()}"/></h5>
                <c:forEach items="${institute.getFacultys()}" var="faculty">
                    <h5><c:out value="${faculty.getLongName()}"/></h5>
                    <c:forEach items="${faculty.getDepartments}" var="department">
                        <form action="/MoveDepartmentPageController" method="post" accept-charset="UTF-8">
                            <input type="hidden"  name="step" value="step1">
                            <input type="hidden"  name="departmentID" value="${department.getID()}">
                            <button onclick="submit" class="itemButton" ><h2><c:out value="${department.getLongName()}"/></h2></button>
                        </form>
                    </c:forEach>
                </c:forEach>
            </div>
        </c:forEach>
    </c:if>
    <c:if test = "${selected eq 'yes'}">
        Please fill form:
        <div>
            <form action="/CreateEmployeePageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="departmentID" value="${departmentID}">
                    <tr class = "textInputLabel">
                        <td>Ім'я:</td>
                        <td>
                            <input type="text" name="name">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Прізвище:</td>
                        <td>
                            <input type="text" name="lastName">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>По Батькові:</td>
                        <td>
                            <input type="text" name="fathersName">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Ідентифікаційний код:</td>
                        <td>
                            <input type="text" name="personalID">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Стать:</td>
                        <td>
                            <input type="radio" name="sex" value="m" checked>Чоловіча<br>
                            <input type="radio" name="sex" value="f">Жіноча
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Дата народження:</td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>День</td>
                        <td>
                            <input type="int" name="bday">
                        </td>
                        <td>   Місяць</td>
                        <td>
                            <input type="text" name="bmonth">
                        </td>
                        <td>   Рік</td>
                        <td>
                            <input type="int" name="byear">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Пошта:</td>
                        <td>
                            <input type="text" name="email">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Телефон:</td>
                        <td>
                            <input type="text" name="phoneNumber">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Адресса:</td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>
                            <input type="text" name="address">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Паспортні данні:</td>
                        <td>
                            <input type="text" name="pasport">
                        </td>
                    </tr>

                    <tr class = "textInputLabel">
                        <td>Посада:</td>
                        <td>
                            <input type="text" name="office">
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton"><h2>Create</h2></button>
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
            <button onclick="submit"  class="topicButton"><h2>Cancel</h2></button>
        </td>
    </form>
</div>
<br />
</body>
</html>
