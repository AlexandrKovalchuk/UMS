package net.ukr.vixtibon.base_objects.study_process;

/**
 * Created by alex on 07/02/2017.
 */
public class DisciplineDepartmentDependencyObject {
    private int ID;
    private int disciplineID;
    private int departmentID;
    private int courseNumber;
    private int semesterNumber;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDisciplineID(int disciplineID) {
        this.disciplineID = disciplineID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public int getID() {
        return ID;
    }

    public int getDisciplineID() {
        return disciplineID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }
}
