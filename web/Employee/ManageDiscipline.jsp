<%@ page import="servlets.SessionsList" %>
<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.Discipline" %>
<%@ page import="servlets.Session" %>
<%@ page import="net.ukr.vixtibon.Chair" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30/09/2016
  Time: 23:57
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
        int step = 0;
        step = Integer.parseInt(request.getParameter("step"));
    %>
    <title>Manage Discipline Page</title>
    <link rel="stylesheet" type="text/css" href="sources\employee_css.css">

</head>
<body>
<div class = "pageTitleText">
    <h5>
        Welcome to Manage Discipline Page!
        <br />
        <c:if test="${param.step eq 0}">Please choose action:</c:if>
        <c:if test="${param.action ne create}">Please select Group:</c:if>
    </h5>
</div>

<c:if test="${param.step eq 0}">
    <div>
        <div>
            <form action="ManageDiscipline.jsp" method="post">
                <input type="hidden"  name="action" value="create">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Create Discipline</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="ManageDiscipline.jsp" method="post">
                <input type="hidden"  name="action" value="update">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Update Discipline</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="ManageDiscipline.jsp" method="post">
                <input type="hidden"  name="action" value="move">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Move Discipline</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="ManageDiscipline.jsp" method="post">
                <input type="hidden"  name="action" value="delete">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Delete Discipline</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="ManageDiscipline.jsp" method="post">
                <input type="hidden"  name="action" value="info">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Show Discipline info</h2></button>
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
                <input type="hidden"  name="tableNameParameter" value="discipline">
                <input type="hidden"  name="operation" value="create">
                <input type="hidden"  name="chairID" value= <%out.print(areaID);%>>
                <tr class = "textInputLabel">
                    <td>Name Of Discipline:</td>
                    <td>
                        <input type="text" name="nameOfDiscipline" data-hint=" please enter name of institute">
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Cource Number:</td>
                    <td>
                        <input type="text" name="courseNumber" data-hint=" please ABR">
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Semester Number:</td>
                    <td>
                        <input type="text" name="semesterNumber" data-hint=" please ABR">
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Count Of Lessons:</td>
                    <td>
                        <input type="text" name="countOfLessons" data-hint=" please ABR">
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Count Of Praktice:</td>
                    <td>
                        <input type="text" name="countOfPraktice" data-hint=" please ABR">
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Exam:</td>
                    <td>
                        <input type="radio" name="exam" value="true">Yes<br>
                        <input type="radio" name="exam" value="false">No<br>
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
            SELECT ID, nameOfDiscipline  FROM discipline WHERE chairID=<%out.print(areaID);%>
        </sql:query>
        <sql:query var="GroupsN">
            SELECT ID, nameOfDiscipline  FROM discipline WHERE chairID=0
        </sql:query>
        <h2>From Department to NONE</h2>
        <c:forEach items="${GroupsC.rows}" var="row">
            <div>
                <form action="ManageDiscipline.jsp" method="post">
                    <input type="hidden"  name="action" value="${param.action}">
                    <input type="hidden"  name="ID" value="${row.ID}">
                    <input type="hidden"  name="step" value="2">
                    <input type="hidden"  name="chairID" value="0">
                    <td colspan=2>
                        <button onclick="submit"  class="topicButton"><h2><c:out value="${row.nameOfDiscipline}"/></h2></button>
                    </td>
                </form>
            </div>
            <br />
        </c:forEach>
        <h2>From NONE to Department</h2>
        <c:forEach items="${GroupsN.rows}" var="nrow">
            <div>
                <form action="ManageDiscipline.jsp" method="post">
                    <input type="hidden"  name="action" value="${param.action}">
                    <input type="hidden"  name="ID" value="${nrow.ID}">
                    <input type="hidden"  name="step" value="2">
                    <input type="hidden"  name="chairID" value="<%out.print(areaID);%>">
                    <td colspan=2>
                        <button onclick="submit"  class="topicButton"><h2><c:out value="${nrow.nameOfDiscipline}"/></h2></button>
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
                SELECT ID, nameOfDiscipline, chairID  FROM discipline WHERE chairID=<%out.print(areaID);%>
            </sql:query>
            <c:forEach items="${Groups.rows}" var="row">
                <div>
                    <form action="ManageDiscipline.jsp" method="post">
                        <input type="hidden"  name="action" value="${param.action}">
                        <input type="hidden"  name="ID" value="${row.ID}">
                        <input type="hidden"  name="step" value="2">
                        <td colspan=2>
                            <button onclick="submit"  class="topicButton"><h2><c:out value="${row.nameOfDiscipline}"/></h2></button>
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
            SELECT nameOfDiscipline, courseNumber,semesterNumber,countOfLessons, countOfPraktice,exam, ID  FROM discipline WHERE ID=${param.ID}
        </sql:query>
        <c:forEach items="${Groups.rows}" var="row">
            <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="tableNameParameter" value="discipline">
                    <input type="hidden"  name="operation" value="update">
                    <input type="hidden"  name="ID" value="${param.ID}">
                    <tr class = "textInputLabel">
                        <td>Name Of Discipline:</td>
                        <td>
                            <input type="text" name="nameOfDiscipline" value=<c:out value="${row.nameOfDiscipline}"/>>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Cource Number:</td>
                        <td>
                            <input type="text" name="courseNumber" value=<c:out value="${row.courseNumber}"/>>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Semester Number:</td>
                        <td>
                            <input type="text" name="semesterNumber" value=<c:out value="${row.semesterNumber}"/>>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Count Of Lessons:</td>
                        <td>
                            <input type="text" name="countOfLessons" value=<c:out value="${row.countOfLessons}"/>>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Count Of Praktice:</td>
                        <td>
                            <input type="text" name="countOfPraktice" value=<c:out value="${row.countOfPraktice}"/>>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Exam:</td>
                        <td>
                            <input type="radio" name="exam" value="true" <c:if test = "${row.exam eq 'true'}"><c:out value="checked"/></c:if>>Yes<br>
                            <input type="radio" name="exam" value="false" <c:if test = "${row.exam eq 'false'}"><c:out value="checked"/></c:if>>No<br>
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
            <input type="hidden"  name="tableNameParameter" value="discipline">
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
            SELECT ID, nameOfDiscipline  FROM discipline WHERE ID=${param.ID}
        </sql:query>
        <c:forEach items="${Groups.rows}" var="row">
            <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="operation" value="delete">
                <input type="hidden"  name="tableNameParameter" value="discipline">
                <input type="hidden"  name="ID" value="${param.ID}">
                <div>
                    <h2>Delete <c:out value="${row.nameOfDiscipline}"/></h2>
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
            SELECT nameOfDiscipline, courseNumber,semesterNumber,countOfLessons, countOfPraktice,exam, ID  FROM discipline WHERE ID=${param.ID}
        </sql:query>
        <c:forEach items="${Groups.rows}" var="row">
            <table>
                <tr class = "textInputLabel">
                    <td>Name Of Discipline:</td>
                    <td>
                        <c:out value="${row.nameOfDiscipline}"/>
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Cource Number:</td>
                    <td>
                        <c:out value="${row.courseNumber}"/>
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Semester Number:</td>
                    <td>
                        <c:out value="${row.semesterNumber}"/>
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Count Of Lessons:</td>
                    <td>
                        <c:out value="${row.countOfLessons}"/>
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Count Of Praktice:</td>
                    <td>
                        <c:out value="${row.countOfPraktice}"/>
                    </td>
                </tr>
                <tr class = "textInputLabel">
                    <td>Exam:</td>
                    <td>
                        <c:if test = "${row.exam eq 'true'}">Yes</c:if>
                        <c:if test = "${row.exam eq 'false'}">No</c:if>
                    </td>
                </tr>
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