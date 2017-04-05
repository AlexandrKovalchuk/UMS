package net.ukr.vixtibon.servlets.controllers.study_process.timetable;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.study_process.DayRequirementsObject;
import net.ukr.vixtibon.base_objects.study_process.Group;
import net.ukr.vixtibon.base_objects.study_process.Lesson;
import net.ukr.vixtibon.base_objects.study_process.LessonsArray;
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
 * Created by alex on 28/02/2017.
 */
public class UpdateTimetablePageController  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){

                request.removeAttribute("step");
                request.setAttribute("lessonID ",request.getParameter("lessonID"));
                request.getRequestDispatcher("UpdateLessonPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("TimetablePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAOLesson daoLesson = new DAOLesson();

            if(daoLesson.getCountByDepartmentID((int) session.getAttribute("departmentID"))>0){
                DAODayRequirements daoDayRequirements = new DAODayRequirements();
                DAOGroup daoGroup = new DAOGroup();

                DayRequirementsObject dayRequirementsObject = new DayRequirementsObject();

                dayRequirementsObject = daoDayRequirements.getEntityByDepartmentID((int) session.getAttribute("departmentID"));

                ArrayList<ArrayList<ArrayList<Lesson>>> week = new ArrayList<>();
                ArrayList<String> dayNames = new ArrayList<>();
                ArrayList<String> lessonsTime = new ArrayList<>();
                ArrayList<ArrayList<Group>> groupNamesByCourse = new ArrayList<>();
                ArrayList<String> courseNumbers = new ArrayList<>();

                for(int i = 0; i < dayRequirementsObject.getCountOfDaysInWeek(); i++){
                    ArrayList<ArrayList<Lesson>> day = new ArrayList<>();
                    for(int j = 0; j < dayRequirementsObject.getCountOfLessonsInADay(); j++){
                        ArrayList<Lesson> lessons = new ArrayList<>();
                        lessons = daoLesson.getAllByDepartmentDayNumber((int) session.getAttribute("departmentID"),i,j);
                        day.add(lessons);
                    }
                    week.add(day);
                }
                LessonsArray lessons = new LessonsArray();
                lessons.setLessons(daoLesson.getAllByDepartmentID((int) session.getAttribute("departmentID")));

                // initialize courseNumbers array
                for(int i = 1; i < 7 ; i++){
                    courseNumbers.add("Course #" + i);
                }

                // initialize dayNames array
                dayNames.add("Monday");
                dayNames.add("Tuesday");
                dayNames.add("Wednesday");
                dayNames.add("Thursday");
                dayNames.add("Friday");
                dayNames.add("Saturday");
                dayNames.add("Sunday");

                // initialize lessonsTime array
                lessonsTime = dayRequirementsObject.getLessonsTime();

                // initialize groupNamesByCourse array

                for(int i = 1; i < 7; i++){
                    ArrayList<Group> groups = daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),i);
                    groupNamesByCourse.add(groups);
                }

                daoGroup.closeConnection();
                daoDayRequirements.closeConnection();
                request.setAttribute("week", week);
                request.setAttribute("dayNames", dayNames);
                request.setAttribute("lessonsTime",lessonsTime);
                request.setAttribute("groupNamesByCourse",groupNamesByCourse);
                request.setAttribute("lessons",lessons);
                request.setAttribute("timetablePresent", "yes");
            }else{
                request.setAttribute("timetablePresent", "no");
            }
            request.setAttribute("step", "step0");
            daoLesson.closeConnection();
            request.getRequestDispatcher("Employee/Timetable/Operations/ViewTimetablePage.jsp").forward(request, response);
        }
    }
}
