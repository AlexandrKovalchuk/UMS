package net.ukr.vixtibon.base_objects.study_process;

import java.util.ArrayList;

/**
 * Created by alex on 18/02/2017.
 */
public class StudentAttendanceObject {
    private int id;
    private int disciplineID;
    private int studentID;
    private ArrayList<String> attendance = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public void setDisciplineID(int disciplineID) {
        this.disciplineID = disciplineID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setAttendance(ArrayList<String> attendance) {
        this.attendance = attendance;
    }

    public int getId() {
        return id;
    }

    public int getDisciplineID() {
        return disciplineID;
    }

    public int getStudentID() {
        return studentID;
    }

    public ArrayList<String> getAttendance() {
        return attendance;
    }
}
