package net.ukr.vixtibon.base_objects.departments;

import net.ukr.vixtibon.QueryBean;
import net.ukr.vixtibon.QuerySet;

/**
 * Created by akovalchuk on 6/4/2015.
 */
public abstract class Structure {

    private String longName;
    private String shortName;
    private int ID;
    public Structure(){}

    public Structure(String longName, String shortName,int ID) {
        this.longName = longName;
        this.shortName = shortName;
        this.ID = ID;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getID(){return ID;}


}
