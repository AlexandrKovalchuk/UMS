<%@ page import="servlets.SessionsList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.*" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css\admin_styles.css">
<html>
<head>
    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        System.out.println("cookies size " + cookies.length);
        String result = sl.sessionControl(cookies,"admin");
        if(!result.equals("success")){
            response.sendRedirect(result);
        }
    %>
    <%
        if(request.getParameter("action").equals("create")){
    %>
    <title>Create Chair Credentials</title>
    <%
    }else if(request.getParameter("action").equals("update")){
    %>
    <title>Update Chair Credentials</title>
    <%
    }else if(request.getParameter("action").equals("delete")){
    %>
    <title>Delete Chair Credentials</title>
    <%
    }else{
    %>
    <title>Warning</title>
    <%
        }
    %>
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Welcome to
        <%out.print(request.getParameter("action").equals("create")?"Create":"");%>
        <%out.print(request.getParameter("action").equals("update")?"Update":"");%>
        <%out.print(request.getParameter("action").equals("delete")?"Delete":"");%>
        Chair Credentials Page!
        <br />
        Please choose action:
    </h5>
</div>
<br />
<%
    if(request.getParameter("action").equals("create")){
%>

<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <table>
        <input type="hidden"  name="tableNameParameter" value="chair">
        <input type="hidden"  name="operation" value="create">
        <input type="hidden"  name="facultyID" value=<%out.print(request.getParameter("ID"));%>>
        <tr>
            <td>long name:</td>
            <td>
                <input type="text" name="longName" data-hint=" please enter name of chair">
            </td>
        </tr>
        <tr>
            <td>short name:</td>
            <td>
                <input type="text" name="shortName" data-hint=" please ABR">
            </td>
        </tr>
        <tr>
            <td colspan=2>
                <input type="submit" value="Додати" >
            </td>
        </tr>
    </table>
</form>

<%
}else if(request.getParameter("action").equals("update")){
%>

<%
}else if(request.getParameter("action").equals("delete")){
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Employee> EobjList = d.getDateEmployee("SELECT longName, shortName, chairID, ID FROM Employee WHERE chairID='" + request.getParameter("ID") + "'");
    ArrayList<Teacher> TobjList = d.getDateTeacher("SELECT longName, shortName, chairID, ID FROM Teacher WHERE chairID='" +request.getParameter("ID") + "'" );
    ArrayList<Group> GobjList = d.getDateGroup("SELECT longName, shortName, chairID, ID FROM Group WHERE chairID='" +request.getParameter("ID") + "'" );
    ArrayList<Discipline> DobjList = d.getDateDiscipline("SELECT longName, shortName, chairID, ID FROM Discipline WHERE chairID='" +request.getParameter("ID") + "'" );
    ArrayList<Timetable> TTobjList = d.getDateTimetable("SELECT longName, shortName, chairID, ID FROM Timetable WHERE chairID='" +request.getParameter("ID") + "'" );
    ArrayList<Chair> chairs = d.getDateChair("SELECT longName, shortName, ID FROM chair WHERE ID='" + request.getParameter("ID") + "'");
%>
<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <input type="hidden"  name="operation" value="delete">
    <input type="hidden"  name="tableNameParameter" value="chair">
    <input type="hidden"  name="id" value=<%out.print(chairs.get(0).getID());%>>

    <%if(objList.size() > 0){%>
    <div class = "yelowInfo">
        <div>
            <h2>Data which will be affected is:</h2>
        </div>
        <div>
            <%
                for(Employee f: objList){
                    out.print(f.getLongName());
                }
            %>
        </div>
    </div>
    <%}%>

    <div>
        <h2>Would you like to continue?</h2>
        <tr>
            <td >
                <button onclick="submit"  class="controlButton"><h2>Yes</h2></button>
            </td>
            <br>
            <td >
                <button onclick="window.location.href='AdminPage.jsp'"  class="controlButton"><h2>No</h2></button>
            </td>
        </tr>
    </div>
</form>
<td >
    <button onclick="window.location.href='AdminPage.jsp'"  class="controlButton"><h2>No</h2></button>
</td>
<%
}else{
%>
<title>Warning</title>
<%
    }
%>
</body>
</html>
