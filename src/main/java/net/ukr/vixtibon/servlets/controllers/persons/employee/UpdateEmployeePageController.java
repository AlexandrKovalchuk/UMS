package net.ukr.vixtibon.servlets.controllers.persons.employee;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.base_objects.persons.Employee;
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
 * Created by alex on 12/12/2016.
 */
public class UpdateEmployeePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                DAODepartment daoi = new DAODepartment();
                Department department = daoi.getEntityById(Integer.parseInt(request.getParameter("departmentID")));
                request.setAttribute("selected", "yes");
                request.setAttribute("department", department);
                request.getRequestDispatcher("Admin/Department/Operations/UpdateDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                DAODepartment daoi = new DAODepartment();
                boolean result = false;
                Department department = new Department();
                department.setID(Integer.parseInt(request.getParameter("departmentID")));
                department.setLongName(request.getParameter("longName"));
                department.setShortName(request.getParameter("shortName"));
                result = daoi.update(department);
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "department");
                }else{
                    request.setAttribute("menu", "department");
                    request.setAttribute("result", "unsuccess");
                }
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
            DAOEmployee daoe = new DAOEmployee();
            ArrayList<Institute> i = daoi.getAllWithFacultiesAndDepartments();
            for(Institute institute:i){
                ArrayList<Faculty> f = daof.getAllByInstituteID(institute.getID());
                for(Faculty faculty:f){
                    ArrayList<Department> d = daod.getAllByfacultyID(faculty.getID());
                    for(Department department: d){
                        ArrayList<Employee> e = daoe.getAllByDepartmentID(department.getID());
                        department.setEmployees(e);
                    }
                    faculty.setDepartments(d);
                }
                institute.setFacultys(f);
            }
            request.setAttribute("institutesList", i);
            request.setAttribute("selected", "no");
            request.getRequestDispatcher("Admin/Department/Operations/UpdateDepartmentPage.jsp").forward(request, response);
        }
    }
}
