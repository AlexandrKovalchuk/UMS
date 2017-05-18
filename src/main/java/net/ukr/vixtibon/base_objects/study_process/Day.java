package net.ukr.vixtibon.base_objects.study_process;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Day implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean dayOff;
    private int dayNumber;
    private String dayName;
    Calendar date;
    private int dayLessons;
    private int eveningLessons;
    private int maxCountOfLessons = 7;
    ArrayList<Lesson> Lessons = new ArrayList<>();

    public Day(boolean dayOff, int dayNumber, Calendar date, int maxCountOfLessons) {
        this.dayOff = dayOff;
        this.dayNumber = dayNumber;
        this.date = date;
        this.maxCountOfLessons = maxCountOfLessons;

    }

    public void setDayOff(boolean dayOff) {
        this.dayOff = dayOff;
    }

    public void setMaxCountOfLessons(int maxCountOfLessons) {
        this.maxCountOfLessons = maxCountOfLessons;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public void setDayLessons(int dayLessons) {
        this.dayLessons = dayLessons;
    }

    public void setEveningLessons(int eveningLessons) {
        this.eveningLessons = eveningLessons;
    }

    public boolean isDayOff() {
        return dayOff;
    }

    public int getMaxCountOfLessons() {
        return maxCountOfLessons;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public String getDayName() {
        return dayName;
    }

    public int getDayLessons() {
        return dayLessons;
    }

    public int getEveningLessons() {
        return eveningLessons;
    }

    public void showDay(){
        System. out .println(" showDay ");
        System. out .println(" Date " + date.get(Calendar.YEAR) +" " + date.get(Calendar.MONTH) +" " + date.get(Calendar.DAY_OF_MONTH));
        if(dayNumber == 1){
            System. out .println(" понеділок ");
        }else
        if(dayNumber == 2){
            System. out .println(" вівторок ");
        }else
        if(dayNumber == 3){
            System. out .println(" середа ");
        }else
        if(dayNumber == 4){
            System. out .println(" четвер ");
        }else
        if(dayNumber == 5){
            System. out .println(" п'ятниця ");
        }else{
            System. out .println(" субота ");
        }
            for(Lesson l: Lessons){
            //l.showLesson();
        }

    }

}
