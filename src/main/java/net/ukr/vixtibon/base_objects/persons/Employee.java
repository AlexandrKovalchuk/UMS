package net.ukr.vixtibon.base_objects.persons;

import java.io.Serializable;

/**
 * Created by alex on 17/01/2016.
 */
public class Employee extends Person implements Serializable {
    private String office;
    private int departmentID;

    public Employee() {
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

    public String getOffice() {
        return office;
    }

}
