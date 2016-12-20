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

    </h5>
</div>
<div>
    <c:if test = "${selected ne 'yes'}">
        Select Institute where to add Employee:
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <h2><c:out value="${institute.getLongName()}"/></h2>
                <c:forEach items="${institute.getFacultys()}" var="faculty">
                    <h2><c:out value="${faculty.getLongName()}"/></h2>
                    <c:forEach items="${faculty.getDepartments()}" var="department">
                        <form action="/CreateEmployeePageController" method="post" accept-charset="UTF-8">
                            <input type="hidden"  name="step" value="step1">
                            <input type="hidden"  name="departmentID" value="${department.getID()}">
                            <button onclick="submit" class="itemButton" ><c:out value="${department.getLongName()}"/></button>
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
                            <input type="text" name="name" required/>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Прізвище:</td>
                        <td>
                            <input type="text" name="lastName" required/>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>По Батькові:</td>
                        <td>
                            <input type="text" name="fathersName" required/>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Ідентифікаційний код:</td>
                        <td>
                            <input type="text" name="personalID" required/>
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
                            <input type="int" name="bday" required/>
                        </td>
                        <td>   Місяць</td>
                        <td>
                            <input type="int" name="bmonth" required/>
                        </td>
                        <td>   Рік</td>
                        <td>
                            <input type="int" name="byear" required/>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Пошта:</td>
                        <td>
                            <input type="text" name="email" required/>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Телефон:</td>
                        <td>
                            <input type="text" name="phoneNumber" required/>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Адресса:</td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>
                            <input type="text" name="address" required/>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Паспортні данні:</td>
                        <td>
                            <input type="text" name="pasport" required/>
                        </td>
                    </tr>

                    <tr class = "textInputLabel">
                        <td>Посада:</td>
                        <td>
                            <input type="text" name="office" required/>
                        </td>
                    </tr>

                    <tr class = "textInputLabel">
                        <td>LogIn:</td>
                        <td>
                            <input type="text" name="login" required/>
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
