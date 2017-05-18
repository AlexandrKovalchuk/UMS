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
       int yearCounter = startDate.get(Calendar.YEAR);
        int monthCounter = startDate.get(Calendar.MONTH);
        int dateCounter = startDate.get(Calendar.DAY_OF_MONTH);
        Calendar[] dates = new Calendar[countOfDays+1] ;
        int i = 0;
        boolean flag = false;
        while (!flag){
           Calendar mc = Calendar.getInstance();
           mc.set(yearCounter, monthCounter, dateCounter);
           if(dateCounter < mc.getMaximum(Calendar.DAY_OF_MONTH)){
                dateCounter++;
            }else{
                dateCounter = 1;
                if(monthCounter < mc.getMaximum(Calendar.MONTH)){
                    monthCounter++;
                }else{
                    monthCounter = 0;
                    yearCounter++;
                }
            }

            if((mc.get(Calendar.YEAR)==endDate.get(Calendar.YEAR))&(mc.get(Calendar.MONTH)==endDate.get(Calendar.MONTH))
                    &(mc.get(Calendar.DAY_OF_MONTH)==endDate.get(Calendar.DAY_OF_MONTH))){
                flag=true;
            }
            dates[i] = mc;

            i++;
        }
        return dates;
    }

}
