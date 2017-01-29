package net.ukr.vixtibon.servlets.controllers.depatments.department;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.departments.DAOFaculty;
import net.ukr.vixtibon.dao.departments.DAOInstitute;
import net.ukr.vixtibon.dao.persons.DAOEmployee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alex on 06/12/2016.
 */
public class DeleteDepartmentPageController   extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAODepartment daoi = new DAODepartment();
            DAOEmployee daoe = new DAOEmployee();
            if(request.getParameter("step").equals("step1")){
                Department department = daoi.getEntityById(Integer.parseInt(request.getParameter("departmentID")));
                department.setEmployees(daoe.getAllByDepartmentID(department.getID()));
                request.setAttribute("selected", "yes");
                if(department.getEmployees().size()>0){
                    request.setAttribute("possible_to_remove", "no");
                }else{
                    request.setAttribute("possible_to_remove", "yes");
                }
                request.setAttribute("department", department);
                request.getRequestDispatcher("Admin/Department/Operations/DeleteDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                boolean result = false;
                result = daoi.delete(Integer.parseInt(request.getParameter("departmentID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "department");
                }else{
                    request.setAttribute("menu", "department");
                    request.setAttribute("result", "unsuccess");
                }
                daoi.closeConnection();
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
            ArrayList<Institute> i = daoi.getAll();
            for(Institute institute:i){
                ArrayList<Faculty> f = daof.getAllByInstituteID(institute.getID());
                for(Faculty faculty:f){
                    ArrayList<Department> d = daod.getAllByfacultyID(faculty.getID());
                    faculty.setDepartments(d);
                }
                institute.setFacultys(f);
            }
            daod.closeConnection();
            daof.closeConnection();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("selected", "no");
            request.getRequestDispatcher("Admin/Department/Operations/DeleteDepartmentPage.jsp").forward(request, response);
        }
    }
}
