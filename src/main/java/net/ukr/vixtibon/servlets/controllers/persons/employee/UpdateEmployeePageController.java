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

/**
 * Created by alex on 12/12/2016.
 */
public class UpdateEmployeePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                DAOEmployee daoe = new DAOEmployee();
                Employee employee = daoe.getEntityById(Integer.parseInt(request.getParameter("employeeID")));
                request.setAttribute("selected", "yes");
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("Admin/Employee/Operations/UpdateEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                DAOEmployee daoe = new DAOEmployee();
                boolean result = false;
                Employee em = new Employee();
                em.setName(request.getParameter("name"));
                em.setlastName(request.getParameter("lastName"));
                em.setfathersName(request.getParameter("fathersName"));
                em.setPersonalID(request.getParameter("personalID"));
                em.setSex(request.getParameter("sex"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
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
                result = daoe.update(em);
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "department");
                }else{
                    request.setAttribute("menu", "department");
                    request.setAttribute("result", "unsuccess");
                }
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
            request.getRequestDispatcher("Admin/Employee/Operations/UpdateEmployeePage.jsp").forward(request, response);
        }
    }
}
