package net.ukr.vixtibon.servlets.controllers.study_process.group;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.Group;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.persons.DAOStudent;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;
import net.ukr.vixtibon.dao.stady_process.DAOGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alex on 04/02/2017.
 */
public class ShowInfoGroupPageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                DAOGroup daog = new DAOGroup();
                DAOStudent daos = new DAOStudent();
                Group group = daog.getEntityById(Integer.parseInt(request.getParameter("groupID")));
                group.setStudents(daos.getAllByGroupID(group.getID()));
                daog.closeConnection();
                daos.closeConnection();
                request.setAttribute("selected", "yes");
                request.setAttribute("group", group);
                request.getRequestDispatcher("Employee/Group/Operations/ShowGroupInfoPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("GroupPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAODepartment daod = new DAODepartment();
            DAOGroup daog = new DAOGroup();
            ArrayList<Department> departments = new ArrayList<Department>();
            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));
            Department departmentNone = daod.getEntityById(0);
            departmentNone.setAllGroups(daog.getAllByDepartmentID(0));
            department.setAllGroups(daog.getAllByDepartmentID((int) session.getAttribute("departmentID")));
            departments.add(departmentNone);
            departments.add(department);
            daog.closeConnection();
            daod.closeConnection();
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("Employee/Group/Operations/ShowGroupInfoPage.jsp").forward(request, response);
        }
    }
}
