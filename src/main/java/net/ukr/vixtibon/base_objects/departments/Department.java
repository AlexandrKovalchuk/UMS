package net.ukr.vixtibon.base_objects.departments;

import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.Group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Department extends Structure implements Serializable {
    private static final long serialVersionUID = 1L;
    private int facultyID;

    private ArrayList<Group> Groups1 = new ArrayList<Group>();
    private ArrayList<Group> Groups2 = new ArrayList<Group>();
    private ArrayList<Group> Groups3 = new ArrayList<Group>();
    private ArrayList<Group> Groups4 = new ArrayList<Group>();
    private ArrayList<Group> Groups5 = new ArrayList<Group>();
    private ArrayList<Group> Groups6 = new ArrayList<Group>();

    private ArrayList<Teacher> Teachers = new ArrayList<Teacher>();
    private ArrayList<Employee> Employees = new ArrayList<Employee>();
    private ArrayList<Discipline> Disciplines = new ArrayList<Discipline>();

    Calendar semesterStart = Calendar.getInstance();
    Calendar semesterEnd = Calendar.getInstance();

    public Department(){}

    public Department(String longName, String shortName, int ID, int facultyID) {
        super(longName, shortName,ID);
        this.facultyID = facultyID;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        Teachers = teachers;
    }

    public ArrayList<Teacher> getTeachers() {
        return Teachers;
    }

    public void setEmployees(ArrayList<Employee> employees){
        this.Employees = employees;
    }

    public ArrayList<Employee> getEmployees(){
        return Employees;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines){this.Disciplines = disciplines;}

    public ArrayList<Discipline> getDisciplines(){
        return Disciplines;
    }

    public ArrayList<Group> getGroups1() {
        return Groups1;
    }

    public ArrayList<Group> getGroups2() {
        return Groups2;
    }

    public ArrayList<Group> getGroups3() {
        return Groups3;
    }

    public ArrayList<Group> getGroups4() {
        return Groups4;
    }

    public ArrayList<Group> getGroups5() {
        return Groups5;
    }

    public ArrayList<Group> getGroups6() {
        return Groups6;
    }

    public void setGroups1(ArrayList<Group> groups1) {
        Groups1 = groups1;
    }

    public void setGroups2(ArrayList<Group> groups2) {
        Groups2 = groups2;
    }

    public void setGroups3(ArrayList<Group> groups3) {
        Groups3 = groups3;
    }

    public void setGroups4(ArrayList<Group> groups4) {
        Groups4 = groups4;
    }

    public void setGroups5(ArrayList<Group> groups5) {
        Groups5 = groups5;
    }

    public void setGroups6(ArrayList<Group> groups6) {
        Groups6 = groups6;
    }

    public void setAllGroups(ArrayList<Group> allGroups){
        for(Group group: allGroups){
            if(group.getCourseNumber() == 1){
                getGroups1().add(group);
            }else if(group.getCourseNumber() == 2){
                getGroups2().add(group);
            }else if(group.getCourseNumber() == 3){
                getGroups3().add(group);
            }else if(group.getCourseNumber() == 4){
                getGroups4().add(group);
            }else if(group.getCourseNumber() == 5){
                getGroups5().add(group);
            }else if(group.getCourseNumber() == 6){
                getGroups6().add(group);
            }
        }
    }

    public ArrayList<Group> getAllGroups(){
        ArrayList<Group> groups = new ArrayList<Group>();
        for(Group group: Groups1){
            groups.add(group);
        }
        for(Group group: Groups2){
            groups.add(group);
        }
        for(Group group: Groups3){
            groups.add(group);
        }
        for(Group group: Groups4){
            groups.add(group);
        }
        for(Group group: Groups5){
            groups.add(group);
        }
        for(Group group: Groups6){
            groups.add(group);
        }
        return groups;
    }
}
