package net.ukr.vixtibon.servlets.controllers.study_process.timetable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 30/01/2017.
 */
public class TimetablePageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("operationType")){
            if(request.getParameter("operationType").equals("create")){
                request.getRequestDispatcher("CreateTimetablePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("update")){
                request.getRequestDispatcher("UpdateTimetablePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("delete")){
                request.getRequestDispatcher("DeleteTimetablePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("move")){
                request.getRequestDispatcher("MoveTimetablePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("showInfo")){
                request.getRequestDispatcher("ShowInfoTimetablePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("cancel")){
                request.getRequestDispatcher("EmployeeMenuPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            request.getRequestDispatcher("Employee/Timetable/TimetablePage.jsp").forward(request, response);
        }
    }
}
