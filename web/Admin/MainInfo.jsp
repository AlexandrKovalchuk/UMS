<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.Institute" %>
<%@ page import="net.ukr.vixtibon.Faculty" %>
<%@ page import="net.ukr.vixtibon.Chair" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 21/09/2016
  Time: 00:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Institute> objListI = new ArrayList<Institute>();
    ArrayList<Faculty> objListF = new ArrayList<Faculty>();
    ArrayList<Chair> objListC = new ArrayList<Chair>();

    objListI = d.getDateInstitute("SELECT longName, shortName, ID FROM institute");
    objListF = d.getDateFaculty("SELECT longName, shortName, instituteID, ID FROM faculty");
    objListC = d.getDateChair("SELECT longName, shortName, facultyID,  ID FROM chair");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>MAIN INFO</title>
    <link rel="stylesheet" type="text/css" href="css\admin_styles.css">
</head>
<body>

<div class = "pageTitleText">
    <h5>
        Welcome to MAIN INFO Page!
    </h5>
</div>
<br/>
<div class = "pageTitleText">
<%
for(Institute i: objListI){
    System.out.println("i " + i.getLongName() + " " + i.getID());
%><h1><%out.print(i.getLongName());%></h1><%
            for(Faculty f: objListF){
                System.out.println("f " + f.getLongName() + " " + f.getID() + " " + f.getInstituteID());
                if(f.getInstituteID() == i.getID()){
                %><h2>_<%out.print(f.getLongName());%></h2><%
                    for(Chair c: objListC){
                        System.out.println("c " + c.getLongName()  + " " + c.getID());
                        if(c.getFacultyID() == f.getID()){
                            %>__<%out.print(c.getLongName());%><%
                    }
            }
        }
    }
    }
    %>
</div>
</body>
</html>
