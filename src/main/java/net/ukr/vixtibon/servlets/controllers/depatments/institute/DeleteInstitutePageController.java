package net.ukr.vixtibon.servlets.controllers.depatments.institute;

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
 * Created by alex on 23/11/2016.
 */
public class DeleteInstitutePageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAOInstitute daoi = new DAOInstitute();
            DAOFaculty daod = new DAOFaculty();
            if(request.getParameter("step").equals("step1")){
                Institute institute = daoi.getEntityById(Integer.parseInt(request.getParameter("instituteID")));
                institute.setFacultys(daod.getAllByInstituteID(institute.getID()));
                request.setAttribute("selected", "yes");
                if(institute.getFacultys().size()>0){
                    request.setAttribute("possible_to_remove", "no");
                }else{
                    request.setAttribute("possible_to_remove", "yes");
                }
                request.setAttribute("institute", institute);
                request.getRequestDispatcher("Admin/Institute/Operations/DeleteInstitutePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                boolean result = false;
                result = daoi.delete(Integer.parseInt(request.getParameter("instituteID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "institute");
                }else{
                    request.setAttribute("menu", "institute");
                    request.setAttribute("result", "unsuccess");
                }
                daod.closeConnection();
                daoi.closeConnection();
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("InstitutePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.getRequestDispatcher("Admin/Institute/Operations/DeleteInstitutePage.jsp").forward(request, response);
        }
    }
}
