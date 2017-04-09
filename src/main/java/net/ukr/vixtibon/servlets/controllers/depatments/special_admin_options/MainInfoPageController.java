package net.ukr.vixtibon.servlets.controllers.depatments.special_admin_options;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainInfoPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("AdminPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "admin");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Admin/MainInfoPage.jsp").forward(request, response);
        }
    }
}
