<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/10/2016
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="sources\employee_css.css">
    <title>Action Result</title>
</head>
<body>
<%if(request.getParameter("result").equals("nomysqlconnection")){%>
<div class = "pageTitleTextBad">
    <h5>
        Connection absent!
        <br />
        No connection with database.
    </h5>
</div>
<%}%>

<%if(request.getParameter("result").equals("unsuccess")){%>
<div class = "pageTitleTextBad">
    <h5>
        Operation was unsuccess!
        <br />
        Please try again?
    </h5>
</div>
<%}%>
<br/>

<%if(request.getParameter("result").equals("success")){%>
<div class = "pageTitleTextGood">
    <h5>
        Operation was success!
    </h5>
</div>
<%}%>
<tr>
    <td colspan=2>
        <button onclick="window.location.href='EmployeePage.jsp'" class="controlButton" >
            <h1>OK</h1>
        </button>
    </td>
    <br />
</tr>
</body>
</html>
