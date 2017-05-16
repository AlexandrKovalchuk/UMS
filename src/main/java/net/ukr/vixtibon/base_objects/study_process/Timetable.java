package net.ukr.vixtibon.base_objects.study_process;

import net.ukr.vixtibon.MyCalendar;

import java.io.Serializable;
import java.util.Calendar;

public class Timetable implements Serializable {
    private static final long serialVersionUID = 1L;
    private int groupID;
    private int maxCountOfDays = 6;
    private int countOfWeeks;
    int ID;
    Day[][] Days;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int countOfDays(Calendar startsemesterDate, Calendar endsemesterDate){
        int count = 0;
        if(startsemesterDate.get(Calendar.YEAR) == endsemesterDate.get(Calendar.YEAR)){
            if(startsemesterDate.get(Calendar.MONTH) == endsemesterDate.get(Calendar.MONTH)){
                if(startsemesterDate.get(Calendar.DAY_OF_MONTH) == endsemesterDate.get(Calendar.DAY_OF_MONTH)){
                    count = 1;
                    return count;
                }else{
                    count = (endsemesterDate.get(Calendar.DAY_OF_MONTH) - startsemesterDate.get(Calendar.DAY_OF_MONTH)) +1;
                    return count;
                }
            }else{
                count = count + (startsemesterDate.getMaximum(Calendar.DAY_OF_MONTH) - startsemesterDate.get(Calendar.DAY_OF_MONTH));
                count = count + (endsemesterDate.get(Calendar.DAY_OF_MONTH));
                if((endsemesterDate.get(Calendar.MONTH)-startsemesterDate.get(Calendar.MONTH)) > 1){
                    for(int i = startsemesterDate.get(Calendar.MONTH) + 1; i < endsemesterDate.get(Calendar.MONTH); i++){
                        Calendar mc = Calendar.getInstance();

                        mc.set(startsemesterDate.get(Calendar.YEAR), i, 1);
                        count = count + mc.getMaximum(Calendar.DAY_OF_MONTH);
                    }

                }
                return  count;
            }
        }else{
            count = count + (startsemesterDate.getMaximum(Calendar.DAY_OF_MONTH) - startsemesterDate.get(Calendar.DAY_OF_MONTH));
            count = count + (endsemesterDate.get(Calendar.DAY_OF_MONTH));
            for(int i = startsemesterDate.get(Calendar.MONTH)+1; i <= startsemesterDate.getMaximum(Calendar.MONTH); i++){
                Calendar mc = Calendar.getInstance();

                mc.set(startsemesterDate.get(Calendar.YEAR), i, 1);
                count = count + mc.getMaximum(Calendar.DAY_OF_MONTH);
            }
            if(endsemesterDate.get(Calendar.MONTH) > 0){
                for(int i = 0; i < endsemesterDate.get(Calendar.MONTH); i++){
                    Calendar mc = Calendar.getInstance();

                    mc.set(endsemesterDate.get(Calendar.YEAR), i, 1);
                    count = count + mc.getMaximum(Calendar.DAY_OF_MONTH);
                }
            }
            return count;

        }

    }

    public void timeTableCreator(Calendar startsemesterDate, Calendar endsemesterDate) {
        //System. out .println("timeTableCreator 1");
        Timetable newTimetable = new Timetable();
        //System. out .println("timeTableCreator 2");
        MyCalendar myCalendar = new MyCalendar();
        //System. out .println("timeTableCreator 3");
        Calendar[] dates = myCalendar.getDates(startsemesterDate, endsemesterDate,countOfDays(startsemesterDate, endsemesterDate));
       // System. out .println("timeTableCreator 4");

        Calendar[] workDates = new Calendar[countOfDays(startsemesterDate, endsemesterDate)];
        //System. out .println("timeTableCreator 5");
        for (int i = 0; i < workDates.length ; i++) {
            workDates[i] = dates[i];
        }
        //System. out .println("point 2 workDates length : " + workDates.length);
        //System. out .println("point 2 Dates length : " + dates.length);
        countOfWeeks = (dates.length/7) + 1;
        int startCorrection = 0;
        int endCorrection = 0;
        boolean flag = false;
        if(startsemesterDate.get(Calendar.DAY_OF_WEEK) != 0){
            startCorrection = startsemesterDate.get(Calendar.DAY_OF_WEEK);
            countOfWeeks++;
        }

        if(startsemesterDate.get(Calendar.DAY_OF_WEEK) != 6){
            endCorrection = 7 - (endsemesterDate.get(Calendar.DAY_OF_WEEK) + 1);
        }

        //System. out .println("point 3 count of weeks : " + countOfWeeks);
        Days = new Day[countOfWeeks][ maxCountOfDays];
        for(int i = 0 ; i < startCorrection; i++){
            Days[0][i] = null;
        }
        int week =0;
        for(int i = 0; i < dates.length ; i++){
            //System. out .println("timeTableCreator 6 : " + i);
            if(dates[i].get(Calendar.DAY_OF_WEEK) == 1){
                Days[week][0] = new Day(false, 1, dates[i], 7);
                //System. out .println("timeTableCreator 6 1 : " + i);
            }
            if(dates[i].get(Calendar.DAY_OF_WEEK) == 2){
                Days[week][1] = new Day(false, 2, dates[i], 7);
                //System. out .println("timeTableCreator 6 2 : " + i);
            }
            if(dates[i].get(Calendar.DAY_OF_WEEK) == 3){
                Days[week][2] = new Day(false, 3, dates[i], 7);
                //System. out .println("timeTableCreator 6 3 : " + i);
            }
            if(dates[i].get(Calendar.DAY_OF_WEEK) == 4){
                Days[week][3] = new Day(false, 4, dates[i], 7);
                //System. out .println("timeTableCreator 6 4 : " + i);
            }
            if(dates[i].get(Calendar.DAY_OF_WEEK) == 5){
                Days[week][4] = new Day(false, 5, dates[i], 7);
               // System. out .println("timeTableCreator 6 5 : " + i);
            }
            if(dates[i].get(Calendar.DAY_OF_WEEK) == 6){
                Days[week][5] = new Day(false, 6, dates[i], 7);
                //System. out .println("timeTableCreator 6 6 : " + i);
            }
            if(dates[i].get(Calendar.DAY_OF_WEEK) == 7){
                //System. out .println("timeTableCreator 6 7 : " + i);
                week++;
                continue;
            }
        }


    }

    public void setDataFromJson(String fileName){
        System. out .println("setDataFromJson function need to fix ");
    }

    public void showTimeTable(){
        //System. out .println(" showTimeTable " + countOfWeeks + " " + maxCountOfDays );
        //System. out .println("length " + Days.length);
        for(int i = 0; i < Days.length; i++){
            //System. out .println(" point 1 " + i);
            for(int j = 0; j < Days[i].length; j++){
                //System. out .println(" point 2 " + j + " " + Days[i].length);
                if(Days[i][j] != null) {
                    Days[i][j].showDay();
                }else{continue;}
            }
        }
    }


}
