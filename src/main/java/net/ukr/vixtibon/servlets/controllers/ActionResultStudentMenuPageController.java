package net.ukr.vixtibon.servlets.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActionResultStudentMenuPageController extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("redirectTo")){
            if(request.getParameter("redirectTo").equals("attendance")){
                request.getRequestDispatcher("/Student/StudentMenuPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("progress")){
                request.getRequestDispatcher("/Student/StudentMenuPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("timetable")){
                request.getRequestDispatcher("/Student/StudentMenuPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("")){
                request.getRequestDispatcher("/Student/StudentMenuPageController").forward(request, response);
            }else {
                //error page
            }

        }else{
            request.setAttribute("result", request.getAttribute("result"));
            request.setAttribute("menu", request.getAttribute("menu"));
            request.getRequestDispatcher("StudentActionResultPage.jsp").forward(request, response);
        }
    }
}
