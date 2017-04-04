package net.ukr.vixtibon.servlets.controllers.study_process.students;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 29/03/2017.
 */
public class StudentMenuPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("operationType")){
            if(request.getParameter("operationType").equals("attendance")){
                request.getRequestDispatcher("ShowAttendancePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("progress")){
                request.getRequestDispatcher("ShowProgressPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("timeTable")){
                request.getRequestDispatcher("ShowTimetablePageController").forward(request, response);
            }else{
                request.setAttribute("result", "wrongParameter");
                request.getRequestDispatcher("ActionResultStudentMenuPageController").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Student/StudentPage.jsp").forward(request, response);
        }
    }
}
