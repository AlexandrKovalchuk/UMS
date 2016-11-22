package net.ukr.vixtibon.base_objects.persons;

import net.ukr.vixtibon.base_objects.stady_process.Discipline;
import net.ukr.vixtibon.QueryBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

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

    public Teacher(int ID, String name, String secondName, String surname, String personalID, String sex, String email, String phoneNumber,
                   Calendar dateOfBorn, String address, String pasport, String office, String level,  int chairID) {
        super(ID,name, secondName, surname, personalID, sex, email, phoneNumber, dateOfBorn, address, pasport);
        this.office = office;
        qs.add(new QueryBean("Teacher","office",office));
        this.level = level;
        qs.add(new QueryBean("Teacher","level",level));
        qs.add(new QueryBean("Teacher","DisciplinesList",""));
        this.chairID = chairID;
        qs.add(new QueryBean("Teacher","chairID",chairID));
    }

    public int getChairID() {
        return chairID;
    }

    public void setChairID(int chairID) {
        this.chairID = chairID;
    }

    public void setOffice(String office) {
        this.office = office;
        updateQuerySetParameter("office",office);
    }

    public void setLevel(String level) {
        this.level = level;
        updateQuerySetParameter("level",level);
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
        updateQuerySetParameter("faculty",faculty);
    }

    public void setChair(String chair) {
        this.chair = chair;
        updateQuerySetParameter("chair",chair);
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
       // System. out .println("point 1 " );
        QueryBean qb = new QueryBean();
        //System. out .println("point 2 " + qs.getSet().get("Discipline").getTableName());
        if(qs.getSet().containsKey("DisciplinesList")) {
            qb.setTableName(qs.getSet().get("DisciplinesList").getTableName());
            qb.setFieldName(qs.getSet().get("DisciplinesList").getFieldName());
            qb.setFieldData(qs.getSet().get("DisciplinesList").getFieldData(0));
        }else{
            qb.setTableName("Teacher");
            qb.setFieldName("DisciplinesList");
            qb.setFieldData("");
        }
       // System. out .println("point 3 " );
        String data = qb.getFieldData("");
        //System. out .println("point 4 " );
        data += disciplineName.getID()  + "#";
       // System. out .println("point 4 " + data);
        qb.setFieldData(data);
        qs.add(qb);
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
