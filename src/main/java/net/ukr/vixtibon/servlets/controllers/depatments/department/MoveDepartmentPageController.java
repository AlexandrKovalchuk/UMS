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
import java.util.ArrayList;

/**
 * Created by alex on 12/12/2016.
 */
public class MoveDepartmentPageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                DAOInstitute daoi = new DAOInstitute();
                ArrayList<Institute> i = daoi.getAll();
                DAOFaculty daof = new DAOFaculty();
                for(Institute institute:i){
                    ArrayList<Faculty> f = daof.getAllByInstituteID(institute.getID());
                    institute.setFacultys(f);
                }
                DAODepartment daod = new DAODepartment();
                Department department = daod.getEntityById(Integer.parseInt(request.getParameter("departmentID")));
                request.setAttribute("selected", "yes");
                request.setAttribute("institutesList", i);
                request.setAttribute("department", department);
                request.getRequestDispatcher("Admin/Department/Operations/MoveDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                DAOFaculty daof = new DAOFaculty();
                DAODepartment daod = new DAODepartment();
                Department department = daod.getEntityById(Integer.parseInt(request.getParameter("departmentID")));
                Faculty faculty = daof.getEntityById(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("selected", "yes2");
                request.setAttribute("department", department);
                request.setAttribute("faculty", faculty);
                request.getRequestDispatcher("Admin/Department/Operations/MoveDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                DAODepartment daod = new DAODepartment();
                boolean result = false;
                result = daod.updateDepartmentLocation(Integer.parseInt(request.getParameter("facultyID")),Integer.parseInt(request.getParameter("departmentID")));
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
            request.setAttribute("selected", "no");
            request.getRequestDispatcher("Admin/Department/Operations/MoveDepartmentPage.jsp").forward(request, response);
        }
    }
}
