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
public class CreateFacultyPageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                request.setAttribute("selected", "yes");
                request.setAttribute("instituteID", request.getParameter("instituteID"));
                request.getRequestDispatcher("Admin/Faculty/Operations/CreateFacultyPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                DAOFaculty d = new DAOFaculty();
                Faculty i = new Faculty();
                boolean result = false;
                i.setInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                i.setLongName(request.getParameter("longName"));
                i.setShortName(request.getParameter("shortName"));
                result = d.create(i);
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "faculty");
                }else{
                    request.setAttribute("menu", "faculty");
                    request.setAttribute("result", "unsuccess");
                }
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("FacultyPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            request.setAttribute("institutesList", i);
            request.getRequestDispatcher("Admin/Faculty/Operations/CreateFacultyPage.jsp").forward(request, response);
        }
    }
}
