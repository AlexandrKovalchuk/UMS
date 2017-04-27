package net.ukr.vixtibon.servlets.controllers.persons;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeMenuPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("elementType")) {
            if (request.getParameter("elementType").equals("discipline")) {
                request.getRequestDispatcher("/Employee/DisciplinePageController").forward(request, response);
            } else if (request.getParameter("elementType").equals("group")) {
                request.getRequestDispatcher("/Employee/GroupPageController").forward(request, response);
            } else if (request.getParameter("elementType").equals("teacher")) {
                request.getRequestDispatcher("/Employee/TeacherPageController").forward(request, response);
            } else if (request.getParameter("elementType").equals("student")) {
                request.getRequestDispatcher("/Employee/StudentPageController").forward(request, response);
            } else if (request.getParameter("elementType").equals("timetable")) {
                request.getRequestDispatcher("/Employee/TimetablePageController").forward(request, response);
            } else if (request.getParameter("elementType").equals("dayRequirements")) {
                request.getRequestDispatcher("/Employee/DayRequirementsPageController").forward(request, response);
            } else {
                request.setAttribute("menu", "employee");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Employee/ActionResultEmployeeMenuPageController").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("EmployeePage.jsp").forward(request, response);
        }
    }
}
