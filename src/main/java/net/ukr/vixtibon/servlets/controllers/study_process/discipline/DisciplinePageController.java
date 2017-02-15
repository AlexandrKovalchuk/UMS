package net.ukr.vixtibon.servlets.controllers.study_process.discipline;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 30/01/2017.
 */
public class DisciplinePageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("operationType")){
            if(request.getParameter("operationType").equals("create")){
                request.getRequestDispatcher("CreateDisciplinePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("update")){
                request.getRequestDispatcher("UpdateDisciplinePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("delete")){
                request.getRequestDispatcher("DeleteDisciplinePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("setDependency")){
                request.getRequestDispatcher("SetDisciplineDepartmentDependencyPageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("showInfo")){
                request.getRequestDispatcher("ShowInfoDisciplinePageController").forward(request, response);
            }else if(request.getParameter("operationType").equals("cancel")){
                request.getRequestDispatcher("EmployeeMenuPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            request.getRequestDispatcher("Employee/Discipline/DisciplinePage.jsp").forward(request, response);
        }
    }
}
