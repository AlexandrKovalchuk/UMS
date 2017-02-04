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
 * Created by alex on 03/02/2017.
 */
public class DeleteDisciplinePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            DAODiscipline daodi = new DAODiscipline();
            if(request.getParameter("step").equals("step1")){
                Discipline discipline = daodi.getEntityById(Integer.parseInt(request.getParameter("disciplineID")));
                DAODisciplineTeacherDependencyObject ddtdo = new DAODisciplineTeacherDependencyObject();
                ArrayList<DisciplineTeacherDependencyObject> disciplineTeacherDependencyObjects = ddtdo.getAllByDisciplineID(discipline.getID());
                request.setAttribute("selected", "yes");
                if(disciplineTeacherDependencyObjects.size()>0){
                    request.setAttribute("possible_to_remove", "no");
                }else{
                    request.setAttribute("possible_to_remove", "yes");
                }
                request.setAttribute("discipline", discipline);
                request.getRequestDispatcher("Employee/Discipline/Operations/DeleteDisciplinePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                boolean result = false;
                result = daodi.delete(Integer.parseInt(request.getParameter("disciplineID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "discipline");
                }else{
                    request.setAttribute("menu", "discipline");
                    request.setAttribute("result", "unsuccess");
                }
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
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("Employee/Discipline/Operations/DeleteDisciplinePage.jsp").forward(request, response);
        }
    }
}
