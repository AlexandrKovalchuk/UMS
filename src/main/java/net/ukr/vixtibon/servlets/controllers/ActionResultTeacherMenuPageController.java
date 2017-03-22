package net.ukr.vixtibon.servlets.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 20/03/2017.
 */
public class ActionResultTeacherMenuPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("redirectTo")){
            if(request.getParameter("redirectTo").equals("institute")){
                request.getRequestDispatcher("TeacherMenuPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("faculty")){
                request.getRequestDispatcher("TeacherMenuPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("admin")){
                request.getRequestDispatcher("TeacherMenuPageController").forward(request, response);
            }else {
                //error page
            }

        }else{
            request.setAttribute("result", request.getAttribute("result"));
            request.setAttribute("menu", request.getAttribute("menu"));
            request.getRequestDispatcher("Teacher/TeacherActionResultPage.jsp").forward(request, response);
        }
    }
}
