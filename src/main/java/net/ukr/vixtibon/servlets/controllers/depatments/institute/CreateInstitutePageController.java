package net.ukr.vixtibon.servlets.controllers.depatments.institute;

import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.departments.DAOInstitute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 08/11/2016.
 */
public class CreateInstitutePageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("fillForm")){
            if(request.getParameter("fillForm").equals("yes")){
                DAOInstitute d = new DAOInstitute();
                Institute i = new Institute();
                boolean result = false;
                i.setLongName(request.getParameter("longName"));
                i.setShortName(request.getParameter("shortName"));
                result = d.create(i);
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "institute");
                }else{
                    request.setAttribute("menu", "institute");
                    request.setAttribute("result", "unsuccess");
                }
                d.closeConnection();
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }else if(request.getParameter("fillForm").equals("cancel")){
                request.getRequestDispatcher("InstitutePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            request.getRequestDispatcher("Admin/Institute/Operations/CreateInstitutePage.jsp").forward(request, response);
        }
    }
}
