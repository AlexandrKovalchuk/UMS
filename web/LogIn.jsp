<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <link rel="stylesheet" type="text/css" href="main_css\styles_for_LogIn_page.css">
    <title>LOG IN PAGE</title>
</head>

<body>

    <div class = "pageTitleText">
        <h5>
            Welcome to Log In Page!
        </h5>
    </div>
    <c:if test = "${!empty wrongPasswordOrLogIn}">
        <div class = "payAttention">
            <h5>
                <c:if test = "${wrongPasswordOrLogIn eq 'absentInBase'}">
                    Incorrect LogIn of Password!
                </c:if>
                <c:if test = "${wrongPasswordOrLogIn eq 'wrongPassword'}">
                    Incorrect LogIn of Password!
                </c:if>
                <c:if test = "${wrongPasswordOrLogIn eq 'absentConnectionToDataBase'}">
                    Absent Data Base connection!
                </c:if>
                <c:if test = "${wrongPasswordOrLogIn eq 'errorInAccess'}">
                    Error in access. Please contact your administrator!
                </c:if>
            </h5>
        </div>
    </c:if>

    <form action="LogInServlet" method="post">
        <div class = "itemsBlock">
            <table>
                <tr>
                    <td><h2>Login Name:</h2></td>
                    <td>
                        <input name="username" type="text"  data-hint="insert log in" required/>
                    </td>
                </tr>
                <tr>
                    <td><h2>Password:</h2></td>
                    <td>
                        <input name="password" type="text" maxlength="20"
                               placeholder="" autocomplete="off" data-hint="insert password" required/>
                    </td>
                </tr>
                <tr>
                    <td >
                        <button onclick="submit" value="Log In" class="controlButton"><h2>Log In</h2></button>
                        <br>
                    </td>
                </tr>
                <br>
            </table>
        </div>
    </form>
</body>
</html>