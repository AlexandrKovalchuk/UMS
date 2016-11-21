<%@ page import="servlets.SessionsList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css\admin_styles.css">
<html>
<head>
    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        String result = sl.sessionControl(cookies,"admin");
        if(!result.equals("success")){
            response.sendRedirect(result);
        }
    %>
    <title>
        <c:if test = "${param.type eq 'institute'}"> Manage University Credentials</c:if>
        <c:if test = "${param.type eq 'faculty'}"> Manage Faculty Credentials</c:if>
        <c:if test = "${param.type eq 'chair'}"> Manage Chair Credentials</c:if>
        <c:if test = "${param.type eq 'emploee'}"> Manage Employee Credentials</c:if>
    </title>

</head>
<body>
<div class = "pageTitleText">
    <h5>
        Welcome to Manage
        <c:if test = "${param.type eq 'institute'}"> University </c:if>
        <c:if test = "${param.type eq 'faculty'}"> Faculty </c:if>
        <c:if test = "${param.type eq 'chair'}"> Chair </c:if>
        <c:if test = "${param.type eq 'emploee'}"> Employee </c:if>
         Credentials Page!
        <br />
        Please choose action:
    </h5>
</div>
<br />
<div class="itemsBlock">
    <div>
    <c:if test = "${param.type eq 'institute'}">
        <div>
            <form action="OperationsInstitute.jsp" method="post">
                <input type="hidden"  name="action" value="create">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Create University Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="update">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Update University Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="delete">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Delete University Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
    </c:if>
    <c:if test = "${param.type eq 'faculty'}">
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="create">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="1">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Create Faculty Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="update">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="2">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Update Faculty Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="move">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="2">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Move Faculty</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="delete">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="2">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Delete Faculty Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
    </c:if>
    <c:if test = "${param.type eq 'chair'}">
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="create">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="2">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Create Chair Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="update">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="3">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Update Chair Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="move">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="3">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Move Chair</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="delete">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="3">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Delete Chair Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
    </c:if>
    <c:if test = "${param.type eq 'emploee'}">
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="create">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="3">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Create Employee Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="update">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="4">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Update Employee Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="move">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="4">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Move Employee</h2></button>
                </td>
            </form>
        </div>
        <br />
        <div>
            <form action="Selector.jsp" method="post">
                <input type="hidden"  name="action" value="delete">
                <input type="hidden"  name="selectFrom" value="institute">
                <input type="hidden"  name="step" value="4">
                <td colspan=2>
                    <button onclick="submit"  class="topicButton"><h2>Delete Employee Credentials</h2></button>
                </td>
            </form>
        </div>
        <br />
    </c:if>
</div>
</div>
</body>
</html>
