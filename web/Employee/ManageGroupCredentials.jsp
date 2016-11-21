<%@ page import="servlets.Session" %>
<%@ page import="servlets.SessionsList" %>
<%@ page import="net.ukr.vixtibon.Group" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.base_objects.persons.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 18/10/2016
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        String result = sl.sessionControl(cookies,"employee");
        int areaID = 0;
        if(!result.equals("success")){
            response.sendRedirect(result);
        }
        Session s = sl.getSession(cookies);
        s.sessionInfo();
        areaID = s.getAreaAccessID();
        //int step = 0;
        //step = Integer.parseInt(request.getParameter("step"));
    %>


    <title>Manage Group Page</title>
    <link rel="stylesheet" type="text/css" href="sources\employee_css.css">

</head>
<body>
<div class = "pageTitleText">
    <h5>
        <c:out value="${pageScope.step}"/>
        <c:out value="${param.action}"/>
        Welcome to Manage Group Page!
        <br />
        <c:if test="${param.step eq 0}">Please choose action:</c:if>
        <c:if test="${param.action ne create}">Please select Group:</c:if>
    </h5>
</div>

<c:if test="${param.step eq 0}">
    <div>
        <div>
            <form action="ManageGroupCredentials.jsp" method="post">
                <input type="hidden"  name="action" value="create">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Create Group</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="ManageGroupCredentials.jsp" method="post">
                <input type="hidden"  name="action" value="update">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Update Group</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="ManageGroupCredentials.jsp" method="post">
                <input type="hidden"  name="action" value="move">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Move Group</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="ManageGroupCredentials.jsp" method="post">
                <input type="hidden"  name="action" value="delete">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Delete Group</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="ManageGroupCredentials.jsp" method="post">
                <input type="hidden"  name="action" value="info">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Show Group info</h2></button>
                </td>
            </form>
        </div>
        <br />
    </div>
</c:if>

<c:if test="${param.step eq 1}">
    <c:if test = "${param.action eq 'create'}">
        <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="tableNameParameter" value="gtgroup">
                <input type="hidden"  name="operation" value="create">
                <input type="hidden"  name="chairID" value= <%out.print(areaID);%>>
                <tr class = "textInputLabel">
                    <td>Name Of Group:</td>
                    <td>
                        <input type="text" name="fullGroupName" data-hint=" please enter name of institute">
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Cource Number:</td>
                    <td>
                        <input type="text" name="courseNumber" data-hint=" please ABR">
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
    <c:if test = "${param.action eq 'move'}">
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
        <sql:query var="GroupsC">
            SELECT ID, fullGroupName  FROM gtgroup WHERE chairID=<%out.print(areaID);%>
        </sql:query>
        <sql:query var="GroupsN">
            SELECT ID, fullGroupName  FROM gtgroup WHERE chairID=0
        </sql:query>
        <h2>From Department to NONE</h2>
        <c:forEach items="${GroupsC.rows}" var="row">
            <div>
                <form action="ManageGroupCredentials.jsp" method="post">
                    <input type="hidden"  name="action" value="${param.action}">
                    <input type="hidden"  name="ID" value="${row.ID}">
                    <input type="hidden"  name="step" value="2">
                    <input type="hidden"  name="chairID" value="0">
                    <td colspan=2>
                        <button onclick="submit"  class="topicButton"><h2><c:out value="${row.fullGroupName}"/></h2></button>
                    </td>
                </form>
            </div>
            <br />
        </c:forEach>
        <h2>From NONE to Department</h2>
        <c:forEach items="${GroupsN.rows}" var="nrow">
            <div>
                <form action="ManageGroupCredentials.jsp" method="post">
                    <input type="hidden"  name="action" value="${param.action}">
                    <input type="hidden"  name="ID" value="${nrow.ID}">
                    <input type="hidden"  name="step" value="2">
                    <input type="hidden"  name="chairID" value="<%out.print(areaID);%>">
                    <td colspan=2>
                        <button onclick="submit"  class="topicButton"><h2><c:out value="${nrow.fullGroupName}"/></h2></button>
                    </td>
                </form>
            </div>
            <br />
        </c:forEach>
    </c:if>
    <c:if test = "${param.action ne 'create'}">
        <c:if test = "${param.action ne 'move'}">
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
            SELECT ID, fullGroupName, chairID  FROM gtgroup WHERE chairID=<%out.print(areaID);%>
        </sql:query>
        <c:forEach items="${Groups.rows}" var="row">
            <div>
                <form action="ManageGroupCredentials.jsp" method="post">
                    <input type="hidden"  name="action" value="${param.action}">
                    <input type="hidden"  name="ID" value="${row.ID}">
                    <input type="hidden"  name="step" value="2">
                    <td colspan=2>
                        <button onclick="submit"  class="topicButton"><h2><c:out value="${row.fullGroupName}"/></h2></button>
                    </td>
                </form>
            </div>
            <br />
        </c:forEach>
        </c:if>
    </c:if>
