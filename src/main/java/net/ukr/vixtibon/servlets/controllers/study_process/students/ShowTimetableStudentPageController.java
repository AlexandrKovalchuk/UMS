package net.ukr.vixtibon.servlets.controllers.study_process.students;

import net.ukr.vixtibon.base_objects.study_process.DayRequirementsObject;
import net.ukr.vixtibon.base_objects.study_process.Group;
import net.ukr.vixtibon.base_objects.study_process.Lesson;
import net.ukr.vixtibon.base_objects.study_process.LessonsArray;
import net.ukr.vixtibon.dao.stady_process.DAODayRequirements;
import net.ukr.vixtibon.dao.stady_process.DAOGroup;
import net.ukr.vixtibon.dao.stady_process.DAOLesson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ShowTimetableStudentPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("StudentMenuPageController").forward(request, response);
            }else{
                request.setAttribute("result", "wrongParameter");
                request.getRequestDispatcher("ActionResultStudentMenuPageController").forward(request, response);
            }
        }else{
            DAOLesson daoLesson = new DAOLesson();

            if(daoLesson.getCountByDepartmentID((int) session.getAttribute("departmentID"))>0){
                DAODayRequirements daoDayRequirements = new DAODayRequirements();
                DAOGroup daoGroup = new DAOGroup();

                DayRequirementsObject dayRequirementsObject = daoDayRequirements.getEntityByDepartmentID((int) session.getAttribute("departmentID"));

                ArrayList<ArrayList<ArrayList<Lesson>>> week = new ArrayList<>();
                ArrayList<String> dayNames = new ArrayList<>();
                ArrayList<String> lessonsTime ;
                ArrayList<ArrayList<Group>> groupNamesByCourse = new ArrayList<>();
                ArrayList<String> courseNumbers = new ArrayList<>();

                for(int i = 0; i < dayRequirementsObject.getCountOfDaysInWeek(); i++){
                    ArrayList<ArrayList<Lesson>> day = new ArrayList<>();
                    for(int j = 0; j < dayRequirementsObject.getCountOfLessonsInADay(); j++){
                        ArrayList<Lesson> lessons = daoLesson.getAllByDepartmentDayNumber((int) session.getAttribute("departmentID"),i,j);
                        day.add(lessons);
                    }
                    week.add(day);
                }
                LessonsArray lessons = new LessonsArray();
                lessons.setLessons(daoLesson.getAllByDepartmentID((int) session.getAttribute("departmentID")));

                for(int i = 1; i < 7 ; i++){
                    courseNumbers.add("Course #" + i);
                }
                dayNames.add("Monday");
                dayNames.add("Tuesday");
                dayNames.add("Wednesday");
                dayNames.add("Thursday");
                dayNames.add("Friday");
                dayNames.add("Saturday");
                dayNames.add("Sunday");
                lessonsTime = dayRequirementsObject.getLessonsTime();

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
            daoLesson.closeConnection();
            request.getRequestDispatcher("StudyProgress/ShowTimeTableStudentPage.jsp").forward(request, response);
        }
    }
}
