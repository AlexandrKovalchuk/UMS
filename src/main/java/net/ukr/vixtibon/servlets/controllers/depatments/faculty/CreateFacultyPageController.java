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
                i.setInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                i.setLongName(request.getParameter("longName"));
                i.setShortName(request.getParameter("shortName"));
                boolean result = d.create(i);
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "faculty");
                }else{
                    request.setAttribute("menu", "faculty");
                    request.setAttribute("result", "unsuccess");
                }
                d.closeConnection();
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
            request.getRequestDispatcher("Admin/Faculty/Operations/CreateFacultyPage.jsp").forward(request, response);
        }
    }
}
