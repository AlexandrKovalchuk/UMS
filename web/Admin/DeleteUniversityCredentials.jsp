<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.Faculty" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28/06/2016
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Faculty> objList = d.getDateFaculty("SELECT longName, shortName, ID FROM faculty WHERE instituteID='" +request.getParameter("ID") + "'" );
%>
<html>
<head>
    <title>Delete University Credentials</title>
    <link rel="stylesheet" type="text/css" href="css\admin_styles.css">
</head>
<body>
<div class = "needToFix">
    <h4>
    this page need to be fixed
    </h4>
</div>
<h1><%
    out.print(objList.size());
%>
</h1>

<div class = "pageTitleText">
    <h5>
        Result of Delete University Credentials Page!
    </h5>
</div>
<br />
<%

    if(objList.size()!=0) {

        for (Faculty f : objList) {
            d.stringProcessor("UPDATE faculty SET instituteID = 'null' WHERE ID ='" + f.getID() + "';");
        }
%>
<div class = "yelowInfo">
    <h4 class="payAttention">
        Data which was affected is:
    </h4>
</div>

<div class = "itemsBlockInfo">
<%
    for (Faculty f : objList) {
        %>
        <h1><%
                        out.print(f.getLongName());
                    %>
    </h1>
    <%
    }
%>
</div>
<%
    }else{
        %>
<div class = "greenInfo">
    <h4 class="googNews">
        No data was affected.
    </h4>
</div>
<%
    }
%>
</body>
</html>
