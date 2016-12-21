package net.ukr.vixtibon.base_objects.departments;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by akovalchuk on 5/28/2015.
 */
public class Faculty extends Structure implements Serializable {
    private static final long serialVersionUID = 1L;
    private int instituteID ;
    private ArrayList<Department> Departments = new ArrayList<Department>();

    public Faculty(){}

    public Faculty(String longName, String shortName,int ID, int instituteID) {
        super(longName, shortName,ID);
        this.instituteID = instituteID;
    }

    public int getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(int instituteID) {
        this.instituteID = instituteID;
    }

    public void setDepartments(ArrayList<Department> departments){
        this.Departments = departments;
    }

    public ArrayList<Department> getDepartments( ){
        return Departments;
    }
/*
    public void addDepartment(Department c){
        Departments.add(c);
    }
*/
}
