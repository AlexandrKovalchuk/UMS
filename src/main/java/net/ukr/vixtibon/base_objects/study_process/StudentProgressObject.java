package net.ukr.vixtibon.base_objects.study_process;

import java.util.ArrayList;

/**
 * Created by alex on 19/02/2017.
 */
public class StudentProgressObject {
    private int id;
    private int disciplineID;
    private int studentID;
    private String examResult;
    private ArrayList<String> progress = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public void setDisciplineID(int disciplineID) {
        this.disciplineID = disciplineID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }

    public void setProgress(ArrayList<String> progress) {
        this.progress = progress;
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

    public String getExamResult() {
        return examResult;
    }

    public ArrayList<String> getProgress() {
        return progress;
    }
}
