package net.ukr.vixtibon.servlets.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActionResultEmployeeMenuPageController extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("redirectTo")){
            if(request.getParameter("redirectTo").equals("discipline")){
                request.getRequestDispatcher("/Employee/DisciplinePageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("group")){
                request.getRequestDispatcher("/Employee/GroupPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("teacher")){
                request.getRequestDispatcher("/Employee/TeacherPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("student")){
                request.getRequestDispatcher("/Employee/StudentPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("timetable")){
                request.getRequestDispatcher("/Employee/TimetablePageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("dayRequirements")) {
                request.getRequestDispatcher("/Employee/EmployeeMenuPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("employee")) {
                request.getRequestDispatcher("/Employee/EmployeeMenuPageController").forward(request, response);
            }else if (request.getParameter("redirectTo").equals("")) {
                request.getRequestDispatcher("/Employee/EmployeeMenuPageController").forward(request, response);
            }else {
                request.getRequestDispatcher("/Employee/EmployeeMenuPageController").forward(request, response);
            }

        }else{
            request.setAttribute("result", request.getAttribute("result"));
            request.setAttribute("menu", request.getAttribute("menu"));
            request.getRequestDispatcher("EmployeeActionResultPage.jsp").forward(request, response);
        }
    }
}
