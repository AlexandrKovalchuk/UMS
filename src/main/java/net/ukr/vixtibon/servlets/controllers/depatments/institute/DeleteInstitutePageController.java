package net.ukr.vixtibon.servlets.controllers.depatments.institute;

import net.ukr.vixtibon.base_objects.departments.Institute;
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
            if(request.getParameter("step").equals("step1")){
                DAOInstitute daoi = new DAOInstitute();
                Institute institute = daoi.getEntityById(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("selected", "yes");
                request.setAttribute("institute", institute);
                request.getRequestDispatcher("Admin/Institute/Operations/DeleteInstitutePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                DAOInstitute daoi = new DAOInstitute();
                boolean result = false;
                result = daoi.delete(Integer.parseInt(request.getParameter("instituteID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "institute");
                }else{
                    request.setAttribute("menu", "institute");
                    request.setAttribute("result", "unsuccess");
                }
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("InstitutePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            System.out.println("i length " + i.size());
            request.setAttribute("institutesList", i);
            request.getRequestDispatcher("Admin/Institute/Operations/DeleteInstitutePage.jsp").forward(request, response);
        }
    }
}
