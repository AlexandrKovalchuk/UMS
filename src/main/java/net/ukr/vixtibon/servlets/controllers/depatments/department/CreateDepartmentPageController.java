package net.ukr.vixtibon.servlets.controllers.depatments.department;

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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alex on 05/12/2016.
 */
public class CreateDepartmentPageController   extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                request.setAttribute("selected", "yes");
                request.setAttribute("facultyID", request.getParameter("facultyID"));
                request.getRequestDispatcher("Admin/Department/Operations/CreateDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                DAODepartment d = new DAODepartment();
                Department i = new Department();
                boolean result = false;
                i.setFacultyID(Integer.parseInt(request.getParameter("facultyID")));
                i.setLongName(request.getParameter("longName"));
                i.setShortName(request.getParameter("shortName"));
                try {
                    result = d.create(i);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "department");
                }else{
                    request.setAttribute("menu", "department");
                    request.setAttribute("result", "unsuccess");
                }
                d.closeConnection();
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("DepartmentPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            DAOFaculty daof = new DAOFaculty();
            DAODepartment daod = new DAODepartment();
            ArrayList<Institute> i = daoi.getAllWithFacultiesAndDepartments();
            for(Institute institute:i){
                ArrayList<Faculty> f = daof.getAllByInstituteID(institute.getID());
                institute.setFacultys(f);
            }
            daod.closeConnection();
            daof.closeConnection();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("selected", "no");
            request.getRequestDispatcher("Admin/Department/Operations/CreateDepartmentPage.jsp").forward(request, response);
        }
    }

}
