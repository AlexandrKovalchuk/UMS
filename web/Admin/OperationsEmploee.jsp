<%@ page import="servlets.SessionsList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.ukr.vixtibon.*" %>
<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 23:47
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
    <title>Create Emploee Credentials</title>
    <%
    }else if(request.getParameter("action").equals("update")){
    %>
    <title>Update Emploee Credentials</title>
    <%
    }else if(request.getParameter("action").equals("move")){
    %>
    <title>Move Emploee</title>
    <%
    }else if(request.getParameter("action").equals("delete")){
    %>
    <title>Delete Emploee Credentials</title>
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
        Emploee Credentials Page!
        <br />
        Please choose action:
    </h5>
</div>
<br />
<div class = "pageTitleText">
<%
    if(request.getParameter("action").equals("create")){
%>
<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <table>
        <input type="hidden"  name="tableNameParameter" value="employee">
        <input type="hidden"  name="operation" value="create">
        <input type="hidden"  name="chairID" value=<%out.print(request.getParameter("ID"));%>>
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


        <tr class = "textInputLabel">
            <td colspan=2>
                <button onclick="submit"  class="controlButton"><h2>Add</h2></button>
            </td>
        </tr>
    </table>
</form>

<%
}else if(request.getParameter("action").equals("update")){
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Employee> f = d.getDateEmployee("SELECT name, lastName, fathersName, personalID, sex, email, phoneNumber" +
            ", dateOfBorn, address, pasport, login, office, ID, chairID FROM employee WHERE ID =" + request.getParameter("ID"));
%>
<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <table>
        <input type="hidden"  name="tableNameParameter" value="employee">
        <input type="hidden"  name="operation" value="update">
        <input type="hidden"  name="ID" value=<%out.print(request.getParameter("ID"));%>>
        <tr class = "textInputLabel">
        <tr class = "textInputLabel">
            <td>Ім'я:</td>
            <td>
                <input type="text" name="name" value=<%out.print(f.get(0).getName());%>>
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Прізвище:</td>
            <td>
                <input type="text" name="lastName" value=<%out.print(f.get(0).getSecondName());%>>
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>По Батькові:</td>
            <td>
                <input type="text" name="fathersName" value=<%out.print(f.get(0).getSurname());%>>
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Ідентифікаційний код:</td>
            <td>
                <input type="text" name="personalID" value=<%out.print(f.get(0).getPersonalID());%>>
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Стать:</td>
            <td>
                <input type="radio" name="sex" value="m" <%out.print(f.get(0).getSex().equals("m")?"checked":"");%>>Чоловіча<br>
                <input type="radio" name="sex" value="f" <%out.print(f.get(0).getSex().equals("f")?"checked":"");%>>Жіноча
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Пошта:</td>
            <td>
                <input type="text" name="email" value=<%out.print(f.get(0).getEmail());%>>
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Телефон:</td>
            <td>
                <input type="text" name="phoneNumber" value=<%out.print(f.get(0).getPhoneNumber());%>>
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Дата народження:</td>
        </tr>
        <tr class = "textInputLabel">
            <td>День</td>
            <td>
                <input type="int" name="bday" value=<%out.print(f.get(0).getDateOfBorn().get(Calendar.DAY_OF_MONTH));%>>
            </td>
            <td>   Місяць</td>
            <td>
                <input type="text" name="bmonth" value=<%out.print(f.get(0).getDateOfBorn().get(Calendar.MONTH));%>>
            </td>
            <td>   Рік</td>
            <td>
                <input type="int" name="byear" value=<%out.print(f.get(0).getDateOfBorn().get(Calendar.YEAR));%>>
            </td>

        </tr>
        <tr class = "textInputLabel">
            <td>Адресса:</td>
        </tr>
        <tr class = "textInputLabel">
            <td>
                <input type="text" name="address" value=<%out.print(f.get(0).getAddress());%>>
            </td>
        </tr>
        <tr class = "textInputLabel">
            <td>Паспортні данні:</td>
        </tr>
        <tr class = "textInputLabel">
            <td>
                <input type="text" name="pasport" value=<%out.print(f.get(0).getAddress());%>>
            </td>
        </tr>

        <tr class = "textInputLabel">
            <td>Посада:</td>
            <td>
                <input type="text" name="office" value=<%out.print(f.get(0).getOffice());%>>
            </td>
        </tr>


        <tr class = "textInputLabel">
            <td colspan=2>
                <button onclick="submit"  class="controlButton"><h2>Add</h2></button>
            </td>
        </tr>
    </table>
</form>

<%
}else if(request.getParameter("action").equals("move")){
    if(request.getParameter("selection").equals("no")){
        DataBaseDriver d = new DataBaseDriver();
        ArrayList<Institute> IobjList = d.getDateInstitute("SELECT longName, shortName, ID FROM institute");
        ArrayList<Faculty> FobjList = d.getDateFaculty("SELECT longName, shortName, ID, instituteID FROM faculty");
        ArrayList<Chair> CobjList = d.getDateChair("SELECT longName, shortName, ID, facultyID FROM chair");
        for(Institute i: IobjList){
            %><h1><%out.print(i.getLongName());%></h1><%
            for(Faculty f: FobjList){
                if(f.getInstituteID() == i.getID()){
                %><h1><%out.print(f.getLongName());%></h1><%
                    for(Chair c: CobjList){
                        if(c.getFacultyID() == f.getID()){
                            %><div><tr><td colspan=2>
                                <button onclick="window.location.href='<%out.print("OperationsEmploee.jsp?action=move&selection=yes&ID="+ request.getParameter("ID")
                                +"&chairID=" + c.getID());%>' " class="itemButton" ><h1><%out.print(c.getLongName());%></h1> </button></td></tr><br/></div><%
                        }
                    }
                }
            }
        }
%><td colspan=2>
    <button onclick="window.location.href='<%out.print("OperationsEmploee.jsp?action=move&selection=yes&ID="+ request.getParameter("ID")
                +"&chairID=0");%>' " class="itemButton" ><h1>None</h1> </button></td></tr><%
}else if(request.getParameter("selection").equals("yes")){
%>
<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <input type="hidden"  name="operation" value="move">
    <input type="hidden"  name="tableNameParameter" value="employee">
    <input type="hidden"  name="chairID" value=<%out.print(request.getParameter("chairID"));%>>
    <input type="hidden"  name="id" value=<%out.print(request.getParameter("ID"));%>>
    <div>
        <h2>Would you like to continue?</h2>
        <tr><td >
            <button onclick="submit"  class="controlButton"><h2>Yes</h2></button></td><td >
            <button onclick="window.location.href='AdminPage.jsp'"  class="controlButton"><h2>No</h2></button>
        </td></tr>
    </div>
</form>
<%
    }
}else if(request.getParameter("action").equals("delete")){
    DataBaseDriver d = new DataBaseDriver();
    ArrayList<Employee> employees = d.getDateEmployee("SELECT name, lastName, ID FROM employee WHERE ID='" +request.getParameter("ID") + "'");
%>
<form action="/FormReaderServlet" method="post" accept-charset="UTF-8">
    <input type="hidden"  name="operation" value="delete">
    <input type="hidden"  name="tableNameParameter" value="employee">
    <input type="hidden"  name="id" value=<%out.print(employees.get(0).getID());%>>

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
