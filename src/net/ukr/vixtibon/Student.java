package net.ukr.vixtibon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String faculty;
    private String indexBook;
    private String fullIdentifier;
    private int index;
    private int chairID;
    private int groupID;
    String[] DisciplinesNames;
    String[][] Attendance ;
    String[][] Progress ;

    public Student() {
    }

    public Student(int ID,String name, String secondName, String surname, String personalID, String sex, String email, String phoneNumber,
                   Calendar dateOfBorn, String address, String pasport, String faculty, String indexBook, String fullIdentifier,
                    int index, ArrayList<Discipline> disciplines, int chairID, int groupID) {

        super(ID, name, secondName, surname, personalID, sex, email, phoneNumber, dateOfBorn, address, pasport);

        this.faculty = faculty;
        qs.add(new QueryBean("Student","faculty",faculty));
        this.indexBook = indexBook;
        qs.add(new QueryBean("Student","indexBook",indexBook));
        this.index = index;
        String indexPlus = "";
        qs.add(new QueryBean("Student","stindex",indexPlus + index));
        int maxSize = 0;
        for(Discipline d: disciplines){
            if(maxSize < d.getCountOfLessons()){
                maxSize = d.getCountOfLessons();
            }else{
                continue;
            }
        }
        DisciplinesNames = new String[disciplines.size()];

        Attendance = new String[disciplines.size()][maxSize];
        Progress = new String[disciplines.size()][maxSize];
        initializeArrays(disciplines);
        qs.add(new QueryBean("Student","Attendance",arrayToString(Attendance)));
        qs.add(new QueryBean("Student","Progress",arrayToString(Progress)));
        this.fullIdentifier = fullIdentifier;
        qs.add(new QueryBean("Student","fullIdentifier",fullIdentifier));
        this.chairID = chairID;
        qs.add(new QueryBean("Student","chairID",chairID));
        this.groupID = groupID;
        qs.add(new QueryBean("Student","groupID",groupID));


        //System. out .println("Student constructor complete");
    }

    private void initializeArrays(ArrayList<Discipline> disciplines){
        //System. out .println("nitializeArrays");
        for(int i = 0; i < disciplines.size()-1; i++){
            DisciplinesNames[i] = disciplines.get(i).nameOfDiscipline;
        }

        for(int i = 0; i < disciplines.size()-1 ; i++){
            for (int j = 0; j < disciplines.get(i).getCountOfLessons()-1; j++){
                Attendance[i][j] = "0";
            }
        }
        for(int i = 0; i < disciplines.size()-1 ; i++){
            for (int j = 0; j < disciplines.get(i).getCountOfPraktice()-2; j++){
                Progress[i][j] = "0";
            }
        }
    }

    public String arrayToString(String[][] A){
        String data = "";
        for(int i = 0; i < A.length-1 ; i++){
            for (int j = 0; j < A[i].length-1; j++){
                data = data + A[i][j];
                data = data + "#";
            }
            data = data + "!";
        }
        return data;
    }

    public String[][] stringToArray(String data){
        String[][] A = null;
        int i = 0;
        int j = 0;
        for(String part1 : data.split("!")){
            for(String part2 : part1.split("#")){
                A[i][j] = part2;
                j++;
            }
            i++;
        }
        return A;
    }

    public int getChairID() {
        return chairID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setChairID(int chairID) {
        this.chairID = chairID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
        updateQuerySetParameter("faculty",faculty);
    }

    public void setIndexBook(String indexBook) {
        this.indexBook = indexBook;
        updateQuerySetParameter("indexBook",indexBook);
    }

    public void setIndex(int index) {
        this.index = index;
        String str = "";
        updateQuerySetParameter("stindex",str + index);
    }

    public String getFaculty() {
        return faculty;
    }

    public String getIndexBook() {
        return indexBook;
    }

    public int getIndex() {
        return index;
    }
    public void setFullIdentifier(){
        fullIdentifier = faculty + indexBook + index;
        updateQuerySetParameter("fullIdentifier",fullIdentifier);
    }
    public String getFullIdentifier(){
        return fullIdentifier;
    }

    public void getDisciplinesInfo(){
        System. out .println("Disciplines info");
        for(int i = 0; i < DisciplinesNames.length - 1; i++){
            System. out .println(DisciplinesNames[i]);
            System. out .print("Attendance ");

                for(int h = 0; h < Attendance[i].length - 1; h++){
                    System. out .print("|" + Attendance[i][h]);
                }

            System. out .println("");
            System. out .print("Progress ");
                for(int h = 0; h < Progress[i].length - 1; h++){
                    System. out .print("|" + Progress[i][h]);
                }

            System. out .println("");
        }

    }

    public void fullInfo(){
        System. out .println("Student info");
        System. out .println(getName() + " " + getSecondName() + " " + getPhoneNumber() + " " + getEmail()) ;
        System. out .println(getAddress());
        System. out .println(getFaculty() + " " + getFullIdentifier() + " "+ getIndexBook());
        System. out .println("");
        getDisciplinesInfo();


    }
}
