<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.*" %>
<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30/06/2016
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    int stepIndex = 0;
    stepIndex = Integer.parseInt(request.getParameter("step"));
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Institute> objListI = new ArrayList<Institute>();
    ArrayList<Faculty> objListF = new ArrayList<Faculty>();
    ArrayList<Chair> objListC = new ArrayList<Chair>();
    ArrayList<Employee> objListE = new ArrayList<Employee>();

    if(request.getParameter("selectFrom").equals("institute")){
        objListI = d.getDateInstitute("SELECT longName, shortName, ID FROM institute");
    }else if(request.getParameter("selectFrom").equals("faculty")){
        objListF = d.getDateFaculty("SELECT longName, shortName, instituteID, ID FROM faculty WHERE instituteID = '" +request.getParameter("ID") +"'");
    }else if(request.getParameter("selectFrom").equals("chair")){
         objListC = d.getDateChair("SELECT longName, shortName, facultyID, ID FROM chair WHERE facultyID = '" +request.getParameter("ID") +"'");
    }else if(request.getParameter("selectFrom").equals("emploee")){
        objListC = d.getDateChair("SELECT name, lastName, chairID, ID FROM emploee WHERE chairID = '" +request.getParameter("ID") +"'");
    }
%>
<link rel="stylesheet" type="text/css" href="css\admin_styles.css">
<html>
<head>
    <title>Selector</title>
</head>
<body>
<div class = "pageTitleText">
    <h5>
        <%if(request.getParameter("action").equals("create")){%>
        Please select location where you would like to create item!
        <%}else if(request.getParameter("action").equals("delete")){%>
        Please select location <%out.print(request.getParameter("step").equals("1")?"which item":"where");%> you would like to
        delete <%out.print(request.getParameter("step").equals("1")?"":"item");%>!
        <%}else if(request.getParameter("action").equals("update")){%>
        Please select location <%out.print(request.getParameter("step").equals("1")?"which item":"where");%> you would like to
        update <%out.print(request.getParameter("step").equals("1")?"":"item");%>!
        <%}%>
    </h5>
</div>
<br />

