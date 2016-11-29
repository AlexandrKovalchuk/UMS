package net.ukr.vixtibon.base_objects.departments;

import net.ukr.vixtibon.QueryBean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by akovalchuk on 5/28/2015.
 */
public class Institute  extends Structure implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Faculty> facultys = new ArrayList<Faculty>();

    public Institute(){}

    public Institute(String longName, String shortName,int ID) {
        super(longName, shortName,ID);

    }

    public ArrayList<Faculty> getFacultys(){
        return facultys;
    }

    public void setFacultys(ArrayList<Faculty> facultiesList ){
        this.facultys = facultiesList;
    }

    public void addFaculty(Faculty f){
        facultys.add(f);
    }

}
