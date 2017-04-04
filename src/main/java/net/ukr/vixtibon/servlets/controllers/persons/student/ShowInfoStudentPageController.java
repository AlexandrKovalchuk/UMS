package net.ukr.vixtibon.servlets.controllers.persons.student;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.DisciplineDepartmentDependencyObject;
import net.ukr.vixtibon.base_objects.study_process.StudentAttendanceObject;
import net.ukr.vixtibon.base_objects.study_process.StudentProgressObject;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.persons.DAOStudent;
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
 * Created by alex on 21/02/2017.
 */
public class ShowInfoStudentPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                request.setAttribute("groupID", request.getParameter("groupID"));
                DAOStudent daos = new DAOStudent();
                ArrayList<Student> students = new ArrayList<Student>();
                students = daos.getAllByGroupID(Integer.parseInt(request.getParameter("groupID")));
                request.setAttribute("students", students);
                request.setAttribute("selected", "yes");
                request.getRequestDispatcher("Employee/Student/Operations/ShowStudentInfoPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")) {
                DAOStudent daoStudent = new DAOStudent();
                DAODiscipline daoDiscipline = new DAODiscipline();
                DAOStudentAttendance daoStudentAttendance = new DAOStudentAttendance();
                DAOStudentProgress daoStudentProgress = new DAOStudentProgress();

                Student student = new Student();
                student = daoStudent.getEntityById(Integer.parseInt(request.getParameter("studentID")));

                student.setAttendance(daoStudentAttendance.getAllByStudentID(student.getID()));
                student.setProgress(daoStudentProgress.getAllByStudentID(student.getID()));

                DAODisciplineDepartmentDependency daoDisciplineDepartmentDependency = new DAODisciplineDepartmentDependency();
                for(Map.Entry<Integer, StudentAttendanceObject> a: student.getAttendance().entrySet()){
                    Discipline discipline = new Discipline();
                    discipline = daoDiscipline.getEntityById(a.getValue().getDisciplineID());
                    DisciplineDepartmentDependencyObject disciplineDepartmentDependencyObject = new DisciplineDepartmentDependencyObject();
                    disciplineDepartmentDependencyObject = daoDisciplineDepartmentDependency.getByDisciplineIDDepartmentID(discipline.getID(),(int)session.getAttribute("departmentID"));
                    discipline.setCourseNumber(disciplineDepartmentDependencyObject.getCourseNumber());
                    System.out.println("discipline id : " + discipline.getID() + " " + discipline.getCourseNumber());
                    student.getDisciplines().put(discipline.getID(), discipline);
                }
                daoDisciplineDepartmentDependency.closeConnection();

                daoStudentProgress.closeConnection();
                daoStudentAttendance.closeConnection();
                daoDiscipline.closeConnection();
                daoStudent.closeConnection();

                request.setAttribute("student", student);
                request.setAttribute("selected", "studentyes");
                request.getRequestDispatcher("Employee/Student/Operations/ShowStudentInfoPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("StudentPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAODepartment daod = new DAODepartment();
            DAOGroup daoGroup = new DAOGroup();

            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));

            department.setGroups1(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),1));
            department.setGroups2(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),2));
            department.setGroups3(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),3));
            department.setGroups4(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),4));
            department.setGroups5(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),5));
            department.setGroups6(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),6));

            daoGroup.closeConnection();
            daod.closeConnection();
            request.setAttribute("department", department);
            request.setAttribute("selected", "no");
            request.getRequestDispatcher("Employee/Student/Operations/ShowStudentInfoPage.jsp").forward(request, response);
        }
    }
}
