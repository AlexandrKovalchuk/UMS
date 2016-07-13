package net.ukr.vixtibon;

import java.util.Random;

/**
 * Created by akovalchuk on 6/4/2015.
 */
public abstract class Structure {

    private String longName;
    private String shortName;
    private int ID;

    public QuerySet qs = new QuerySet();
    public Structure(){}

    public Structure(String longName, String shortName,int ID,String tName) {
        this.longName = longName;
        //System.out.println("Structure 1 " + longName);

        qs.add(new QueryBean(tName,"longName",longName));
        //System.out.println("Structure 2");
        this.shortName = shortName;
        //System.out.println("Structure 3");
        qs.add(new QueryBean(tName,"shortName",shortName));
        //System.out.println("Structure 4");
        qs.add(new QueryBean(tName,"ID",ID));
    }

    public void updateQuerySetParameter(String key, String update){
        QueryBean qb = new QueryBean();
        if(qs.getSet().containsKey(key)) {
            qb.setTableName(qs.getSet().get(key).getTableName());
            qb.setFieldName(qs.getSet().get(key).getFieldName());

        }else{
            qb.setTableName(null);
            qb.setFieldName(key);
        }
        qb.setFieldData(update);
        qs.add(qb);
    }
    public void updateQuerySetParameter(String key, int update){
        QueryBean qb = new QueryBean();
        if(qs.getSet().containsKey(key)) {
            qb.setTableName(qs.getSet().get(key).getTableName());
            qb.setFieldName(qs.getSet().get(key).getFieldName());

        }else{
            qb.setTableName(null);
            qb.setFieldName(key);
        }
        qb.setFieldData(update);
        qs.add(qb);
    }

    public void setLongName(String longName) {
        this.longName = longName;
        updateQuerySetParameter("longName",longName);
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
        updateQuerySetParameter("shortName",shortName);
    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getID(){return ID;}

    public void setID(int ID){
        this.ID = ID;
        updateQuerySetParameter("ID",ID);
    }
}
