package net.ukr.vixtibon.servlets.controllers.study_process.discipline;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.DisciplineDepartmentDependencyObject;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineDepartmentDependency;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SetDisciplineDepartmentDependencyPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            DAODiscipline daodi = new DAODiscipline();
            DAODepartment daod = new DAODepartment();
            DAODisciplineDepartmentDependency daoddd = new DAODisciplineDepartmentDependency();
            if(request.getParameter("step").equals("step1")){
                request.setAttribute("selected", "yes");
                Discipline discipline = daodi.getEntityById(Integer.parseInt(request.getParameter("disciplineID")));
                DisciplineDepartmentDependencyObject dddo = daoddd.getByDisciplineIDDepartmentID(Integer.parseInt(request.getParameter("disciplineID")),(int) session.getAttribute("departmentID"));
                request.setAttribute("discipline", discipline);
                request.setAttribute("dependencyObject", dddo);
                request.setAttribute("state", request.getParameter("state"));
                request.getRequestDispatcher("Discipline/Operations/SetDisciplineDepartmentDependencyPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                boolean result = false;
                DisciplineDepartmentDependencyObject dddo = new DisciplineDepartmentDependencyObject();
                if(request.getParameter("action").equals("new")){
                    dddo.setDisciplineID(Integer.parseInt(request.getParameter("disciplineID")));
                    dddo.setDepartmentID((int) session.getAttribute("departmentID"));
                    dddo.setCourseNumber(Integer.parseInt(request.getParameter("courseNumber")));
                    dddo.setSemesterNumber(Integer.parseInt(request.getParameter("semesterNumber")));

                    try {
                        result = daoddd.create(dddo);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(request.getParameter("action").equals("update")){
                    dddo = daoddd.getByDisciplineIDDepartmentID(Integer.parseInt(request.getParameter("disciplineID")),(int) session.getAttribute("departmentID"));
                    dddo.setCourseNumber(Integer.parseInt(request.getParameter("courseNumber")));
                    dddo.setSemesterNumber(Integer.parseInt(request.getParameter("semesterNumber")));
                    result = daoddd.update(dddo);
                }else if(request.getParameter("action").equals("remove")){
                    dddo = daoddd.getByDisciplineIDDepartmentID(Integer.parseInt(request.getParameter("disciplineID")),(int) session.getAttribute("departmentID"));
                    result = daoddd.delete(dddo.getID());
                }
                daoddd.closeConnection();

                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "discipline");
                }else{
                    request.setAttribute("menu", "discipline");
                    request.setAttribute("result", "unsuccess");
                }
                daod.closeConnection();
                daodi.closeConnection();
                request.getRequestDispatcher("/Employee/ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("/Employee/DisciplinePageController").forward(request, response);
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
            request.setAttribute("disciplinesNotConnectedWithDepartment",  disciplinesNotConnectedWithDepartment);
            request.getRequestDispatcher("Discipline/Operations/SetDisciplineDepartmentDependencyPage.jsp").forward(request, response);
        }
    }
}
