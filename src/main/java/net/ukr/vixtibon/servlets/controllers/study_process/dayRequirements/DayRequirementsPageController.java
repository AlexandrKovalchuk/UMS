package net.ukr.vixtibon.servlets.controllers.study_process.dayRequirements;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.study_process.DayRequirementsObject;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.stady_process.DAODayRequirements;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by alex on 24/02/2017.
 */
public class DayRequirementsPageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                DAODayRequirements daoDayRequirements = new DAODayRequirements();

                if(request.getParameter("requirementsPresent").equals("no")){
                    DayRequirementsObject dro = new DayRequirementsObject();
                    dro.setDepartmentID((int) session.getAttribute("departmentID"));
                    dro.setCountOfDaysInWeek(Integer.parseInt(request.getParameter("countOfDaysInWeek")));
                    dro.setCountOfLessonsInADay(Integer.parseInt(request.getParameter("countOfLessonsInADay")));
                    try {
                        daoDayRequirements.create(dro);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    request.setAttribute("dayRequirementsObject", dro);
                    request.setAttribute("step", "step1");
                    request.setAttribute("requirementsPresent", "no");
                    request.getRequestDispatcher("Employee/DayRequirements/DayRequirementsPage.jsp").forward(request, response);


                }else if(request.getParameter("requirementsPresent").equals("yes")){
                    DayRequirementsObject dro = new DayRequirementsObject();
                    dro.setDepartmentID((int) session.getAttribute("departmentID"));
                    dro.setCountOfDaysInWeek(Integer.parseInt(request.getParameter("countOfDaysInWeek")));
                    dro.setCountOfLessonsInADay(Integer.parseInt(request.getParameter("countOfLessonsInADay")));
                    daoDayRequirements.updateCounts(dro);
                    dro = daoDayRequirements.getEntityByDepartmentID((int) session.getAttribute("departmentID"));
                    request.setAttribute("dayRequirementsObject", dro);
                    request.setAttribute("step", "step1");
                    request.setAttribute("requirementsPresent", "yes");
                    request.getRequestDispatcher("Employee/DayRequirements/DayRequirementsPage.jsp").forward(request, response);

                }
                daoDayRequirements.closeConnection();

            }else if(request.getParameter("step").equals("step2")){

                DAODayRequirements daoDayRequirements = new DAODayRequirements();
                DayRequirementsObject dro = new DayRequirementsObject();
                dro = daoDayRequirements.getEntityByDepartmentID((int) session.getAttribute("departmentID"));
                boolean result = false;

                for(int i = 1; i < dro.getCountOfLessonsInADay() + 1; i++){
                    String fieldName = "timeForLesson" + i;
                    String value = request.getParameter(fieldName);
                    dro.getLessonsTime().set(i-1,value);
                    System.out.println("fieldName " + fieldName + "  " + dro.getLessonsTime().get(i-1));
                }

                result = daoDayRequirements.updateLessonArray(dro);

                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "dayRequirements");
                }else{
                    request.setAttribute("menu", "dayRequirements");
                    request.setAttribute("result", "unsuccess");
                }
                daoDayRequirements.closeConnection();
                request.getRequestDispatcher("ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("EmployeeMenuPageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAODayRequirements daodr = new DAODayRequirements();
            if(daodr.getCountOfDayRequirements((int) session.getAttribute("departmentID"))>0){
                DayRequirementsObject dro = daodr.getEntityByDepartmentID((int) session.getAttribute("departmentID"));
                request.setAttribute("step", "step0");
                request.setAttribute("requirementsPresent", "yes");
                request.setAttribute("dayRequirementsObject", dro);
                System.out.println("present");
            }else{
                request.setAttribute("step", "step0");
                request.setAttribute("requirementsPresent", "no");
                System.out.println("absent");
            }
            daodr.closeConnection();
            request.getRequestDispatcher("Employee/DayRequirements/DayRequirementsPage.jsp").forward(request, response);
        }
    }
}
