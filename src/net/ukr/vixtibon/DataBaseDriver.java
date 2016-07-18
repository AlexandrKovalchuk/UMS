package net.ukr.vixtibon;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

import java.sql.*;

/**
 * Created by alex on 23/04/2016.
 */
public class DataBaseDriver {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/institute";
//?useUnicode=true&characterEncoding=utf-8
    //  Database credentials
    static final String USER = "javatest";
    static final String PASS = "testpass";



    //Tales creation
    //Table creator read info about table from XML file and add table with appropriate fields to data base

    public int findFreeID(String tableName){
        int ID = 0;
        int counter = 0;
        boolean flag = false;

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("findFreeID Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "SELECT  ID FROM " + tableName + ";";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println("findFreeID " + counter + " " + rs.getInt("ID") );
                if(counter == rs.getInt("ID")){
                    counter++;
                }else {
                    flag = true;
                    ID = counter;
                    break;
                }
            }

            if(!flag) {
                ID = counter;
                System.out.println("findFreeID false" + ID);
            }

            rs.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");

        return ID;
    }

    public void deleteItem(String tableName, String queryID){
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "DELETE FROM " + tableName + " WHERE id='" +queryID +"' LIMIT 1;";
            System.out.println("DELETE QUERY is " + sql);
            stmt.executeUpdate(sql);

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    public ArrayList<Chair> getDateChair(String select){
        ArrayList<Chair> objList = new ArrayList<Chair>();
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()){
                Chair i = new Chair();
                i.setLongName(rs.getString("longName"));
                System.out.println("i.setLongName : " + i.getLongName());
                i.setShortName(rs.getString("shortName"));
                System.out.println("i.setShortName : " + i.getShortName());
                i.setID(rs.getInt("ID"));
                System.out.println("i.setID : " + i.getID());
                i.setFacultyID(rs.getInt("facultyID"));
                System.out.println("i.setfacultyID : " + i.getFacultyID());
                objList.add(i);
            }
            rs.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
        return objList;
    }

