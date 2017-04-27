<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 04/02/2017
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <title>Delete Group Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Delete Group Page (<c:out value="${requestScope.department.getLongName()}"/>)
</div>
<br />

<c:if test = "${requestScope.selected ne 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Group to Delete:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <jsp:useBean id="departments" scope="request" type="java.util.List"/>
        <c:forEach items="${departments}" var="department">
            <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${department.getLongName()}"/></div>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #1</div>
            <c:forEach items="${department.getGroups1()}" var="group">
                <div>
                    <form action="${pageContext.request.contextPath}/Employee/DeleteGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #2</div>
            <c:forEach items="${department.getGroups2()}" var="group">
                <div>
                    <form action="${pageContext.request.contextPath}/Employee/DeleteGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #3</div>
            <c:forEach items="${department.getGroups3()}" var="group">
                <div>
                    <form action="${pageContext.request.contextPath}/Employee/DeleteGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #4</div>
            <c:forEach items="${department.getGroups4()}" var="group">
                <div>
                    <form action="${pageContext.request.contextPath}/Employee/DeleteGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #5</div>
            <c:forEach items="${department.getGroups5()}" var="group">
                <div>
                    <form action="${pageContext.request.contextPath}/Employee/DeleteGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
            <div class = "textLabelParagraph textLabelEmployeePage">Course #6</div>
            <c:forEach items="${department.getGroups6()}" var="group">
                <div>
                    <form action="${pageContext.request.contextPath}/Employee/DeleteGroupPageController" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="step" value="step1">
                        <input type="hidden"  name="groupID" value="${group.getID()}">
                        <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                    </form>
                </div>
            </c:forEach>
        </c:forEach>
    </div>

</c:if>

<c:if test = "${requestScope.selected eq 'yes'}">
    <div class = "pageContent pageContentEmployeePages pageContentAdminPagesTwoFieldsSize">
        <c:if test = "${requestScope.possible_to_remove eq 'yes'}">
            <div class = "textLabelParagraph textLabelEmployeePage">
                Please Confirm Delete: <c:out value="${requestScope.group.getFullGroupName()}"/>
            </div>

            <div>
                <form action="${pageContext.request.contextPath}/Employee/DeleteGroupPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="groupID" value="${requestScope.group.getID()}">
                    <button class="controlButton controlButtonEmployeePage">Delete</button>
                </form>
            </div>
        </c:if>

        <c:if test = "${requestScope.possible_to_remove eq 'no'}">
            <div class = "pageTitleText  pageTitleTextBad">
                Impossible to Delete: <c:out value="${requestScope.institute.getLongName()}"/> , there is still some Teachers depended!
            </div>
        </c:if>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/DeleteGroupPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
