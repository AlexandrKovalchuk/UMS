package net.ukr.vixtibon;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by akovalchuk on 5/28/2015.
 */
public class Faculty extends Structure implements Serializable {
    private static final long serialVersionUID = 1L;
    private int instituteID ;
    ArrayList<Chair> Chairs = new ArrayList<Chair>();

    public Faculty(){}

    public Faculty(String longName, String shortName,int ID, String tName, int instID) {
        super(longName, shortName,ID, tName);
        this.instituteID = instID;
        qs.add(new QueryBean(null,"instituteID",instituteID));
    }

    public int getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(int instituteID) {
        this.instituteID = instituteID;
    }

    public void addChair(Chair c){
        Chairs.add(c);

        QueryBean qb = new QueryBean();
        //System. out .println("point 2 " + qs.getSet().get("Discipline").getTableName());
        if(qs.getSet().containsKey("ChairsList")) {
            qb.setTableName(qs.getSet().get("ChairsList").getTableName());
            qb.setFieldName(qs.getSet().get("ChairsList").getFieldName());
            qb.setFieldData(qs.getSet().get("ChairsList").getFieldData(0));
        }else{
            qb.setTableName("Faculty");
            qb.setFieldName("ChairsList");
            qb.setFieldData("");
        }
        // System. out .println("point 3 " );
        String data = qb.getFieldData("");
        //System. out .println("point 4 " );
        data += c.getID()  + "#";
        // System. out .println("point 4 " + data);
        qb.setFieldData(data);
        qs.add(qb);
    }

}