    public ArrayList<Faculty> getDateFaculty(String select){
        ArrayList<Faculty> objList = new ArrayList<Faculty>();
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()){
                Faculty i = new Faculty();
                i.setLongName(rs.getString("longName"));
                System.out.println("i.setLongName : " + i.getLongName());
                i.setShortName(rs.getString("shortName"));
                System.out.println("i.setShortName : " + i.getShortName());
                i.setID(rs.getInt("ID"));
                System.out.println("i.setID : " + i.getID());
                //i.setInstituteID(rs.getString("instituteID"));
                System.out.println("i.setInstituteID : " + i.getInstituteID());
                objList.add(i);
            }
            rs.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
        return objList;
    }
    public  ArrayList<Institute> getDateInstitute(String select){
        ArrayList<Institute> objList = new ArrayList<Institute>();
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()){
                Institute i = new Institute();
                i.setLongName(rs.getString("longName"));
                i.setShortName(rs.getString("shortName"));
                i.setID(rs.getInt("ID"));
                System.out.println("i.setLongName : " + i.getLongName());
                System.out.println("i.setShortName : " + i.getShortName());
                System.out.println("i.setID : " + i.getID());
                objList.add(i);
            }
            rs.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
        return objList;
    }

    public void getTablesNames(){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            DatabaseMetaData m = conn.getMetaData();
            ResultSet tables = m.getTables(conn.getCatalog(),null,"TAB_%",null);
            for(int i = 0; i < tables.getMetaData().getColumnCount();i++){
                System.out.println("Table name is : " + tables.getMetaData().getTableName(i));
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void selectObject(String st){
        System.out.println("sselectObject");
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(st);

            while (rs.next()){
                Institute i = new Institute();
                i.setLongName(rs.getString("longName"));
                i.setShortName(rs.getString("shortName"));
                i.setID(rs.getInt("ID"));
                System.out.println("i.setLongName : " + i.getLongName());
                System.out.println("i.setShortName : " + i.getShortName());
                System.out.println("i.setID : " + i.getID());
            }
            rs.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    public boolean stringProcessor(String st){
        System.out.println("stringProcessor");
        Connection conn = null;
        Statement stmt = null;
        boolean result = false;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = st;

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
            result = true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            result = false;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            result = false;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            result = false;
        }
        return result;
    }
    public void tableCreator(String pathToXML) {
        System.out.println("tableCreator");
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = createTableString(pathToXML);

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }




    //Tables managing
    //Statement creator read info about statement from array which include names of table field is first row
    //and data in second row
    public void statementCreator(QueryDataToProces qdtp){

    }

    public void statementUpdater(QueryDataToProces qdtp){

    }

    public String updateQuery(QuerySet qs){
        String UpdateQuery = "Update INTO ";

        return UpdateQuery;
    }

    public String insertQuery(QuerySet qs) throws UnsupportedEncodingException {
        String UpdateQuery = "INSERT INTO ";
        String tableName = "";
        String listOfParameters = " (";
        String listOfValues = "VALUES (";
        Short counter = 0;

        for(Map.Entry<String, QueryBean> entry : qs.getSet().entrySet()){
            QueryBean qb = entry.getValue();
            System.out.println("query data " + qb.getFieldName() + " " + qb.getFieldData("") + " " + qb.getFieldData(0));
            if(qb.getTableName()!=null){
                tableName = qb.getTableName();
            }
            listOfParameters += qb.getFieldName();

            listOfValues += (qb.getFieldData("")==null?qb.getFieldData(0):"'" + qb.getFieldData("") + "'");
            //System.out.println("counter " + counter + " qs.getSet().size() " + qs.getSet().size());
            if(counter == (qs.getSet().size() - 1)){
                listOfParameters += ") ";
                listOfValues += ");";
            }else{
                listOfParameters += ", ";
                listOfValues += ", ";
            }
            counter++;
        }
        UpdateQuery += tableName + listOfParameters + listOfValues;
        //byte middle[] = UpdateQuery.getBytes();
        //String result = new String(middle,"UTF-8");
        System.out.println("UpdateQuery: " + UpdateQuery);
        return UpdateQuery;
    }

    public String createTableString(String parametersLocation){
        String CreateTableSQLString = "";
        CreateTableSQLString = CreateTableSQLString + "CREATE TABLE " ;
        try{
            File xmlFile = new File(parametersLocation);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(xmlFile);

            Element root = document.getDocumentElement();
            NodeList nl = root.getChildNodes();
            String primaryKey = "";
;
            for(int i = 0; i < nl.getLength(); i++) {

                Node n = nl.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) n;

                    if (element.getTagName().equals("TableName")) {
                        CreateTableSQLString += element.getTextContent() + " (";
                    }
                    NodeList nlc = n.getChildNodes();
                    String name = "";
                    String type = "";
                    String value = "";
                    String key = "";
                    String fieldprimary = "";
                    String part = "";
                    for (int j = 0; j < nlc.getLength(); j++) {

                        Node nc = nlc.item(j);
                        if (nc.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementC = (Element) nc;


                            if (j == 1) {
                                name += elementC.getTextContent();
                            } else if (j == 3) {
                                type += elementC.getTextContent();
                            } else if (j == 5) {
                                if(!elementC.getTextContent().equals("")){
                                    value += "(" + elementC.getTextContent() + ") ";
                                }else{
                                    value += " ";
                                }

                            } else if (j == 7) {
                                key += elementC.getTextContent();
                            }else if (j == 9) {

                                fieldprimary += elementC.getTextContent();
                                if (fieldprimary.equals("PRIMARY KEY")) {
                                    primaryKey += ", PRIMARY KEY " + "(" + name + ")";

                                } else {
                                    //part += key + ", ";
                                }
                            }
                            //System.out.println("parameters " + name + " " + type + " " + value + " " + key);

                            //if (i != (nl.getLength() - 2)){
                            // part += ", ";
                            //}else {
                            // part += "";
                            //}


                        }
                    }
                    part += name + " " + type  + value  + key;
                    System.out.println("parameters " + part);

                    if (i != (nl.getLength() - 2)) {

                        if (part.equals(" ")) {
                            part = "";
                        }else {
                            part += ", ";
                        }
                    } else {
                        part += primaryKey;
                    }

                    CreateTableSQLString += part;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        CreateTableSQLString +=   ");";
        System.out.println(" CreateTableSQLString : " + CreateTableSQLString);
        return CreateTableSQLString;
    }
}
