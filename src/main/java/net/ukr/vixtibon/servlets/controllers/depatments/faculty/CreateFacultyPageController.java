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

/**
 * Created by alex on 29/11/2016.
 */
public class CreateFacultyPageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("fillForm")){
            if(request.getParameter("fillForm").equals("yes")){
                DAOFaculty d = new DAOFaculty();
                Faculty i = new Faculty();
                boolean result = false;
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
            }else if(request.getParameter("fillForm").equals("cancel")){
                request.getRequestDispatcher("FacultyPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            request.getRequestDispatcher("Admin/Faculty/Operations/CreateFacultyPage.jsp").forward(request, response);
        }
    }
}
