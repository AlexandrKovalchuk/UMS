package net.ukr.vixtibon.servlets.controllers.depatments;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("elementType")){
            if(request.getParameter("elementType").equals("institute")){
                request.getRequestDispatcher("/Admin/InstitutePageController").forward(request, response);
            }else if(request.getParameter("elementType").equals("faculty")){
                request.getRequestDispatcher("/Admin/FacultyPageController").forward(request, response);
            }else if(request.getParameter("elementType").equals("department")){
                request.getRequestDispatcher("/Admin/DepartmentPageController").forward(request, response);
            }else if(request.getParameter("elementType").equals("employee")){
                request.getRequestDispatcher("/Admin/EmployeePageController").forward(request, response);
            }else if(request.getParameter("elementType").equals("mainInfo")){
                request.getRequestDispatcher("/Admin/MainInfoPageController").forward(request, response);
            }else if(request.getParameter("elementType").equals("generateBaseDate")){
                request.getRequestDispatcher("/Admin/GenerateBaseDateController").forward(request, response);
            }else if(request.getParameter("elementType").equals("clearAllDate")){
                request.getRequestDispatcher("/Admin/ClearAllDateController").forward(request, response);
            }else{
                request.setAttribute("menu", "admin");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
        }
    }
}
