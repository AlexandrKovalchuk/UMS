package net.ukr.vixtibon.servlets.controllers.study_process.discipline;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.DisciplineDepartmentDependencyObject;
import net.ukr.vixtibon.base_objects.study_process.DisciplineTeacherDependencyObject;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.persons.DAOTeacher;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineDepartmentDependency;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineTeacherDependencyObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ShowInfoDisciplinePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                DAODiscipline daodi = new DAODiscipline();
                DAODepartment daod = new DAODepartment();
                DAOTeacher daot = new DAOTeacher();
                DAODisciplineDepartmentDependency daoddd = new DAODisciplineDepartmentDependency();
                DAODisciplineTeacherDependencyObject daodtd = new DAODisciplineTeacherDependencyObject();

                Discipline discipline = daodi.getEntityById(Integer.parseInt(request.getParameter("disciplineID")));

                ArrayList<Teacher> teachersDependency = new ArrayList<>();
                ArrayList<Department> departmentsDependency = new ArrayList<>();

                for(DisciplineDepartmentDependencyObject dddo : daoddd.getAllByDepartmentID(discipline.getID())){
                    departmentsDependency.add(daod.getEntityById(dddo.getDepartmentID()));
                }

                for(DisciplineTeacherDependencyObject dtdo : daodtd.getAllByDisciplineID(discipline.getID())){
                    teachersDependency.add(daot.getEntityById(dtdo.getTeacherID()));
                }

                daod.closeConnection();
                daot.closeConnection();
                daoddd.closeConnection();
                daodtd.closeConnection();
                daodi.closeConnection();
                request.setAttribute("departmentsDependency", departmentsDependency);
                request.setAttribute("teachersDependency", teachersDependency);
                request.setAttribute("selected", "yes");
                request.setAttribute("discipline", discipline);
                request.getRequestDispatcher("Discipline/Operations/ShowInfoDisciplinePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("DisciplinePageController").forward(request, response);
            }else{
                request.setAttribute("menu", "discipline");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Employee/ActionResultEmployeeMenuPageController").forward(request, response);
            }
        }else{
            DAODepartment daod = new DAODepartment();
            DAODiscipline daodi = new DAODiscipline();
            DAODisciplineDepartmentDependency daoddd = new DAODisciplineDepartmentDependency();

            ArrayList<DisciplineDepartmentDependencyObject> dddos = daoddd.getAllByDepartmentID((int) session.getAttribute("departmentID"));

            ArrayList<Discipline> disciplinesConnectedWithDepartment = new ArrayList<>();
            ArrayList<Discipline> disciplinesNotConnectedWithDepartment;

            for(DisciplineDepartmentDependencyObject dddo: dddos){
                disciplinesConnectedWithDepartment.add(daodi.getEntityById(dddo.getDisciplineID()));
            }

            disciplinesNotConnectedWithDepartment = daodi.getAll();

            for(DisciplineDepartmentDependencyObject dddo: dddos){
                for(Discipline d: disciplinesNotConnectedWithDepartment){
                    if(dddo.getDisciplineID() == d.getID()){
                        disciplinesNotConnectedWithDepartment.remove(d);
                        break;
                    }
                }
            }

            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));

            daoddd.closeConnection();
            daodi.closeConnection();
            daod.closeConnection();

            request.setAttribute("department", department);
            request.setAttribute("disciplinesConnectedWithDepartment", disciplinesConnectedWithDepartment);
            request.setAttribute(" disciplinesNotConnectedWithDepartment",  disciplinesNotConnectedWithDepartment);
            request.getRequestDispatcher("Discipline/Operations/ShowInfoDisciplinePage.jsp").forward(request, response);
        }
    }
}
