<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
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
<c:if test = "${param.result eq 'nomysqlconnection'}">
<div class = "pageTitleTextBad">
    <h5>
        Connection absent!
        <br />
        No connection with database.
    </h5>
    <td colspan=2>
        <button onclick="window.location.href='AdminPage.jsp'" class="controlButton" >
            <h1>OK</h1>
        </button>
    </td>
</div>
</c:if>
<c:if test = "${param.result eq 'unsuccess'}">
<div class = "pageTitleTextBad">
    <h5>
        Operation was unsuccess!
        <br />
        Please try again?
    </h5>
    <td colspan=2>
        <button onclick="window.location.href='AdminPage.jsp'" class="controlButton" >
            <h1>OK</h1>
        </button>
    </td>
    <br />
    <h5> </h5>
</div>
</c:if>
<br/>
<c:if test = "${param.result eq 'success'}">
<div class = "pageTitleTextGood">
    <h5>
        Operation was success!
        <br />
    <c:if test = "${param.action eq 'create'}">
        Would you like to add item to the same location?
    </c:if>
    <c:if test = "${param.action eq 'update'}">
        NEED TO COMPLETE!!!!!!!!!
    </c:if>
        <c:if test = "${param.action eq 'move'}">
            NEED TO COMPLETE!!!!!!!!!
        </c:if>
        <c:if test = "${param.action eq 'delete'}">
            NEED TO COMPLETE!!!!!!!!!
        </c:if>
    </h5>
</div>

<div class = "pageTitleText">
    <tr>
        <c:if test = "${param.action eq 'create'}">
            <c:if test = "${param.type eq 'Institute'}">
        <td colspan=2>
            <button onclick="window.location.href='OperationsInstitute.jsp?action=create'" class="controlButton" >
                <h1>Yes</h1>
            </button>
        </td>
        </c:if>
            <c:if test = "${param.type eq 'chair'}">
        <td colspan=2>
            <button onclick="window.location.href='OperationsChair.jsp?action=create&ID='<c:out value="${param.locationID}"/>" class="controlButton" >
                <h1>Yes</h1>
            </button>
        </td>
        </c:if>
            <c:if test = "${param.type eq 'employee'}">
        <td colspan=2>
            <button onclick="window.location.href='OperationsEmploee.jsp?action=create&ID='<c:out value="${param.locationID}"/>" class="controlButton" >
                <h1>Yes</h1>
            </button>
        </td>
        </c:if>
            <c:if test = "${param.type eq 'faculty'}">
        <td colspan=2>
            <button onclick="window.location.href='OperationsFaculty.jsp?action=create&ID='<c:out value="${param.locationID}"/>" class="controlButton" >
                <h1>Yes</h1>
            </button>
        </td>
        </c:if>

        </c:if>

        <td colspan=2>
            <button onclick="window.location.href='AdminPage.jsp'" class="controlButton" >
                <c:if test = "${param.action eq 'create'}">
                    <h1>No</h1>
                </c:if>
                <c:if test = "${param.action ne 'create'}">
                    <h1>OK</h1>
                </c:if>
            </button>
        </td>
        <br />
    </tr>
</div>
</c:if>
</body>
</html>
