package net.ukr.vixtibon;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by alex on 17/01/2016.
 */
public class Employee extends Person implements Serializable {
    private String office;
    private int chairID;

    public Employee() {
    }

    public Employee(int ID, String name, String secondName, String surname, String personalID, String sex, String email, String phoneNumber,
                   Calendar dateOfBorn, String address, String pasport, String office, int chairID) {
        super(ID, name, secondName, surname, personalID, sex, email, phoneNumber, dateOfBorn, address, pasport);
        this.office = office;
        qs.add(new QueryBean("Employee","office",office));
        this.chairID = chairID;
        qs.add(new QueryBean("Employee","chairID",chairID));
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

    public String getOffice() {
        return office;
    }

    public void showInfo(){
        System. out .println("Date " + dateOfBorn);
        System. out .println("Name : " + getName() + "  " + getSecondName());
        System. out .println("Office : " + office);

    }
}
