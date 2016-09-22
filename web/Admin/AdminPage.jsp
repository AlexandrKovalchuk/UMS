<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 17/07/2016
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        String result = sl.sessionControl(cookies,"admin");
        if(!result.equals("success")){
            response.sendRedirect(result);
        }
    %>
    <meta charset="UTF-8">
    <title>Administrator Page</title>
    <link rel="stylesheet" type="text/css" href="css\admin_styles.css">
</head>
<body>

<div class = "pageTitleText">
    <h5>
        Welcome to Administrator Page!
        <br />
        Please choose action:
    </h5>
</div>

<div class="itemsBlock">
    <div>
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='SelectOperation.jsp?type=institute'" class="topicButton" >
                        <h1>Manage University Credentials</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='SelectOperation.jsp?type=faculty'" class="topicButton" >
                        <h1>Manage Faculty Credentials</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='SelectOperation.jsp?type=chair'" class="topicButton" >
                        <h1>Manage Chair Credentials</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='SelectOperation.jsp?type=emploee'" class="topicButton" >
                        <h1>Manage Employee Credentials</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='MainInfo.jsp'" class="controlButton" >
                        <h1>Main Info</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="document.location.href='/LogOutServlet'" class="controlButton" >
                        <h1>Log Out</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
    </div>
</div>

</body>
</html>
