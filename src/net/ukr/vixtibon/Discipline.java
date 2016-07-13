package net.ukr.vixtibon;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by akovalchuk on 6/4/2015.
 */
@ClassReadyForTest
public class Discipline  implements Serializable {
    private static final long serialVersionUID = 1L;
    String nameOfDiscipline  = null; // Name of discipline: contain only Space, A-Z, a-z, �-�, �-� and "-" symbol, limit 60 symbols
    int courseNumber ; // Can contain only 1-6 and no other numbers, no negative numbers
    int semesterNumber; // Can contain only 1 or 2 and no other numbers, no negative numbers
    private int countOfLessons; //Can contain 0,1,2... ,no negative numbers
    private int countOfPraktice;//Can contain 0,1,2... ,no negative numbers
    boolean exam;// Exam in the end of semester or not can be thrue of false
    private Teacher teacher;
    private int ID;
    private int chairID;

    public QuerySet qs = new QuerySet();

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

    public void setCountOfPraktice(int countOfPraktice) {
        this.countOfPraktice = countOfPraktice;
        String str = "";
        updateQuerySetParameter("countOfPraktice",str + countOfPraktice);
    }

    public int getCountOfPraktice() {

        return countOfPraktice;
    }

    public Discipline(int ID, String nameOfDiscipline, int courseNumber, int semesterNumber, int countOfLessons, boolean exam, int countOfPraktice
            , int chairID) {
        this.ID = ID;
        qs.add(new QueryBean("Discipline","ID",ID));
        this.nameOfDiscipline = nameOfDiscipline;
        qs.add(new QueryBean("Discipline","nameOfDiscipline",nameOfDiscipline));
        this.courseNumber = courseNumber;
        String str = "";
        qs.add(new QueryBean("Discipline","courseNumber", str + courseNumber));
        this.semesterNumber = semesterNumber;
        str = "";
        qs.add(new QueryBean("Discipline","semesterNumber",str + semesterNumber));
        this.countOfLessons = countOfLessons;
        str = "";
        qs.add(new QueryBean("Discipline","countOfLessons",str + countOfLessons));
        this.countOfPraktice = countOfPraktice;
        str = "";
        qs.add(new QueryBean("Discipline","countOfPraktice",str + countOfPraktice));
        this.exam = exam;
        str = "";
        qs.add(new QueryBean("Discipline","exam",str + exam));
        this.chairID = chairID;
        qs.add(new QueryBean("Discipline","chairID",chairID));
    }
    public  Discipline(){}
    public String getFirstLetter(String s){
        String l = null;
        l = s.substring(0,1);
        return l;
    }

    public int getChairID() {
        return chairID;
    }

    public void setChairID(int chairID) {
        this.chairID = chairID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setNameOfDiscipline(String nameOfDiscipline) {
        if(nameOfDiscipline == "/"){
            this.nameOfDiscipline = "";
        }else{
            this.nameOfDiscipline = nameOfDiscipline;
        }
        updateQuerySetParameter("nameOfDiscipline",nameOfDiscipline);

    }

    //test created by: Alexander Kovalchuk
    //test for method setNameOfDiscipline
    @Test
    public static boolean TestSetNameOfDiscipline1(){
        Discipline d = new Discipline();
        String testData = "123";

        d.setNameOfDiscipline(testData);

        boolean result = d.getNameOfDiscipline().equals(null);

        return result;
    }

    //test created by: Nadia Galakhova
    //test for method setNameOfDiscipline
    @Test
    public static boolean TestSetNameOfDiscipline4(){
        Discipline d = new Discipline();

        String testData = "/";
        System.out.println("Inserted data for test: " + testData);

        d.setNameOfDiscipline(testData);

        boolean result = d.getNameOfDiscipline().equals(null);
        System.out.println("Name of discipline: " + d.getNameOfDiscipline());
        return result;
    }

    //test created by: Nadia Galakhova
    //test for method setNameOfDiscipline
    @Test
    public static boolean TestSetNameOfDiscipline5(){
        Discipline d = new Discipline();
        boolean result = true;

        String[] testData = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        for(String letter:testData){
            System.out.println("Point 0 ");
            d.setNameOfDiscipline(letter);
            result = d.getNameOfDiscipline().equals(letter);
            System.out.println("Inserted data for test: " + letter);
            if(!result){
                System.out.println("Point 1 ");
                break;
            }
            System.out.println("Point 2 ");

        }
        return result;
    }


    //test created by: Alexander Kovalchuk
    //test for method setNameOfDiscipline
    @Test
    public static boolean TestSetNameOfDiscipline2(){
        Discipline d = new Discipline();
        String testData = "Test";
        d.setNameOfDiscipline(testData);
        boolean result = d.getNameOfDiscipline().equals("Test");
        return result;
    }
    //test created by: Alexander Kovalchuk
    //test for method setNameOfDiscipline
    @Test
    public static boolean TestSetNameOfDiscipline3(){
        Discipline d = new Discipline();
        String testData = "Test";
        d.setNameOfDiscipline(testData);
        boolean result = d.getNameOfDiscipline().equals("Test");
        return result;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
        String str = "";
        updateQuerySetParameter("courseNumber",str + courseNumber);
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
        String str = "";
        updateQuerySetParameter("semesterNumber",str + semesterNumber);
    }

    public void setCountOfLessons(int countOfLessons) {
        this.countOfLessons = countOfLessons;
        String str = "";
        updateQuerySetParameter("countOfLessons",str + countOfLessons);
    }

    public void setExam(boolean exam) {
        this.exam = exam;
        String str = "";
        updateQuerySetParameter("exam",str + exam);
    }

    public String getNameOfDiscipline() {
        return nameOfDiscipline;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public int getCountOfLessons() {
        return countOfLessons;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public boolean isExam() {
        return exam;
    }
    public void showDisciplineInfo(){
        System. out .println("Discipline : " + getNameOfDiscipline() + "; course : " + getCourseNumber() + "; semester : " +
                             getSemesterNumber() + "; count of lessons : " + getCountOfLessons() + "; count of practice : "+getCountOfPraktice()+"; examine : " + exam );
        System. out .println("Teacher : " + teacher.getName() + " " + teacher.getSecondName());
    }
}
