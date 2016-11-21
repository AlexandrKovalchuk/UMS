<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.base_objects.departments.Institute" %>
<%@ page import="net.ukr.vixtibon.base_objects.departments.Faculty" %>
<%@ page import="net.ukr.vixtibon.base_objects.departments.Department" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.SessionsList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 21/09/2016
  Time: 00:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Institute> objListI = new ArrayList<Institute>();
    ArrayList<Faculty> objListF = new ArrayList<Faculty>();
    ArrayList<Department> objListC = new ArrayList<Department>();

    objListI = d.getDateInstitute("SELECT longName, shortName, ID FROM institute");
    objListF = d.getDateFaculty("SELECT longName, shortName, instituteID, ID FROM faculty");
    objListC = d.getDateChair("SELECT longName, shortName, facultyID,  ID FROM chair");
%>
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
    <meta charset="UTF-8">
    <title>MAIN INFO</title>
    <link rel="stylesheet" type="text/css" href="css\admin_styles.css">
</head>
<body>

<div class = "pageTitleText">
    <h5>
        Welcome to MAIN INFO Page!
    </h5>
</div>
<br/>
<div class = "pageTitleText">
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
    <sql:query var="institute">
        SELECT longName, shortName, ID FROM institute
    </sql:query>
    <c:forEach items="${institute.rows}" var="row">
        <c:out value="${row.longName}"/>
        <sql:query var="faculty">
            SELECT longName, shortName, instituteID, ID FROM faculty WHERE instituteID=${row.ID}
        </sql:query>
        <c:forEach items="${faculty.rows}" var="frow">
            <c:out value="${frow.longName}"/>
            <sql:query var="chair">
                SELECT longName, shortName, facultyID,  ID FROM chair WHERE facultyID=${frow.ID}
            </sql:query>
            <c:forEach items="${chair.rows}" var="crow">
                <c:out value="${crow.longName}"/>
            </c:forEach>
        </c:forEach>
    </c:forEach>
</div>
</body>
</html>
