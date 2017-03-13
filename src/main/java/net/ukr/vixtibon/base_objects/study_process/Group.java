package net.ukr.vixtibon.base_objects.study_process;

import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.Timetable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ID;
    private String fullGroupName;
    private int courseNumber;
    private int departmentID;

    Timetable groupTimeTable = new Timetable();
    ArrayList<Discipline> DisciplineList = new ArrayList<>();
    ArrayList<Student> StudentsList = new ArrayList<Student>();

    public Group(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public  ArrayList<Student> getStudentsList(){
        return StudentsList;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getStudentsCount(){
        return StudentsList.size();
    }

    public int getCourseNumber() {
        return courseNumber;
    }


    public String getFullGroupName() {
        return fullGroupName;
    }

    public void setFullGroupName(String fullGroupName){
        this.fullGroupName = fullGroupName;
    }
    public void setStudents (ArrayList<Student> st){
        StudentsList = st;
    }
    public ArrayList<Student> getStudents(){
        return StudentsList;
    }


}
