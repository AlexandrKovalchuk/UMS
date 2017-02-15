package net.ukr.vixtibon.servlets.controllers.persons.teacher;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.persons.DAOTeacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alex on 15/02/2017.
 */
public class MoveTeacherPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            DAOTeacher daot = new DAOTeacher();
            DAODepartment daod = new DAODepartment();
            if(request.getParameter("step").equals("step1")){
                Teacher teacher = daot.getEntityById(Integer.parseInt(request.getParameter("teacherID")));
                Department currentDepartment = daod.getEntityById((int) session.getAttribute("departmentID"));
                Department noneDepartment = daod.getEntityById(0);

                if(teacher.getDepartmentID() == (int) session.getAttribute("departmentID")){
                    request.setAttribute("currentDepartment", currentDepartment);
                    request.setAttribute("moveToDepartment", noneDepartment);
                }else{
                    request.setAttribute("currentDepartment", noneDepartment);
                    request.setAttribute("moveToDepartment", currentDepartment);
                }
                request.setAttribute("selected", "yes");
                request.setAttribute("teacher", teacher);
                request.getRequestDispatcher("Employee/Teacher/Operations/MoveTeacherPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                boolean result = false;
                result = daot.updateTeacherLocation(Integer.parseInt(request.getParameter("departmentID")),Integer.parseInt(request.getParameter("teacherID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "teacher");
                }else{
                    request.setAttribute("menu", "teacher");
                    request.setAttribute("result", "unsuccess");
                }
                daod.closeConnection();
                daot.closeConnection();
                request.getRequestDispatcher("ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("TeacherPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAODepartment daod = new DAODepartment();
            DAOTeacher daot = new DAOTeacher();
            ArrayList<Department> departments = new ArrayList<>();
            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));
            Department departmentNone = daod.getEntityById(0);
            departmentNone.setTeachers(daot.getAllByDepartmentID(0));
            department.setTeachers(daot.getAllByDepartmentID((int) session.getAttribute("departmentID")));
            departments.add(department);
            departments.add(departmentNone);
            daot.closeConnection();
            daod.closeConnection();
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("Employee/Teacher/Operations/MoveTeacherPage.jsp").forward(request, response);
        }
    }
}
