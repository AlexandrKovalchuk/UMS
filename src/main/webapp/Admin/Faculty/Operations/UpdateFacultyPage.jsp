<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 29/11/2016
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main_css\main_styles.css">
    <title>Update Faculty Page</title>
</head>
<body class = "backgroungImageAdmin">

<div class = "pageTitleText pageTitleTextAdmin">
        Update Faculty Page
</div>
<br />

<c:if test = "${step eq 'step0'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Select Institute where to Update Faculty:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <form action="UpdateFacultyPageController" method="post" accept-charset="UTF-8">
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
        Select Faculty to Update:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${facultiesList}" var="faculty">
            <div>
                <form action="UpdateFacultyPageController" method="post" accept-charset="UTF-8">
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
        Please fill form:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
         <form action="UpdateFacultyPageController" method="post" accept-charset="UTF-8">
             <table>
                 <input type="hidden"  name="step" value="step3">
                 <input type="hidden"  name="facultyID" value="${faculty.getID()}" >
                 <tr class = "textInputLabel">
                      <td class = "textLabel textLabelAdminPage">Long name:</td>
                      <td>
                          <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="longName" maxlength="70" required value="${faculty.getLongName()}">
                      </td>
                 </tr>
                 <tr class = "textInputLabel">
                      <td class = "textLabel textLabelAdminPage">Short name:</td>
                      <td>
                          <input class = "inputSettings inputAdminPage" type="text" name="shortName" maxlength="10" required value="${faculty.getShortName()}">
                      </td>
                 </tr>
                 <tr>
                      <td colspan=2>
                          <button onclick="submit"  class="controlButton controlButtonAdminPage">Update</button>
                      </td>
                 </tr>
             </table>
         </form>
    </div>
</c:if>

<div>
    <form action="UpdateFacultyPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <td colspan=2>
            <button onclick="submit"  class="controlButton controlButtonAdminPage">Cancel</button>
        </td>
    </form>
</div>

</body>
</html>
