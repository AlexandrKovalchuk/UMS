<%--
  Created by IntelliJ IDEA.
  User: akovalchuk
  Date: 7/31/2015
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Students Info</title>
</head>
<body bgcolor="#ffefd5">
<form action="WEB-INF/input_jstl.jsp" method="post">
    <table>
        <tr>
            <td>Ім'я:</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>Прізвище:</td>
            <td>
                <input type="text" name="lastName">
            </td>
        </tr>
        <tr>
            <td>По Батькові:</td>
            <td>
                <input type="text" name="fathersName">
            </td>
        </tr>
        <tr>
        <td>Ідентифікаційний код:</td>
        <td>
            <input type="long" name="personalID">
        </td>
        </tr>
        <tr>
            <td>Стать:</td>
            <td>
                <input type="radio" name="sex" value="m" checked>Чоловіча<br>
                <input type="radio" name="sex" value="f">Жіноча
            </td>
        </tr>
        <tr>
        <td>Пошта:</td>
        <td>
            <input type="text" name="email">
        </td>
        </tr>
        <tr>
            <td>Телефон:</td>
            <td>
                <input type="text" name="phoneNumber">
            </td>
        </tr>
        <tr>
            <td>Дата народження:</td>
        </tr>
        <tr>
            <td>День</td>
            <td>
                <input type="int" name="day">
            </td>
            <td>   Місяць</td>
            <td>
                <input type="text" name="month">
            </td>
            <td>   Рік</td>
            <td>
                <input type="int" name="year">
            </td>

        </tr>
        <tr>
            <td>Адресса:</td>
        </tr>
        <tr>
            <td> Країна</td>
            <td>
                <input type="text" name="country">
            </td>
            <td>   Місто</td>
            <td>
                <input type="text" name="city">
            </td>
         </tr>
        <tr>
            <td> Вулиця</td>
            <td>
                <input type="text" name="street">
            </td>
            <td> Будинок</td>
            <td>
                <input type="text" name="house">
            </td>
            <td> Квартира</td>
            <td>
                <input type="int" name="appartment">
            </td>
        </tr>
        <tr>
            <td> Поштовий індех</td>
            <td>
                <input type="text" name="postIndex">
            </td>

        </tr>
        <tr>
            <td>Паспортні данні:</td>
        </tr>
        <tr>
            <td> Серія</td>
            <td>
                <input type="text" name="seria">
            </td>
            <td> Номер</td>
            <td>
                <input type="long" name="number">
            </td>

        </tr>
        <tr>
            <td>Де виданий паспорт:</td>
            <td>
                <input type="text" name="whereIssued">
            </td>
        </tr>
        <tr>
            <td>Ким виданий паспорт:</td>
            <td>
                <input type="text" name="issuedByWhom">
            </td>
        </tr>
        <tr>
            <td>Коли виданий паспорт:</td>
        </tr>
        <tr>
            <td>День</td>
            <td>
                <input type="int" name="day">
            </td>
            <td>   Місяць</td>
            <td>
                <input type="text" name="month">
            </td>
            <td>   Рік</td>
            <td>
                <input type="int" name="year">
            </td>

        </tr>
        <tr>
            <td>Факультет:</td>
            <td>
                <input type="text" name="faculty">
            </td>
        </tr>
        <tr>
            <td>Залікова книжка:</td>
            <td>
                <input type="text" name="indexBook">
            </td>
        </tr>
        <tr>
            <td colspan=2>
                <input type="submit" value="Додати">
            </td>
        </tr>
        </table>
    </form>

</body>
</html>
