<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.Institute" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 17/06/2016
  Time: 07:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Institute> objList = d.getDateInstitute("SELECT longName, shortName, ID FROM institute");
%>
<html>
<head>
    <title>Update University Credentials</title>
    <link rel="stylesheet" type="text/css" href="css\admin_styles.css">
</head>
<body>

<div class = "pageTitleText">
    <h5>
        Welcome to Update University Credentials Page!
        <br />
        Please select item to update:
    </h5>
</div>

<br />
<%
    if(objList.size()!=0){
%>
<div class="itemsBlock">
    <%
        for(Institute i: objList){
    %>
    <div>
        <tr>
            <td colspan=2>
                <button onclick="window.location.href='UpdateUniversityCredentials.jsp?longname=<%out.print(i.getLongName());%>&shortname=<%out.print(i.getShortName());%>&ID=<%out.print(i.getID());%>'" class="itemButton" >
                    <h1><%
                        out.print(i.getLongName());
                    %></h1>
                </button>
            </td>
        </tr>
    </div>
    <br />

    <%
        }
    %>
</div>
<%
    }else if(objList.size() ==1){
%>
        <c:redirect url = UpdateUniversityCredentials.jsp?longname=<%out.print(objList.get(0).getLongName());%>&shortname=<%out.print(objList.get(0).getShortName());%>&ID=<%out.print(objList.get(0).getID());%>/>
                <%
    }else{
    %>
    <div class = "yelowInfo">
    <h4 class="payAttention">
        There is no data to update.
    </h4>
</div>
                    <%
    }
%>
</body>
</html>
