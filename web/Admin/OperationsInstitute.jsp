<%@ page import="servlets.SessionsList" %>
<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.base_objects.departments.Faculty" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.base_objects.departments.Institute" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 23:27
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
    <title>
        <c:if test = "${param.action eq 'create'}"> Create University Credentials</c:if>
        <c:if test = "${param.action eq 'update'}"> Update University Credentials</c:if>
        <c:if test = "${param.action eq 'delete'}"> Delete University Credentials</c:if>
    </title>
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Welcome to
        <c:if test = "${param.action eq 'create'}"> Create </c:if>
        <c:if test = "${param.action eq 'update'}"> Update </c:if>
        <c:if test = "${param.action eq 'delete'}"> Delete </c:if>
        University Credentials Page!
    </h5>
</div>
<br />
<div class = "pageTitleText">
    <c:if test = "${param.action eq 'create'}">
        <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="tableNameParameter" value="Institute">
                <input type="hidden"  name="operation" value="create">
                <tr class = "textInputLabel">
                    <td>Long name:</td>
                    <td>
                        <input type="text" name="longName" data-hint=" please enter name of institute">
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Short name:</td>
                    <td>
                        <input type="text" name="shortName" data-hint=" please ABR">
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button onclick="submit"  class="controlButton"><h2>Add</h2></button>
                    </td>
                </tr>
            </table>
        </form>
    </c:if>
    <c:if test = "${param.action eq 'update'}">
        <sql:setDataSource
                driver="com.mysql.jdbc.Driver"
                url="jdbc:mysql://localhost:3306/institute"
                user="javatest"
                password="testpass"
                var="databaseOne"
                scope="page" />
        <sql:setDataSource
                dataSource="${databaseOne}"
                scope="request" />
        <sql:query var="Groups">
            SELECT longName, shortName, ID FROM institute WHERE ID=${param.ID}
        </sql:query>
        <c:forEach items="${Groups.rows}" var="row">
            <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="tableNameParameter" value="Institute">
                    <input type="hidden"  name="operation" value="update">
                    <input type="hidden"  name="ID" value="${param.ID}">
                    <tr class = "textInputLabel">
                        <td>Long name:</td>
                        <td>
                            <input type="text" name="longName" data-hint=" please enter name of institute" value=<c:out value="${row.longName}"/>>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Short name:</td>
                        <td>
                            <input type="text" name="shortName" data-hint=" please ABR" value=<c:out value="${row.shortName}"/>>
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>
                            <button onclick="submit"  class="controlButton"><h2>Update</h2></button>
                        </td>
                    </tr>
                </table>
            </form>
        </c:forEach>
    </c:if>
    <c:if test = "${param.action eq 'delete'}">
        <sql:setDataSource
                driver="com.mysql.jdbc.Driver"
                url="jdbc:mysql://localhost:3306/institute"
                user="javatest"
                password="testpass"
                var="databaseOne"
                scope="page" />
        <sql:setDataSource
                dataSource="${databaseOne}"
                scope="request" />
        <sql:query var="faculty">
            SELECT longName, shortName, instituteID, ID FROM faculty WHERE instituteID=${param.ID}
        </sql:query>
        <sql:query var="institute">
            SELECT longName, shortName, ID FROM institute WHERE ID=${param.ID}
        </sql:query>
        <c:forEach items="${institute.rows}" var="row">
    <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
        <input type="hidden"  name="operation" value="delete">
        <input type="hidden"  name="tableNameParameter" value="Institute">
        <input type="hidden"  name="ID" value="${param.ID}">
        <div class = "yelowInfo">
            <div>
                <h2>Data which will be affected is:</h2>
            </div>

                    <c:forEach items="${faculty.rows}" var="frow">
                        <h3><c:out value="${frow.longName}"/></h3>
                        <br>
                    </c:forEach>
        </div>
        <div>
            <h2>Would you like to continue?</h2>
                <tr>
                    <td >
                        <button onclick="submit"  class="controlButton"><h2>Yes</h2></button>
                    </td>
                </tr>
        </div>
    </form>
    </c:forEach>
    <td >
        <button onclick="window.location.href='AdminPage.jsp'"  class="controlButton"><h2>No</h2></button>
    </td>
    </c:if>
</div>
</body>
</html>
