package net.ukr.vixtibon.servlets.controllers.depatments.department;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.DisciplineDepartmentDependencyObject;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.departments.DAOFaculty;
import net.ukr.vixtibon.dao.departments.DAOInstitute;
import net.ukr.vixtibon.dao.persons.DAOEmployee;
import net.ukr.vixtibon.dao.persons.DAOTeacher;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineDepartmentDependency;
import net.ukr.vixtibon.dao.stady_process.DAOGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alex on 29/01/2017.
 */
public class ShowInfoDepartmentPageController   extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAODepartment daod = new DAODepartment();
            DAOFaculty daof = new DAOFaculty();
            if(request.getParameter("step").equals("step1")){
                ArrayList<Faculty> f = daof.getAllByInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("facultiesList", f);
                request.setAttribute("step", "step1");
                request.getRequestDispatcher("Admin/Department/Operations/ShowInfoDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                ArrayList<Department> departments = daod.getAllByfacultyID(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("step", "step2");
                request.setAttribute("departmentsList", departments);
                request.getRequestDispatcher("Admin/Department/Operations/ShowInfoDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                DAOEmployee daoe = new DAOEmployee();
                DAOTeacher daoTeacher = new DAOTeacher();
                DAOGroup daoGroup = new DAOGroup();
                DAODiscipline daoDiscipline = new DAODiscipline();
                DAODisciplineDepartmentDependency daoDisciplineDepartmentDependency = new DAODisciplineDepartmentDependency();

                Department department = daod.getEntityById(Integer.parseInt(request.getParameter("departmentID")));
                ArrayList<DisciplineDepartmentDependencyObject> disciplineDepartmentDependencyObjects = daoDisciplineDepartmentDependency.getAllByDepartmentID(department.getID());
                department.setEmployees(daoe.getAllByDepartmentID(department.getID()));
                department.setTeachers(daoTeacher.getAllByDepartmentID(department.getID()));
                department.setGroups1(daoGroup.getAllByDepartmentID(department.getID(),1));
                department.setGroups2(daoGroup.getAllByDepartmentID(department.getID(), 2));
                department.setGroups3(daoGroup.getAllByDepartmentID(department.getID(), 3));
                department.setGroups4(daoGroup.getAllByDepartmentID(department.getID(), 4));
                department.setGroups5(daoGroup.getAllByDepartmentID(department.getID(), 5));
                department.setGroups6(daoGroup.getAllByDepartmentID(department.getID(), 6));

                ArrayList<Discipline> disciplines = new ArrayList<>();
                for(DisciplineDepartmentDependencyObject d: disciplineDepartmentDependencyObjects){
                    Discipline discipline = daoDiscipline.getEntityById(d.getDisciplineID());
                    disciplines.add(discipline);
                }
                department.setDisciplines(disciplines);

                daoDisciplineDepartmentDependency.closeConnection();
                daoDiscipline.closeConnection();
                daoe.closeConnection();
                daoTeacher.closeConnection();
                daoGroup.closeConnection();
                request.setAttribute("step", "step3");
                request.setAttribute("department", department);
                request.getRequestDispatcher("Admin/Department/Operations/ShowInfoDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("DepartmentPageController").forward(request, response);
            }else{
                //error page
            }
            daof.closeConnection();
            daod.closeConnection();
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("step", "step0");
            request.getRequestDispatcher("Admin/Department/Operations/ShowInfoDepartmentPage.jsp").forward(request, response);
        }
    }
}
