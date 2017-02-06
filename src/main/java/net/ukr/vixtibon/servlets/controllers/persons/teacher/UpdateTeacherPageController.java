package net.ukr.vixtibon.servlets.controllers.persons.teacher;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.DisciplineTeacherDependencyObject;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.persons.DAOTeacher;
import net.ukr.vixtibon.dao.stady_process.DAODiscipline;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineTeacherDependencyObject;

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

/**
 * Created by alex on 05/02/2017.
 */
public class UpdateTeacherPageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(request.getParameterMap().containsKey("step")){
            DAOTeacher daot = new DAOTeacher();
            DAODiscipline daodi = new DAODiscipline();
            DAODisciplineTeacherDependencyObject daodtdo = new DAODisciplineTeacherDependencyObject();
            if(request.getParameter("step").equals("step1")){
                Teacher teacher = daot.getEntityById(Integer.parseInt(request.getParameter("teacherID")));
                ArrayList<DisciplineTeacherDependencyObject> dtdos = daodtdo.getAllByTeacherID(teacher.getID());

                for(DisciplineTeacherDependencyObject dtdo: dtdos){
                    teacher.getDisciplines().add(daodi.getEntityById(dtdo.getDisciplineID()));
                }

                ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
                disciplines = daodi.getAllByDepartmentID((int) session.getAttribute("departmentID"));

                for(Discipline d: teacher.getDisciplines()){
                    for(Discipline dd: disciplines)
                        if(d.getID() == dd.getID()){
                            disciplines.remove(dd);
                            break;
                        }else{
                            continue;
                        }
                }



                request.setAttribute("selected", "yes");
                request.setAttribute("teacher", teacher);
                request.setAttribute("disciplines", disciplines);
                request.getRequestDispatcher("Employee/Teacher/Operations/UpdateTeacherPage.jsp").forward(request, response);
            }else if(request.getParameter("step").equals("step2")){
                Teacher teacher = new Teacher();
                boolean result = false;
                teacher.setName(request.getParameter("name"));
                teacher.setlastName(request.getParameter("lastName"));
                teacher.setfathersName(request.getParameter("fathersName"));
                teacher.setPersonalID(request.getParameter("personalID"));
                teacher.setSex(request.getParameter("sex"));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                String dateInString = ""+request.getParameter("bday")+"-"+request.getParameter("bmonth")+"-"+request.getParameter("byear")+" 10:20:56";
                Date date = new Date();
                try {
                    date = sdf.parse(dateInString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                teacher.setDateOfBorn(date);
                teacher.setEmail(request.getParameter("email"));
                teacher.setPhoneNumber(request.getParameter("phoneNumber"));
                teacher.setAddress(request.getParameter("address"));
                teacher.setPasport(request.getParameter("pasport"));
                teacher.setOffice(request.getParameter("office"));
                teacher.setLevel(request.getParameter("level"));
                teacher.setLogin(request.getParameter("login"));
                teacher.setID(Integer.parseInt(request.getParameter("teacherID")));
                teacher.setDepartmentID(Integer.parseInt(request.getParameter("departmentID")));
                String[] disciplines = request.getParameterValues("discipline");

                if(disciplines != null) {
                    for (String disciplineID : disciplines) {
                        teacher.getDisciplines().add(daodi.getEntityById(Integer.parseInt(disciplineID)));
                    }
                }

                result = daot.update(teacher);

                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "teacher");
                }else{
                    request.setAttribute("menu", "teacher");
                    request.setAttribute("result", "unsuccess");
                }
                daodtdo.closeConnection();
                daodi.closeConnection();
                daot.closeConnection();
                request.getRequestDispatcher("ActionResultEmployeeMenuPageController").forward(request, response);
            }else if(request.getParameter("step").equals("cancel")){
                request.getRequestDispatcher("DisciplinePageController").forward(request, response);
            }else{
                //error page
            }
        }else{
            DAODepartment daod = new DAODepartment();
            DAOTeacher daot = new DAOTeacher();
            ArrayList<Department> departments = new ArrayList<Department>();
            Department department = daod.getEntityById((int) session.getAttribute("departmentID"));
            Department departmentNone = daod.getEntityById(0);
            departmentNone.setTeachers(daot.getAllByDepartmentID(0));
            department.setTeachers(daot.getAllByDepartmentID((int) session.getAttribute("departmentID")));
            departments.add(departmentNone);
            departments.add(department);
            daot.closeConnection();
            daod.closeConnection();
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("Employee/Teacher/Operations/UpdateTeacherPage.jsp").forward(request, response);
        }
    }
}
