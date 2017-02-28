package net.ukr.vixtibon.base_objects.study_process;

import net.ukr.vixtibon.base_objects.persons.Teacher;

import java.io.Serializable;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Lesson implements Serializable {
    private int ID;
    private int dayNumber;
    private int lessonNumberInDay;
    private int groupID;
    private int disciplineID;
    private int departmentID;
    private int teacherID;

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public void setLessonNumberInDay(int lessonNumberInDay) {
        this.lessonNumberInDay = lessonNumberInDay;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setDisciplineID(int disciplineID) {
        this.disciplineID = disciplineID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getID() {
        return ID;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public int getLessonNumberInDay() {
        return lessonNumberInDay;
    }

    public int getGroupID() {
        return groupID;
    }

    public int getDisciplineID() {
        return disciplineID;
    }

    public int getTeacherID() {
        return teacherID;
    }
}
