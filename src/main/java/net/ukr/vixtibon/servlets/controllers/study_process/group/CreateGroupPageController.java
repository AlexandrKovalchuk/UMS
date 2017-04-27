package net.ukr.vixtibon.servlets.controllers.study_process.group;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.study_process.Group;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.stady_process.DAOGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CreateGroupPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("fillForm")){
            if(request.getParameter("fillForm").equals("yes")){
                DAOGroup daog = new DAOGroup();
                Group group = new Group();
                boolean result = false;
                group.setDepartmentID((int) session.getAttribute("departmentID"));
                group.setFullGroupName(request.getParameter("fullGroupName"));
                group.setCourseNumber(Integer.parseInt(request.getParameter("courseNumber")));
                try {
                    result = daog.create(group);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "group");
                }else{
                    request.setAttribute("menu", "group");
                    request.setAttribute("result", "unsuccess");
                }
                daog.closeConnection();
                request.getRequestDispatcher("/Employee/ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("fillForm").equals("cancel")){
                request.getRequestDispatcher("/Employee/GroupPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "group");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Employee/ActionResultEmployeeMenuPageController").forward(request, response);
            }
        }else{
            DAODepartment daod = new DAODepartment();
            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));
            daod.closeConnection();
            request.setAttribute("department", department);
            request.getRequestDispatcher("Group/Operations/CreateGroupPage.jsp").forward(request, response);
        }
    }
}
