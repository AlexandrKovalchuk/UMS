<%@ page import="servlets.SessionsList" %>
<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.Faculty" %>
<%@ page import="net.ukr.vixtibon.Chair" %>
<%@ page import="java.util.ArrayList" %>
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
        <%out.print(request.getParameter("action").equals("delete")?"Delete":"");%>
        Faculty Credentials Page!
    </h5>
</div>
<br />
<%
    if(request.getParameter("action").equals("create")){
        %>

        <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="tableNameParameter" value="faculty">
                <input type="hidden"  name="operation" value="create">
                <input type="hidden"  name="instituteID" value=<%out.print(request.getParameter("ID"));%>>
                <tr>
                    <td>long name:</td>
                    <td>
                        <input type="text" name="longName" data-hint=" please enter name of faculty">
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
    ArrayList<Chair> objList = d.getDateChair("SELECT longName, shortName, facultyID, ID FROM chair WHERE facultyID='" +request.getParameter("ID") + "'" );
    ArrayList<Faculty> facultys = d.getDateFaculty("SELECT longName, shortName, ID FROM faculty WHERE ID='" +request.getParameter("ID") + "'");
%>
<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <input type="hidden"  name="operation" value="delete">
    <input type="hidden"  name="tableNameParameter" value="Institute">
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
