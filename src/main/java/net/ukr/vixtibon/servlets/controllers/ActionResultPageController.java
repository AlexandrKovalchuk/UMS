package net.ukr.vixtibon.servlets.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 25/11/2016.
 */
public class ActionResultPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("redirectTo")){
            if(request.getParameter("redirectTo").equals("institute")){
                request.getRequestDispatcher("InstitutePageController").forward(request, response);
            }
        }else{
            request.setAttribute("result", request.getParameter("result"));
            request.setAttribute("menu", request.getParameter("menu"));
            request.getRequestDispatcher("LogIn.jsp").forward(request, response);
        }
    }
}
