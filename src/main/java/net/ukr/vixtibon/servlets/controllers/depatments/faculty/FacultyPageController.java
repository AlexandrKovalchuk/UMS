package net.ukr.vixtibon.servlets.controllers.depatments.faculty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FacultyPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("operationType")){
            if(request.getParameter("operationType").equals("create")){
                request.getRequestDispatcher("CreateFacultyPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("update")){
                request.getRequestDispatcher("UpdateFacultyPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("delete")){
                request.getRequestDispatcher("DeleteFacultyPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("move")){
                request.getRequestDispatcher("MoveFacultyPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("showInfo")){
                request.getRequestDispatcher("ShowInfoFacultyPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("cancel")){
                request.getRequestDispatcher("AdminPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "admin");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Admin/Faculty/FacultyPage.jsp").forward(request, response);
        }
    }
}
