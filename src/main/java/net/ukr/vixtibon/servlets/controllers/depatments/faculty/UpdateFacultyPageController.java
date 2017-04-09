package net.ukr.vixtibon.servlets.controllers.depatments.faculty;

import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.departments.DAOFaculty;
import net.ukr.vixtibon.dao.departments.DAOInstitute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateFacultyPageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAOFaculty daof = new DAOFaculty();
            if(request.getParameter("step").equals("step1")){
                ArrayList<Faculty> f = daof.getAllByInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("facultiesList", f);
                request.setAttribute("step", "step1");
                request.getRequestDispatcher("Admin/Faculty/Operations/UpdateFacultyPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                Faculty faculty = daof.getEntityById(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("step", "step2");
                request.setAttribute("faculty", faculty);
                request.getRequestDispatcher("Admin/Faculty/Operations/UpdateFacultyPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                Faculty faculty = new Faculty();
                faculty.setID(Integer.parseInt(request.getParameter("facultyID")));
                faculty.setLongName(request.getParameter("longName"));
                faculty.setShortName(request.getParameter("shortName"));
                boolean result = daof.update(faculty);
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "faculty");
                }else{
                    request.setAttribute("menu", "faculty");
                    request.setAttribute("result", "unsuccess");
                }
                daof.closeConnection();
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("FacultyPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "faculty");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("step", "step0");
            request.getRequestDispatcher("Admin/Faculty/Operations/UpdateFacultyPage.jsp").forward(request, response);
        }
    }
}
