<%@ page import="servlets.SessionsList" %>
<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.Faculty" %>
<%@ page import="net.ukr.vixtibon.Chair" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.Institute" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 23:43
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
    <title>Create Faculty Credentials</title>

    <%
    }else if(request.getParameter("action").equals("update")){
    %>
    <title>Update Faculty Credentials</title>
    <%
    }else if(request.getParameter("action").equals("move")){
    %>
    <title>Move Faculty</title>
    <%
    }else if(request.getParameter("action").equals("delete")){
    %>
    <title>Delete Faculty Credentials</title>
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
        Faculty Credentials Page!
    </h5>
</div>
<br />
<div class = "pageTitleText">
    <%
    if(request.getParameter("action").equals("create")){
    %>
        <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="tableNameParameter" value="faculty">
                <input type="hidden"  name="operation" value="create">
                <input type="hidden"  name="instituteID" value=<%out.print(request.getParameter("ID"));%>>
                <tr class = "textInputLabel">
                    <td>Long name:</td>
                    <td>
                        <input type="text" name="longName" data-hint=" please enter name of faculty">
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
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Faculty> f = d.getDateFaculty("SELECT longName, shortName, ID FROM faculty WHERE id=" + request.getParameter("ID"));
        %>
    <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
        <table>
            <input type="hidden"  name="tableNameParameter" value="faculty">
            <input type="hidden"  name="operation" value="update">
            <input type="hidden"  name="ID" value=<%out.print(f.get(0).getID());%>>
            <tr class = "textInputLabel">
                <td>Long name:</td>
                <td>
                    <input type="text" name="longName" data-hint=" please enter name of institute" value=<%out.print(f.get(0).getLongName());%>>
                </td>
            </tr>
            <tr class = "textInputLabel">
                <td>Short name:</td>
                <td>
                    <input type="text" name="shortName" data-hint=" please ABR" value=<%out.print(f.get(0).getShortName());%>>
                </td>
            </tr>
            <tr>
                <td colspan=2>
                    <button onclick="submit"  class="controlButton"><h2>Update</h2></button>
                </td>
            </tr>
        </table>
    </form>
    <%
}else if(request.getParameter("action").equals("move")){
    if(request.getParameter("selection").equals("no")){
        DataBaseDriver d = new DataBaseDriver();
        ArrayList<Institute> IobjList = d.getDateInstitute("SELECT longName, shortName, ID FROM institute");
        for(Institute i: IobjList){
            %><div><tr><td colspan=2>
                <button onclick="window.location.href='<%out.print("OperationsFaculty.jsp?action=move&selection=yes&ID="+ request.getParameter("ID")
                +"&instituteID=" + i.getID());%>' " class="itemButton" ><h1><%out.print(i.getLongName());%></h1> </button></td></tr><br/></div><%
        }
        %><td colspan=2>
            <button onclick="window.location.href='<%out.print("OperationsFaculty.jsp?action=move&selection=yes&ID="+ request.getParameter("ID")
            +"&instituteID=0");%>' " class="itemButton" ><h1>None</h1> </button></td></tr><%
    }else if(request.getParameter("selection").equals("yes")){
                %>

                <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
                <input type="hidden"  name="operation" value="move">
                <input type="hidden"  name="tableNameParameter" value="faculty">
                <input type="hidden"  name="instituteID" value=<%out.print(request.getParameter("instituteID"));%>>
                <input type="hidden"  name="id" value=<%out.print(request.getParameter("ID"));%>>
                <div><h2>Would you like to continue?</h2><tr><td >
                <button onclick="submit"  class="controlButton"><h2>Yes</h2></button></td><td >
                <button onclick="window.location.href='AdminPage.jsp'"  class="controlButton"><h2>No</h2></button></td></tr>
    </div>
    </form>
    <%
    }
    }else if(request.getParameter("action").equals("delete")){
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Chair> objList = d.getDateChair("SELECT longName, shortName, facultyID, ID FROM chair WHERE facultyID='" +request.getParameter("ID") + "'" );
    ArrayList<Faculty> facultys = d.getDateFaculty("SELECT longName, shortName, ID FROM faculty WHERE ID='" +request.getParameter("ID") + "'");
%>
<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <input type="hidden"  name="operation" value="delete">
    <input type="hidden"  name="tableNameParameter" value="faculty">
    <input type="hidden"  name="id" value=<%out.print(facultys.get(0).getID());%>>

    <%if(objList.size() > 0){%>
    <div class = "yelowInfo">
        <div>
            <h2>Data which will be affected is:</h2>
        </div>
        <div>
            <%
                for(Chair f: objList){
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
</div>
</body>
</html>
