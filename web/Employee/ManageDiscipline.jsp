<%@ page import="servlets.SessionsList" %>
<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.Discipline" %>
<%@ page import="servlets.Session" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30/09/2016
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        String result = sl.sessionControl(cookies,"employee");
        int areaID = 0;
        if(!result.equals("success")){
            response.sendRedirect(result);
            Session s = sl.getSession(cookies);
            areaID = s.getAreaAccessID();
        }
        int step = 0;
        step = Integer.parseInt(request.getParameter("step"));
    %>
    <title>Manage Discipline Page</title>
    <link rel="stylesheet" type="text/css" href="sources\employee_css.css">
</head>
<body>

<div class = "pageTitleText">
    <h5>
        Welcome to Manage Discipline Page!
        <br />
        <%if(step == 0){%>Please choose action:<%}%>
        <%if(!(request.getParameter("action").equals("create"))){%>Please select Discipline:<%}%>
    </h5>
</div>

<%

if(Integer.parseInt(request.getParameter("step")) == 0){
    //select operation create, update, move, delete
    %>
    <div>
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='ManageDiscipline.jsp?step=1&action=create'" class="topicButton" >
                        <h1>Create Discipline</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='ManageDiscipline.jsp?step=1&action=update'" class="topicButton" >
                        <h1>Update Discipline</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='ManageDiscipline.jsp?step=1&action=move'" class="topicButton" >
                        <h1>Move Discipline</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='ManageDiscipline.jsp?step=1&action=delete'" class="topicButton" >
                        <h1>Delete Discipline</h1>
                    </button>
                </td>
            </tr>
        </div>
        <br />
    </div>
    <%
}else if(Integer.parseInt(request.getParameter("step")) == 1){
    if(request.getParameter("action").equals("create")){
        %>
            <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
                <table>
                    <input type="hidden"  name="tableNameParameter" value="discipline">
                    <input type="hidden"  name="operation" value="create">
                    <input type="hidden"  name="chairID" value= <%out.print(areaID);%>>
                    <tr class = "textInputLabel">
                        <td>Name Of Discipline:</td>
                        <td>
                            <input type="text" name="nameOfDiscipline" data-hint=" please enter name of institute">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Cource Number:</td>
                        <td>
                            <input type="text" name="courseNumber" data-hint=" please ABR">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Semester Number:</td>
                        <td>
                            <input type="text" name="semesterNumber" data-hint=" please ABR">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Count Of Lessons:</td>
                        <td>
                            <input type="text" name="countOfLessons" data-hint=" please ABR">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Count Of Praktice:</td>
                        <td>
                            <input type="text" name="countOfPraktice" data-hint=" please ABR">
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Exam:</td>
                        <td>
                            <input type="radio" name="exam" value="true">Yes<br>
                            <input type="radio" name="exam" value="false">No<br>
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
    }else {
        DataBaseDriver d = new DataBaseDriver();
        ArrayList<Discipline> dsc = d.getDateDiscipline("SELECT ID, nameOfDiscipline  FROM discipline WHERE chairID='" + areaID +"'");
        for(Discipline entry: dsc){
            %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='<%out.print("ManageDiscipline.jsp?step=2&action=" + request.getParameter("action") + "&ID=" + entry.getID());%>' " class="itemButton" >
                                <h1><%out.print(entry.getNameOfDiscipline());%></h1> </button>
                        </td>
                    </tr>
                </div>
                <br />
            <%
        }
    }
    //create
}else if(Integer.parseInt(request.getParameter("step")) == 2){
            DataBaseDriver d = new DataBaseDriver();
            if(request.getParameter("action").equals("update")){

            }else if(request.getParameter("action").equals("move")){

            }else if(request.getParameter("action").equals("delete")){
            %>
                <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="operation" value="delete">
                    <input type="hidden"  name="tableNameParameter" value="discipline">
                    <input type="hidden"  name="id" value=<%out.print(request.getParameter("ID"));%>>
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

}else{
     %>
         <title>Warning</title>
      <%
}
%>
</body>
</html>
