package net.ukr.vixtibon.servlets.controllers.persons.student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 30/01/2017.
 */
public class StudentPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("operationType")){
            if(request.getParameter("operationType").equals("create")){
                request.getRequestDispatcher("CreateStudentPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("update")){
                request.getRequestDispatcher("UpdateStudentPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("delete")){
                request.getRequestDispatcher("DeleteStudentPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("move")){
                request.getRequestDispatcher("MoveStudentPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("showInfo")){
                request.getRequestDispatcher("ShowInfoStudentPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("cancel")){
                request.getRequestDispatcher("EmployeeMenuPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            request.getRequestDispatcher("Employee/Student/StudentPage.jsp").forward(request, response);
        }
    }
}