</c:if>
<c:if test="${param.step eq 2}">
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
            SELECT ID, fullGroupName, chairID, courseNumber  FROM gtgroup WHERE ID=${param.ID}
        </sql:query>
        <c:forEach items="${Groups.rows}" var="row">
        <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="tableNameParameter" value="gtgroup">
                <input type="hidden"  name="operation" value="update">
                <input type="hidden"  name="ID" value="${param.ID}">
                <tr class = "textInputLabel">
                    <td>Name Of Group:</td>
                    <td>
                        <input type="text" name="fullGroupName" value=<c:out value="${row.fullGroupName}"/>>
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Cource Number:</td>
                    <td>
                        <input type="text" name="courseNumber" value=<c:out value="${row.courseNumber}"/>>
                    </td>
                </tr>
                <tr>
                    <td colspan=2>
                        <button onclick="submit"  class="controlButton"><h2>Add</h2></button>
                    </td>
                </tr>
            </table>
        </form>
        </c:forEach>
    </c:if>
    <c:if test = "${param.action eq 'move'}">
        <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="operation" value="move">
            <input type="hidden"  name="tableNameParameter" value="gtgroup">
            <input type="hidden"  name="chairID" value="${param.chairID}">
            <input type="hidden"  name="ID" value="${param.ID}">
            <div>
                <h2>Would you like to continue?</h2>
                <tr><td >
                    <button onclick="submit"  class="controlButton"><h2>Yes</h2></button></td><td >
                    <button onclick="window.location.href='EmployeePage.jsp'"  class="controlButton"><h2>No</h2></button>
                </td></tr>
            </div>
        </form>
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
        <sql:query var="Groups">
            SELECT ID, fullGroupName  FROM gtgroup WHERE ID=${param.ID}
        </sql:query>
        <c:forEach items="${Groups.rows}" var="row">
        <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
            <input type="hidden"  name="operation" value="delete">
            <input type="hidden"  name="tableNameParameter" value="gtgroup">
            <input type="hidden"  name="ID" value="${param.ID}">
            <div>
                <h2>Delete <c:out value="${row.fullGroupName}"/></h2>
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
            <button onclick="window.location.href='EmployeePage.jsp'"  class="controlButton"><h2>No</h2></button>
        </td>
    </c:if>
    <c:if test = "${param.action eq 'info'}">
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
            SELECT ID, fullGroupName, courseNumber  FROM gtgroup WHERE ID=${param.ID}
        </sql:query>
        <sql:query var="Students">
            SELECT name, lastName, ID FROM student WHERE groupID=${param.ID}
        </sql:query>
        <c:forEach items="${Groups.rows}" var="row">
            <table>
                <tr class = "textInputLabel">
                    <td>Name Of Group:</td>
                    <td>
                        <c:out value="${row.fullGroupName}"/>
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Cource Number:</td>
                    <td>
                        <c:out value="${row.courseNumber}"/>
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Students:</td>
                </tr>
                <c:forEach items="${Students.rows}" var="srow">
                <td>
                    <c:out value="${srow.lastName}"/> <c:out value="${srow.name}"/>
                </td>
            </c:forEach>
            </table>
        </c:forEach>
        <tr>
            <button onclick="window.location.href='EmployeePage.jsp'" class="controlButton" >
                <h1>OK</h1>
            </button>
        </tr>
    </c:if>
</c:if>
</body>
</html>
