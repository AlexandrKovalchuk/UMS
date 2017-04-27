package net.ukr.vixtibon.servlets.controllers.study_process.teachers;

import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.DisciplineDepartmentDependencyObject;
import net.ukr.vixtibon.base_objects.study_process.DisciplineTeacherDependencyObject;
import net.ukr.vixtibon.base_objects.study_process.Group;
import net.ukr.vixtibon.dao.persons.DAOStudent;
import net.ukr.vixtibon.dao.stady_process.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class SetProgressPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            DAOGroup daoGroup = new DAOGroup();
            DAODiscipline daoDiscipline = new DAODiscipline();
            DAODisciplineDepartmentDependency daoDisciplineDepartmentDependency = new DAODisciplineDepartmentDependency();
            DAOStudent daoStudent = new DAOStudent();
            DAOStudentProgress daoStudentProgress = new DAOStudentProgress();
            if(request.getParameter("step").equals("step1")){
                session.setAttribute("disciplineID", Integer.parseInt(request.getParameter("disciplineID")));
                DisciplineDepartmentDependencyObject disciplineDepartmentDependency = daoDisciplineDepartmentDependency.getByDisciplineIDDepartmentID((int) session.getAttribute("disciplineID"), (int) session.getAttribute("departmentID"));
                //System.out.println("disciplineDepartmentDependency" + disciplineDepartmentDependency.getDisciplineID() + " " + disciplineDepartmentDependency.getDepartmentID());
                ArrayList<Group> groups = daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"), disciplineDepartmentDependency.getCourseNumber());
                //System.out.println("groups" + groups.size());
                request.setAttribute("select", "select1");
                request.setAttribute("groups", groups);
                request.getRequestDispatcher("StudyProgress/SetProgressPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                Discipline discipline = daoDiscipline.getEntityById((int) session.getAttribute("disciplineID"));
                ArrayList<Student> students = daoStudent.getAllByGroupID(Integer.parseInt(request.getParameter("groupID")));
                for(Student student: students){
                    student.setProgress(daoStudentProgress.getByStudentIDDisciplineID(student.getID(),(int) session.getAttribute("disciplineID")));

                }
                request.setAttribute("discipline", discipline);
                request.setAttribute("students", students);
                request.setAttribute("groupID", request.getParameter("groupID"));
                request.setAttribute("select", "select2");
                request.getRequestDispatcher("StudyProgress/SetProgressPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                ArrayList<Student> students = daoStudent.getAllByGroupID(Integer.parseInt(request.getParameter("groupID")));
                boolean result = false;
                for(Student student: students){
                    student.setProgress(daoStudentProgress.getByStudentIDDisciplineID(student.getID(),(int) session.getAttribute("disciplineID")));
                    ArrayList<String> progress = new ArrayList<>();
                    for(int i = 0; i < student.getProgress().entrySet().iterator().next().getValue().getProgress().size(); i++){
                        String value = request.getParameter("" + student.getID() + "#" + student.getProgress().entrySet().iterator().next().getValue().getDisciplineID() + "#" + i);
                        progress.add(value);
                    }
                    student.getProgress().entrySet().iterator().next().getValue().setProgress(progress);
                    student.getProgress().entrySet().iterator().next().getValue().setExamResult(request.getParameter("" + student.getID() + "#" + student.getProgress().entrySet().iterator().next().getValue().getDisciplineID() + "#exam"));
                    result = daoStudentProgress.update(student.getProgress().entrySet().iterator().next().getValue());
                }

                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "progress");
                }else{
                    request.setAttribute("menu", "progress");
                    request.setAttribute("result", "unsuccess");
                }
                request.getRequestDispatcher("/Teacher/ActionResultTeacherMenuPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                session.removeAttribute("disciplineID");
                request.getRequestDispatcher("/Teacher/TeacherMenuPageController").forward(request, response);
            }else{
                request.setAttribute("result", "wrongParameter");
                request.getRequestDispatcher("/Teacher/ActionResultTeacherMenuPageController").forward(request, response);
            }
            daoDiscipline.closeConnection();
            daoDisciplineDepartmentDependency.closeConnection();
            daoGroup.closeConnection();
            daoStudent.closeConnection();
            daoStudentProgress.closeConnection();
        }else{
            DAODiscipline daodi = new DAODiscipline();
            DAODisciplineTeacherDependencyObject daodtdo = new DAODisciplineTeacherDependencyObject();
            Teacher teacher = new Teacher();

            ArrayList<DisciplineTeacherDependencyObject> dtdos = daodtdo.getAllByTeacherID((int) session.getAttribute("teacherID"));

            for(DisciplineTeacherDependencyObject dtdo: dtdos){
                teacher.getDisciplines().add(daodi.getEntityById(dtdo.getDisciplineID()));
            }
            daodi.closeConnection();
            daodtdo.closeConnection();

            request.setAttribute("teacher", teacher);
            request.setAttribute("select", "select0");
            request.getRequestDispatcher("StudyProgress/SetProgressPage.jsp").forward(request, response);
        }
    }
}
