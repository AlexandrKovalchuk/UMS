package net.ukr.vixtibon.servlets.controllers.depatments.institute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InstitutePageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("operationType")){
            if(request.getParameter("operationType").equals("create")){
                request.getRequestDispatcher("CreateInstitutePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("update")){
                request.getRequestDispatcher("UpdateInstitutePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("delete")){
                request.getRequestDispatcher("DeleteInstitutePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("showInfo")){
                request.getRequestDispatcher("ShowInstituteInfoPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("cancel")){
                request.getRequestDispatcher("AdminPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "admin");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Admin/Institute/InstitutePage.jsp").forward(request, response);
        }
    }
}