<div class="itemsBlock">
    <%if(request.getParameter("selectFrom").equals("institute")){
        if(request.getParameter("step").equals("1")){
            if(request.getParameter("action").equals("create")){
                for(Institute i: objListI){
                    %>
                    <div>
                        <tr>
                            <td colspan=2>
                                <button onclick="window.location.href='<%out.print("OperationsFaculty.jsp?action=" + request.getParameter("action") + "&ID=" + i.getID());%>' " class="itemButton" >
                                    <h1><%out.print(i.getLongName());%></h1> </button>
                            </td>
                        </tr>
                    </div>
                    <br />
                    <%
                            }
                    %>
                    <div>
                        <tr>
                            <td colspan=2>
                                <button onclick="window.location.href='<%out.print("OperationsFaculty.jsp?action=" + request.getParameter("action") + "&ID=0" );%>' " class="itemButton" >
                                    <h1>None</h1> </button>
                            </td>
                        </tr>
                    </div>
                    <%
            }else{
            if(objListI.size() > 0){
            for(Institute i: objListI){
                %>
                <div>
                    <tr>
                        <td colspan=2>
                        <button onclick="window.location.href='<%out.print("OperationsInstitute.jsp?action=" + request.getParameter("action") + "&ID=" + i.getID());%>' " class="itemButton" >
                            <h1><%out.print(i.getLongName());%></h1> </button>
                        </td>
                    </tr>
                </div>
                <br />
                <%
                }
                    }else{
                    %>
                    <div class = "yelowInfo">
                    <h4 class="payAttention">
                            There is no data to <%out.print(request.getParameter("action"));%>
                    </h4>
                    </div>
                    <br />
                    <div>
                        <tr>
                            <td colspan=2>
                                <button onclick="window.location.href='AdminPage.html'" class="topicButton" >
                                    <h1>Go To Main Page</h1>
                                </button>
                            </td>
                        </tr>
                    </div>
                    <%
                }
            }
        }else{
                    stepIndex--;
            for(Institute i: objListI){

                %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='<%out.print("Selector.jsp?action=" + request.getParameter("action") + "&ID=" + i.getID() + "&selectFrom=faculty" + "&step=" + stepIndex);%>' " class="itemButton" >
                            <h1><%out.print(i.getLongName());%></h1> </button>
                        </td>
                    </tr>
                </div>
                <br />
                <%
                }
                %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='<%out.print("Selector.jsp?action=" + request.getParameter("action") + "&ID=0" + "&selectFrom=faculty" + "&step=" + stepIndex);%>' " class="itemButton" >
                            <h1>None</h1> </button>
                        </td>
                    </tr>
                </div>
                     <%
             }

    }else if(request.getParameter("selectFrom").equals("faculty")){
        if(request.getParameter("step").equals("1")){
            if(request.getParameter("action").equals("create")){
                for(Faculty f: objListF){
                %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='<%out.print("OperationsChair.jsp?action=" + request.getParameter("action") + "&ID=" + f.getID());%>' " class="itemButton" >
                                <h1><%out.print(f.getLongName());%></h1> </button>
                        </td>
                    </tr>
                </div>
                <br />
                <%
                    }
                %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='<%out.print("OperationsFaculty.jsp?action=" + request.getParameter("action") + "&ID=0" );%>' " class="itemButton" >
                                <h1>None</h1> </button>
                        </td>
                    </tr>
                </div>
                <%

            }else{
            if(objListF.size() > 0){
            for(Faculty f: objListF){
            %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='<%out.print("OperationsFaculty.jsp?action=" + request.getParameter("action") + "&ID=" + f.getID());%>' " class="itemButton" >
                                <h1><%out.print(f.getLongName());%></h1> </button>
                        </td>
                    </tr>
                </div>
                <br />
            <%
            }
            }else{
            %>
                <div class = "yelowInfo">
                    <h4 class="payAttention">
                        There is no data to <%out.print(request.getParameter("action"));%>
                    </h4>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='AdminPage.html'" class="topicButton" >
                                <h1>Go To Main Page</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <%
        }

        }
         }else{
            stepIndex--;
             for(Faculty f: objListF){

                 %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='<%out.print("Selector.jsp?action=" + request.getParameter("action") + "&ID=" + f.getID() + "&selectFrom=chair" + "&step=" + stepIndex);%>' " class="itemButton" >
                                <h1><%out.print(f.getLongName());%></h1> </button>
                        </td>
                    </tr>
                </div>
                <br />
             <%
             }
             %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='<%out.print("Selector.jsp?action=" + request.getParameter("action") + "&ID=0" + "&selectFrom=chair" + "&step=" + stepIndex);%>' " class="itemButton" >
                                <h1>None</h1> </button>
                        </td>
                    </tr>
                </div>
    <%
    }
    }else if(request.getParameter("selectFrom").equals("chair")){
        if(request.getParameter("step").equals("1")){
            if(objListC.size() > 0){
             for(Chair c: objListC){
             %>
                <div>
                    <tr>
                        <td colspan=2>
                        <button onclick="window.location.href='<%out.print("OperationsChair.jsp?action=" + request.getParameter("action") + "&ID=" + c.getID());%>' " class="itemButton" >
                            <h1><%out.print(c.getLongName());%></h1> </button>
                        </td>
                    </tr>
                </div>
                <br />
             <%
             }
             }else{
             %>
                <div class = "yelowInfo">
                    <h4 class="payAttention">
                        There is no data to <%out.print(request.getParameter("action"));%>
                    </h4>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='AdminPage.html'" class="topicButton" >
                                <h1>Go To Main Page</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <%
        }
        }else{
            stepIndex--;
              for(Chair c: objListC){

                  %>
                    <div>
                        <tr>
                             <td colspan=2>
                             <button onclick="window.location.href='<%out.print("Selector.jsp?action=" + request.getParameter("action") + "&ID=" + c.getID() + "&selectFrom=chair" + "&step=" + stepIndex);%>' " class="itemButton" >
                                    <h1><%out.print(c.getLongName());%></h1> </button>
                             </td>
                        </tr>
                    </div>
                    <br />
                    <%
                    }
                    %>
                    <div>
                        <tr>
                            <td colspan=2>
                                <button onclick="window.location.href='<%out.print("Selector.jsp?action=" + request.getParameter("action") + "&ID=1" + "&selectFrom=chair" + "&step=" + stepIndex);%>' " class="itemButton" >
                                    <h1>None</h1> </button>
                            </td>
                        </tr>
                    </div>
                        <%
                    }
    }else if(request.getParameter("selectFrom").equals("emploee")){
         if(request.getParameter("step").equals("1")){
             if(objListE.size() > 0){
              for(Employee e: objListE){
              %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='<%out.print("OperationsEmploee.jsp?action=" + request.getParameter("action") + "&ID=" + e.getPersonalID());%>' " class="itemButton" >
                                <h1><%out.print(e.getName());%> </h1> <h1><%out.print(e.getSecondName());%> </h1></button>
                        </td>
                    </tr>
                </div>
                <br />
              <%
              }
              }else{
              %>
                <div class = "yelowInfo">
                    <h4 class="payAttention">
                        There is no data to <%out.print(request.getParameter("action"));%>
                    </h4>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='AdminPage.html'" class="topicButton" >
                                <h1>Go To Main Page</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <%
        }
         }else{
            stepIndex--;
              for(Employee e: objListE){

                  %>
                    <div>
                        <tr>
                            <td colspan=2>
                                <button onclick="window.location.href='<%out.print("Selector.jsp?action=" + request.getParameter("action") + "&ID=" + e.getPersonalID() + "&selectFrom=chair" + "&step=" + stepIndex);%>' " class="itemButton" >
                                    <h1><%out.print(e.getName());%> </h1> <h1><%out.print(e.getSecondName());%> </h1> </button>
                            </td>
                        </tr>
                    </div>
                    <br />
              <%
              }
              %>
                    <div>
                        <tr>
                            <td colspan=2>
                                <button onclick="window.location.href='<%out.print("Selector.jsp?action=" + request.getParameter("action") + "&ID=1" + "&selectFrom=chair" + "&step=" + stepIndex);%>' " class="itemButton" >
                                    <h1>None</h1> </button>
                            </td>
                        </tr>
                    </div>
               <%
            }
        }
    %>

</div>
</body>
</html>
