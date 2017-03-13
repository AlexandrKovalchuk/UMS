<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>LOG IN PAGE</title>
</head>

<body class = "backgroungImageLogIn">

    <div class = "pageTitleText pageTitleTextLogIn">
            Welcome to Log In Page!
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
                <c:if test = "${wrongPasswordOrLogIn eq 'notAuthorized'}">
                    Not authorized!
                </c:if>
            </h5>
        </div>
    </c:if>

    <form action="LogInServlet" method="post">
        <div class = "itemsBlock">
            <table>
                <tr>
                    <td class = "textLabel textLabelLogInPage">Login Name:</td>
                    <td>
                        <input class = "inputSettings inputLogInPage" name="username" type="text"  data-hint="insert log in" required/>
                    </td>
                </tr>
                <tr>
                    <td class = "textLabel textLabelLogInPage">Password:</td>
                    <td>
                        <input class = "inputSettings inputLogInPage" name="password" type="password" maxlength="20"
                               placeholder="" autocomplete="off" data-hint="insert password" required/>
                    </td>
                </tr>
                <br>
            </table>
            <tr>
                <td >
                    <button onclick="submit" value="Log In" class="controlButton controlButtonWLogInPage">Log In</button>
                    <br>
                </td>
            </tr>
        </div>
    </form>
</body>
</html>