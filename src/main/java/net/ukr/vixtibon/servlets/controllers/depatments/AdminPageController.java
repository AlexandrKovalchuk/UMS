package net.ukr.vixtibon.servlets.controllers.depatments;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 08/11/2016.
 */
public class AdminPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("elementType")){
            if(request.getParameter("elementType").equals("institute")){
                request.getRequestDispatcher("InstitutePageController").forward(request, response);
            }else if(request.getParameter("elementType").equals("faculty")){
                request.getRequestDispatcher("FacultyPageController").forward(request, response);
            }else if(request.getParameter("elementType").equals("department")){
                request.getRequestDispatcher("DepartmentPageController").forward(request, response);
            }else if(request.getParameter("elementType").equals("employee")){
                request.getRequestDispatcher("EmployeePageController").forward(request, response);
            }else if(request.getParameter("elementType").equals("mainInfo")){
                request.getRequestDispatcher("MainInfoPageController").forward(request, response);
            }else if(request.getParameter("elementType").equals("generateBaseDate")){
                request.getRequestDispatcher("GenerateBaseDateController").forward(request, response);
            }else if(request.getParameter("elementType").equals("clearAllDate")){
                request.getRequestDispatcher("ClearAllDateController").forward(request, response);
            }else{
                //error page
            }
        }else{
            request.getRequestDispatcher("Admin/AdminPage.jsp").forward(request, response);
        }
    }
}
