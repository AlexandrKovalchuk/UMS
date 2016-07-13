package net.ukr.vixtibon;

import java.io.UnsupportedEncodingException;

/**
 * Created by akovalchuk on 5/21/2015.
 */
public class main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Generator generator = new Generator();

        try {
            generator.runGenerator();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /*
        Tester tester = new Tester();
        tester.test(Address.class,Discipline.class,Calendar.class,Chair.class,Date.class,Day.class,Discipline.class,Faculty.class,
                    Group.class,Institute.class,Lesson.class,MyDate.class,Pasport.class,Person.class,Structure.class,Student.class,
                    Teacher.class,Timetable.class);

        /*
        ToCreateTestsMethodsList tctml = new ToCreateTestsMethodsList();
        tctml.test(Address.class,Discipline.class,Calendar.class,Chair.class,Date.class,Day.class,Discipline.class,Faculty.class,
                Group.class,Institute.class,Lesson.class,MyDate.class,Pasport.class,Person.class,Structure.class,Student.class,
                Teacher.class,Timetable.class);

*/

    }
}
