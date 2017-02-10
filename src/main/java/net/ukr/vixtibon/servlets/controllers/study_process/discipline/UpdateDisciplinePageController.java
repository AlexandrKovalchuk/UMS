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
import java.util.ArrayList;

/**
 * Created by alex on 02/02/2017.
 */
public class UpdateDisciplinePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            DAODiscipline daodi = new DAODiscipline();
            if(request.getParameter("step").equals("step1")){
                Discipline discipline = daodi.getEntityById(Integer.parseInt(request.getParameter("disciplineID")));
                request.setAttribute("selected", "yes");
                request.setAttribute("discipline", discipline);
                request.getRequestDispatcher("Employee/Discipline/Operations/UpdateDisciplinePage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                Discipline d = new Discipline();
                boolean result = false;
                d.setID(Integer.parseInt(request.getParameter("disciplineID")));
                d.setNameOfDiscipline(request.getParameter("nameOfDiscipline"));
                d.setCountOfLessons(Integer.parseInt(request.getParameter("countOfLessons")));
                d.setExam(request.getParameter("exam"));
                    result = daodi.update(d);
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "discipline");
                }else{
                    request.setAttribute("menu", "discipline");
                    request.setAttribute("result", "unsuccess");
                }
                daodi.closeConnection();
                request.getRequestDispatcher("ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("DisciplinePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAODepartment daod = new DAODepartment();
            DAODiscipline daodi = new DAODiscipline();
            DAODisciplineDepartmentDependency daoddd = new DAODisciplineDepartmentDependency();

            ArrayList<DisciplineDepartmentDependencyObject> dddos = new ArrayList<>();
            dddos = daoddd.getAllByDepartmentID((int) session.getAttribute("departmentID"));

            ArrayList<Discipline> disciplinesConnectedWithDepartment = new ArrayList<>();
            ArrayList<Discipline> disciplinesNotConnectedWithDepartment = new ArrayList<>();

            for(DisciplineDepartmentDependencyObject dddo: dddos){
                disciplinesConnectedWithDepartment.add(daodi.getEntityById(dddo.getDisciplineID()));
            }

            disciplinesNotConnectedWithDepartment = daodi.getAll();

            System.out.println("disciplinesConnectedWithDepartment " + disciplinesConnectedWithDepartment.size());
            System.out.println("disciplinesNotConnectedWithDepartment " + disciplinesNotConnectedWithDepartment.size());

            for(DisciplineDepartmentDependencyObject dddo: dddos){
                for(Discipline d: disciplinesNotConnectedWithDepartment){
                    if(dddo.getDisciplineID() == d.getID()){
                        disciplinesNotConnectedWithDepartment.remove(d);
                        break;
                    }else{
                        continue;
                    }
                }
            }
            System.out.println("disciplinesNotConnectedWithDepartment " + disciplinesNotConnectedWithDepartment.size());
            System.out.println("disciplinesNotConnectedWithDepartment " + disciplinesNotConnectedWithDepartment.get(0).getNameOfDiscipline());

            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));

            daoddd.closeConnection();
            daodi.closeConnection();
            daod.closeConnection();

            request.setAttribute("department", department);
            request.setAttribute("disciplinesConnectedWithDepartment", disciplinesConnectedWithDepartment);
            request.setAttribute("disciplinesNotConnectedWithDepartment",  disciplinesNotConnectedWithDepartment);
            request.getRequestDispatcher("Employee/Discipline/Operations/UpdateDisciplinePage.jsp").forward(request, response);
        }
    }
}
