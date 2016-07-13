package net.ukr.vixtibon;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by akovalchuk on 6/9/2015.
 */
public class MyCalendar {
    Date date = new Date(2014,1,1);

    Calendar cl = Calendar.getInstance();


    private int firstDayInYear = cl.get(Calendar.DAY_OF_WEEK);

    //private int Year = 2015;
    int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
    String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};





    public Calendar[] getDates(Calendar startDate, Calendar endDate, int countOfDays){
        //System.out.println("getDates 1");
        int yearCounter = startDate.get(Calendar.YEAR);
        int monthCounter = startDate.get(Calendar.MONTH);
        int dateCounter = startDate.get(Calendar.DAY_OF_MONTH);
        //System.out.println("getDates 2");
        Calendar[] dates = new Calendar[countOfDays+1] ;
        //System.out.println("getDates 4");
        int i = 0;
        boolean flag = false;
       // System.out.println("getDates 5");
        while (!flag){
           // System.out.println("getDates 6");
            Calendar mc = Calendar.getInstance();
            //System.out.println("getDates 7");
            mc.set(yearCounter, monthCounter, dateCounter);
            //System.out.println("getDates 8");
            if(dateCounter < mc.getMaximum(Calendar.DAY_OF_MONTH)){
                dateCounter++;
                //System.out.println("getDates 9 : " + dateCounter);
            }else{
                dateCounter = 1;
                //monthCounter++;
                //System.out.println("getDates 10 : " + dateCounter);

                if(monthCounter < mc.getMaximum(Calendar.MONTH)){
                    monthCounter++;
                    //System.out.println("getDates 11 :" + monthCounter);
                }else{
                    monthCounter = 0;
                    yearCounter++;
                    //System.out.println("getDates 12 :" + monthCounter);
                }
            }

            //System.out.println("Current date :" +mc.get(Calendar.YEAR)+ " " +mc.get(Calendar.MONTH)+ " " +mc.get(Calendar.DAY_OF_MONTH));
            //System.out.println("End date     :" +endDate.get(Calendar.YEAR)+ " " +endDate.get(Calendar.MONTH)+ " " +endDate.get(Calendar.DAY_OF_MONTH));
            if((mc.get(Calendar.YEAR)==endDate.get(Calendar.YEAR))&(mc.get(Calendar.MONTH)==endDate.get(Calendar.MONTH))
                    &(mc.get(Calendar.DAY_OF_MONTH)==endDate.get(Calendar.DAY_OF_MONTH))){
                flag=true;
            }
            //System.out.println("Date size : " + dates.length + " i : " + i +" Flag :" + flag);
            dates[i] = mc;

            i++;
        }
        return dates;
    }

}
