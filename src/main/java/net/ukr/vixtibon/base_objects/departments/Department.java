package net.ukr.vixtibon.base_objects.departments;

import net.ukr.vixtibon.*;
import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.study_process.Discipline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by akovalchuk on 5/22/2015.
 */
public class Department extends Structure implements Serializable {
    private static final long serialVersionUID = 1L;
    private int facultyID;

    private ArrayList<Group> Groups1 = new ArrayList<Group>();
    private ArrayList<Group> Groups2 = new ArrayList<Group>();
    private ArrayList<Group> Groups3 = new ArrayList<Group>();
    private ArrayList<Group> Groups4 = new ArrayList<Group>();
    private ArrayList<Group> Groups5 = new ArrayList<Group>();
    private ArrayList<Group> Groups6 = new ArrayList<Group>();

    private ArrayList<Teacher> Teachers = new ArrayList<Teacher>();
    private ArrayList<Employee> Employees = new ArrayList<Employee>();
    private ArrayList<Discipline> Disciplines = new ArrayList<Discipline>();

    Calendar semesterStart = Calendar.getInstance();
    Calendar semesterEnd = Calendar.getInstance();

    public Department(){}

    public Department(String longName, String shortName, int ID, int facultyID) {
        super(longName, shortName,ID);
        this.facultyID = facultyID;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    public void setEmployees(ArrayList<Employee> employees){
        this.Employees = employees;
    }

    public ArrayList<Employee> getEmployees(){
        return Employees;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines){this.Disciplines = disciplines;}

    public ArrayList<Discipline> getDisciplines(){
        return Disciplines;
    }
/*
    public String[][] listOfGroups(){
        int size = Groups1.size() + Groups2.size() + Groups3.size() + Groups4.size() + Groups5.size() + Groups6.size();
        String[][] list = new String[size][2];
        int sizeCounter = 0;
        for (int i = 0 ; i < Groups1.size(); i++){
            list[sizeCounter][0] = Groups1.get(i).getFullGroupName();
            list[sizeCounter][1] = "1";
            sizeCounter++;
        }
        for (int i = 0 ; i < Groups2.size(); i++){
            list[sizeCounter][0] = Groups2.get(i).getFullGroupName();
            list[sizeCounter][1] = "1";
            sizeCounter++;
        }
        for (int i = 0 ; i < Groups3.size(); i++){
            list[sizeCounter][0] = Groups3.get(i).getFullGroupName();
            list[sizeCounter][1] = "1";
            sizeCounter++;
        }
        for (int i = 0 ; i < Groups4.size(); i++){
            list[sizeCounter][0] = Groups4.get(i).getFullGroupName();
            list[sizeCounter][1] = "1";
            sizeCounter++;
        }
        for (int i = 0 ; i < Groups5.size(); i++){
            list[sizeCounter][0] = Groups5.get(i).getFullGroupName();
            list[sizeCounter][1] = "1";
            sizeCounter++;
        }
        for (int i = 0 ; i < Groups6.size(); i++){
            list[sizeCounter][0] = Groups6.get(i).getFullGroupName();
            list[sizeCounter][1] = "1";
            sizeCounter++;
        }

        return list;
    }
    public int countOfGroups(){
        int countOfGroup = 0;
        countOfGroup = Groups1.size()+Groups2.size()+Groups3.size()+Groups4.size()+Groups5.size()+Groups6.size();
        return countOfGroup;
    }

    public void setDisciplinesForTeachers(){
        System. out .println("setDisciplinesForTeachers");
        int counter = 0;
        for(Discipline d: Disciplines){
            Teachers.get(counter).addDiscipline(d);
            d.setTeacher(Teachers.get(counter));
            if(counter == Teachers.size() - 1){
                counter = 0;
            }else{
                counter++;
            }
        }
    }

    public void setDisciplinesForGroups(){
        ArrayList<Discipline> DisciplinesToFill = new ArrayList<>();

        for(Discipline d: Disciplines){
            DisciplinesToFill.add(d);
        }
        //System. out .println("ERROR fillTimeTables point -1  " + AllGroups.size());
        ArrayList<Discipline> DisciplinesToFill1 = new ArrayList<>();
        ArrayList<Discipline> DisciplinesToFill2 = new ArrayList<>();
        ArrayList<Discipline> DisciplinesToFill3 = new ArrayList<>();
        ArrayList<Discipline> DisciplinesToFill4 = new ArrayList<>();
        ArrayList<Discipline> DisciplinesToFill5 = new ArrayList<>();
        ArrayList<Discipline> DisciplinesToFill6 = new ArrayList<>();
        for(Discipline d: DisciplinesToFill){
            if(d.getCourseNumber() == 1){
                DisciplinesToFill1.add(d);

            }else if(d.getCourseNumber() == 2){
                DisciplinesToFill2.add(d);

            }else if(d.getCourseNumber() == 3){
                DisciplinesToFill3.add(d);

            }else if(d.getCourseNumber() == 4){
                DisciplinesToFill4.add(d);

            }else if(d.getCourseNumber() == 5){
                DisciplinesToFill5.add(d);

            }else if(d.getCourseNumber() == 6){
                DisciplinesToFill6.add(d);

            }
        }

        for(Group g: Groups1){
            g.DisciplineList = DisciplinesToFill1;
        }
        for(Group g: Groups2){
            g.DisciplineList = DisciplinesToFill2;
        }
        for(Group g: Groups3){
            g.DisciplineList = DisciplinesToFill3;
        }
        for(Group g: Groups4){
            g.DisciplineList = DisciplinesToFill4;
        }
        for(Group g: Groups5){
            g.DisciplineList = DisciplinesToFill5;
        }
        for(Group g: Groups6){
            g.DisciplineList = DisciplinesToFill6;
        }

    }

    public void  fillTimetablesFodiferentGroups(){
        //System. out .println(" fillTimetablesFodiferentGroups 1 ");
        ArrayList<ArrayList<Group>> AllGroups = new ArrayList<>();
        AllGroups.add(Groups1);
        AllGroups.add(Groups2);
        AllGroups.add(Groups3);
        AllGroups.add(Groups4);
        AllGroups.add(Groups5);
        AllGroups.add(Groups6);
        ArrayList<Discipline> DisciplinesToFill = new ArrayList<>();

        //System. out .println(" fillTimetablesFodiferentGroups 2 ");
        int course = 1;
        for(ArrayList<Group> gl: AllGroups){
            //System. out .println(" fillTimetablesFodiferentGroups 3 ");
            for(Group g: gl){
                //System. out .println(" fillTimetablesFodiferentGroups 4 ");
                g.groupTimeTable = fillTimeTable(course);
                //System. out .println(" fillTimetablesFodiferentGroups 5 ");

            }
            course++;
        }

    }

    public Timetable fillTimeTable(int course){
        //System. out .println(" fillTimeTable 1 ");
        Timetable groupTimeTable = new Timetable();

        groupTimeTable.timeTableCreator(semesterStart,semesterEnd);
        //System. out .println(" fillTimeTable 2 ");
        ArrayList<Discipline> DisciplinesToFill = new ArrayList<>();
        for(Discipline d: Disciplines) {
            //System. out .println(" fillTimeTable 3 ");
            if (d.getCourseNumber() == course) {
                DisciplinesToFill.add(d);
                //System. out .println(" fillTimeTable 4 " + d.getNameOfDiscipline());

            }
        }
        int[] Lessons = new int[DisciplinesToFill.size()];
        //System. out .println("count " + DisciplinesToFill.size());

        for(int i = 0; i < DisciplinesToFill.size(); i++){
            Lessons[i] = DisciplinesToFill.get(i).getCountOfLessons();
            //System. out .println("Lessons[i]" + Lessons[i]);
        }

        int index = 0;
        for(int z = 0; z < 7; z++) {
            for (int y = 0; y < 6 ; y++) {
                for (int x = 0; x < groupTimeTable.Days.length ; x++) {
                    //System.out.println("fillTimeTable 5" + " x " + x + " y " + y + " z " + z + " groupTimeTable.Days.length " + groupTimeTable.Days.length);

                    if (groupTimeTable.Days[x][y] != null) {
                        //System.out.println("fillTimeTable no ");


                    if (groupTimeTable.Days[x][y].Lessons.get(z).getDiscipline() == null) {
                        if (Lessons[index] != 0) {
                            groupTimeTable.Days[x][y].Lessons.get(z).setDiscipline(DisciplinesToFill.get(index));
                            groupTimeTable.Days[x][y].Lessons.get(z).setTeacher(DisciplinesToFill.get(index).getTeacher());
                            //DisciplinesToFill.get(index).showDisciplineInfo();
                            //groupTimeTable.Days[x][y].Lessons.get(z).getDiscipline().getNameOfDiscipline();

                            Lessons[index]--;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }else{
                        continue;
                    }

                }
                if(index == Lessons.length - 1){
                    int flag = 0;
                    for(int count: Lessons){
                        if(count > 0){
                            flag++;
                        }else{
                            continue;
                        }
                    }
                    if(flag > 0){
                        index = 0;
                    }else{
                        break;
                    }

                }else {
                    index++;
                }
            }
        }


        return groupTimeTable;

    }

    public void fillTimeTables(){
        ArrayList<ArrayList<Group>> AllGroups = new ArrayList<>();
        AllGroups.add(Groups1);
        AllGroups.add(Groups2);
        AllGroups.add(Groups3);
        AllGroups.add(Groups4);
        AllGroups.add(Groups5);
        AllGroups.add(Groups6);
        ArrayList<Discipline> DisciplinesToFill = new ArrayList<>();
        for(Discipline d: Disciplines){
            DisciplinesToFill.add(d);
        }
        //System. out .println("ERROR fillTimeTables point -1  " + AllGroups.size());
        ArrayList<Discipline> DisciplinesToFill1 = new ArrayList<>();
        ArrayList<Discipline> DisciplinesToFill2 = new ArrayList<>();
        ArrayList<Discipline> DisciplinesToFill3 = new ArrayList<>();
        ArrayList<Discipline> DisciplinesToFill4 = new ArrayList<>();
        ArrayList<Discipline> DisciplinesToFill5 = new ArrayList<>();
        ArrayList<Discipline> DisciplinesToFill6 = new ArrayList<>();
        for(Discipline d: DisciplinesToFill){
            if(d.getCourseNumber() == 1){
                DisciplinesToFill1.add(d);

            }else if(d.getCourseNumber() == 2){
                DisciplinesToFill2.add(d);

            }else if(d.getCourseNumber() == 3){
                DisciplinesToFill3.add(d);

            }else if(d.getCourseNumber() == 4){
                DisciplinesToFill4.add(d);

            }else if(d.getCourseNumber() == 5){
                DisciplinesToFill5.add(d);

            }else if(d.getCourseNumber() == 6){
                DisciplinesToFill6.add(d);

            }
        }

        System.out.println("Disciplines to fill content");
        for(Discipline d: DisciplinesToFill1){
            System.out.print(" # " + d.getNameOfDiscipline());
        }
        System.out.println("");
        for(Discipline d: DisciplinesToFill2){
            System.out.print(" # " + d.getNameOfDiscipline());
        }
        System.out.println("");
        for(Discipline d: DisciplinesToFill3){
            System.out.print(" # " + d.getNameOfDiscipline());
        }
        System.out.println("");
        for(Discipline d: DisciplinesToFill4){
            System.out.print(" # " + d.getNameOfDiscipline());
        }
        System.out.println("");
        for(Discipline d: DisciplinesToFill5){
            System.out.print(" # " + d.getNameOfDiscipline());
        }
        System.out.println("");
        for(Discipline d: DisciplinesToFill6){
            System.out.print(" # " + d.getNameOfDiscipline());
        }
        System.out.println("");

        int[][] LessonsCounterForEachGroup = new int[6][];

        for(int i = 0; i < AllGroups.size(); i++){
            for(int j = 0; j < AllGroups.get(i).size(); j++){
            }
        }


        ArrayList<ArrayList<Discipline>> AllDisciplines = new ArrayList<>();
        AllDisciplines.add(DisciplinesToFill1);
        AllDisciplines.add(DisciplinesToFill2);
        AllDisciplines.add(DisciplinesToFill3);
        AllDisciplines.add(DisciplinesToFill4);
        AllDisciplines.add(DisciplinesToFill5);
        AllDisciplines.add(DisciplinesToFill6);
        int z = 0;
        int l = 0;
        int weeks = Groups1.get(0).groupTimeTable.Days.length;

        int flag = 1;

        int counter = 0;

        for(int lessonNumber = 0; lessonNumber < 7; lessonNumber++){
            for(int weekday = 0; weekday < 6; weekday++) {
            for (int weekNumber = 0; weekNumber < weeks ; weekNumber++){

                    for (int course = 0; course < AllGroups.size(); course++) {
                        for (int group = 0; group < AllGroups.get(course).size(); group++) {
                            if (AllGroups.get(course).get(group).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).getDiscipline() == null){
                                System.out.println(" course " + course + " group " +group +" weekNumber " +weekNumber+" weekday " +weekday+" lessonNumber "+lessonNumber+ "  result " + AllGroups.get(course).get(group).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).getDiscipline());
                                Discipline insertDiscipline = new Discipline();

                                for(Discipline d: AllDisciplines.get(course)){
                                    if(d.getCountOfLessons() != 0){
                                        insertDiscipline = d;
                                        break;
                                    }else{
                                        continue;
                                    }
                                }
                                //System. out .println("ERROR fillTimeTables point0 " + insertDiscipline.getNameOfDiscipline());

                                for (int coursefind = 0; coursefind < AllGroups.size(); coursefind++) {
                                    for (int groupfind = 0; groupfind < AllGroups.get(course).size(); groupfind++) {

                                        //System. out .println("TEST group in fillTimeTables point1 " + AllGroups.get(coursefind).get(groupfind).getFullGroupName());

                                        //System. out .println("ERROR fillTimeTables name1 " + insertDiscipline.getTeacher().getName());
                                        //System. out .println("ERROR fillTimeTables name2 " + AllGroups.get(coursefind).get(groupfind).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).getDiscipline());
                                        //System. out .println("ERROR fillTimeTables name2 " + AllGroups.get(coursefind).get(groupfind).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).getTeacher().getName() );
                                        //System. out .println("ERROR fillTimeTables second name1 " + insertDiscipline.getTeacher().getSecondName());
                                        //System. out .println("ERROR fillTimeTables second name2 " + AllGroups.get(coursefind).get(groupfind).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).getTeacher().getSecondName());

                                        if (counter == 100){
                                            flag = 3;
                                            break;
                                        }
                                        System.out.println("counter = " + counter);
                                        counter++;
                                        if(AllGroups.get(coursefind).get(groupfind).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).getDiscipline() != null) {
                                            if ((insertDiscipline.getTeacher().getName().equals(AllGroups.get(coursefind).get(groupfind).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).getTeacher().getName()))
                                                    && (insertDiscipline.getTeacher().getSecondName().equals(AllGroups.get(coursefind).get(groupfind).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).getTeacher().getSecondName()))) {
                                                //insertDiscipline = null;
                                                System.out.println("ERROR fillTimeTables point2");
                                                flag = 0;
                                            } else {
                                                flag = 1;

                                                //System.out.println("not null  ##### fillTimeTables point3 " + AllGroups.get(course).get(group).getFullGroupName() + "  " + insertDiscipline.getNameOfDiscipline());

                                            }
                                        }else{
                                            flag = 1;
                                            //System.out.println(" NULL ##### fillTimeTables point3 " + AllGroups.get(course).get(group).getFullGroupName() + "  " + insertDiscipline.getNameOfDiscipline());
                                            //System.out.println(" lesson start " + AllGroups.get(coursefind).get(groupfind).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).getTimeStart());
                                        }
                                    }
                                }
                                if(flag == 1){
                                    AllGroups.get(course).get(group).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).setDiscipline(insertDiscipline);
                                    System.out.println(" NULL ##### fillTimeTables point3 " + AllGroups.get(course).get(group).getFullGroupName() + "  " + insertDiscipline.getNameOfDiscipline());
                                    System.out.println(" NULL ##### fillTimeTables point3 " + AllGroups.get(course).get(group).groupTimeTable.Days[weekNumber][weekday].Lessons.get(lessonNumber).getTimeStart());
                                    flag = 0;
                                }else if(flag == 3){

                                    break;
                                }else{
                                    continue;
                                }

                            }else {
                                continue;
                            }
                        }
                    }

                }

            }
        }

        for(int x = 0; x < AllGroups.size(); x++){
            for(int i = 0; i < AllGroups.get(x).size(); i++){
                for(int y = 0; y < AllGroups.get(x).get(i).groupTimeTable.Days.length; y++) {
                   if( AllGroups.get(x).get(i).groupTimeTable.Days[y][z].Lessons.get(l).getDiscipline() == null){

                   }

                }
            }
        }
    }
*/
}
