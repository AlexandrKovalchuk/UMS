package net.ukr.vixtibon;

import java.util.*;

/**
 * Created by alex on 06/05/2016.
 */
public class QuerySet {

    private Map<String,QueryBean> SetOfBeans = new HashMap<String,QueryBean>();

    public QuerySet(){
        //System.out.println("QuerySet " );
    }

    public void add(QueryBean qb){

        QueryBean q = new QueryBean();
        q.setTableName(qb.getTableName());
        q.setFieldName(qb.getFieldName());
        q.setFieldData(qb.getFieldData(""));
        q.setFieldData(qb.getFieldData(0));

        //System.out.println("QuerySet add 1 " );
        SetOfBeans.put(q.getFieldName(),q);
       // System.out.println("QuerySet add 2 ");
//showQuerySet();
        //System.out.println("QuerySet add 3 ");
    }

public void showSet(){
    //System. out .println("QuerySet contain ");

    for(Map.Entry<String, QueryBean> entry : getSet().entrySet()){
        QueryBean qb = entry.getValue();
        qb.show();
        //System. out .println("QueryBean contain " + " " + qb.getTableName() + " " +  qb.getFieldName() + " " +  qb.getFieldData("") + " " +  qb.getFieldData(0));
    }
}

    public HashMap<String,QueryBean> getSet(){
        //System. out .println("getSet 1 " );
        //showSet();
        return  (HashMap)SetOfBeans;
    }
}
