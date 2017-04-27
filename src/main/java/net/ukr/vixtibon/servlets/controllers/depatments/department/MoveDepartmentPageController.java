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

public class MoveDepartmentPageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAOFaculty daof = new DAOFaculty();
            DAODepartment daod = new DAODepartment();
            if(request.getParameter("step").equals("step1")){
                ArrayList<Faculty> f = daof.getAllByInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("facultiesList", f);
                request.setAttribute("step", "step1");
                request.getRequestDispatcher("Department/Operations/MoveDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                ArrayList<Department> departments = daod.getAllByfacultyID(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("step", "step2");
                request.setAttribute("departmentsList", departments);
                request.getRequestDispatcher("Department/Operations/MoveDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                DAOInstitute daoi = new DAOInstitute();
                ArrayList<Institute> i = daoi.getAll();
                daoi.closeConnection();
                request.setAttribute("departmentID", Integer.parseInt(request.getParameter("departmentID")));
                request.setAttribute("institutesList", i);
                request.setAttribute("step", "step3");
                request.getRequestDispatcher("Department/Operations/MoveDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step4")){
                ArrayList<Faculty> f = daof.getAllByInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("departmentID", Integer.parseInt(request.getParameter("departmentID")));
                request.setAttribute("facultiesList", f);
                request.setAttribute("step", "step4");
                request.getRequestDispatcher("Department/Operations/MoveDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step5")){
                Faculty faculty = daof.getEntityById(Integer.parseInt(request.getParameter("facultyID")));
                Department department = daod.getEntityById(Integer.parseInt(request.getParameter("departmentID")));
                request.setAttribute("faculty", faculty);
                request.setAttribute("department", department);
                request.setAttribute("step", "step5");
                request.getRequestDispatcher("Department/Operations/MoveDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step6")){
                boolean result = daod.updateDepartmentLocation(Integer.parseInt(request.getParameter("facultyID")),Integer.parseInt(request.getParameter("departmentID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "department");
                }else{
                    request.setAttribute("menu", "department");
                    request.setAttribute("result", "unsuccess");
                }
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("/Admin/DepartmentPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "department");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }
            daod.closeConnection();
            daof.closeConnection();
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("step", "step0");
            request.getRequestDispatcher("Department/Operations/MoveDepartmentPage.jsp").forward(request, response);
        }
    }
}
