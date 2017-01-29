<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30/11/2016
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Delete Faculty Page</title>
</head>

<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
    Delete Faculty Page!
</div>
<br />

<c:if test = "${selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Faculty to Delete:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${institute.getLongName()}"/></div>
            <c:forEach items="${institute.getFacultys()}" var="faculty">
                <div>
                    <form action="/DeleteFacultyPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                        <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${faculty.getLongName()}"/></button>
                    </form>
                </div>
            </c:forEach>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
        <c:if test = "${possible_to_remove eq 'yes'}">
            <div class = "textLabelParagraph textLabelAdminPage">
                Please Confirm Delete: <c:out value="${faculty.getLongName()}"/>
            </div>

            <div>
                <form action="/DeleteFacultyPageController" method="post" accept-charset="UTF-8">
                    <table>
                        <input type="hidden"  name="step" value="step2">
                        <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                        <tr>
                            <td colspan=2>
                                <button onclick="submit"  class="controlButton controlButtonAdminPage">Delete</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </c:if>
        <c:if test = "${possible_to_remove eq 'no'}">
            <div class = "pageTitleText  pageTitleTextBad">
                Impossible to Delete: <c:out value="${faculty.getLongName()}"/> , there is still some depatments present!
            </div>
         </c:if>
    </div>
</c:if>

<div>
    <form action="DeleteFacultyPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
