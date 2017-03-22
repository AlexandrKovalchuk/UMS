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
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
</head>
<body class = "backgroungImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Create Student Page! (<c:out value="${department.getLongName()}"/>)
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Group to add student:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>

            <div class = "textLabelParagraph textLabelEmployeePage">Course 1:</div>
            <c:forEach items="${department.getGroups1()}" var="group">
                <div>
                    <form action="CreateStudentPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 2:</div>
        <c:forEach items="${department.getGroups2()}" var="group">
            <div>
                <form action="CreateStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 3:</div>
        <c:forEach items="${department.getGroups3()}" var="group">
            <div>
                <form action="CreateStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 4:</div>
        <c:forEach items="${department.getGroups4()}" var="group">
            <div>
                <form action="CreateStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 5:</div>
        <c:forEach items="${department.getGroups5()}" var="group">
            <div>
                <form action="CreateStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 6:</div>
        <c:forEach items="${department.getGroups6()}" var="group">
            <div>
                <form action="CreateStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button onclick="submit" class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelEmployeePage">
            Please fill form:
        </div>

        <div>
            <form action="CreateStudentPageController" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="groupID" value="${groupID}">
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Ім'я:</td>
                        <td>
                            <input class = "inputSettings inputEmployee" type="text" name="name" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Прізвище:</td>
                        <td>
                            <input class = "inputSettings inputEmployee" type="text" name="lastName" required/>
                        </td>
                    </tr>
                    <tr >
                        <td class = "textLabel textLabelEmployeePage">По Батькові:</td>
                        <td>
                            <input class = "inputSettings inputEmployee" type="text" name="fathersName" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Ідентифікаційний код:</td>
                        <td>
                            <input class = "inputSettings inputEmployee" type="text" name="personalID" required/>
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
                            <input class = "inputSettings inputEmployee" type="int" name="bday" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">   Місяць</td>
                        <td>
                            <input class = "inputSettings inputEmployee" type="int" name="bmonth" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">   Рік</td>
                        <td>
                            <input class = "inputSettings inputEmployee" type="int" name="byear" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Пошта:</td>
                        <td>
                            <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="email" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Телефон:</td>
                        <td>
                            <input class = "inputSettings inputEmployee" type="text" name="phoneNumber" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Адресса:</td>
                        <td>
                            <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="address" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Паспортні данні:</td>
                        <td>
                            <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="pasport" required/>
                        </td>
                    </tr>
                    <tr>
                        <td class = "textLabel textLabelEmployeePage">Students book:</td>
                        <td>
                            <input class = "inputSettings inputEmployee" type="text" name="indexBook" required/>
                        </td>
                    </tr>

                    <tr>
                        <td class = "textLabel textLabelEmployeePage">LogIn:</td>
                        <td>
                            <input class = "inputSettings inputEmployee inputAdminPageLongNames" type="text" name="login" required/>
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
</c:if>

<div>
    <form action="CreateStudentPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonEmployeePage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
