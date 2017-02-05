package net.ukr.vixtibon.base_objects.persons;

import net.ukr.vixtibon.base_objects.study_process.Discipline;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Teacher extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String office;
    private String level;
    private int departmentID;
    private ArrayList<Discipline> disciplines = new ArrayList<>();

    public Teacher() {
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOffice() {
        return office;
    }

    public String getLevel() {
        return level;
    }

    public void setDisciplines(ArrayList<Discipline> discipline){
        this.disciplines = discipline;
    }
    public ArrayList<Discipline> getDisciplines(){
        return  disciplines;
    }
}
