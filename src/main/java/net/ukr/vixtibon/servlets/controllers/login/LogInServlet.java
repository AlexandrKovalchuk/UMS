package net.ukr.vixtibon.servlets.controllers.login;

import net.ukr.vixtibon.dao.login.DAOLogin;
import net.ukr.vixtibon.dao.persons.DAOEmployee;
import net.ukr.vixtibon.dao.persons.DAOStudent;
import net.ukr.vixtibon.dao.persons.DAOTeacher;
import net.ukr.vixtibon.login_body.LogInBody;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;

/**
 * Created by alex on 10/30/2015.
 */
public class LogInServlet extends HttpServlet {
    String username = null;
    String password = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        username = request.getParameter("username");
        password = request.getParameter("password");

        DAOLogin dl = new DAOLogin();
        LogInBody lib = dl.getEntityByLogIn(username);
        if(lib.getID()== -1){
            request.setAttribute("wrongPasswordOrLogIn", "absentInBase");
            request.getRequestDispatcher("LogIn.jsp").forward(request, response);
        }else {
            if(password.equals(lib.getPassword())){
                HttpSession session=request.getSession();
                session.setAttribute("username",username);
                session.setMaxInactiveInterval(30*60);
                if(lib.getAccess().equals("admin")){
                    session.setAttribute("type","admin");
                    request.getRequestDispatcher("Admin/AdminPage.jsp").forward(request, response);
                }else if(lib.getAccess().equals("employee")){
                    DAOEmployee daoEmployee = new DAOEmployee();
                    session.setAttribute("type","employee");
                    session.setAttribute("departmentID", daoEmployee.getDepartmentIDByUserID(lib.getAccessID()));
                    request.getRequestDispatcher("Employee/EmployeePage.jsp").forward(request, response);
                }else if(lib.getAccess().equals("teacher")){
                    DAOTeacher daoTeacher = new DAOTeacher();
                    session.setAttribute("type","teacher");
                    session.setAttribute("departmentID", daoTeacher.getDepartmentIDByUserID(lib.getAccessID()));
                    System.out.println("AccessID" + lib.getAccessID());
                    System.out.println("departmentID" + session.getAttribute("departmentID"));
                    session.setAttribute("teacherID",daoTeacher.getIDbyUserName(username));
                    request.getRequestDispatcher("Teacher/TeacherPage.jsp").forward(request, response);
                }else if(lib.getAccess().equals("student")){
                    DAOStudent daoStudent = new DAOStudent();
                    session.setAttribute("type","student");
                    session.setAttribute("departmentID", daoStudent.getDepartmentIDByUserID(lib.getAccessID()));
                    request.getRequestDispatcher("Student/StudentPage.jsp").forward(request, response);
                }else{
                    request.setAttribute("wrongPasswordOrLogIn", "errorInAccess");
                    request.getRequestDispatcher("LogIn.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("wrongPasswordOrLogIn", "wrongPassword");
                request.getRequestDispatcher("LogIn.jsp").forward(request, response);
            }

        }
        dl.returnConnectionInPool();
        dl.closeConnection();

    }

   public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {

          }

    }

