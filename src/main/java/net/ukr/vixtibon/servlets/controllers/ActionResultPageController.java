package net.ukr.vixtibon.servlets.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActionResultPageController extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("redirectTo")){
            if(request.getParameter("redirectTo").equals("institute")){
                request.getRequestDispatcher("/Admin/InstitutePageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("faculty")){
                request.getRequestDispatcher("/Admin/FacultyPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("department")){
                request.getRequestDispatcher("/Admin/DepartmentPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("employee")){
                request.getRequestDispatcher("/Admin/EmployeePageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("admin")){
                request.getRequestDispatcher("/Admin/AdminPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("")){
                request.getRequestDispatcher("/Admin/AdminPageController").forward(request, response);
            }else {
                request.getRequestDispatcher("/Admin/AdminPageController").forward(request, response);
            }
        }else{
            request.setAttribute("result", request.getAttribute("result"));
            request.setAttribute("menu", request.getAttribute("menu"));
            request.getRequestDispatcher("AdminActionResultPage.jsp").forward(request, response);
        }
    }
}
