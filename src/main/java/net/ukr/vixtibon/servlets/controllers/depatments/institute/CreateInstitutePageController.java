package net.ukr.vixtibon.servlets.controllers.depatments.institute;

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
