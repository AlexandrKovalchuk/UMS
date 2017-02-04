package net.ukr.vixtibon.servlets.controllers.study_process.discipline;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by alex on 01/02/2017.
 */
public class CreateDisciplinePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("fillForm")){
            if(request.getParameter("fillForm").equals("yes")){
                DAODiscipline daodi = new DAODiscipline();
                Discipline d = new Discipline();
                boolean result = false;
                d.setDepartmentID((int) session.getAttribute("departmentID"));
                d.setNameOfDiscipline(request.getParameter("nameOfDiscipline"));
                d.setCourseNumber(Integer.parseInt(request.getParameter("courseNumber")));
                d.setSemesterNumber(Integer.parseInt(request.getParameter("semesterNumber")));
                d.setCountOfLessons(Integer.parseInt(request.getParameter("countOfLessons")));
                d.setCountOfPractice(Integer.parseInt(request.getParameter("CountOfPractice")));
                d.setExam(request.getParameter("exam"));
                try {
                    result = daodi.create(d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "discipline");
                }else{
                    request.setAttribute("menu", "discipline");
                    request.setAttribute("result", "unsuccess");
                }
                daodi.closeConnection();
                request.getRequestDispatcher("ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("fillForm").equals("cancel")){
                request.getRequestDispatcher("DisciplinePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAODepartment daod = new DAODepartment();
            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));
            daod.closeConnection();
            request.setAttribute("department", department);
            request.getRequestDispatcher("Employee/Discipline/Operations/CreateDisciplinePage.jsp").forward(request, response);
        }
    }
}
