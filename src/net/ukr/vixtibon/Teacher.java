package net.ukr.vixtibon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Teacher extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String office;
    private String level;
    private String faculty;
    private String chair;
    private String fullIdentifier;
    private int chairID;

    public void setFullIdentifier() {
        this.fullIdentifier = getFirstLetter(getName())+getFirstLetter(getSecondName())+getSex()+getPersonalID();
    }

    public String getFullIdentifier() {

        return fullIdentifier;
    }

    ArrayList<Discipline> disciplines = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(int ID, String name, String secondName, String surname, String personalID, String sex, String email, String phoneNumber,
                   Calendar dateOfBorn, String address, String pasport, String office, String level, String faculty, String chair, int chairID) {
        super(ID,name, secondName, surname, personalID, sex, email, phoneNumber, dateOfBorn, address, pasport);
        this.office = office;
        qs.add(new QueryBean("Teacher","office",office));
        this.level = level;
        qs.add(new QueryBean("Teacher","level",level));
        this.faculty = faculty;
        qs.add(new QueryBean("Teacher","faculty",faculty));
        this.chair = chair;
        qs.add(new QueryBean("Teacher","chair",chair));
        setFullIdentifier();
        qs.add(new QueryBean("Teacher","fullIdentifier",fullIdentifier));
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
}
