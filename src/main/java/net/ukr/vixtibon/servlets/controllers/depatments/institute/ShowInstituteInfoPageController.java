package net.ukr.vixtibon.servlets.controllers.depatments.institute;

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

public class ShowInstituteInfoPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAOInstitute daoi = new DAOInstitute();
            DAOFaculty daof = new DAOFaculty();
            DAODepartment daod = new DAODepartment();
            if(request.getParameter("step").equals("step1")){
                Institute institute = daoi.getEntityById(Integer.parseInt(request.getParameter("instituteID")));
                ArrayList<Faculty> faculties = daof.getAllByInstituteID(institute.getID());
                for(Faculty f: faculties){
                    ArrayList<Department> departments = daod.getAllByfacultyID(f.getID());
                    f.setDepartments(departments);
                }
                institute.setFacultys(faculties);
                request.setAttribute("selected", "yes");
                request.setAttribute("institute", institute);
                request.getRequestDispatcher("Institute/Operations/ShowInstituteInfoPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("/Admin/InstitutePageController").forward(request, response);
            }else{
                request.setAttribute("menu", "institute");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.getRequestDispatcher("Institute/Operations/ShowInstituteInfoPage.jsp").forward(request, response);
        }
    }
}
