package net.ukr.vixtibon.servlets.controllers.study_process.timetable;

import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.study_process.*;
import net.ukr.vixtibon.dao.persons.DAOStudent;
import net.ukr.vixtibon.dao.persons.DAOTeacher;
import net.ukr.vixtibon.dao.stady_process.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by alex on 04/04/2017.
 */
public class UpdateLessonPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("operation")){
            if(request.getParameter("operation").equals("step1")){
                DAODiscipline daoDiscipline = new DAODiscipline();
                DAOTeacher daoTeacher = new DAOTeacher();
                DAODisciplineTeacherDependencyObject daoDisciplineTeacherDependencyObject = new DAODisciplineTeacherDependencyObject();

                Discipline discipline = daoDiscipline.getEntityById(Integer.parseInt(request.getParameter("disciplineID")));
                ArrayList<Teacher> teachers = new ArrayList<>();
                DisciplineTeacherDependencyObject disciplineTeacherDependencyObject = new DisciplineTeacherDependencyObject();
                ArrayList<DisciplineTeacherDependencyObject> disciplineTeacherDependencyObjects = daoDisciplineTeacherDependencyObject.getAllByDisciplineID(discipline.getID());

                for(DisciplineTeacherDependencyObject d: disciplineTeacherDependencyObjects){
                    Teacher teacher = daoTeacher.getEntityById(d.getTeacherID());
                    teachers.add(teacher);
                }
                daoDisciplineTeacherDependencyObject.closeConnection();
                daoTeacher.closeConnection();
                daoDiscipline.closeConnection();

                request.setAttribute("teachers", teachers);
                request.setAttribute("operation", "step2");
                request.setAttribute("disciplineID", discipline.getID());
                request.setAttribute("lessonID", Integer.parseInt(request.getParameter("lessonID")));
                request.getRequestDispatcher("Employee/Timetable/Operations/UpdateLessonPage.jsp").forward(request, response);
            }else if(request.getParameter("operation").equals("step2")){
                DAOLesson daoLesson = new DAOLesson();
                DAOTeacher daoTeacher = new DAOTeacher();
                DAODiscipline daoDiscipline = new DAODiscipline();
                Lesson lesson = daoLesson.getEntityById(Integer.parseInt(request.getParameter("lessonID")));

                if(request.getParameter("disciplineID").equals("NULL")) {
                    daoLesson.update(lesson, true);
                }else{
                    Discipline discipline = daoDiscipline.getEntityById(Integer.parseInt(request.getParameter("disciplineID")));
                    Teacher teacher = daoTeacher.getEntityById(Integer.parseInt(request.getParameter("teacherID")));
                    lesson.setTeacher(teacher);
                    lesson.setDiscipline(discipline);
                    daoLesson.update(lesson);
                }

                daoTeacher.closeConnection();
                daoDiscipline.closeConnection();
                daoLesson.closeConnection();
                request.getRequestDispatcher("UpdateTimetablePageController").forward(request, response);
            }else if(request.getParameter("operation").equals("cancel")){
                request.getRequestDispatcher("UpdateTimetablePageController").forward(request, response);
            }else{
                //wrong parameter error
            }
        }else{
            DAODiscipline daoDiscipline = new DAODiscipline();
            DAODisciplineDepartmentDependency daoDisciplineDepartmentDependency = new DAODisciplineDepartmentDependency();
            ArrayList<DisciplineDepartmentDependencyObject> disciplineDepartmentDependencyObjects = daoDisciplineDepartmentDependency.getAllByDepartmentID((int) session.getAttribute("departmentID"));
            ArrayList<Discipline> disciplines = new ArrayList<>();
            for(DisciplineDepartmentDependencyObject d: disciplineDepartmentDependencyObjects){
                Discipline discipline = daoDiscipline.getEntityById(d.getDisciplineID());
                disciplines.add(discipline);
            }

            daoDiscipline.closeConnection();
            daoDisciplineDepartmentDependency.closeConnection();
            request.setAttribute("disciplines", disciplines);
            request.setAttribute("operation", "step1");
            request.setAttribute("lessonID", request.getParameter("lessonID"));
            request.getRequestDispatcher("Employee/Timetable/Operations/UpdateLessonPage.jsp").forward(request, response);
        }
    }
}
