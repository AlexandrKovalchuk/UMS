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
public class DeleteEmployeePageController   extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAOEmployee daoe = new DAOEmployee();
            if(request.getParameter("step").equals("step1")){
                Employee employee = daoe.getEntityById(Integer.parseInt(request.getParameter("employeeID")));
                request.setAttribute("selected", "yes");
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("Admin/Employee/Operations/DeleteEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                boolean result = false;
                result = daoe.delete(Integer.parseInt(request.getParameter("employeeID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "employee");
                }else{
                    request.setAttribute("menu", "employee");
                    request.setAttribute("result", "unsuccess");
                }
                daoe.closeConnection();
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("EmployeePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            DAOFaculty daof = new DAOFaculty();
            DAODepartment daod = new DAODepartment();
            DAOEmployee daoe = new DAOEmployee();
            ArrayList<Institute> i = daoi.getAll();
            ArrayList<Institute> emptyI = new ArrayList<>();
            for(Institute institute: i){
                ArrayList<Faculty> f = daof.getAllByInstituteID(institute.getID());
                ArrayList<Faculty> emptyF = new ArrayList<>();
                for(Faculty faculty:f){
                    ArrayList<Department> d = daod.getAllByfacultyID(faculty.getID());
                    ArrayList<Department> emptyD = new ArrayList<>();
                    for(Department department: d){
                        ArrayList<Employee> e = daoe.getAllByDepartmentID(department.getID());
                        department.setEmployees(e);
                        if(department.getEmployees().size() == 0){
                            emptyD.add(department);
                        }
                    }
                    for(Department emptyDepartment: emptyD){
                        d.remove(emptyDepartment);
                    }
                    faculty.setDepartments(d);
                    if(faculty.getDepartments().size() == 0){
                        emptyF.add(faculty);
                    }
                }
                for(Faculty emptyFaculty: emptyF){
                    f.remove(emptyFaculty);
                }
                institute.setFacultys(f);
                if(institute.getFacultys().size() == 0){
                    emptyI.add(institute);
                }
            }
            for(Institute emptyInstitute: emptyI){
                    i.remove(emptyInstitute);
            }

            daoe.closeConnection();
            daod.closeConnection();
            daof.closeConnection();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("selected", "no");
            request.getRequestDispatcher("Admin/Employee/Operations/DeleteEmployeePage.jsp").forward(request, response);
        }
    }
}
