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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by alex on 12/12/2016.
 */
public class CreateEmployeePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                request.setAttribute("selected", "yes");
                request.setAttribute("departmentID", request.getParameter("departmentID"));
                request.getRequestDispatcher("Admin/Employee/Operations/CreateEmployeePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                DAOEmployee daoe = new DAOEmployee();
                Employee em = new Employee();
                boolean result = false;
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
                try {
                    result = daoe.create(em);
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
            ArrayList<Institute> i = daoi.getAllWithFacultiesAndDepartments();
            for(Institute institute:i){
                ArrayList<Faculty> f = daof.getAllByInstituteID(institute.getID());
                for(Faculty faculty:f){
                    ArrayList<Department> d = daod.getAllByfacultyID(faculty.getID());
                    faculty.setDepartments(d);
                }
                institute.setFacultys(f);
            }
            request.setAttribute("institutesList", i);
            request.getRequestDispatcher("Admin/Employee/Operations/CreateEmployeePage.jsp").forward(request, response);
        }
    }
}
