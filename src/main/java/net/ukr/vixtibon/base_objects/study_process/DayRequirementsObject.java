package net.ukr.vixtibon.base_objects.study_process;

import java.util.ArrayList;

/**
 * Created by alex on 24/02/2017.
 */
public class DayRequirementsObject {
    private int ID;
    private int departmentID;
    private int countOfDaysInWeek;
    private int countOfLessonsInADay;
    private ArrayList<String> lessonsTime = new ArrayList<>();

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setCountOfDaysInWeek(int countOfDaysInWeek) {
        this.countOfDaysInWeek = countOfDaysInWeek;
    }

    public void setCountOfLessonsInADay(int countOfLessonsInADay) {
        this.countOfLessonsInADay = countOfLessonsInADay;
    }

    public void setLessonsTime(ArrayList<String> lessonsTime) {
        this.lessonsTime = lessonsTime;
    }

    public int getID() {
        return ID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public int getCountOfDaysInWeek() {
        return countOfDaysInWeek;
    }

    public int getCountOfLessonsInADay() {
        return countOfLessonsInADay;
    }

    public ArrayList<String> getLessonsTime() {
        return lessonsTime;
    }
}
