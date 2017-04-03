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
            DAOFaculty daof = new DAOFaculty();
            DAODepartment daod = new DAODepartment();
            if(request.getParameter("step").equals("step1")){
                ArrayList<Faculty> f = daof.getAllByInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("facultiesList", f);
                request.setAttribute("step", "step1");
                request.getRequestDispatcher("Admin/Department/Operations/CreateDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                Faculty faculty = daof.getEntityById(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("step", "step2");
                request.setAttribute("faculty", faculty);
                request.getRequestDispatcher("Admin/Department/Operations/CreateDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
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
            daod.closeConnection();
            daof.closeConnection();
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("step", "step0");
            request.getRequestDispatcher("Admin/Department/Operations/CreateDepartmentPage.jsp").forward(request, response);
        }
    }

}
