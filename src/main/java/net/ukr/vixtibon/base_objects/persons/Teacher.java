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
    private String faculty;
    private String chair;
    private int chairID;

    ArrayList<Discipline> disciplines = new ArrayList<>();

    public ArrayList<Discipline> getDisciplines(){
        return  disciplines;
    }

    public Teacher() {
    }


    public int getChairID() {
        return chairID;
    }

    public void setChairID(int chairID) {
        this.chairID = chairID;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getOffice() {
        return office;
    }

    public String getLevel() {
        return level;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getChair() {
        return chair;
    }

    public void addDiscipline(Discipline disciplineName){

        disciplines.add(disciplineName);
    }

    public void showInfo(){
        System. out .println("Date " );
        System. out .println("Name : " + getName() + "  " + getSecondName());
        System. out .println("Level : " + getLevel());
        System. out .println("Office : " + getOffice());

        for (Discipline d: disciplines){
            System. out .println(" discipline : " + d.getNameOfDiscipline());
        }
    }

    public void setDisciplines(String info){
        System. out .println("setDisciplines in progress");
    }
}
