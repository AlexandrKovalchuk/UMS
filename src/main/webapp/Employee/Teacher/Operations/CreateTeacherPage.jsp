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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>
<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Create Teacher Page
    <br />
    Please fill form:
</div>
<br />

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <form action="CreateTeacherPageController" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="fillForm" value="yes">
                <input type="hidden"  name="departmentID" value="${departmentID}">
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Ім'я:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="text" name="name" maxlength="40" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Прізвище:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="text" name="lastName" maxlength="50" required/>
                    </td>
                </tr>
                <tr >
                    <td class = "textLabel textLabelEmployeePage">По Батькові:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="text" name="fathersName" maxlength="40" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Ідентифікаційний код:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="number" name="personalID" maxlength="10" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Стать:</td>
                    <td class ="textLabel textLabelEmployeePage">
                        <input type="radio" name="sex" value="m" checked>Чоловіча<br>
                        <input type="radio" name="sex" value="f">Жіноча
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Дата народження:</td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">День</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="number" name="bday" maxlength="2" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">   Місяць</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="number" name="bmonth" maxlength="2" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">   Рік</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="number" name="byear" maxlength="4" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Пошта:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="email" maxlength="100" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Телефон:</td>
                    <td>
                        <input class = "inputSettings inputEmployee" type="text" name="phoneNumber" maxlength="20" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Адресса:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="address" maxlength="200" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelEmployeePage">Паспортні данні:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="pasport" maxlength="200" required/>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Посада:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="office" maxlength="100" required/>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Звання:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="level" maxlength="100" required/>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">LogIn:</td>
                    <td>
                        <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="login" maxlength="70" required/>
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
                        <c:forEach items="${disciplinesConnectedWithDepartment}" var="discipline">
                            <input type="checkbox" name="discipline" value="<c:out value="${discipline.getID()}"/>"> <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                        </c:forEach>
                    </td>
                </tr>

                <tr>
                    <td class = "textLabel textLabelEmployeePage">Not Current Department</td>
                </tr>

                <tr>
                    <td  class = "textLabel textLabelEmployeePage">
                        <c:forEach items="${disciplinesNotConnectedWithDepartment}" var="discipline">
                            <input type="checkbox" name="discipline" value="<c:out value="${discipline.getID()}"/>"> <c:out value="${discipline.getNameOfDiscipline()}"/><br>
                        </c:forEach>
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
</div>

<div>
    <form action="CreateTeacherPageController" method="post">
        <input type="hidden"  name="fillForm" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>
</body>
</html>
