package net.ukr.vixtibon.base_objects.study_process;

/**
 * Created by alex on 03/02/2017.
 */
public class DisciplineTeacherDependencyObject {
    int id;
    int disciplineID;
    int teacherID;

    public DisciplineTeacherDependencyObject(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setDisciplineID(int disciplineID) {
        this.disciplineID = disciplineID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getId() {
        return id;
    }

    public int getDisciplineID() {
        return disciplineID;
    }

    public int getTeacherID() {
        return teacherID;
    }
}
