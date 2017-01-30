package net.ukr.vixtibon;

import net.ukr.vixtibon.base_objects.study_process.Timetable;

import java.util.Calendar;

/**
 * Created by alex on 01/06/2016.
 */
public class MyCalendarTester {
    public static void main(String[] args) {
    MyCalendar mct = new MyCalendar();
    Timetable tt = new Timetable();
    Calendar ss = Calendar.getInstance();
    Calendar se = Calendar.getInstance();
        ss.set(2016, 8, 1);
        se.set(2017,0,30);

        mct.getDates(ss,se,tt.countOfDays(ss,se));
    }
}
