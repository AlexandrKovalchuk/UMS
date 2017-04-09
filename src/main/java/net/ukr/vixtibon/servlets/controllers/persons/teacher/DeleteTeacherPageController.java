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

public class DeleteTeacherPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            DAOTeacher daot = new DAOTeacher();
            if(request.getParameter("step").equals("step1")){
                Teacher teacher = daot.getEntityById(Integer.parseInt(request.getParameter("teacherID")));
                request.setAttribute("selected", "yes");
                request.setAttribute("teacher", teacher);
                request.getRequestDispatcher("Employee/Teacher/Operations/DeleteTeacherPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                boolean result = daot.delete(Integer.parseInt(request.getParameter("teacherID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "teacher");
                }else{
                    request.setAttribute("menu", "teacher");
                    request.setAttribute("result", "unsuccess");
                }
                daot.closeConnection();
                request.getRequestDispatcher("ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("TeacherPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "teacher");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("ActionResultEmployeeMenuPageController").forward(request, response);
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
            request.getRequestDispatcher("Employee/Teacher/Operations/DeleteTeacherPage.jsp").forward(request, response);
        }
    }
}
