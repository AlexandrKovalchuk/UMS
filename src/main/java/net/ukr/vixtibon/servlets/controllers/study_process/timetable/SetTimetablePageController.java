package net.ukr.vixtibon.servlets.controllers.study_process.timetable;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.study_process.DayRequirementsObject;
import net.ukr.vixtibon.base_objects.study_process.Group;
import net.ukr.vixtibon.base_objects.study_process.Lesson;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.stady_process.DAODayRequirements;
import net.ukr.vixtibon.dao.stady_process.DAOGroup;
import net.ukr.vixtibon.dao.stady_process.DAOLesson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alex on 24/02/2017.
 */
public class SetTimetablePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                boolean result = false;
                DAOLesson daoLesson = new DAOLesson();
                DAODepartment daoDepartment = new DAODepartment();
                DAOGroup daoGroup = new DAOGroup();
                DAODayRequirements daoDayRequirements = new DAODayRequirements();

                if(request.getParameter("timetablePresent").equals("yes")){
                    daoLesson.deleteByDepartmentID((int) session.getAttribute("departmentID"));

                }

                Department department = new Department();
                DayRequirementsObject dayRequirementsObject = new DayRequirementsObject();
                dayRequirementsObject = daoDayRequirements.getEntityByDepartmentID((int) session.getAttribute("departmentID"));

                department.setGroups1(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),1));
                department.setGroups2(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"), 2));
                department.setGroups3(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"), 3));
                department.setGroups4(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"), 4));
                department.setGroups5(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"), 5));
                department.setGroups6(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"), 6));

                for(int i = 1; i < dayRequirementsObject.getCountOfDaysInWeek() + 1; i++){
                    for(int j = 1; j < dayRequirementsObject.getCountOfLessonsInADay() + 1; j++){
                        for(Group g: department.getGroups1()){
                            Lesson lesson = new Lesson();
                            lesson.setDepartmentID((int) session.getAttribute("departmentID"));
                            lesson.setDayNumber(i);
                            lesson.setLessonNumberInDay(j);
                            lesson.setGroupID(g.getID());
                            try {
                                daoLesson.create(lesson);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        for(Group g: department.getGroups2()){
                            Lesson lesson = new Lesson();
                            lesson.setDepartmentID((int) session.getAttribute("departmentID"));
                            lesson.setDayNumber(i);
                            lesson.setLessonNumberInDay(j);
                            lesson.setGroupID(g.getID());
                            try {
                                daoLesson.create(lesson);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        for(Group g: department.getGroups3()){
                            Lesson lesson = new Lesson();
                            lesson.setDepartmentID((int) session.getAttribute("departmentID"));
                            lesson.setDayNumber(i);
                            lesson.setLessonNumberInDay(j);
                            lesson.setGroupID(g.getID());
                            try {
                                daoLesson.create(lesson);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        for(Group g: department.getGroups4()){
                            Lesson lesson = new Lesson();
                            lesson.setDepartmentID((int) session.getAttribute("departmentID"));
                            lesson.setDayNumber(i);
                            lesson.setLessonNumberInDay(j);
                            lesson.setGroupID(g.getID());
                            try {
                                daoLesson.create(lesson);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        for(Group g: department.getGroups5()){
                            Lesson lesson = new Lesson();
                            lesson.setDepartmentID((int) session.getAttribute("departmentID"));
                            lesson.setDayNumber(i);
                            lesson.setLessonNumberInDay(j);
                            lesson.setGroupID(g.getID());
                            try {
                                daoLesson.create(lesson);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        for(Group g: department.getGroups6()){
                            Lesson lesson = new Lesson();
                            lesson.setDepartmentID((int) session.getAttribute("departmentID"));
                            lesson.setDayNumber(i);
                            lesson.setLessonNumberInDay(j);
                            lesson.setGroupID(g.getID());
                            try {
                                daoLesson.create(lesson);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                if(result){
                    request.setAttribute("result", "success");
                }else{
                    request.setAttribute("result", "unsuccess");
                }

                daoDayRequirements.closeConnection();
                daoGroup.closeConnection();
                daoDepartment.closeConnection();
                daoLesson.closeConnection();
                request.setAttribute("menu", "timetable");
                request.getRequestDispatcher("ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("TimetablePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAOLesson daoLesson = new DAOLesson();

            if(daoLesson.getCountByDepartmentID((int) session.getAttribute("departmentID"))>0){
                request.setAttribute("timetablePresent", "yes");
            }else{
                request.setAttribute("timetablePresent", "no");
            }
            request.setAttribute("step", "step0");
            daoLesson.closeConnection();
            request.getRequestDispatcher("Employee/Timetable/Operations/SetTimetablePage.jsp").forward(request, response);
        }
    }

    private void setup(){

    }
}
