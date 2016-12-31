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

/**
 * Created by alex on 29/11/2016.
 */
public class MoveFacultyPageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAOInstitute daoi = new DAOInstitute();
            DAOFaculty daof = new DAOFaculty();
            if(request.getParameter("step").equals("step1")){
                ArrayList<Institute> i = daoi.getAll();
                Faculty faculty = daof.getEntityById(Integer.parseInt(request.getParameter("facultyID")));
                daof.closeConnection();
                daoi.closeConnection();
                request.setAttribute("selected", "yes");
                request.setAttribute("institutesList", i);
                request.setAttribute("faculty", faculty);
                request.getRequestDispatcher("Admin/Faculty/Operations/MoveFacultyPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                Institute institute = daoi.getEntityById(Integer.parseInt(request.getParameter("instituteID")));
                Faculty faculty = daof.getEntityById(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("selected", "yes2");
                request.setAttribute("institute", institute);
                request.setAttribute("faculty", faculty);
                request.getRequestDispatcher("Admin/Faculty/Operations/MoveFacultyPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                boolean result = false;
                result = daof.updateFacultyLocation(Integer.parseInt(request.getParameter("instituteID")),Integer.parseInt(request.getParameter("facultyID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "faculty");
                }else{
                    request.setAttribute("menu", "faculty");
                    request.setAttribute("result", "unsuccess");
                }
                daof.closeConnection();
                daoi.closeConnection();
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("FacultyPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            DAOFaculty daof = new DAOFaculty();
            ArrayList<Institute> i = daoi.getAll();
            for(Institute institute:i){
                ArrayList<Faculty> f = daof.getAllByInstituteID(institute.getID());
                institute.setFacultys(f);
            }
            daof.closeConnection();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("selected", "no");
            request.getRequestDispatcher("Admin/Faculty/Operations/MoveFacultyPage.jsp").forward(request, response);
        }
    }
}
