package net.ukr.vixtibon.base_objects.study_process;

import net.ukr.vixtibon.ClassReadyForTest;
import net.ukr.vixtibon.Test;

import java.io.Serializable;

/**
 * Created by akovalchuk on 6/4/2015.
 */
@ClassReadyForTest
public class Discipline  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ID;
    String nameOfDiscipline  = null; // Name of discipline: contain only Space, A-Z, a-z, �-�, �-� and "-" symbol, limit 60 symbols
    int courseNumber ; // Can contain only 1-6 and no other numbers, no negative numbers
    int semesterNumber; // Can contain only 1 or 2 and no other numbers, no negative numbers
    private int countOfLessons; //Can contain 0,1,2... ,no negative numbers
    boolean exam;// Exam in the end of semester or not can be thrue of false

    public  Discipline(){}

    /*
    public void setCountOfPractice(int countOfPractice) {
        this.countOfPractice = countOfPractice;
    }

    public int getCountOfPractice() {
        return countOfPractice;
    }

    public String getFirstLetter(String s){
        String l = null;
        l = s.substring(0,1);
        return l;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
    */

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setNameOfDiscipline(String nameOfDiscipline) {
        if(nameOfDiscipline.equals("/")){
            this.nameOfDiscipline = "";
        }else{
            this.nameOfDiscipline = nameOfDiscipline;
        }

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

        d.setNameOfDiscipline(testData);

        boolean result = d.getNameOfDiscipline().equals(null);
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
            d.setNameOfDiscipline(letter);
            result = d.getNameOfDiscipline().equals(letter);
            if(!result){
                break;
            }

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
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
        String str = "";
    }

    public void setCountOfLessons(int countOfLessons) {
        this.countOfLessons = countOfLessons;
    }

    public void setExam(String exam) {
        if(exam.equals("yes")){
            this.exam = true;
        }else if(exam.equals("no")){
            this.exam = false;
        }
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
/*
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    */


    public String isExam() {
        if(exam){
            return "yes";
        }else{
            return "no";
        }
    }
}
