package net.ukr.vixtibon;

import java.io.Serializable;

/**
 * Created by akovalchuk on 5/21/2015.
 */
public class MyDate implements Serializable {
    private int day;
    private String month;
    private int year;
    private static final long serialVersionUID = 1L;

    public MyDate() {
    }

    public MyDate(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public int getMonthInt(){
        int index = 0;
        switch (month){
            case "Січень": {index = 1;}break;
            case "Лютий": {index = 2;}break;
            case "Березень": {index = 3;}break;
            case "Квітень": {index = 4;}break;
            case "Травень": {index = 5;}break;
            case "Червень": {index = 6;}break;
            case "Липень": {index = 7;}break;
            case "Серпень": {index = 8;}break;
            case "Вересень": {index = 9;}break;
            case "Жовтень": {index = 10;}break;
            case "Листопад": {index = 11;}break;
            case "Грудень": {index = 12;}break;

            default: System.out.println("incorrect munth name");
        }
        return index;
    }


    public int getYear() {
        return year;
    }

    public void showInfo(){
        System.out.println("Day : " + getDay() + " Month : " + getMonth() + " Year : " + getYear());
    }
}
