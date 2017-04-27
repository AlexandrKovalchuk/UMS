package net.ukr.vixtibon.servlets.controllers.depatments.institute;

import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.departments.DAOInstitute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateInstitutePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAOInstitute daoi = new DAOInstitute();
            if(request.getParameter("step").equals("step1")){
                Institute institute = daoi.getEntityById(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("selected", "yes");
                request.setAttribute("institute", institute);
                request.getRequestDispatcher("Institute/Operations/UpdateInstitutePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                boolean result;
                Institute institute = new Institute();
                institute.setID(Integer.parseInt(request.getParameter("instituteID")));
                institute.setLongName(request.getParameter("longName"));
                institute.setShortName(request.getParameter("shortName"));
                result = daoi.update(institute);
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "institute");
                }else{
                    request.setAttribute("menu", "institute");
                    request.setAttribute("result", "unsuccess");
                }
                daoi.closeConnection();
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("/Admin/InstitutePageController").forward(request, response);
            }else{
                request.setAttribute("menu", "institute");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.getRequestDispatcher("Institute/Operations/UpdateInstitutePage.jsp").forward(request, response);
        }
    }
}
