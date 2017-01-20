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
 * Created by alex on 20/12/2016.
 */
public class MoveEmployeePageController   extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOInstitute daoi = new DAOInstitute();
        DAOFaculty daof = new DAOFaculty();
        DAODepartment daod = new DAODepartment();
        DAOEmployee daoe = new DAOEmployee();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                ArrayList<Institute> i = daoi.getAll();
                for(Institute institute:i){
                    ArrayList<Faculty> f = daof.getAllByInstituteID(institute.getID());
                    for(Faculty faculty: f){
                        ArrayList<Department> d = daod.getAllByfacultyID(faculty.getID());
                        faculty.setDepartments(d);
                    }
                    institute.setFacultys(f);
                }
                Department department = daod.getEntityById(Integer.parseInt(request.getParameter("departmentID")));
                request.setAttribute("selected", "yes");
                request.setAttribute("institutesList", i);
                request.setAttribute("department", department);
                request.getRequestDispatcher("Admin/Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                Department department = daod.getEntityById(Integer.parseInt(request.getParameter("departmentID")));
                Faculty faculty = daof.getEntityById(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("selected", "yes2");
                request.setAttribute("department", department);
                request.setAttribute("faculty", faculty);
                request.getRequestDispatcher("Admin/Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                boolean result = false;
                result = daod.updateDepartmentLocation(Integer.parseInt(request.getParameter("facultyID")),Integer.parseInt(request.getParameter("departmentID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "department");
                }else{
                    request.setAttribute("menu", "department");
                    request.setAttribute("result", "unsuccess");
                }
                daod.closeConnection();
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("EmployeePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            ArrayList<Institute> i = daoi.getAll();
            for(Institute institute:i){
                ArrayList<Faculty> f = daof.getAllByInstituteID(institute.getID());
                for(Faculty faculty:f){
                    ArrayList<Department> d = daod.getAllByfacultyID(faculty.getID());
                    for(Department department: d){
                        ArrayList<Employee> e = daoe.getAllByDepartmentID(department.getID());
                        department.setEmployees(e);
                        if(department.getEmployees().size() == 0){
                            d.remove(department);
                        }
                    }
                    faculty.setDepartments(d);
                    if(faculty.getDepartments().size() == 0){
                        f.remove(faculty);
                    }
                }
                institute.setFacultys(f);
                if(institute.getFacultys().size() == 0){
                    i.remove(institute);
                }
            }
            request.setAttribute("institutesList", i);
            request.setAttribute("selected", "no");
            request.getRequestDispatcher("Admin/Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
        }
        daoe.closeConnection();
        daod.closeConnection();
        daof.closeConnection();
        daoi.closeConnection();
    }
}
