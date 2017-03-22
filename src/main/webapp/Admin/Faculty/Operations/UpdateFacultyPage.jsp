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

<c:if test = "${selected ne 'yes'}">
   <div class = "pageTitleText pageTitleTextAdmin">
       Select Faculty to update:
   </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPages500px">
        <c:forEach items="${institutesList}" var="institute">
            <div>
                <div class = "textLabelParagraph textLabelAdminPage"><c:out value="${institute.getLongName()}"/></div>
                <c:forEach items="${institute.getFacultys()}" var="faculty">
                    <div>
                        <form action="UpdateFacultyPageController" method="post" accept-charset="UTF-8">
                                    <input type="hidden"  name="step" value="step1">
                                    <input type="hidden"  name="facultyID" value="${faculty.getID()}">
                                    <button onclick="submit" class="itemButton itemButtonAdminPages" ><c:out value="${faculty.getLongName()}"/></button>
                        </form>
                    </div>
                 </c:forEach>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextAdmin">
        Please fill form:
    </div>

    <div class = "pageContent pageContentAdminPages pageContentAdminPagesTwoFieldsSize">
         <form action="UpdateFacultyPageController" method="post" accept-charset="UTF-8">
             <table>
                 <input type="hidden"  name="step" value="step2">
                 <input type="hidden"  name="facultyID" value="${faculty.getID()}" >
                 <tr class = "textInputLabel">
                      <td class = "textLabel textLabelAdminPage">Long name:</td>
                      <td>
                          <input class = "inputSettings inputAdminPage inputAdminPageLongNames" type="text" name="longName"  required value="${faculty.getLongName()}">
                      </td>
                 </tr>
                 <tr class = "textInputLabel">
                      <td class = "textLabel textLabelAdminPage">Short name:</td>
                      <td>
                          <input class = "inputSettings inputAdminPage" type="text" name="shortName" required value="${faculty.getShortName()}">
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
