<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.Institute" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28/06/2016
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Institute> objList = d.getDateInstitute("SELECT longName, shortName, ID FROM institute");
%>
<html>
<head>
    <title>Delete University Credentials Selection</title>
    <link rel="stylesheet" type="text/css" href="css\admin_styles.css">
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Welcome to Delete University Credentials Page!
        <br />
        Please select item to delete:
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
                <button onclick="window.location.href='DeleteUniversityCredentials.jsp?longname=<%out.print(i.getLongName());%>&shortname=<%out.print(i.getShortName());%>&ID=<%out.print(i.getID());%>'" class="itemButton" >
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
}else{
%>
<div class = "yelowInfo">
    <h4 class="payAttention">
        There is no data to delete.
    </h4>
</div>
<%
    }
%>

</body>
</html>
