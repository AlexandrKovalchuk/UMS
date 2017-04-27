package net.ukr.vixtibon.servlets.controllers.depatments.department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepartmentPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("operationType")){
            if(request.getParameter("operationType").equals("create")){
                request.getRequestDispatcher("/Admin/CreateDepartmentPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("update")){
                request.getRequestDispatcher("/Admin/UpdateDepartmentPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("delete")){
                request.getRequestDispatcher("/Admin/DeleteDepartmentPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("move")){
                request.getRequestDispatcher("/Admin/MoveDepartmentPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("showInfo")){
                request.getRequestDispatcher("/Admin/ShowInfoDepartmentPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("cancel")){
                request.getRequestDispatcher("/Admin/AdminPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "admin");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Department/DepartmentPage.jsp").forward(request, response);
        }
    }
}
