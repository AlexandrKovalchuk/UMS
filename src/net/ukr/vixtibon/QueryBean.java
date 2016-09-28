package net.ukr.vixtibon;

/**
 * Created by alex on 06/05/2016.
 */
public class QueryBean {
    private Byte counter = 0;
    private String tableName = null;
    private String fieldName = null;
    private String SfieldData = null;
    private int IfieldData = 0;

    public QueryBean(){
        //System.out.println("QueryBean created");
    }

    public QueryBean(String tableName, String fieldName, String fieldData) {
        //System.out.println("QueryBean1 " );
        this.tableName = tableName;
        this.fieldName = fieldName;
        this.SfieldData = fieldData;
        //System.out.println("QueryBean " +tableName +" " + fieldName + " " +fieldData);
    }
    public QueryBean(String tableName, String fieldName, int fieldData) {
        //System.out.println("QueryBean1 " );
        this.tableName = tableName;
        this.fieldName = fieldName;
        this.IfieldData = fieldData;
        //System.out.println("QueryBean " +tableName +" " + fieldName + " " +fieldData);
    }

    public void show(){
        System.out.println("QueryBean Info " +tableName +" " + fieldName + " " +SfieldData + " " + IfieldData);
    }

    public void setCounter(Byte counter) {
        this.counter = counter;
        //System.out.println("QueryBean setCounter");
    }

    public Byte getCounter() {
        return counter;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
        //System.out.println("QueryBean setTableName");
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
        //System.out.println("QueryBean setFieldName");
    }

    public void setFieldData(String fieldData) {
        this.SfieldData = fieldData;
        //System.out.println("QueryBean setFieldData");
    }
    public void setFieldData(int fieldData) {
        this.IfieldData = fieldData;
        //System.out.println("QueryBean setFieldData");
    }

    public String getTableName() {
        return tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldData(String parameter) {
        return SfieldData;
    }
    public int getFieldData(int parameter) {
        return IfieldData;
    }
}
