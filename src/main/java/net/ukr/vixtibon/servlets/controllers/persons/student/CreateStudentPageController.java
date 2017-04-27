package net.ukr.vixtibon.servlets.controllers.persons.student;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.DisciplineDepartmentDependencyObject;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.persons.DAOStudent;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineDepartmentDependency;
import net.ukr.vixtibon.dao.stady_process.DAOGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CreateStudentPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            if(request.getParameter("step").equals("step1")){
                request.setAttribute("groupID", request.getParameter("groupID"));
                request.setAttribute("selected", "yes");
                request.getRequestDispatcher("Student/Operations/CreateStudentPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")) {
                DAOStudent daos = new DAOStudent();
                Student student = new Student();
                boolean result = false;
                student.setName(request.getParameter("name"));
                student.setlastName(request.getParameter("lastName"));
                student.setfathersName(request.getParameter("fathersName"));
                student.setPersonalID(request.getParameter("personalID"));
                student.setSex(request.getParameter("sex"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                String dateInString = ""+request.getParameter("bday")+"-"+request.getParameter("bmonth")+"-"+request.getParameter("byear")+" 10:20:56";
                Date date = new Date();
                try {
                    date = sdf.parse(dateInString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                student.setDateOfBorn(date);
                student.setEmail(request.getParameter("email"));
                student.setPhoneNumber(request.getParameter("phoneNumber"));
                student.setAddress(request.getParameter("address"));
                student.setPasport(request.getParameter("pasport"));
                student.setIndexBook(request.getParameter("indexBook"));
                student.setLogin(request.getParameter("login"));
                student.setGroupID(Integer.parseInt(request.getParameter("groupID")));

                DAODisciplineDepartmentDependency daodddo = new DAODisciplineDepartmentDependency();
                ArrayList<DisciplineDepartmentDependencyObject> dddos = daodddo.getAllByDepartmentID((int) session.getAttribute("departmentID"));

                HashMap<Integer, Discipline> disciplines = new HashMap<>();
                DAODiscipline daodi = new DAODiscipline();

                for(DisciplineDepartmentDependencyObject dddo: dddos){
                    Discipline discipline = daodi.getEntityById(dddo.getDisciplineID());
                    disciplines.put(discipline.getID(),discipline);
                }

                student.setDisciplines(disciplines);

                try {
                    result = daos.create(student);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (result) {
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "student");
                } else {
                    request.setAttribute("menu", "student");
                    request.setAttribute("result", "unsuccess");
                }
                daos.closeConnection();
                request.getRequestDispatcher("/Employee/ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("/Employee/StudentPageController").forward(request, response);
            }else{
                request.setAttribute("menu", "student");
                request.setAttribute("error", "incorrectValue");
                request.getRequestDispatcher("/Employee/ActionResultEmployeeMenuPageController").forward(request, response);
            }
        }else{
            DAODepartment daod = new DAODepartment();
            DAOGroup daoGroup = new DAOGroup();

            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));

            department.setGroups1(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),1));
            department.setGroups2(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),2));
            department.setGroups3(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),3));
            department.setGroups4(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),4));
            department.setGroups5(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),5));
            department.setGroups6(daoGroup.getAllByDepartmentID((int) session.getAttribute("departmentID"),6));

            daoGroup.closeConnection();
            daod.closeConnection();
            request.setAttribute("department", department);
            request.getRequestDispatcher("Student/Operations/CreateStudentPage.jsp").forward(request, response);
        }
    }
}
