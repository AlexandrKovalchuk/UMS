package net.ukr.vixtibon.servlets.controllers.depatments.special_admin_options;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.departments.DAOFaculty;
import net.ukr.vixtibon.dao.departments.DAOInstitute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alex on 13/03/2017.
 */
public class MainInfoPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("AdminPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            request.getRequestDispatcher("Admin/MainInfoPage.jsp").forward(request, response);
        }
    }
}
