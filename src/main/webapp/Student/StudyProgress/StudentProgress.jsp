<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 04/04/2017
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Progress Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}\main_css\main_styles.css">
</head>

<body class = "backgroundImageStudent">

<div class = "pageTitleText pageTitleTextStudent">
    Welcome to Student Progress Page
</div>
<br />

<div class = "pageTitleText pageTitleTextStudent">
    Progress:
</div>
<div class = "pageContent pageContentStudentPages pageContentAdminPages500px">
    <c:set var="count" value="1" scope="page" />
    <c:forEach begin="1" end="6" varStatus="loop">
        <div class = "pageTitleText pageTitleTextStudent">
            Course #<c:out value="${count}"/>
        </div>
        <table  class = "studentTable">
            <c:forEach var="saoItem" items="${requestScope.student.getProgress()}">
                <c:if test = "${requestScope.student.getDisciplines().get(saoItem.value.getDisciplineID()).getCourseNumber() == count}">
                    <tr  class = "studentTable">
                        <td class = "textLabel textLabelStudentPage studentTable"><c:out value="${requestScope.student.getDisciplines().get(saoItem.value.getDisciplineID()).getNameOfDiscipline()}"/></td>
                        <c:forEach var="progress" items="${saoItem.value.getProgress()}">
                            <td class = "textLabel textLabelStudentPage studentTable studentTableWidth"><c:out value="${progress}"/></td>
                        </c:forEach>
                        <td class = "textLabel textLabelStudentPage studentTable studentTableWidth"><c:out value="${saoItem.value.getExamResult()}"/></td>
                    </tr>
                </c:if>
            </c:forEach>

        </table>
        <c:set var="count" value="${count + 1}" scope="page"/>
    </c:forEach>
</div>

<div>
    <form action="${pageContext.request.contextPath}/Student/ShowProgressPageController" method="post">
        <input type="hidden"  name="step" value="ok">
        <button class="controlButton controlButtonStudentPage">OK</button>
    </form>
</div>

</body>
</html>
