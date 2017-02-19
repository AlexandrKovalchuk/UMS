package net.ukr.vixtibon.base_objects.persons;

import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.StudentAttendanceObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String indexBook;
    private int index;
    private int groupID;
    private HashMap<Integer, Discipline> Disciplines;
    private HashMap<Integer, StudentAttendanceObject> Attendance;
    private HashMap<Integer, StudentAttendanceObject> Progress;

    public Student() {
    }

    public void setDisciplines(HashMap<Integer, Discipline> disciplines) {
        Disciplines = disciplines;
    }

    public void setAttendance(HashMap<Integer, StudentAttendanceObject> attendance) {
        Attendance = attendance;
    }

    public void setProgress(HashMap<Integer, StudentAttendanceObject> progress) {
        Progress = progress;
    }

    public HashMap<Integer, Discipline> getDisciplines() {
        return Disciplines;
    }

    public HashMap<Integer, StudentAttendanceObject> getAttendance() {
        return Attendance;
    }

    public HashMap<Integer, StudentAttendanceObject> getProgress() {
        return Progress;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setIndexBook(String indexBook) {
        this.indexBook = indexBook;
    }

    public void setIndex(int index) {
        this.index = index;
        String str = "";
    }

    public String getIndexBook() {
        return indexBook;
    }

    public int getIndex() {
        return index;
    }

}
