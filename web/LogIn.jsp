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
<%
if(request.getParameter("message").equals("ok")) {
%>
<form action="LogInServlet" method="Get" >
    <%
        }
    %>


    <div class = "pageTitleText">
        <h5>
            Welcome to Log In Page!
        </h5>
    </div>

    <div class = "itemsBlock">
<%
if(request.getParameter("message").equals("wrongLogin")) {
    %>
        <br>
        <div class = "redInfo">
            <h4 class="payAttention">
                Incorrect login or password!
            </h4>
        </div>
        <br>
        <tr>
            <td >
                <button onclick="window.location.href='LogIn.jsp?message=ok'"  class="controlButton"><h2>Try Again</h2></button>
                <br>
            </td>
        </tr>
        <br>
        <%
}else if(request.getParameter("message").equals("ok")){

%>
    <table>
        <input type="hidden"  name="tableNameParameter" value="Institute">
        <tr>
            <td><h2>Login Name:</h2></td>
            <td>
                <input name="username" type="text"  data-hint="" />
            </td>
        </tr>
        <tr>
            <td><h2>Password:</h2></td>
            <td>
                <input name="password" type="text" maxlength="254"
                       placeholder="" autocomplete="off" data-hint="" />
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
        <%
        }
        %>
    </div>
            <%
        if(request.getParameter("message").equals("ok")) {
        %>
        </form  >
            <%
                }
            %>

</body>
</html>