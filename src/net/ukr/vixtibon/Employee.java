package net.ukr.vixtibon;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by alex on 17/01/2016.
 */
public class Employee extends Person implements Serializable {
    private String office;
    private String faculty;
    private String chair;
    private String fullIdentifier;
    private int chairID;

    public Employee() {
    }

    public Employee(int ID, String name, String secondName, String surname, String personalID, String sex, String email, String phoneNumber,
                   Calendar dateOfBorn, String address, String pasport, String office, String faculty, String chair, int chairID) {
        super(ID, name, secondName, surname, personalID, sex, email, phoneNumber, dateOfBorn, address, pasport);
        this.office = office;
        qs.add(new QueryBean("Employee","office",office));
        this.faculty = faculty;
        qs.add(new QueryBean("Employee","faculty",faculty));
        this.chair = chair;
        qs.add(new QueryBean("Employee","chair",chair));
        setFullIdentifier();
        qs.add(new QueryBean("Employee","fullIdentifier",fullIdentifier));
        this.chairID = chairID;
        qs.add(new QueryBean("Employee","chairID",chairID));
    }

    public int getChairID() {
        return chairID;
    }

    public void setChairID(int chairID) {
        this.chairID = chairID;
    }

    public void setFullIdentifier() {
        this.fullIdentifier = getFirstLetter(getName())+getFirstLetter(getSecondName())+getSex()+getPersonalID();
        updateQuerySetParameter("fullIdentifier",fullIdentifier);
    }

    public String getFullIdentifier() {
        return fullIdentifier;
    }

    public void setOffice(String office) {
        this.office = office;
        updateQuerySetParameter("office",office);
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

    public String getFaculty() {
        return faculty;
    }

    public String getChair() {
        return chair;
    }

    public void showInfo(){
        System. out .println("Date " + dateOfBorn);
        System. out .println("Name : " + getName() + "  " + getSecondName());
        System. out .println("Office : " + office);
        System. out .println("faculty : " + faculty);
        System. out .println("chair : " + chair);

    }
}
