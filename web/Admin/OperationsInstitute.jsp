<%@ page import="servlets.SessionsList" %>
<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.Faculty" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.Institute" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 23:27
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
    <title>Create University Credentials</title>
    <%
    }else if(request.getParameter("action").equals("update")){
    %>
    <title>Update University Credentials</title>
    <%
    }else if(request.getParameter("action").equals("move")){
    %>
    <title>Move University Credentials</title>
    <%
    }else if(request.getParameter("action").equals("delete")){
    %>
    <title>Delete University Credentials</title>
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
        University Credentials Page!
    </h5>
</div>
<br />
<div class = "pageTitleText">
    <%
    if(request.getParameter("action").equals("create")){
    %>
        <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
            <table>
                <input type="hidden"  name="tableNameParameter" value="Institute">
                <input type="hidden"  name="operation" value="create">
                <tr class = "textInputLabel">
                    <td>Long name:</td>
                    <td>
                        <input type="text" name="longName" data-hint=" please enter name of institute">
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
        ArrayList<Institute> i = d.getDateInstitute("SELECT longName, shortName, ID FROM institute");
    %>
    <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
        <table>
            <input type="hidden"  name="tableNameParameter" value="Institute">
            <input type="hidden"  name="operation" value="update">
            <input type="hidden"  name="ID" value=<%out.print(i.get(0).getID());%>>
            <tr class = "textInputLabel">
                <td>Long name:</td>
                <td>
                    <input type="text" name="longName" data-hint=" please enter name of institute" value=<%out.print(i.get(0).getLongName());%>>
                </td>
            </tr>
            <tr class = "textInputLabel">
                <td>Short name:</td>
                <td>
                    <input type="text" name="shortName" data-hint=" please ABR" value=<%out.print(i.get(0).getShortName());%>>
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
    }else if(request.getParameter("action").equals("delete")){
        DataBaseDriver d = new DataBaseDriver();
        ArrayList<Faculty> objList = d.getDateFaculty("SELECT longName, shortName, instituteID, ID FROM faculty WHERE instituteID='" +request.getParameter("ID") + "'" );
        ArrayList<Institute> institutes = d.getDateInstitute("SELECT longName, shortName, ID FROM institute WHERE ID='" +request.getParameter("ID") + "'");
    %>
    <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
        <input type="hidden"  name="operation" value="delete">
        <input type="hidden"  name="tableNameParameter" value="Institute">
        <input type="hidden"  name="id" value=<%out.print(institutes.get(0).getID());%>>

        <%if(objList.size() > 0){%>
        <div class = "yelowInfo">
            <br>
            <div>
                <h2>Data which will be affected is:</h2>
            </div>
            <div>
                <%
                for(Faculty f: objList){
                %>
                    <h3><%out.print(f.getLongName());%></h3>
                <%
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
