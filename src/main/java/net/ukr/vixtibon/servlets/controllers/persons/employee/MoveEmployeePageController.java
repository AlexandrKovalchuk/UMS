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

public class MoveEmployeePageController   extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOInstitute daoi = new DAOInstitute();
        DAOFaculty daof = new DAOFaculty();
        DAODepartment daod = new DAODepartment();
        DAOEmployee daoe = new DAOEmployee();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                ArrayList<Faculty> f = daof.getAllByInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("facultiesList", f);
                request.setAttribute("step", "step1");
                request.getRequestDispatcher("Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                ArrayList<Department> departments = daod.getAllByfacultyID(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("step", "step2");
                request.setAttribute("departmentsList", departments);
                request.getRequestDispatcher("Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                ArrayList<Employee> employees = daoe.getAllByDepartmentID(Integer.parseInt(request.getParameter("departmentID")));
                request.setAttribute("step", "step3");
                request.setAttribute("employeesList", employees);
                request.getRequestDispatcher("Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step4")){
                ArrayList<Institute> i = daoi.getAll();
                request.setAttribute("institutesList", i);
                request.setAttribute("employeeID", Integer.parseInt(request.getParameter("employeeID")));
                request.setAttribute("step", "step4");
                request.getRequestDispatcher("Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step5")){
                ArrayList<Faculty> faculties = daof.getAllByInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("facultiesList", faculties);
                request.setAttribute("employeeID", Integer.parseInt(request.getParameter("employeeID")));
                request.setAttribute("step", "step5");
                request.getRequestDispatcher("Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step6")){
                ArrayList<Department> departments = daod.getAllByfacultyID(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("departmentsList", departments);
                request.setAttribute("employeeID", Integer.parseInt(request.getParameter("employeeID")));
                request.setAttribute("step", "step6");
                request.getRequestDispatcher("Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step7")){
                Department department = daod.getEntityById(Integer.parseInt(request.getParameter("departmentID")));
                Employee employee = daoe.getEntityById(Integer.parseInt(request.getParameter("employeeID")));
                request.setAttribute("department", department);
                request.setAttribute("employee", employee);
                request.setAttribute("step", "step7");
                request.getRequestDispatcher("Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step8")){
                boolean result = daoe.updateEmployeeLocation(Integer.parseInt(request.getParameter("departmentID")),Integer.parseInt(request.getParameter("employeeID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "employee");
                }else{
                    request.setAttribute("menu", "employee");
                    request.setAttribute("result", "unsuccess");
                }
                daod.closeConnection();
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("/Admin/EmployeePageController").forward(request, response);
            }else{
                request.setAttribute("menu", "employee");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }
        }else{
            ArrayList<Institute> i = daoi.getAll();
            request.setAttribute("institutesList", i);
            request.setAttribute("step", "step0");
            request.getRequestDispatcher("Employee/Operations/MoveEmployeePage.jsp").forward(request, response);
        }
        daoe.closeConnection();
        daod.closeConnection();
        daof.closeConnection();
        daoi.closeConnection();
    }
}
