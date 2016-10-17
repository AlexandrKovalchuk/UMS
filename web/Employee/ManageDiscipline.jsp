<%@ page import="servlets.SessionsList" %>
<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.Discipline" %>
<%@ page import="servlets.Session" %>
<%@ page import="net.ukr.vixtibon.Chair" %>
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
        }
        Session s = sl.getSession(cookies);
        s.sessionInfo();
        areaID = s.getAreaAccessID();
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
        <div>
            <tr>
                <td colspan=2>
                    <button onclick="window.location.href='ManageDiscipline.jsp?step=1&action=info'" class="topicButton" >
                        <h1>Show Discipline info</h1>
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
        ArrayList<Discipline> dsc = d.getDateDiscipline("SELECT ID, nameOfDiscipline, chairID  FROM discipline WHERE chairID=" + areaID +"");
        if(!request.getParameter("action").equals("move")){
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
        }else{
                ArrayList<Discipline> ndsc = d.getDateDiscipline("SELECT ID, nameOfDiscipline, chairID  FROM discipline WHERE chairID=0");
                %>
                    <h2>From Department to NONE</h2>
                        <%
                            for(Discipline entry: dsc){
                        %>
                                <div>
                                    <tr>
                                        <td colspan=2>
                                            <button onclick="window.location.href='<%out.print("ManageDiscipline.jsp?step=2&action=" + request.getParameter("action") + "&ID=" + entry.getID()+ "&chairID=0");%>' " class="itemButton" >
                                                <h1><%out.print(entry.getNameOfDiscipline());%></h1> </button>
                                        </td>
                                    </tr>
                                </div>
                                <br />
                                <%
                                    }
                        %>

                    <h2>From NONE to Department</h2>
                        <%
                            for(Discipline entry: ndsc){
                        %>
                                <div>
                                    <tr>
                                        <td colspan=2>
                                            <button onclick="window.location.href='<%out.print("ManageDiscipline.jsp?step=2&action=" + request.getParameter("action") + "&ID=" + entry.getID()+ "&chairID=" + areaID);%>' " class="itemButton" >
                                                <h1><%out.print(entry.getNameOfDiscipline());%></h1> </button>
                                        </td>
                                    </tr>
                                </div>
                                <br />
                                <%
                                    }
                        %>
                <%
            }
    }
    //create
}else if(Integer.parseInt(request.getParameter("step")) == 2){
            DataBaseDriver d = new DataBaseDriver();
            if(request.getParameter("action").equals("update")){
                ArrayList<Discipline> i = d.getDateDiscipline("SELECT nameOfDiscipline, courseNumber,semesterNumber,countOfLessons," +
                        "countOfPraktice,exam, ID FROM discipline WHERE id=" + request.getParameter("ID"));
                %>
                    <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
                        <table>
                            <input type="hidden"  name="tableNameParameter" value="discipline">
                            <input type="hidden"  name="operation" value="update">
                            <input type="hidden"  name="ID" value=<%out.print(i.get(0).getID());%>>
                            <tr class = "textInputLabel">
                                <td>Name Of Discipline:</td>
                                <td>
                                    <input type="text" name="nameOfDiscipline" value=<%out.print(i.get(0).getNameOfDiscipline());%>>
                                </td>
                            </tr>
                            <tr class = "textInputLabel">
                                <td>Cource Number:</td>
                                <td>
                                    <input type="text" name="courseNumber" value=<%out.print(i.get(0).getCourseNumber());%>>
                                </td>
                            </tr>
                            <tr class = "textInputLabel">
                                <td>Semester Number:</td>
                                <td>
                                    <input type="text" name="semesterNumber" value=<%out.print(i.get(0).getSemesterNumber());%>>
                                </td>
                            </tr>
                            <tr class = "textInputLabel">
                                <td>Count Of Lessons:</td>
                                <td>
                                    <input type="text" name="countOfLessons" value=<%out.print(i.get(0).getCountOfLessons());%>>
                                </td>
                            </tr>
                            <tr class = "textInputLabel">
                                <td>Count Of Praktice:</td>
                                <td>
                                    <input type="text" name="countOfPraktice" value=<%out.print(i.get(0).getCountOfPraktice());%>>
                                </td>
                            </tr>
                            <tr class = "textInputLabel">
                                <td>Exam:</td>
                                <td>
                                    <input type="radio" name="exam" value="true" <%out.print(i.get(0).isExam()?"checked":"");%>>Yes<br>
                                    <input type="radio" name="exam" value="false" <%out.print(!i.get(0).isExam()?"checked":"");%>>No<br>
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

            }else if(request.getParameter("action").equals("move")){
                %>
                    <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
                        <input type="hidden"  name="operation" value="move">
                        <input type="hidden"  name="tableNameParameter" value="discipline">
                        <input type="hidden"  name="chairID" value=<%out.print(request.getParameter("chairID"));%>>
                        <input type="hidden"  name="id" value=<%out.print(request.getParameter("ID"));%>>
                        <div>
                            <h2>Would you like to continue?</h2>
                            <tr><td >
                                <button onclick="submit"  class="controlButton"><h2>Yes</h2></button></td><td >
                                <button onclick="window.location.href='EmployeePage.jsp'"  class="controlButton"><h2>No</h2></button>
                            </td></tr>
                        </div>
                    </form>
                <%
            }else if(request.getParameter("action").equals("delete")){
            %>
                <form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
                    <input type="hidden"  name="operation" value="delete">
                    <input type="hidden"  name="tableNameParameter" value="discipline">
                    <input type="hidden"  name="id" value=<%out.print(request.getParameter("ID"));%>>
                    <div>
                        <h2>Delete </h2>
                        <h2>Would you like to continue?</h2>
                        <tr>
                            <td >
                                <button onclick="submit"  class="controlButton"><h2>Yes</h2></button>
                            </td>
                        </tr>
                    </div>
                </form>
                <td >
                    <button onclick="window.location.href='EmployeePage.jsp'"  class="controlButton"><h2>No</h2></button>
                </td>
            <%
            }else if(request.getParameter("action").equals("info")){
                ArrayList<Discipline> i = d.getDateDiscipline("SELECT nameOfDiscipline, courseNumber,semesterNumber,countOfLessons," +
                        "countOfPraktice,exam, ID FROM discipline WHERE id=" + request.getParameter("ID"));
                %>
                <table>
                    <tr class = "textInputLabel">
                        <td>Name Of Discipline:</td>
                        <td>
                            <%out.print(i.get(0).getNameOfDiscipline());%>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Cource Number:</td>
                        <td>
                            <%out.print(i.get(0).getCourseNumber());%>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Semester Number:</td>
                        <td>
                            <%out.print(i.get(0).getSemesterNumber());%>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Count Of Lessons:</td>
                        <td>
                            <%out.print(i.get(0).getCountOfLessons());%>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Count Of Praktice:</td>
                        <td>
                            <%out.print(i.get(0).getCountOfPraktice());%>
                        </td>
                    </tr>
                    <tr class = "textInputLabel">
                        <td>Exam:</td>
                        <td>
                            <%out.print(i.get(0).isExam()?"Yes":"No");%>
                        </td>
                    </tr>
                </table>
                <tr>
                    <button onclick="window.location.href='EmployeePage.jsp'" class="controlButton" >
                        <h1>OK</h1>
                    </button>
                </tr>
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