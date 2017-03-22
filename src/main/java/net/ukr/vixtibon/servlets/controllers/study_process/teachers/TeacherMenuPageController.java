package net.ukr.vixtibon.servlets.controllers.study_process.teachers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 20/03/2017.
 */
public class TeacherMenuPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("operationType")){
            System.out.println(request.getParameter("operationType"));
            if(request.getParameter("operationType").equals("attendance")){
                request.getRequestDispatcher("SetAttendancePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("progress")){
                request.getRequestDispatcher("SetProgressPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("timeTable")){
                request.getRequestDispatcher("ShowTimetablePageController").forward(request, response);
            }else{
                request.setAttribute("result", "wrongParameter");
                request.getRequestDispatcher("ActionResultTeacherMenuPageController").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Teacher/TeacherPage.jsp").forward(request, response);
        }
    }
}
