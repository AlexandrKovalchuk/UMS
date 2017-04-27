package net.ukr.vixtibon.servlets.controllers.persons.teacher;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.study_process.DisciplineTeacherDependencyObject;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.persons.DAOTeacher;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineTeacherDependencyObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ShowInfoTeacherPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                DAOTeacher daot = new DAOTeacher();
                DAODisciplineTeacherDependencyObject daodtdo = new DAODisciplineTeacherDependencyObject();
                DAODiscipline daod = new DAODiscipline();
                Teacher teacher = daot.getEntityById(Integer.parseInt(request.getParameter("teacherID")));
                ArrayList<DisciplineTeacherDependencyObject> dtdos = daodtdo.getAllByTeacherID(teacher.getID());

                for(DisciplineTeacherDependencyObject dtdo: dtdos){
                    teacher.getDisciplines().add(daod.getEntityById(dtdo.getDisciplineID()));
                }

                daot.closeConnection();
                daodtdo.closeConnection();
                daod.closeConnection();
                request.setAttribute("selected", "yes");
                request.setAttribute("teacher", teacher);
                request.getRequestDispatcher("Teacher/Operations/ShowTeacherInfoPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("/Employee/TeacherPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "teacher");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Employee/ActionResultEmployeeMenuPageController").forward(request, response);
            }
        }else{
            DAODepartment daod = new DAODepartment();
            DAOTeacher daot = new DAOTeacher();
            ArrayList<Department> departments = new ArrayList<>();
            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));
            Department departmentNone = daod.getEntityById(0);
            departmentNone.setTeachers(daot.getAllByDepartmentID(0));
            department.setTeachers(daot.getAllByDepartmentID((int) session.getAttribute("departmentID")));
            departments.add(departmentNone);
            departments.add(department);
            daot.closeConnection();
            daod.closeConnection();
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("Teacher/Operations/ShowTeacherInfoPage.jsp").forward(request, response);
        }
    }
}
