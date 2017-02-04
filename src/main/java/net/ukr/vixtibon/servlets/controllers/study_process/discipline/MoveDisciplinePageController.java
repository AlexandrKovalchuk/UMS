package net.ukr.vixtibon.servlets.controllers.study_process.discipline;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.DisciplineTeacherDependencyObject;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineTeacherDependencyObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alex on 04/02/2017.
 */
public class MoveDisciplinePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            DAODiscipline daodi = new DAODiscipline();
            DAODepartment daod = new DAODepartment();
            if(request.getParameter("step").equals("step1")){
                request.setAttribute("selected", "yes");
                Discipline discipline = daodi.getEntityById(Integer.parseInt(request.getParameter("disciplineID")));
                Department departmentFrom = new Department();
                Department departmentTo = new Department();

                if(discipline.getDepartmentID() == 0){
                    departmentFrom = daod.getEntityById(0);
                    departmentTo = daod.getEntityById((int) session.getAttribute("departmentID"));
                }else{
                    departmentFrom = daod.getEntityById(discipline.getDepartmentID());
                    departmentTo = daod.getEntityById(0);
                }

                request.setAttribute("departmentFrom", departmentFrom);
                request.setAttribute("departmentTo", departmentTo);
                request.setAttribute("discipline", discipline);
                request.getRequestDispatcher("Employee/Discipline/Operations/MoveDisciplinePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                boolean result = false;
                result = daodi.updateDisciplineLocation(Integer.parseInt(request.getParameter("departmentID")),Integer.parseInt(request.getParameter("disciplineID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "discipline");
                }else{
                    request.setAttribute("menu", "discipline");
                    request.setAttribute("result", "unsuccess");
                }
                daod.closeConnection();
                daodi.closeConnection();
                request.getRequestDispatcher("ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("DisciplinePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAODepartment daod = new DAODepartment();
            DAODiscipline daodi = new DAODiscipline();
            ArrayList<Department> departments = new ArrayList<Department>();
            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));
            Department departmentNone = daod.getEntityById(0);
            departmentNone.setDisciplines(daodi.getAllByDepartmentID(0));
            department.setDisciplines(daodi.getAllByDepartmentID((int) session.getAttribute("departmentID")));
            departments.add(departmentNone);
            departments.add(department);
            daodi.closeConnection();
            daod.closeConnection();
            request.setAttribute("selected", "no");
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("Employee/Discipline/Operations/MoveDisciplinePage.jsp").forward(request, response);
        }
    }
}
