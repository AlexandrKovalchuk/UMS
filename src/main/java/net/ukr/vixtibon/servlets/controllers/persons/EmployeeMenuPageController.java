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
                request.getRequestDispatcher("DisciplinePageController").forward(request, response);
            } else if (request.getParameter("elementType").equals("group")) {
                request.getRequestDispatcher("GroupPageController").forward(request, response);
            } else if (request.getParameter("elementType").equals("teacher")) {
                request.getRequestDispatcher("TeacherPageController").forward(request, response);
            } else if (request.getParameter("elementType").equals("student")) {
                request.getRequestDispatcher("StudentPageController").forward(request, response);
            } else if (request.getParameter("elementType").equals("timetable")) {
                request.getRequestDispatcher("TimetablePageController").forward(request, response);
            } else if (request.getParameter("elementType").equals("dayRequirements")) {
                request.getRequestDispatcher("DayRequirementsPageController").forward(request, response);
            } else {
                request.setAttribute("menu", "employee");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("ActionResultEmployeeMenuPageController").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("Employee/EmployeePage.jsp").forward(request, response);
        }
    }
}
