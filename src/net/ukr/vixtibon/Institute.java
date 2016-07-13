package net.ukr.vixtibon;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by akovalchuk on 5/28/2015.
 */
public class Institute  extends Structure implements Serializable {
    private static final long serialVersionUID = 1L;
    public ArrayList<Faculty> facultys = new ArrayList<Faculty>();

    public Institute(){}

    public Institute(String longName, String shortName,int ID, String tName) {
        super(longName, shortName,ID, tName);

    }

    public ArrayList<Faculty> getFacultys(){
        return facultys;
    }

    public void addFaculty(Faculty f){
        facultys.add(f);
        QueryBean qb = new QueryBean();
        //System. out .println("point 2 " + qs.getSet().get("Discipline").getTableName());
        if(qs.getSet().containsKey("FacultysIDList")) {
            qb.setTableName(qs.getSet().get("FacultysIDList").getTableName());
            qb.setFieldName(qs.getSet().get("FacultysIDList").getFieldName());
            qb.setFieldData(qs.getSet().get("FacultysIDList").getFieldData(0));
        }else{
            qb.setTableName("Institute");
            qb.setFieldName("FacultysIDList");
            qb.setFieldData("");
        }
        // System. out .println("point 3 " );
        String data = qb.getFieldData("");
        //System. out .println("point 4 " );
        data += f.getID()  + "#";
        // System. out .println("point 4 " + data);
        qb.setFieldData(data);
        qs.add(qb);
    }

}
