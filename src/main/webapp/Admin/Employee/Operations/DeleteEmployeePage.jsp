<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 12/01/2017
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Delete Employee Page</title>
</head>
<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Delete Employee Page
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Employee to delete:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${institute.getLongName()}"/></div>
            <c:forEach items="${institute.getFacultys()}" var="faculty">
                <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${faculty.getLongName()}"/></div>
                <c:forEach items="${faculty.getDepartments()}" var="department">
                    <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${department.getLongName()}"/></div>
                    <c:forEach items="${department.getEmployees()}" var="employee">
                        <div>
                            <form action="DeleteEmployeePageController" method="post" accept-charset="UTF-8">
                                <input type="hidden"  name="step" value="step1">
                                <input type="hidden"  name="employeeID" value="${employee.getID()}">
                                <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></button>
                            </form>
                        </div>
                    </c:forEach>
                </c:forEach>
            </c:forEach>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <div class = "textLabelParagraph textLabelAdminPage">
            Please Confirm Delete: <c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/>
        </div>

        <div>
             <form action="DeleteEmployeePageController" method="post" accept-charset="UTF-8">
                  <table>
                       <input type="hidden"  name="step" value="step2">
                       <input type="hidden"  name="employeeID" value="${employee.getID()}">
                       <tr>
                           <td colspan=2>
                               <button onclick="submit"  class="controlButton controlButtonAdminPage">Delete</button>
                           </td>
                       </tr>
                  </table>
             </form>
        </div>
    </div>
</c:if>

<div>
    <form action="DeleteEmployeePageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
        </td>
    </form>
</div>
<br />
</body>
</html>
