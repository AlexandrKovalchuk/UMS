<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 17/07/2016
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Action Result</title>
    <link rel="stylesheet" type="text/css" href="css\admin_styles.css">
</head>
<body>
<%if(request.getParameter("result").equals("success")){%>
<div class = "pageTitleTextGood">
    <h5>
        Operation was success!
        <br />
        Would you like to add item to the same location?
    </h5>
</div>
<%}%>
<%if(request.getParameter("result").equals("unsuccess")){%>
<div class = "pageTitleTextBad">
    <h5>
        Operation was unsuccess!
        <br />
        Would you like to try again?
    </h5>
</div>
<%}%>
<br/>
<div class = "pageTitleText">
    <tr>
        <%if(request.getParameter("action").equals("create")){%>
        <%if(request.getParameter("type").equals("Institute")){%>
        <td colspan=2>
            <button onclick="window.location.href='OperationsInstitute.jsp?action=create'" class="controlButton" >
                <h1>Yes</h1>
            </button>
        </td>
        <%}%>
        <%if(request.getParameter("type").equals("chair")){%>
        <td colspan=2>
            <button onclick="window.location.href='OperationsChair.jsp?action=create&ID='+<%out.print(request.getParameter("locationID"));%>" class="controlButton" >
                <h1>Yes</h1>
            </button>
        </td>
        <%}%>
        <%if(request.getParameter("type").equals("Employee")){%>
        <td colspan=2>
            <button onclick="window.location.href='OperationsEmploee.jsp?action=create&ID='+<%out.print(request.getParameter("locationID"));%>" class="controlButton" >
                <h1>Yes</h1>
            </button>
        </td>
        <%}%>
        <%if(request.getParameter("type").equals("faculty")){%>
        <td colspan=2>
            <button onclick="window.location.href='OperationsFaculty.jsp?action=create&ID='+<%out.print(request.getParameter("locationID"));%>" class="controlButton" >
                <h1>Yes</h1>
            </button>
        </td>
        <%}%>

        <%}%>
        <td colspan=2>
            <button onclick="window.location.href='AdminPage.jsp'" class="controlButton" >
                <h1>No</h1>
            </button>
        </td>
    </tr>
</div>
</body>
</html>
