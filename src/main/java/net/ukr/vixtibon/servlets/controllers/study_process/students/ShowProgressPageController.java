package net.ukr.vixtibon.servlets.controllers.study_process.students;

import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.DisciplineDepartmentDependencyObject;
import net.ukr.vixtibon.base_objects.study_process.StudentAttendanceObject;
import net.ukr.vixtibon.base_objects.study_process.StudentProgressObject;
import net.ukr.vixtibon.dao.persons.DAOStudent;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineDepartmentDependency;
import net.ukr.vixtibon.dao.stady_process.DAOStudentAttendance;
import net.ukr.vixtibon.dao.stady_process.DAOStudentProgress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by alex on 04/04/2017.
 */
public class ShowProgressPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("ok")){
                request.getRequestDispatcher("StudentMenuPageController").forward(request, response);
            }else{
                //wrong parameter error
            }
        }else{
            DAOStudent daoStudent = new DAOStudent();
            DAODiscipline daoDiscipline = new DAODiscipline();
            DAOStudentAttendance daoStudentAttendance = new DAOStudentAttendance();
            DAOStudentProgress daoStudentProgress = new DAOStudentProgress();
            DAODisciplineDepartmentDependency daoDisciplineDepartmentDependency = new DAODisciplineDepartmentDependency();

            Student student = new Student();
            student = daoStudent.getEntityById((int) session.getAttribute("studentID"));
            student.setProgress(daoStudentProgress.getAllByStudentID(student.getID()));

            for(Map.Entry<Integer, StudentProgressObject> a: student.getProgress().entrySet()){
                Discipline discipline = new Discipline();
                discipline = daoDiscipline.getEntityById(a.getValue().getDisciplineID());
                DisciplineDepartmentDependencyObject disciplineDepartmentDependencyObject = new DisciplineDepartmentDependencyObject();
                disciplineDepartmentDependencyObject = daoDisciplineDepartmentDependency.getByDisciplineIDDepartmentID(discipline.getID(),(int)session.getAttribute("departmentID"));
                discipline.setCourseNumber(disciplineDepartmentDependencyObject.getCourseNumber());
                student.getDisciplines().put(discipline.getID(), discipline);
            }

            daoDiscipline.closeConnection();
            daoDisciplineDepartmentDependency.closeConnection();
            daoStudent.closeConnection();
            daoStudentAttendance.closeConnection();
            request.setAttribute("student", student);
            request.getRequestDispatcher("Student/StudyProgress/StudentProgress.jsp").forward(request, response);
        }
    }
}
