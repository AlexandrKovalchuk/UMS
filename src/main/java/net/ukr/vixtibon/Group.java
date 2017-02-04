package net.ukr.vixtibon;

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
    private int wave;
    private int groupIndex;
    private String fullGroupName;
    private int ID;
    private int departmentID;
    private int courseNumber;

    Timetable groupTimeTable = new Timetable();
    ArrayList<Discipline> DisciplineList = new ArrayList<>();
    ArrayList<Student> StudentsList = new ArrayList<Student>();

    public Group(){}

    public Group(int ID, String fullGroupName, int courseNumber, int chairID){
        this.ID = ID;
        this.fullGroupName = fullGroupName;
        this.courseNumber = courseNumber;
        this.chairID = chairID;
    }

    public Group(int wave,int ID, int chairID) {
        this.wave = wave;
        this.chairID = chairID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public  ArrayList<Student> getStudentsList(){
        return StudentsList;
    }

    public int getChairID() {
        return chairID;
    }

    public void setChairID(int chairID) {
        this.chairID = chairID;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }

    public void setGroupIndex(int groupIndex) {
        this.groupIndex = groupIndex;
    }

    public int getWave() {
        return wave;
    }

    public int getGroupIndex() {
        return groupIndex;
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

    public void setFullGroupName(String chairShortName){
        fullGroupName = chairShortName + "-" + wave + groupIndex;
    }
    public void setSetStudents (ArrayList<Student> st){
        StudentsList = st;
    }
    public void setFGN(String name){
        this.fullGroupName = name;
    }
    public void addStudent(Student student){
        StudentsList.add(student);
    }

    public void deleteStudent(int index){
        StudentsList.remove(index);
    }


}
