package net.ukr.vixtibon.servlets.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActionResultEmployeeMenuPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("redirectTo")){
            if(request.getParameter("redirectTo").equals("discipline")){
                request.getRequestDispatcher("DisciplinePageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("group")){
                request.getRequestDispatcher("GroupPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("teacher")){
                request.getRequestDispatcher("TeacherPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("student")){
                request.getRequestDispatcher("StudentPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("timetable")){
                request.getRequestDispatcher("TimetablePageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("dayRequirements")) {
                request.getRequestDispatcher("EmployeeMenuPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("employee")) {
                request.getRequestDispatcher("EmployeeMenuPageController").forward(request, response);
            }else {
                request.getRequestDispatcher("EmployeeMenuPageController").forward(request, response);
            }

        }else{
            request.setAttribute("result", request.getAttribute("result"));
            request.setAttribute("menu", request.getAttribute("menu"));
            request.getRequestDispatcher("Employee/EmployeeActionResultPage.jsp").forward(request, response);
        }
    }
}
