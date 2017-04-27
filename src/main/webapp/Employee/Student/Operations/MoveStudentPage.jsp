<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 20/02/2017
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Move Student Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>
<body class = "backgroundImageEmployee">

<div class = "pageTitleText pageTitleTextEmployee">
    Move Student Page
</div>
<br />

<c:if test = "${requestScope.selected eq 'no'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select from Group to Move student:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${requestScope.department.getLongName()}"/></div>

        <div class = "textLabelParagraph textLabelEmployeePage">Course 1:</div>
        <c:forEach items="${requestScope.department.getGroups1()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 2:</div>
        <c:forEach items="${requestScope.department.getGroups2()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 3:</div>
        <c:forEach items="${requestScope.department.getGroups3()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 4:</div>
        <c:forEach items="${requestScope.department.getGroups4()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 5:</div>
        <c:forEach items="${requestScope.department.getGroups5()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 6:</div>
        <c:forEach items="${requestScope.department.getGroups6()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step1">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test = "${requestScope.selected eq 'yes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Student to Move:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <c:forEach items="${requestScope.students}" var="student">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step2">
                    <input type="hidden"  name="studentID" value="${student.getID()}">
                    <button class="itemButton itemButtonEmployeePages" > <c:out value="${student.getSecondName()}"/> <c:out value="${student.getName()}"/></button>
                </form>
            </div>
        </c:forEach>

    </div>
</c:if>

<c:if test = "${requestScope.selected eq 'studentyes'}">
    <div class = "pageTitleText pageTitleTextEmployee">
        Select Group where to Move student:
    </div>

    <div class = "pageContent pageContentEmployeePages pageContentAdminPages500px">
        <div class = "textLabelParagraph textLabelEmployeePage"><c:out value="${requestScope.department.getLongName()}"/></div>

        <div class = "textLabelParagraph textLabelEmployeePage">Course 1:</div>
        <c:forEach items="${requestScope.department.getGroups1()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="studentID" value="${requestScope.studentID}">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 2:</div>
        <c:forEach items="${requestScope.department.getGroups2()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="studentID" value="${requestScope.studentID}">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 3:</div>
        <c:forEach items="${requestScope.department.getGroups3()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="studentID" value="${requestScope.studentID}">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 4:</div>
        <c:forEach items="${requestScope.department.getGroups4()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="studentID" value="${requestScope.studentID}">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 5:</div>
        <c:forEach items="${requestScope.department.getGroups5()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="studentID" value="${requestScope.studentID}">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <div class = "textLabelParagraph textLabelEmployeePage">Course 6:</div>
        <c:forEach items="${requestScope.department.getGroups6()}" var="group">
            <div>
                <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="step" value="step3">
                    <input type="hidden"  name="studentID" value="${requestScope.studentID}">
                    <input type="hidden"  name="groupID" value="${group.getID()}">
                    <button class="itemButton itemButtonEmployeePages" ><c:out value="${group.getFullGroupName()}"/></button>
                </form>
            </div>
        </c:forEach>
    </div>
</c:if>

<div>
    <form action="${pageContext.request.contextPath}/Employee/MoveStudentPageController" method="post">
        <input type="hidden"  name="step" value="cancel">
        <button class="controlButton controlButtonEmployeePage">Cancel</button>
    </form>
</div>

</body>
</html>
