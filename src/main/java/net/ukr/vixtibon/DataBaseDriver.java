package net.ukr.vixtibon;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.stady_process.Discipline;
import net.ukr.vixtibon.base_objects.stady_process.Timetable;
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

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/institute";
    static final String USER = "javatest";
    static final String PASS = "testpass";

    Connection conn = null;
    Statement stmt = null;


//Tales creation function
//Table creator read info about table from XML file and add table with appropriate fields to data base

public boolean connectionCheck(){
    boolean reachable = false;
    System.out.println("connectionCheck 1" + reachable);
    try {
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        reachable = conn.isValid(10);
        System.out.println("connectionCheck 2" + reachable);
        return reachable;
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("connectionCheck 3" + reachable);
        return reachable;
    }
}

public void tableCreator(String pathToXML) {
    System.out.println("tableCreator");
    try {
        //STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        String sql = createTableString(pathToXML);
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
// get object functions
    // get institute objects ------------------------------------------------------------------------------------------
public  ArrayList<Institute> getDateInstitute(String select){
    ArrayList<Institute> objList = new ArrayList<Institute>();
    try {
        //STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(select);

        while (rs.next()){
            Institute i = new Institute();
            if(select.contains("longName")) {
                i.setLongName(rs.getString("longName"));
            }
            if(select.contains("shortName")) {
                i.setShortName(rs.getString("shortName"));
            }
            if(select.contains("ID")) {
                i.setID(rs.getInt("ID"));
            }
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
    return objList;
}
    // get faculty objects --------------------------------------------------------------------------------------------
public ArrayList<Faculty> getDateFaculty(String select){
    ArrayList<Faculty> objList = new ArrayList<Faculty>();
    System.out.println("getDateFaculty 1");
    try {
        //STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        System.out.println("getDateFaculty 2");
        while (rs.next()){
            Faculty i = new Faculty();
            if(select.contains("longName")) {
                i.setLongName(rs.getString("longName"));
            }
            if(select.contains("shortName")) {
                i.setShortName(rs.getString("shortName"));
            }
            if(select.contains("ID")) {
                i.setID(rs.getInt("ID"));
            }
            if(select.contains("instituteID")) {
                i.setInstituteID(rs.getInt("instituteID"));
            }
            objList.add(i);
            System.out.println("getDateFaculty 3");
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
    return objList;
}
    // get chair objects ----------------------------------------------------------------------------------------------
public ArrayList<Department> getDateChair(String select){
    ArrayList<Department> objList = new ArrayList<Department>();

    try {
        //STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(select);

        while (rs.next()){
            Department i = new Department();
            if(select.contains("longName")) {
                i.setLongName(rs.getString("longName"));
            }
            if(select.contains("shortName")) {
                i.setShortName(rs.getString("shortName"));
            }
            if(select.contains("ID")) {
                i.setID(rs.getInt("ID"));
            }
            if(select.contains("facultyID")) {
                i.setFacultyID(rs.getInt("facultyID"));
            }
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
    return objList;
}
    // get group objects ----------------------------------------------------------------------------------------------
    public ArrayList<Group> getDateGroup(String select){
        ArrayList<Group> objList = new ArrayList<Group>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()){
                Group i = new Group();
                if(select.contains("fullGroupName")) {
                    i.setFGN(rs.getString("fullGroupName"));
                }
                if(select.contains("ID")) {
                    i.setID(rs.getInt("ID"));
                }
                if(select.contains("chairID")) {
                    i.setChairID(rs.getInt("chairID"));
                }
                if(select.contains("courseNumber")) {
                    i.setCourseNumber(rs.getInt("courseNumber"));
                }
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
        return objList;
    }
    // get emploee objects --------------------------------------------------------------------------------------------
    public ArrayList<Employee> getDateEmployee(String select){
        ArrayList<Employee> objList = new ArrayList<Employee>();
        System.out.println("getDateEmployee 1" + select);

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()) {
                System.out.println("getDateEmployee 2");
                Employee i = new Employee();
                if (select.contains("name")) {
                    i.setName(rs.getString("name"));
                }
                if (select.contains("lastName")) {
                    i.setlastName(rs.getString("lastName"));
                }
                if (select.contains("fathersName")) {
                    i.setfathersName(rs.getString("fathersName"));
                }
                if (select.contains("personalID")) {
                    i.setPersonalID(rs.getString("personalID"));
                }
                if (select.contains("sex")) {
                    i.setSex(rs.getString("sex"));
                }
                if (select.contains("email")) {
                    i.setEmail(rs.getString("email"));
                }
                if (select.contains("phoneNumber")) {
                    i.setPhoneNumber(rs.getString("phoneNumber"));
                }
                if (select.contains("dateOfBorn")) {
                    System.out.println("dateOfBorn " + rs.getString("dateOfBorn"));
                    i.stringToDate(rs.getString("dateOfBorn"));
                }
                if (select.contains("address")) {
                    i.setAddress(rs.getString("address"));
                }
                if (select.contains("pasport")) {
                    i.setPasport(rs.getString("pasport"));
                }
                if (select.contains("login")) {
                    if (select.contains("login")) {
                        i.setLogin(rs.getString("login"));
                    }
                    if (select.contains("office")) {
                        i.setOffice(rs.getString("office"));
                    }
                    if (select.contains("ID")) {
                        i.setID(rs.getInt("ID"));
                    }
                    if (select.contains("chairID")) {
                        i.setChairID(rs.getInt("chairID"));
                    }
                    objList.add(i);
                }
                rs.close();
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
        return objList;
    }
    // get teacher objects --------------------------------------------------------------------------------------------
    public ArrayList<Teacher> getDateTeacher(String select){
        ArrayList<Teacher> objList = new ArrayList<Teacher>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()){
                Teacher i = new Teacher();
                if(select.contains("name")) {
                    i.setName(rs.getString("name"));
                    System.out.println("name" + i.getName());
                }
                if(select.contains("lastName")) {
                    i.setlastName(rs.getString("lastName"));
                    System.out.println("lastName" + i.getName());
                }
                if(select.contains("fathersName")) {
                    i.setfathersName(rs.getString("fathersName"));
                    System.out.println("fathersName" + i.getSecondName());
                }
                if(select.contains("personalID")) {
                    i.setPersonalID(rs.getString("personalID"));
                }
                if(select.contains("sex")) {
                    i.setSex(rs.getString("sex"));
                }
                if(select.contains("email")) {
                    i.setEmail(rs.getString("email"));
                }
                if(select.contains("phoneNumber")) {
                    i.setPhoneNumber(rs.getString("phoneNumber"));
                }
                if(select.contains("dateOfBorn")) {
                    i.stringToDate(rs.getString("dateOfBorn"));
                }
                if(select.contains("address")) {
                    i.setAddress(rs.getString("address"));
                }
                if(select.contains("pasport")) {
                    i.setPasport(rs.getString("pasport"));
                }
                if(select.contains("login")) {
                    i.setLogin(rs.getString("login"));
                }
                if(select.contains("office")) {
                    i.setOffice(rs.getString("office"));
                }
                if(select.contains("level")) {
                    i.setLevel(rs.getString("level"));
                }
                if(select.contains("DisciplinesList")) {

                    String dl = rs.getString("DisciplinesList");
                    String[] dla = dl.split("#");
                    ArrayList<Discipline> d = new ArrayList<>();
                    for(int y = 0; y < dla.length; y++){
                        i.addDiscipline(getDateDiscipline("SELECT ID, nameOfDiscipline, chairID  FROM discipline WHERE ID=" + dla[y]).get(0));
                    }
                    //i.setDisciplines(rs.getString("DisciplinesList"));
                }
                if(select.contains("ID")) {
                    i.setID(rs.getInt("ID"));
                }
                if(select.contains("chairID")) {
                    i.setChairID(rs.getInt("chairID"));
                }
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
        return objList;
    }
    // get student objects --------------------------------------------------------------------------------------------
    public ArrayList<Student> getDateStudent(String select){
        ArrayList<Student> objList = new ArrayList<Student>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()){
                Student i = new Student();
                if(select.contains("name")) {
                    i.setName(rs.getString("name"));
                }
                if(select.contains("lastName")) {
                    i.setlastName(rs.getString("lastName"));
                }
                if(select.contains("fathersName")) {
                    i.setfathersName(rs.getString("fathersName"));
                }
                if(select.contains("personalID")) {
                    i.setPersonalID(rs.getString("personalID"));
                }
                if(select.contains("sex")) {
                    i.setSex(rs.getString("sex"));
                }
                if(select.contains("email")) {
                    i.setEmail(rs.getString("email"));
                }
                if(select.contains("phoneNumber")) {
                    i.setPhoneNumber(rs.getString("phoneNumber"));
                }
                if(select.contains("dateOfBorn")) {
                    i.stringToDate(rs.getString("dateOfBorn"));
                }
                if(select.contains("address")) {
                    i.setAddress(rs.getString("address"));
                }
                if(select.contains("pasport")) {
                    i.setPasport(rs.getString("pasport"));
                }
                if(select.contains("login")) {
                    i.setLogin(rs.getString("login"));
                }
                if(select.contains("indexBook")) {
                    i.setIndexBook(rs.getString("indexBook"));
                }
                if(select.contains("DisciplinesNames")) {
                    System. out .print("DisciplinesNames need to fix ");
                }
                if(select.contains("Attendance")) {
                   // i.Attendance = i.stringToArray(rs.getString("Attendance"));
                }
                if(select.contains("Progress")) {
                    //i.Progress = i.stringToArray(rs.getString("Progress"));
                }
                if(select.contains("ID")) {
                    i.setID(rs.getInt("ID"));
                }
                if(select.contains("chairID")) {
                    i.setChairID(rs.getInt("chairID"));
                }
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
        return objList;
    }
    // get discipline objects -----------------------------------------------------------------------------------------
    public ArrayList<Discipline> getDateDiscipline(String select){
        ArrayList<Discipline> objList = new ArrayList<Discipline>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println(select);
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()){
                Discipline i = new Discipline();
                if(select.contains("ID")) {
                    i.setID(rs.getInt("ID"));
                }
                if(select.contains("nameOfDiscipline")) {
                    i.setNameOfDiscipline(rs.getString("nameOfDiscipline"));
                }
                if(select.contains("courseNumber")) {
                    i.setCourseNumber(rs.getInt("courseNumber"));
                }
                if(select.contains("semesterNumber")) {
                    i.setSemesterNumber(rs.getInt("semesterNumber"));
                }
                if(select.contains("countOfLessons")) {
                    i.setCountOfLessons(rs.getInt("countOfLessons"));
                }
                if(select.contains("countOfPraktice")) {
                    i.setCountOfPraktice(rs.getInt("countOfPraktice"));
                }
                if(select.contains("exam")) {
                    i.setExam(rs.getBoolean("exam"));
                }
                if(select.contains("chairID")) {
                    i.setChairID(rs.getInt("chairID"));
                }
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
        return objList;
    }
    // get timetable objects ------------------------------------------------------------------------------------------
    public ArrayList<Timetable> getDateTimetable(String select){
        ArrayList<Timetable> objList = new ArrayList<Timetable>();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()){
                Timetable i = new Timetable();
                if(select.contains("ID")) {
                    i.setID(rs.getInt("ID"));
                }
                if(select.contains("groupID")) {
                    i.setGroupID(rs.getInt("groupID"));
                }
                if(select.contains("FileName")) {
                    i.setDataFromJson(rs.getString("FileName"));
                }
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
        return objList;
    }
// processing functions
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

    public String updateQuery(QuerySet qs, String tableName, int ID){
        String UpdateQuery = "UPDATE ";
        UpdateQuery = UpdateQuery + tableName + " " + "SET ";
        int counter = qs.getSet().size();
        for(Map.Entry<String, QueryBean> entry : qs.getSet().entrySet()){
            QueryBean qb = entry.getValue();
            System.out.println("query data " + qb.getFieldName() + " " + qb.getFieldData("") + " " + qb.getFieldData(0));
            UpdateQuery = UpdateQuery + qb.getFieldName() + "=" + (qb.getFieldData("")==null?qb.getFieldData(0):"'" + qb.getFieldData("") + "'");
            if(counter!=1){
                UpdateQuery = UpdateQuery + ", ";
            }
            counter--;
        }
        UpdateQuery = UpdateQuery + " WHERE id=" + ID + ";";
        System.out.println("update query : " + UpdateQuery);
        return UpdateQuery;
    }

    public boolean stringProcessor(String st){
        System.out.println("stringProcessor");
        boolean result = false;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = st;
            stmt.executeUpdate(sql);
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
                result = false;
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
                result = false;
            }
        }
        return result;
    }

    public boolean moveItem(String tableName, int queryID, int ID){
        System.out.println("moveItem " + tableName +" "+ queryID +" "+ ID);
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = null;
            if(tableName.equals("faculty")){
                sql = "UPDATE faculty SET instituteID='"+ ID +"' WHERE id=" + queryID +";";
            }else if(tableName.equals("chair")){
                sql = "UPDATE chair SET facultyID='"+ ID +"' WHERE id=" + queryID +";";
            }else if(tableName.equals("gtgroup")){
                sql = "UPDATE gtgroup SET chairID='"+ ID +"' WHERE id=" + queryID +";";
            }else if(tableName.equals("discipline")){
                sql = "UPDATE discipline SET chairID='"+ ID +"' WHERE id=" + queryID +";";
            }else if(tableName.equals("student")){
                sql = "UPDATE student SET groupID='"+ ID +"' WHERE id=" + queryID +";";
            }else if(tableName.equals("teacher")){
                sql = "UPDATE teacher SET chairID='"+ ID +"' WHERE id=" + queryID +";";
            }else if(tableName.equals("timetable")){
                sql = "UPDATE timetable SET chairID='"+ ID +"' WHERE id=" + queryID +";";
            }else if(tableName.equals("employee")){
                sql = "UPDATE employee SET chairID='"+ ID +"' WHERE id=" + queryID +";";
            }
            //"DELETE FROM " + tableName + " WHERE id='" +queryID +"' LIMIT 1;";
            System.out.println("moveItem " + sql);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
                return false;
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
                return false;
            }
        }
    }

public boolean deleteItem(String tableName, int queryID){
    try {
        Class.forName(JDBC_DRIVER).newInstance();
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        String sql = "DELETE FROM " + tableName + " WHERE id='" +queryID +"' LIMIT 1;";
        stmt.executeUpdate(sql);
        return true;
    } catch (SQLException se) {
        //Handle errors for JDBC
        se.printStackTrace();
        return false;
    } catch (Exception e) {
        //Handle errors for Class.forName
        e.printStackTrace();
        return false;
    } finally {
        //finally block used to close resources
        try {
            if (stmt != null)
                conn.close();
        } catch (SQLException se) {
            return false;
        }// do nothing
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
}
// help functions //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int findFreeID(String tableName){
        int ID = 1;
        int previous = 0;
        boolean flag = false;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT  ID FROM " + tableName + ";";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                if((rs.getInt("ID")-previous)>1){
                    ID = previous + 1;
                    flag = true;
                    break;
                }else{
                    previous = rs.getInt("ID");
                    flag = false;
                    continue;
                }
            }
            if(!flag) {
                ID = previous + 1;
            }
            rs.close();
            System.out.println("findFreeID ID : " + ID);

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
        return ID;
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
// end ----------------------------------------------------------------------------------------------------------------

    // tresh-----------------------------------------------------------------------------------------------------------
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

    public String updateQuery(QuerySet qs){
        String UpdateQuery = "Update INTO ";
        return UpdateQuery;
    }


}
