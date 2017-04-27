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

public class ShowEmployeeInfoPageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAOFaculty daof = new DAOFaculty();
            DAODepartment daod = new DAODepartment();
            DAOEmployee daoe = new DAOEmployee();
            if(request.getParameter("step").equals("step1")){
                ArrayList<Faculty> f = daof.getAllByInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("facultiesList", f);
                request.setAttribute("step", "step1");
                request.getRequestDispatcher("Employee/Operations/ShowEmployeeInfoPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                ArrayList<Department> departments = daod.getAllByfacultyID(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("step", "step2");
                request.setAttribute("departmentsList", departments);
                request.getRequestDispatcher("Employee/Operations/ShowEmployeeInfoPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                ArrayList<Employee> employees = daoe.getAllByDepartmentID(Integer.parseInt(request.getParameter("departmentID")));
                request.setAttribute("step", "step3");
                request.setAttribute("employeesList", employees);
                request.getRequestDispatcher("Employee/Operations/ShowEmployeeInfoPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step4")){
                Employee employee = daoe.getEntityById(Integer.parseInt(request.getParameter("employeeID")));
                daoe.closeConnection();
                request.setAttribute("step", "step4");
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("Employee/Operations/ShowEmployeeInfoPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("/Admin/EmployeePageController").forward(request, response);
            }else{
                request.setAttribute("menu", "employee");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }
            daod.closeConnection();
            daof.closeConnection();
            daoe.closeConnection();
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("step", "step0");
            request.getRequestDispatcher("Employee/Operations/ShowEmployeeInfoPage.jsp").forward(request, response);
        }
    }
}
