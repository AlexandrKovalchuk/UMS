package net.ukr.vixtibon;

import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.stady_process.Discipline;
import net.ukr.vixtibon.base_objects.stady_process.Timetable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    private int wave;
    private int groupIndex;
    private String fullGroupName;
    private int ID;
    private int chairID;
    private int courseNumber;

    Timetable groupTimeTable = new Timetable();
    ArrayList<Discipline> DisciplineList = new ArrayList<>();
    ArrayList<Student> StudentsList = new ArrayList<Student>();

    public QuerySet qs = new QuerySet();

    public Group(){}

    public Group(int ID, String fullGroupName, int courseNumber, int chairID){
        this.ID = ID;
        qs.add(new QueryBean("gtgroup","ID",ID));
        this.fullGroupName = fullGroupName;
        qs.add(new QueryBean("gtgroup","fullGroupName",fullGroupName));
        this.courseNumber = courseNumber;
        qs.add(new QueryBean("gtgroup","courseNumber",courseNumber));
        this.chairID = chairID;
        qs.add(new QueryBean("gtgroup","chairID",chairID));
    }

    public Group(int wave,int ID, int chairID) {
        this.wave = wave;
        String str = "";
        qs.add(new QueryBean("gtgroup","wave",str + wave));
        qs.add(new QueryBean("gtgroup","ID",ID));
        this.chairID = chairID;
        qs.add(new QueryBean("gtgroup","chairID",chairID));
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    public  ArrayList<Student> getStudentsList(){
        return StudentsList;
    }
    public void updateQuerySetParameter(String key, String update){
        QueryBean qb = new QueryBean();
        if(qs.getSet().containsKey(key)) {
            qb.setTableName(qs.getSet().get(key).getTableName());
            qb.setFieldName(qs.getSet().get(key).getFieldName());

        }else{
            qb.setTableName("gtgroup");
            qb.setFieldName(key);
        }
        qb.setFieldData(update);
        qs.add(qb);
    }

    public int getChairID() {
        return chairID;
    }

    public void setChairID(int chairID) {
        this.chairID = chairID;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
        String str = "";
        updateQuerySetParameter("courseNumber",str + courseNumber);
    }

    public void setWave(int wave) {
        this.wave = wave;
        String str = "";
        updateQuerySetParameter("wave",str + wave);
    }

    public void setGroupIndex(int groupIndex) {
        this.groupIndex = groupIndex;
        String str = "";
        updateQuerySetParameter("groupIndex",str + groupIndex);
    }

    public int getWave() {
        return wave;
    }

    public int getGroupIndex() {
        return groupIndex;
    }

    public int getStudentsCount(){
        return StudentsList.size();
    }

    public int getCourseNumber() {
        return courseNumber;
    }


    public String getFullGroupName() {
        return fullGroupName;
    }

    public void setFullGroupName(String chairShortName){
        fullGroupName = chairShortName + "-" + wave + groupIndex;
        updateQuerySetParameter("fullGroupName",fullGroupName);
    }
    public void setSetStudents (ArrayList<Student> st){
        StudentsList = st;
    }
    public void setFGN(String name){
        this.fullGroupName = name;
    }
    public void addStudent(Student student){
        StudentsList.add(student);
        QueryBean qb = new QueryBean();
        //System. out .println("point 2 " + qs.getSet().get("Discipline").getTableName());
        if(qs.getSet().containsKey("StudentList")) {
            qb.setTableName(qs.getSet().get("StudentList").getTableName());
            qb.setFieldName(qs.getSet().get("StudentList").getFieldName());
            qb.setFieldData(qs.getSet().get("StudentList").getFieldData(0));
        }else{
            qb.setTableName("gtgroup");
            qb.setFieldName("StudentList");
            qb.setFieldData("");
        }
        // System. out .println("point 3 " );
        String data = qb.getFieldData("");
        //System. out .println("point 4 " );
        data += student.getFullIdentifier()  + "#";
        // System. out .println("point 4 " + data);
        qb.setFieldData(data);
        qs.add(qb);
    }

    public void deleteStudent(int index){
        StudentsList.remove(index);
    }

    public void showDisciplinesList(){
        for (Discipline d: DisciplineList){
            d.showDisciplineInfo();
        }
    }
}
