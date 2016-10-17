<%@ page import="servlets.Session" %>
<%@ page import="servlets.SessionsList" %>
<%@ page import="net.ukr.vixtibon.DataBaseDriver" %>
<%@ page import="net.ukr.vixtibon.Discipline" %>
<%@ page import="net.ukr.vixtibon.Teacher" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 10/10/2016
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        DataBaseDriver d = new DataBaseDriver();
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
    <title><title>Manage Teacher Credentials</title></title>
    <link rel="stylesheet" type="text/css" href="sources\employee_css.css">
</head>
<body>
<div class = "pageTitleText">
    <h5>
        Welcome to Manage Teacher Credentials Page!
        <br />
        <%if(step == 0){%>Please choose action:<%}%>
        <%if(!(request.getParameter("action").equals("create"))){%>Please select Teacher:<%}%>
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
                        <button onclick="window.location.href='ManageTeacherCredentials.jsp?step=1&action=create'" class="topicButton" >
                            <h1>Create Teacher Credentials</h1>
                        </button>
                    </td>
                </tr>
            </div>
            <br />
            <div>
                <tr>
                    <td colspan=2>
                        <button onclick="window.location.href='ManageTeacherCredentials.jsp?step=1&action=update'" class="topicButton" >
                            <h1>Update Teacher Credentials</h1>
                        </button>
                    </td>
                </tr>
            </div>
            <br />
            <br />
            <div>
                <tr>
                    <td colspan=2>
                        <button onclick="window.location.href='ManageTeacherCredentials.jsp?step=1&action=move'" class="topicButton" >
                            <h1>Move Teacher Credentials</h1>
                        </button>
                    </td>
                </tr>
            </div>
            <br />
            <div>
                <tr>
                    <td colspan=2>
                        <button onclick="window.location.href='ManageTeacherCredentials.jsp?step=1&action=delete'" class="topicButton" >
                            <h1>Delete Teacher Credentials</h1>
                        </button>
                    </td>
                </tr>
            </div>
            <br />
            <div>
                <tr>
                    <td colspan=2>
                        <button onclick="window.location.href='ManageTeacherCredentials.jsp?step=1&action=info'" class="topicButton" >
                            <h1>Show Teachers info</h1>
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
        <input type="hidden"  name="tableNameParameter" value="teacher">
        <input type="hidden"  name="operation" value="create">
        <input type="hidden"  name="chairID" value= <%out.print(areaID);%>>
        <tr class = "textInputLabel">
        <tr class = "textInputLabel">
            <td>Ім'я:</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Прізвище:</td>
            <td>
                <input type="text" name="lastName">
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>По Батькові:</td>
            <td>
                <input type="text" name="fathersName">
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Ідентифікаційний код:</td>
            <td>
                <input type="text" name="personalID">
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Стать:</td>
            <td>
                <input type="radio" name="sex" value="m" checked>Чоловіча<br>
                <input type="radio" name="sex" value="f">Жіноча
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Пошта:</td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Телефон:</td>
            <td>
                <input type="text" name="phoneNumber">
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Дата народження:</td>
        </tr>
        <tr class = "textInputLabel">
            <td>День</td>
            <td>
                <input type="int" name="bday">
            </td>
            <td>   Місяць</td>
            <td>
                <input type="text" name="bmonth">
            </td>
            <td>   Рік</td>
            <td>
                <input type="int" name="byear">
            </td>

        </tr>
        <tr class = "textInputLabel">
            <td>Адресса:</td>
        </tr>
        <tr class = "textInputLabel">
            <td> Країна</td>
            <td>
                <input type="text" name="address">
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Паспортні данні:</td>
            <td>
                <input type="text" name="pasport">
            </td>
        </tr>

        <tr class = "textInputLabel">
            <td>Посада:</td>
            <td>
                <input type="text" name="office">
            </td>
        </tr>

        <tr>
            <td>Науковий ступінь:</td>
            <td>
                <input type="text" name="level">
            </td>
        </tr>
        <tr>
        <%

        ArrayList<Discipline> ds = d.getDateDiscipline("SELECT ID, nameOfDiscipline, chairID  FROM discipline WHERE chairID=" + areaID +"");
            int i = 0;
            for(Discipline entry: ds){
                %>
                    <input type="checkbox" name="DS<%out.print(i);%>" value=<%out.print(entry.getID());%> ><%out.print(entry.getNameOfDiscipline());%><br>
                <%
                i++;
            }
        %>
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
    ArrayList<Teacher> dsc = d.getDateTeacher("SELECT ID, name, lastname chairID  FROM teacher WHERE chairID=" + areaID + "");
    if(!request.getParameter("action").equals("move")){
        for(Teacher entry: dsc){
%>
<div>
    <tr>
        <td colspan=2>
            <button onclick="window.location.href='<%out.print("ManageTeacherCredentials.jsp?step=2&action=" + request.getParameter("action") + "&ID=" + entry.getID());%>' " class="itemButton" >
                <h1><%out.print(entry.getOffice() + " " +entry.getSecondName() + " " + entry.getName());%></h1> </button>
        </td>
    </tr>
</div>
<br />
<%
    }
}else{
    ArrayList<Teacher> ndsc = d.getDateTeacher("SELECT ID, name, lastname chairID  FROM teacher WHERE chairID=0");
%>
<h2>From Department to NONE</h2>
<%
    for(Teacher entry: dsc){
%>
<div>
    <tr>
        <td colspan=2>
            <button onclick="window.location.href='<%out.print("ManageTeacherCredentials.jsp?step=2&action=" + request.getParameter("action") + "&ID=" + entry.getID()+ "&chairID=0");%>' " class="itemButton" >
                <h1><%out.print(entry.getOffice() + " " +entry.getSecondName() + " " + entry.getName());%></h1> </button>
        </td>
    </tr>
</div>
<br />
<%
    }
%>

<h2>From NONE to Department</h2>
<%
    for(Teacher entry: ndsc){
%>
<div>
    <tr>
        <td colspan=2>
            <button onclick="window.location.href='<%out.print("ManageTeacherCredentials.jsp?step=2&action=" + request.getParameter("action") + "&ID=" + entry.getID()+ "&chairID=" + areaID);%>' " class="itemButton" >
                <h1><%out.print(entry.getOffice() + " " +entry.getSecondName() + " " + entry.getName());%></h1> </button>
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
    <input type="hidden"  name="tableNameParameter" value="teacher">
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
    <input type="hidden"  name="tableNameParameter" value="teacher">
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
    ArrayList<Teacher> i = d.getDateTeacher("SELECT nameOfDiscipline, courseNumber,semesterNumber,countOfLessons," +
            "countOfPraktice,exam, ID FROM discipline WHERE id=" + request.getParameter("ID"));
%>
<table>
    <tr class = "textInputLabel">
        <td>Name Of Discipline:</td>
        <td>
            <%//out.print(i.get(0).getNameOfDiscipline());%>
        </td>
    </tr>
    <tr class = "textInputLabel">
        <td>Cource Number:</td>
        <td>
            <%//out.print(i.get(0).getCourseNumber());%>
        </td>
    </tr>
    <tr class = "textInputLabel">
        <td>Semester Number:</td>
        <td>
            <%//out.print(i.get(0).getSemesterNumber());%>
        </td>
    </tr>
    <tr class = "textInputLabel">
        <td>Count Of Lessons:</td>
        <td>
            <%//out.print(i.get(0).getCountOfLessons());%>
        </td>
    </tr>
    <tr class = "textInputLabel">
        <td>Count Of Praktice:</td>
        <td>
            <%//out.print(i.get(0).getCountOfPraktice());%>
        </td>
    </tr>
    <tr class = "textInputLabel">
        <td>Exam:</td>
        <td>
            <%//out.print(i.get(0).isExam()?"Yes":"No");%>
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
