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

<c:if test = "${step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute where to Delete Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="DeleteEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="instituteID" value="${institute.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${institute.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step1'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Faculty where to Delete Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="DeleteEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${faculty.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step2'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Department where to Delete Employee:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${departmentsList}" var="department">
            <div>
                <form action="DeleteEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="departmentID" value="${department.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${department.getLongName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step3'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Employee to Delete:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${employeesList}" var="employee">
            <div>
                <form action="DeleteEmployeePageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step4">
                    <input type="hidden"  name="employeeID" value="${employee.getID()}">
                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${step eq 'step4'}">
    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <div class = "textLabelParagraph textLabelAdminPage">
            Please Confirm Delete: <c:out value="${employee.getSecondName()}"/> <c:out value="${employee.getName()}"/>
        </div>

        <div>
             <form action="DeleteEmployeePageController" method="post" accept-charset="UTF-8">
                  <table>
                       <input type="hidden"  name="step" value="step5">
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
