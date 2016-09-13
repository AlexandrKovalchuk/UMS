<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css\admin_styles.css">
<html>
<head>
    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        System.out.println("cookies size " + cookies.length);
        String result = sl.sessionControl(cookies,"admin");
        if(!result.equals("success")){
            response.sendRedirect(result);
        }
    %>
    <%
        if(request.getParameter("action").equals("create")){
    %>
    <title>Create Emploee Credentials</title>
    <%
    }else if(request.getParameter("action").equals("update")){
    %>
    <title>Update Emploee Credentials</title>
    <%
    }else if(request.getParameter("action").equals("move")){
    %>
    <title>Move Emploee</title>
    <%
    }else if(request.getParameter("action").equals("delete")){
    %>
    <title>Delete Emploee Credentials</title>
    <%
    }else{
    %>
    <title>Warning</title>
    <%
        }
    %>
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Welcome to
        <%out.print(request.getParameter("action").equals("create")?"Create":"");%>
        <%out.print(request.getParameter("action").equals("update")?"Update":"");%>
        <%out.print(request.getParameter("action").equals("move")?"Move":"");%>
        <%out.print(request.getParameter("action").equals("delete")?"Delete":"");%>
        Emploee Credentials Page!
        <br />
        Please choose action:
    </h5>
</div>
<br />
<div class = "pageTitleText">
<%
    if(request.getParameter("action").equals("create")){
%>
<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <table>
        <input type="hidden"  name="tableNameParameter" value="employee">
        <input type="hidden"  name="operation" value="create">
        <input type="hidden"  name="chairID" value=<%out.print(request.getParameter("ID"));%>>
        <tr class = "textInputLabel">
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
            <td>Адресса:</td>
        </tr>
        <tr class = "textInputLabel">
            <td> Країна</td>
            <td>
                <input type="text" name="country">
            </td>
            <td>   Місто</td>
            <td>
                <input type="text" name="city">
            </td>
        </tr>
        <tr class = "textInputLabel">
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
        <tr class = "textInputLabel">
            <td> Поштовий індех</td>
            <td>
                <input type="text" name="postIndex">
            </td>

        </tr>
        <tr class = "textInputLabel">
            <td>Паспортні данні:</td>
        </tr>
        <tr class = "textInputLabel">
            <td> Серія</td>
            <td>
                <input type="text" name="seria">
            </td>
            <td> Номер</td>
            <td>
                <input type="long" name="number">
            </td>

        </tr>
        <tr class = "textInputLabel">
            <td>Де виданий паспорт:</td>
            <td>
                <input type="text" name="whereIssued">
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Ким виданий паспорт:</td>
            <td>
                <input type="text" name="issuedByWhom">
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Коли виданий паспорт:</td>
        </tr>
        <tr class = "textInputLabel">
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

        <tr class = "textInputLabel">
            <td>Посада:</td>
            <td>
                <input type="text" name="office">
            </td>
        </tr>

        
        <tr class = "textInputLabel">
            <td colspan=2>
                <button onclick="submit"  class="controlButton"><h2>Add</h2></button>
            </td>
        </tr>
    </table>
</form>

<%
}else if(request.getParameter("action").equals("update")){
%>

<%
}else if(request.getParameter("action").equals("delete")){
%>

<%
}else{
%>
<title>Warning</title>
<%
    }
%>
    </div>
</body>
</html>
