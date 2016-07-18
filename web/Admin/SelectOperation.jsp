<%@ page import="servlets.SessionsList" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 05/07/2016
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css\admin_styles.css">
<html>
<head>
    <%
        SessionsList sl = new SessionsList();
        Cookie[] cookies = request.getCookies();
        String result = sl.sessionControl(cookies,"admin");
        if(!result.equals("success")){
            response.sendRedirect(result);
        }
    %>
    <%
    if(request.getParameter("type").equals("institute")){
        %>
        <title>Manage University Credentials</title>
        <%
    }else if(request.getParameter("type").equals("faculty")){
        %>
        <title>Manage Faculty Credentials</title>
        <%
    }else if(request.getParameter("type").equals("chair")){
        %>
        <title>Manage Chair Credentials</title>
        <%
    }else if(request.getParameter("type").equals("emploee")){
        %>
        <title>Manage Employee Credentials</title>
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
        Welcome to Manage
        <%out.print(request.getParameter("type").equals("institute")?"University":"");%>
        <%out.print(request.getParameter("type").equals("faculty")?"Faculty":"");%>
        <%out.print(request.getParameter("type").equals("chair")?"Chair":"");%>
        <%out.print(request.getParameter("type").equals("emploee")?"Employee":"");%>
         Credentials Page!
        <br />
        Please choose action:
    </h5>
</div>
<br />
<div class="itemsBlock">
    <div>
    <%
    if(request.getParameter("type").equals("institute")){
    %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='OperationsInstitute.jsp?action=create'" class="topicButton" >
                                <h1>Create University Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=update&selectFrom=institute&step=1'" class="topicButton" >
                                <h1>Update University Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=delete&selectFrom=institute&step=1'" class="topicButton" >
                                <h1>Delete University Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
    <%
    }else if(request.getParameter("type").equals("faculty")){
    %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=create&selectFrom=institute&step=1'" class="topicButton" >
                                <h1>Create Faculty Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=update&selectFrom=institute&step=2'" class="topicButton" >
                                <h1>Update Faculty Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=delete&selectFrom=institute&step=2'" class="topicButton" >
                                <h1>Delete Faculty Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
    <%
    }else if(request.getParameter("type").equals("chair")){
    %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=create&selectFrom=institute&step=2'" class="topicButton" >
                                <h1>Create Chair Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=update&selectFrom=institute&step=3'" class="topicButton" >
                                <h1>Update Chair Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=delete&selectFrom=institute&step=3'" class="topicButton" >
                                <h1>Delete Chair Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
    <%
    }else if(request.getParameter("type").equals("emploee")){
    %>
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=create&selectFrom=institute&step=3'" class="topicButton" >
                                <h1>Create Employee Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=update&selectFrom=institute&step=4'" class="topicButton" >
                                <h1>Update Employee Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
                <div>
                    <tr>
                        <td colspan=2>
                            <button onclick="window.location.href='Selector.jsp?action=delete&selectFrom=institute&step=4'" class="topicButton" >
                                <h1>Delete Employee Credentials</h1>
                            </button>
                        </td>
                    </tr>
                </div>
                <br />
    <%
    }else{
%>
<title>Warning</title>
<%
    }
%>
</div>
</div>
</body>
</html>
