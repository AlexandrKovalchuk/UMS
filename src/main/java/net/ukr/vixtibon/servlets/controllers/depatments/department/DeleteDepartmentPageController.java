package net.ukr.vixtibon.servlets.controllers.depatments.department;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.departments.DAOFaculty;
import net.ukr.vixtibon.dao.departments.DAOInstitute;
import net.ukr.vixtibon.dao.persons.DAOEmployee;
import net.ukr.vixtibon.dao.persons.DAOTeacher;
import net.ukr.vixtibon.dao.stady_process.DAODayRequirements;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineDepartmentDependency;
import net.ukr.vixtibon.dao.stady_process.DAOGroup;
import net.ukr.vixtibon.dao.stady_process.DAOLesson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteDepartmentPageController   extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("step")){
            DAOFaculty daof = new DAOFaculty();
            DAODepartment daod = new DAODepartment();
            DAOEmployee daoe = new DAOEmployee();
            if(request.getParameter("step").equals("step1")){
                ArrayList<Faculty> f = daof.getAllByInstituteID(Integer.parseInt(request.getParameter("instituteID")));
                request.setAttribute("facultiesList", f);
                request.setAttribute("step", "step1");
                request.getRequestDispatcher("Department/Operations/DeleteDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                ArrayList<Department> departments = daod.getAllByfacultyID(Integer.parseInt(request.getParameter("facultyID")));
                request.setAttribute("step", "step2");
                request.setAttribute("departmentsList", departments);
                request.getRequestDispatcher("Department/Operations/DeleteDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step3")){
                DAODisciplineDepartmentDependency daoDisciplineDepartmentDependency = new DAODisciplineDepartmentDependency();
                DAOTeacher daoTeacher = new DAOTeacher();
                DAODayRequirements daoDayRequirements = new DAODayRequirements();
                DAOLesson daoLesson = new DAOLesson();
                DAOGroup daoGroup = new DAOGroup();
                Department department = daod.getEntityById(Integer.parseInt(request.getParameter("departmentID")));
                if(daoe.getCountOfEmployeesByDepartmentID(department.getID()) == 0){
                    if(daoDisciplineDepartmentDependency.getCountOfDependencyByDepartmentID(department.getID()) == 0){
                        if(daoTeacher.getCountOfTeachersByDepartmentID(department.getID()) == 0){
                            if(daoDayRequirements.getCountOfDayRequirements(department.getID()) == 0){
                                if(daoLesson.getCountByDepartmentID(department.getID()) == 0){
                                    if(daoGroup.getCountOfGroupsByDepartmentID(department.getID()) == 0){
                                        request.setAttribute("possible_to_remove", "yes");
                                    }else{
                                        request.setAttribute("possible_to_remove", "no");
                                    }
                                }else{
                                    request.setAttribute("possible_to_remove", "no");
                                }
                            }else{
                                request.setAttribute("possible_to_remove", "no");
                            }
                        }else{
                            request.setAttribute("possible_to_remove", "no");
                        }
                    }else{
                        request.setAttribute("possible_to_remove", "no");
                    }
                }else {
                    request.setAttribute("possible_to_remove", "no");
                }
                daoe.closeConnection();
                daoGroup.closeConnection();
                daoLesson.closeConnection();
                daoTeacher.closeConnection();
                daoDisciplineDepartmentDependency.closeConnection();
                request.setAttribute("step", "step3");
                request.setAttribute("department", department);
                request.getRequestDispatcher("Department/Operations/DeleteDepartmentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step4")){
                boolean result = daod.delete(Integer.parseInt(request.getParameter("departmentID")));
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "department");
                }else{
                    request.setAttribute("menu", "department");
                    request.setAttribute("result", "unsuccess");
                }
                daod.closeConnection();
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("/Admin/DepartmentPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "department");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
            }
        }else{
            DAOInstitute daoi = new DAOInstitute();
            ArrayList<Institute> i = daoi.getAll();
            daoi.closeConnection();
            request.setAttribute("institutesList", i);
            request.setAttribute("step", "step0");
            request.getRequestDispatcher("Department/Operations/DeleteDepartmentPage.jsp").forward(request, response);
        }
    }
}
