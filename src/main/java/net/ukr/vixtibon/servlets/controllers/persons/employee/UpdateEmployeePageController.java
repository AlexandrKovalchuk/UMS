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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UpdateEmployeePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAOFaculty daof = new DAOFaculty();
            DAODepartment daod = new DAODepartment();
            DAOEmployee daoe = new DAOEmployee();
            if(request.getParameter("step").equals("step1")){
                ArrayList<Faculty> f = daof.getAllByInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("facultiesList", f);
                request.setAttribute("step", "step1");
                request.getRequestDispatcher("Employee/Operations/UpdateEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                ArrayList<Department> departments = daod.getAllByfacultyID(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("step", "step2");
                request.setAttribute("departmentsList", departments);
                request.getRequestDispatcher("Employee/Operations/UpdateEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                ArrayList<Employee> employees = daoe.getAllByDepartmentID(Integer.parseInt(request.getParameter("departmentID")));
                request.setAttribute("step", "step3");
                request.setAttribute("employeesList", employees);
                request.getRequestDispatcher("Employee/Operations/UpdateEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step4")){
                Employee employee = daoe.getEntityById(Integer.parseInt(request.getParameter("employeeID")));
                request.setAttribute("step", "step4");
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("Employee/Operations/UpdateEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step5")){
                Employee em = new Employee();
                em.setID(Integer.parseInt(request.getParameter("employeeID")));
                em.setName(request.getParameter("name"));
                em.setlastName(request.getParameter("lastName"));
                em.setfathersName(request.getParameter("fathersName"));
                em.setPersonalID(request.getParameter("personalID"));
                em.setSex(request.getParameter("sex"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                String dateInString = ""+request.getParameter("bday")+"-"+request.getParameter("bmonth")+"-"+request.getParameter("byear")+" 10:20:56";
                Date date = new Date();
                try {
                    date = sdf.parse(dateInString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                em.setDateOfBorn(date);
                em.setEmail(request.getParameter("email"));
                em.setPhoneNumber(request.getParameter("phoneNumber"));
                em.setAddress(request.getParameter("address"));
                em.setPasport(request.getParameter("pasport"));
                em.setOffice(request.getParameter("office"));
                em.setLogin(request.getParameter("login"));
                em.setDepartmentID(Integer.parseInt(request.getParameter("departmentID")));
                boolean result = daoe.update(em);
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "employee");
                }else{
                    request.setAttribute("menu", "employee");
                    request.setAttribute("result", "unsuccess");
                }
                daod.closeConnection();
                daof.closeConnection();
                daoe.closeConnection();
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("/Admin/EmployeePageController").forward(request, response);
            }else{
                request.setAttribute("menu", "employee");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("step", "step0");
            request.getRequestDispatcher("Employee/Operations/UpdateEmployeePage.jsp").forward(request, response);
        }
    }
}
