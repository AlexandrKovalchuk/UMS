package net.ukr.vixtibon;

import net.ukr.vixtibon.base_objects.departments.Faculty;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by alex on 30/05/2016.
 */
public class DataBaseDriverTester {
    public static void main(String[] args) throws UnsupportedEncodingException {
        DataBaseDriver dbd = new DataBaseDriver();
        //INSERT TEST
        //institute COMPLETED
        /*
        Institute i = new Institute("Київський Політехнічний Інститут","КПИ","institute");
        i.addFaculty(new Faculty("test long name 1","test short name 1","faculty", i.getID()));
        i.addFaculty(new Faculty("test long name 2","test short name 2","faculty",i.getID()));
        System.out.println("Insert String:  " + dbd.insertQuery(i.qs));
        */
        // faculty COMPLETED
        System.out.println("Institute table create " + dbd.createTableString("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\InstituteTableParameters.xml"));
        ArrayList<Faculty> f = dbd.getDateFaculty("SELECT longName,  ID FROM faculty ;" );
        //Faculty f = new Faculty("test long name 1","test short name 1",1,"table_name",1);
       // f.addChair(new Chair("test long Chair name 1","test short Chair name 1",1,1,"table_name"));
       // f.addChair(new Chair("test long Chair name 2","test short Chair name 2",2,1,"table_name"));
        //System.out.println("Institute " + dbd.insertQuery(f.qs));

        // chair

        //System.out.println(dbd.createTableString("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\TimeTableTableParameters.xml"));

        //Person p = new Person("name", "String secondName", "String surname", "String personalID", 'M', "String email","String phoneNumber",
                //new Date(4,5,2016), "String address", "String pasport");

        //Teacher t = new Teacher("name", "String secondName", "String surname", "String personalID", 'M', "String email","String phoneNumber",
                //new Date(4,5,2016), "String address", "String pasport",  "String office", "String level","String faculty", "String chair");
        //Employee e = new Employee("name", "String secondName", "String surname", "String personalID", 'M', "String email","String phoneNumber",
               // new Date(4,5,2016), "String address", "String pasport",  "String office", "String faculty", "String chair");

        //Discipline d1 = new Discipline("String name OfDiscipline1", 1,2, 20, true,15);
        //Discipline d2 = new Discipline("String name OfDiscipline2", 1,2, 21, true,15);
       //Discipline d3 = new Discipline("String name OfDiscipline3", 1,2, 22, true,15);
        //ArrayList<Discipline> disciplines = new ArrayList<>();
        //disciplines.add(d1);
        //disciplines.add(d2);
        //disciplines.add(d3);
        //Student s = new Student("String name", "String secondName", "String surname", "String personalID", 'M', "String email", "String phoneNumber",
                //new Date(4,5,2016), "String address", "String pasport", "String faculty", "String indexBook", "String fullIdentifier",
        //4102, disciplines);
        //System.out.println("Person " + dbd.insertQuery(s.qs));
        //Chair
        //Group g = new Group();
        //Timetable
        //t.addDiscipline(d);

        //t.showInfo();

        //System.out.println("Person " + dbd.insertQuery(p.qs));
        //System.out.println("Employee " + dbd.insertQuery(e.qs));
        //System.out.println("Discipline " + dbd.insertQuery(d.qs));
        //System.out.println("Teacher " + dbd.insertQuery(t.qs));

        //Discipline d2 = new Discipline("String name OfDiscipline2", 1,2, 20,
               // true,15);
        //t.addDiscipline(d2);
        //t.setSex('S');
        //System.out.println("Teacher " + dbd.insertQuery(t.qs));

    }
}
