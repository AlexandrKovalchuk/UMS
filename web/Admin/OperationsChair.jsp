<%@ page import="servlets.SessionsList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.*" %>
<%@ page import="net.ukr.vixtibon.Chair" %>
<%@ page import="net.ukr.vixtibon.Employee" %>
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
    }else if(request.getParameter("action").equals("move")){
    %>
    <title>Move Chair </title>
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
        <%out.print(request.getParameter("action").equals("move")?"Move":"");%>
        <%out.print(request.getParameter("action").equals("delete")?"Delete":"");%>
        Chair Credentials Page!
        <br />
        Please choose action:
    </h5>
</div>
<br />

<div class = "pageTitleText">
<%
    if(request.getParameter("action").equals("create")){
%>

<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <table>
        <input type="hidden"  name="tableNameParameter" value="chair">
        <input type="hidden"  name="operation" value="create">
        <input type="hidden"  name="facultyID" value=<%out.print(request.getParameter("ID"));%>>
        <tr class = "textInputLabel">
            <td>Long name:</td>
            <td>
                <input type="text" name="longName" data-hint=" please enter name of chair">
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Short name:</td>
            <td>
                <input type="text" name="shortName" data-hint=" please ABR">
            </td>
        </tr>
        <tr>
            <td colspan=2>
                <button onclick="submit"  class="controlButton"><h2>Add</h2></button>
            </td>
        </tr>
    </table>
</form>

<%
}else if(request.getParameter("action").equals("update")){
%>

<%
}else if(request.getParameter("action").equals("move")){
    if(request.getParameter("selection").equals("no")){
        DataBaseDriver d = new DataBaseDriver();
        ArrayList<Institute> IobjList = d.getDateInstitute("SELECT longName, shortName, ID FROM institute");
        ArrayList<Faculty> FobjList = d.getDateFaculty("SELECT longName, shortName, ID, instituteID FROM faculty");
        for(Institute i: IobjList){
            %><h1><%out.print(i.getLongName());%></h1><%
            for(Faculty f: FobjList){
            System.out.println(f.getInstituteID() + " " + i.getID());
                if(f.getInstituteID() == i.getID()){
                    %><div><tr><td colspan=2>
                            <button onclick="window.location.href='<%out.print("OperationsChair.jsp?action=move&selection=yes&ID="+ request.getParameter("ID")
                                +"&facultyID=" + f.getID());%>' " class="itemButton" ><h1><%out.print(f.getLongName());%></h1> </button></td></tr><br/></div><%
                }
            }
        }
        %><td colspan=2>
                <button onclick="window.location.href='<%out.print("OperationsChair.jsp?action=move&selection=yes&ID="+ request.getParameter("ID")
                +"&facultyID=0");%>' " class="itemButton" ><h1>None</h1> </button></td></tr><%
    }else if(request.getParameter("selection").equals("yes")){
         %>
    <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
        <input type="hidden"  name="operation" value="move">
        <input type="hidden"  name="tableNameParameter" value="chair">
        <input type="hidden"  name="facultyID" value=<%out.print(request.getParameter("facultyID"));%>>
        <input type="hidden"  name="id" value=<%out.print(request.getParameter("ID"));%>>
        <div>
            <h2>Would you like to continue?</h2>
            <tr><td >
                    <button onclick="submit"  class="controlButton"><h2>Yes</h2></button></td><td >
                    <button onclick="window.location.href='AdminPage.jsp'"  class="controlButton"><h2>No</h2></button>
                </td></tr>
        </div>
    </form>
        <%
    }
}else if(request.getParameter("action").equals("delete")){
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Employee> EobjList = d.getDateEmployee("SELECT name, lastName, chairID, ID FROM Employee WHERE chairID='" + request.getParameter("ID") + "'");
    ArrayList<Teacher> TobjList = d.getDateTeacher("SELECT name, lastName,, chairID, ID FROM Teacher WHERE chairID='" +request.getParameter("ID") + "'" );
    ArrayList<Group> GobjList = d.getDateGroup("SELECT longName, shortName, chairID, ID FROM Group WHERE chairID='" +request.getParameter("ID") + "'" );
    ArrayList<Discipline> DobjList = d.getDateDiscipline("SELECT longName, shortName, chairID, ID FROM Discipline WHERE chairID='" +request.getParameter("ID") + "'" );
    ArrayList<Timetable> TTobjList = d.getDateTimetable("SELECT longName, shortName, chairID, ID FROM Timetable WHERE chairID='" +request.getParameter("ID") + "'" );
    ArrayList<Chair> chairs = d.getDateChair("SELECT longName, shortName, ID FROM chair WHERE ID='" + request.getParameter("ID") + "'");
%>
<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <input type="hidden"  name="operation" value="delete">
    <input type="hidden"  name="tableNameParameter" value="chair">
    <input type="hidden"  name="id" value=<%out.print(chairs.get(0).getID());%>>

    <%if((EobjList.size() > 0)|(TobjList.size() > 0)|(GobjList.size() > 0)|(DobjList.size() > 0)|(TTobjList.size() > 0)){%>
    <div class = "yelowInfo">
        <div>
            <h2>Data which will be affected is:</h2>
        </div>
        <div>
            <%
                for(Employee e: EobjList){
                    out.print(e.getSecondName() + " " + e.getName());
                }
                for(Teacher t: TobjList){
                    out.print(t.getSecondName() + " "+ t.getName());
                }
                for(Group g: GobjList){
                    out.print("Group: " + g.getID());
                }
                for(Discipline dc: DobjList){
                    out.print(dc.getNameOfDiscipline());
                }
                for(Timetable t: TTobjList){
                    out.print("Timetable: " + t.getID());
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
