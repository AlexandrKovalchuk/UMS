package net.ukr.vixtibon;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.stady_process.Discipline;

import java.io.*;
import java.util.*;

/**
 * Created by akovalchuk on 5/21/2015.
 */
public class Generator {
    private ArrayList<String> FemaleNames = openStringsArray("FemaleNames.txt");
    private ArrayList<String> MaleNames = openStringsArray("MaleNames.txt");
    private ArrayList<String> FemaleSurnames = openStringsArray("FemaleSurnames.txt");
    private ArrayList<String> MaleSurnames = openStringsArray("MaleSurnames.txt");

    private ArrayList<String> City = openStringsArray("City.txt");
    private ArrayList<String> gumvs = openStringsArray("gumvs.txt");
    private ArrayList<String> Street = openStringsArray("Street.txt");
    private ArrayList<String> month = openStringsArray("month.txt");

    int insrituteIDCounter = 1;
    int facultyIDCounter = 1;
    int chairIDCounter = 1;
    int groupIDCounter = 1;

    int studentIDCounter = 1;
    int emploeeIDCounter = 1;
    int teacherIDCounter = 1;

    int disciplineIDCounter = 1;
    int timeTableIDcounter = 1;
    /*
    "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\DisciplineTableParameters.xml",
    "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\EmployeeTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\FacultyTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\InstituteTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\TeacherTableParameters.xml"
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\TimeTableTableParameters.xml"
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\ChairTableParameters.xml"
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\GroupTableParameters.xml",
     */

    String[] tapleParametersList = {
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\InstituteTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\FacultyTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\ChairTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\GroupTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\EmployeeTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\TeacherTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\StudentTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\DisciplineTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\TimeTableTableParameters.xml",
            "C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\web\\ParametersXLS\\\\TeacherDisciplineTableParameters.xml"
    };



    //Institute KPI = new Institute("Київський Політехнічний Інститут","КПИ",insrituteIDCounter,null);

    Random rn = new Random();
    Calendar semesterStart = Calendar.getInstance();

           // new Date(2,2,2016);//new Date(generateDay(), randomInt(), generateBirthYear(course));
    Calendar semesterEnd = Calendar.getInstance();
           // new Date(29,5,2016);//new Date(generateDay(), randomInt(), generateBirthYear(course));


    static final  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final  String DB_URL = "jdbc:mysql://localhost:3306/STUDENTS";

    static final  String USER = "username";
    static final  String PASS = "password";
    DataBaseDriver d = new DataBaseDriver();

public void setupBase(String[] list) {
    System.out.println("setupBase");
    for (String s : list) {
        d.tableCreator(s);
    }
}

    public void runGenerator() throws UnsupportedEncodingException {
        //set semecter period
        semesterStart.set(2016,8,1);
        semesterEnd.set(2017,0,30);

        //setup data base
        setupBase(tapleParametersList);




        //create timetables table
       // String timetablesTable = ();


        //openFacultys("Facultys.txt", KPI.getID());
/*
        for(Faculty i: KPI.getFacultys()){
            System.out.println("Short name : " + i.getShortName() + " - " + i.getLongName() );
            ArrayList<Chair> AC = openChairs(i.getShortName() + ".txt", i.getShortName(), i.getID(), "Chair");
            for(Chair c : AC){
                i.addChair(c);
            }
            System. out .println("############# Faculty insert query: " + d.insertQuery(i.qs));
            d.stringProcessor(d.insertQuery(i.qs));
        }
*/
        //info
/*
        for(Faculty f: KPI.getFacultys()){
            System. out .println("############# Faculty : " + f.getLongName());


            for(Chair c: f.Chairs){
                System. out .println("############# Chair : " + c.getLongName() + " - " + c.getShortName());
                //c.showTeachersList();
                //c.showDisciplinesList();

                System. out .println("############# Course 1 : ");
                for(Group g1: c.Groups1){

                    System. out .println("############# Group : " + g1.getFullGroupName());
                    for(Student s: g1.StudentsList){
                        //System. out .println("Name : " + s.getName() + " " + s.getSecondName());
                        //s.fullInfo();
                    }
                    System. out .println(" time table ");
                    //g1.groupTimeTable.showTimeTable();
                }
                System. out .println("############# Course 2 : ");
                for(Group g2: c.Groups2){

                    System. out .println("############# Group : " + g2.getFullGroupName());
                    for(Student s: g2.StudentsList){
                        //s.fullInfo();
                    }
                    //g2.groupTimeTable.showTimeTable();
                }
                System. out .println("############# Course 3 : ");
                for(Group g3: c.Groups3){

                    System. out .println("############# Group : " + g3.getFullGroupName());
                    for(Student s: g3.StudentsList){
                        //s.fullInfo();
                    }
                    //g3.groupTimeTable.showTimeTable();
                }
                System. out .println("############# Course 4 : ");
                for(Group g4: c.Groups4){

                    System. out .println("############# Group : " + g4.getFullGroupName());
                    for(Student s: g4.StudentsList){
                        //s.fullInfo();
                    }
                    //g4.groupTimeTable.showTimeTable();
                }
                System. out .println("############# Course 1 : ");
                for(Group g5: c.Groups5){

                    System. out .println("############# Group : " + g5.getFullGroupName());
                    for(Student s: g5.StudentsList){
                        //s.fullInfo();
                    }
                    //g5.groupTimeTable.showTimeTable();
                }
                System. out .println("############# Course 6 : ");
                for(Group g6: c.Groups6){

                    System. out .println("############# Group : " + g6.getFullGroupName());
                    for(Student s: g6.StudentsList){
                        //s.fullInfo();
                    }
                    //g6.groupTimeTable.showTimeTable();
                }
            }

        }
        */
// PASSWORD CREATOR
        /*
        BufferedWriter w = null;
        try {
            w = new BufferedWriter(new FileWriter("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\login_password.txt"));
            for(LogInSettings entry: LogIns) {
                w.write(entry.getLogin() + " " + entry.getPassword() + " " + entry.getLevel());
                w.newLine();
            }
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

       // d.stringProcessor(d.insertQuery(KPI.qs));

        String str = "SELECT longName, shortName, ID FROM institute";
        d.selectObject(str);
        System. out .println("Institute opening complete");

    }


    public int ecualCount(String number) {
        //System.out.println("inserted " + number);
        int count = 0;
        switch (number) {
            case "0": {
                count = 0;
            }
            break;
            case "1": {
                count = 1;
            }
            break;
            case "2": {
                count = 2;
            }
            break;
            case "3": {
                count = 3;
            }
            break;
            case "4": {
                count = 4;
            }
            break;
            case "5": {
                count = 5;
            }
            break;
            case "6": {
                count = 6;
            }
            break;
            case "7": {
                count = 7;
            }
            break;
            case "8": {
                count = 8;
            }
            break;
            case "9": {
                count = 9;
            }
            break;
            default:
                System.out.println("Error in opening group count");
        }
        return count;
    }
/*
    public ArrayList<Department> openChairs(String name, String faculty, int facultyID, String tName){
        System. out .println("openChairs 1");
        ArrayList<Department> chairs = new ArrayList<Department>();
        try(BufferedReader f =new BufferedReader(new FileReader(name))){
            String str = "";
            for(;(str = f.readLine())!=null;) {
                String[] parts = str.split(" - ");
                int wave = 0;
                //Department chair = new Department(parts[0], parts[1],chairIDCounter,facultyID, tName);
               // chair.semesterStart = semesterStart;
                //chair.semesterEnd = semesterEnd;

                for(int i = 0; i < 15 + rn.nextInt(5); i++) {
                    //chair.Disciplines.add(new Discipline(disciplineIDCounter,"Дисципліна " + chair.Disciplines.size(),1,2,25 + rn.nextInt(8),rn.nextBoolean(),10 +rn.nextInt(5),chair.getID()));
                    disciplineIDCounter++;
                }
                for(int i = 0; i < 15 + rn.nextInt(5); i++) {
                   // chair.Disciplines.add(new Discipline(disciplineIDCounter,"Дисципліна " + chair.Disciplines.size(),2,2,25 + rn.nextInt(8),rn.nextBoolean(),10 +rn.nextInt(5),chair.getID()));
                    disciplineIDCounter++;
                }
                for(int i = 0; i < 15 + rn.nextInt(5); i++) {
                   // chair.Disciplines.add(new Discipline(disciplineIDCounter,"Дисципліна " + chair.Disciplines.size(),3,2,25 + rn.nextInt(8),rn.nextBoolean(),10 +rn.nextInt(5),chair.getID()));
                    disciplineIDCounter++;
                }
                for(int i = 0; i < 13 + rn.nextInt(5); i++) {
                   // chair.Disciplines.add(new Discipline(disciplineIDCounter,"Дисципліна " + chair.Disciplines.size(),4,2,25 + rn.nextInt(8),rn.nextBoolean(),10 +rn.nextInt(5),chair.getID()));
                    disciplineIDCounter++;
                }
                for(int i = 0; i < 11 + rn.nextInt(5); i++) {
                   // chair.Disciplines.add(new Discipline(disciplineIDCounter,"Дисципліна " + chair.Disciplines.size(),5,2,25 + rn.nextInt(8),rn.nextBoolean(),10 +rn.nextInt(5),chair.getID()));
                    disciplineIDCounter++;
                }
                for(int i = 0; i < 7 + rn.nextInt(5); i++) {
                   // chair.Disciplines.add(new Discipline(disciplineIDCounter,"Дисципліна " + chair.Disciplines.size(),6,2,25 + rn.nextInt(8),rn.nextBoolean(),10 +rn.nextInt(5),chair.getID()));
                    disciplineIDCounter++;
                }

                for(int i = 0; i < 3; i++){
                   // chair.Employees.add(generateEmployee(faculty,chair.getLongName(),chair.getID()));
                    String strI = "" + i;
                    LogInSettings lis = new LogInSettings();
                    //lis = chair.Employees.get(i).generateLogIn(toLatinConverter(chair.getShortName()),"hr",strI,LogIns,"");
                    //chair.Employees.get(i).showInfo();
                    //System.out.println("lis login " +lis.getLogin()+ " pass "+lis.getPassword()+" level "+ lis.getLevel());
                    LogIns.add(lis);
                }

                System.out.println("group generation start ");

                //chair.Groups1 = groupsGenerator(parts[1],ecualCount(parts[2]), (wave  == 9 ? wave = 1: wave++), 1, faculty, chair.Disciplines,chair.getID());
                //chair.Groups2 = groupsGenerator(parts[1],ecualCount(parts[2]), (wave  == 9 ? wave = 1: wave++), 2, faculty, chair.Disciplines,chair.getID());
                //chair.Groups3 = groupsGenerator(parts[1],ecualCount(parts[2]), (wave  == 9 ? wave = 1: wave++), 3, faculty, chair.Disciplines,chair.getID());
                //chair.Groups4 = groupsGenerator(parts[1],ecualCount(parts[2]), (wave  == 9 ? wave = 1: wave++), 4, faculty, chair.Disciplines,chair.getID());
                //chair.Groups5 = groupsGenerator(parts[1],ecualCount(parts[2]), (wave  == 9 ? wave = 1: wave++), 5, faculty, chair.Disciplines,chair.getID());
                //chair.Groups6 = groupsGenerator(parts[1],ecualCount(parts[2]), (wave  == 9 ? wave = 1: wave++), 6, faculty, chair.Disciplines,chair.getID());
                System.out.println("group generation end ");

                //for(int i = 0; i < chair.countOfGroups(); i++){
                   // chair.Teachers.add(generateTeacher(faculty, parts[1],chair.getID()));
                    LogInSettings lis = null;
                    //lis = chair.Teachers.get(i).generateLogIn(toLatinConverter(chair.getShortName()),"tc",String.valueOf(i),LogIns,"");
                    LogIns.add(lis);
                }

                //System. out .println("point 0" + chair.Teachers.size());
                //chair.setDisciplinesForTeachers();
                //System. out .println("point 1");

                //chair.showDisciplinesList();
                //chair.showTeachersList();
               // chair.setDisciplinesForGroups();
                //System. out .println(" ##################### showDisciplinesList for group 2 ##################### ");
                //chair.Groups2.get(2).showDisciplinesList();

                //System. out .println("Weeks : " + chair.Groups1.get(0).groupTimeTable.Days.length);
                System. out .println(" ##################### File time table ##################### ");
                chair.fillTimetablesFodiferentGroups();
                //System. out .println("Weeks : " + chair.Groups1.get(0).groupTimeTable.Days.length);
                //System. out .println("Group time table : " + chair.Groups1.get(0).getFullGroupName());
                //chair.Groups1.get(0).groupTimeTable.showTimeTable();
                chairs.add(chair);
            }
            //chairs.get(0).Groups1.get(1).StudentsList.get(5).fullInfo();
            //chairs.get(0).Groups1.get(0).getFullGroupName();
            //chairs.get(0).Groups1.get(0).groupTimeTable.showTimeTable();
            return chairs;
        } catch(IOException e){
            System. out .println("ERROR openChairs");
            return null;
        }

    */

    public String toLatinConverter(String entry){
        //System.out.println("toLatinConverter 1" + " entry " + entry);
        String result = "";
        String[] arrayEntry = entry.split("");
        String[] ciril = {"а","б","ц","д","е","ф","г","х","і","ж","к","л","м","н","о","п","р","с","т","у","в","з","и","й","ч","ш","щ","ь","ю","є","ґ","ї","я"};
        String[] CIRIL = {"А","Б","Ц","Д","Е","Ф","Г","Х","І","Ж","К","Л","М","Н","О","П","Р","С","Т","У","В","З","И","Й","Ч","Ш","Щ","Ь","Ю","Є","Ґ","Ї","Я"};
        String[] latin = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","R","S","T","U","V","W","X","Y","Z","Q"                };

        for(int i = 0; i < arrayEntry.length; i++){
            String letter = "";
            boolean flag = false;
            for(int j = 0; j < ciril.length; j++){
                if(arrayEntry[i].equals(ciril[j])){
                    if(j < 25){
                        letter = latin[j];
                        flag = true;
                        break;

                    }else{
                        letter = latin[25];
                        flag = true;
                        break;
                    }

                }else{
                    continue;
                }
            }
            if(!flag){
                for(int j = 0; j < CIRIL.length; j++){
                    if(arrayEntry[i].equals(CIRIL[j])){
                        if(j < 25){
                            letter = latin[j];
                            flag = true;
                            break;

                        }else{
                            letter = latin[25];
                            flag = true;
                            break;
                        }

                    }else{
                        continue;
                    }
                }
            }
            result += letter;
        }
        //System.out.println("toLatinConverter 2" + " result " + result);
        return  result;
    }

    public String levelGenerate(){
        String level = "";
        String[] list = {"аспірант","кандидат","доктор наук"};
        level = list[rn.nextInt(2)];
        return level;
    }
    public String officeGenerate(){
        String office = "";
        String[] list = {"головний науковий  співробітник","провідний науковий  співробітник","старший   науковий співробітник",
                         "науковий    співробітник","науковий співробітник-консультант"," молодший науковий співробітник "};
        office = list[rn.nextInt(5)];
        return office;
    }

    public ArrayList<Group> groupsGenerator(String chairShortName,int countOfGroups, int wave, int course, String faculty, ArrayList<Discipline> disciplines, int chairID){
        //System. out .println("groupsGenerator 1");
        ArrayList<Group> groups = new ArrayList<Group>();
        //System. out .println("groupsGenerator 2");
        for (int i = 1; i <= countOfGroups; i++){
            //System. out .println("groupsGenerator 3");
            Group group = new Group(wave,groupIDCounter,chairID);
            //System. out .println("groupsGenerator 4");
            group.setCourseNumber(course);
            //System. out .println("groupsGenerator 5");
            group.setGroupIndex(i);
            //System. out .println("groupsGenerator 6");
            group.setFullGroupName(chairShortName);
            //System. out .println("groupsGenerator 7");
            group.StudentsList = generateListOfStudents(course, faculty, chairShortName, wave, i, disciplines,chairID,group.getID());
            //System. out .println("groupsGenerator 8");
            //group.groupTimeTable.timeTableCreator(semesterStart,semesterEnd);
            //System. out .println("groupsGenerator 9");
            groups.add(group);
            //System. out .println("groupsGenerator 10");
            groupIDCounter++;
        }
        return groups;
    }

    public ArrayList<Student> generateListOfStudents(int course, String faculty, String chairShortName, int wave, int groupIndex,ArrayList<Discipline> disciplines, int chairID, int groupID){
        //System. out .println("generateListOfStudents 1");
        ArrayList<Student> students = new ArrayList<Student>();
        //System. out .println("generateListOfStudents 2");
        int difference = rn.nextInt(9);
        int base = 0;
        //System. out .println("generateListOfStudents 3");
        if(course == 1){
            base = 20;
            //System. out .println("generateListOfStudents 4");
        }else if(course == 2) {
            base = 17;
            //System. out .println("generateListOfStudents 5");
        }else if(course == 3) {

            base = 16;
            //System. out .println("generateListOfStudents 6");
        }else if(course == 4) {
            base = 15;
            //System. out .println("generateListOfStudents 7");
        }else if(course == 5) {
            base = 12;
            //System. out .println("generateListOfStudents 8");
        }else if(course == 6) {
            base = 14;
            //System. out .println("generateListOfStudents 9");
        }
        int count = base + difference;
        for(int i = 0; i < count; i++) {
            int studentNumber = i+1;
            //System. out .println("generateListOfStudents 10");
            Student student = generateStudent(course, faculty, chairShortName, wave, studentNumber, groupIndex, disciplines,chairID,groupID);
            //System. out .println("generateListOfStudents 11");
            students.add(student);
            //System. out .println("generateListOfStudents 12");
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(studentNumber);
            String strI = sb.toString();



        }
            return students;
    }

    public Employee generateEmployee(String faculty, String chair, int chairID){
        boolean male = rn.nextBoolean();
        Calendar personDate = Calendar.getInstance();
        personDate.set(generateTeachersBirthYear(), randomInt(), generateDay());
        Calendar pasportDate = Calendar.getInstance();
        pasportDate.set(personDate.get(Calendar.YEAR)+1, randomInt(), generateDay());
        String city = randomString(City);
        String pasportNumber = generatePasportNumber();
        String indifCode = generatePersonalID();
        emploeeIDCounter++;
        return null;


    }

    public Teacher generateTeacher(String faculty, String chair, int chairID){
        boolean male = rn.nextBoolean();
        Calendar personDate = Calendar.getInstance();
        personDate.set(generateTeachersBirthYear(), randomInt(), generateDay());
        Calendar pasportDate = Calendar.getInstance();
        pasportDate.set(personDate.get(Calendar.YEAR)+1, randomInt(), generateDay());

        String city = randomString(City);
        String pasportNumber = generatePasportNumber();
        String indifCode = generatePersonalID();
return  null;
    }

    public Student generateStudent(int course, String faculty, String chairShortName, int wave, int index, int groupIndex, ArrayList<Discipline> disciplines, int chairID, int groupID){
        //System. out .println("generateStudent 1");
        boolean male = rn.nextBoolean();
        Calendar personDate = Calendar.getInstance();
        personDate.set(generateBirthYear(course), randomInt(), generateDay());
        Calendar pasportDate = Calendar.getInstance();
        pasportDate.set(personDate.get(Calendar.YEAR)+1, randomInt(), generateDay());

        String city = randomString(City);
        String pasportNumber = generatePasportNumber();
        String indifCode = generatePersonalID();
        //System. out .println("generateStudent 2");
        return  null;

    }
/*
    public Institute openFacultys(String name, int instID){
        try(BufferedReader f =new BufferedReader(new FileReader(name))){
            String str = "";
            for(;(str = f.readLine())!=null;) {
                String[] parts = str.split(" - ");
                //Faculty faculty = new Faculty(parts[0], parts[1],facultyIDCounter, "Faculty", instID);
                facultyIDCounter++;
                //KPI.addFaculty(faculty);
            }
           // return KPI;
        } catch(IOException e){
            System. out .println("ERROR openFacultys");
            return null;
        }
    }
    */
    public int generateBirthYear(int course){
        int year = 2015 - rn.nextInt(2) - course - 16;
        return year;
    }
    public int generateTeachersBirthYear(){
        int year = 2015;
        year = year - 24 - rn.nextInt(50);
        return year;
    }

    public String randomString(ArrayList<String> strings){
        String string = "";
        string = strings.get(rn.nextInt(strings.size() - 1));
        return string;
    }
    public int randomInt(){
        int munth ;
        munth = rn.nextInt(12);
        return munth;
    }

    public ArrayList<String> openStringsArray(String name){
        ArrayList<String> list = new ArrayList<String>();
        try(BufferedReader f =new BufferedReader(new FileReader(name))){
            String str = "";
            for(;(str = f.readLine())!=null;) {
                list.add(str);
            }
        } catch(IOException e){
            System. out .println("ERROR open " + name);
        }

        return list;
    }

    public void showList(ArrayList<String> list){
        for(int i = 0; i < list.size(); i++) {
            System.out.println("index :" + i + " item : " + list.get(i));
        }
    }
    public int generateDay(){
        int day;
        day = rn.nextInt(30);
        if(day == 0){
            day++;
        }
        return day;
    }

    public String generatePostIndex(){
        String postIndex = "";
        for(int i = 0; i < 5; i++){
            postIndex = postIndex + rn.nextInt(9);
        }
        return postIndex;
    }

    public String generatePhoneNumber(){
        String phone = "";
        switch (rn.nextInt(12)) {
            case 0: {
                phone = phone + "039";
            }
            break;
            case 1: {
                phone = phone + "050";
            }
            break;
            case 2: {
                phone = phone + "063";
            }
            break;
            case 3: {
                phone = phone + "066";
            }
            break;
            case 4: {
                phone = phone + "067";
            }
            break;
            case 5: {
                phone = phone + "068";
            }
            break;
            case 6: {
                phone = phone + "091";
            }
            break;
            case 7: {
                phone = phone + "092";
            }
            break;
            case 8: {
                phone = phone + "093";
            }
            break;
            case 9: {
                phone = phone + "094";
            }
            break;
            case 10: {
                phone = phone + "095";
            }
            break;
            case 11: {
                phone = phone + "096";
            }
            break;
            case 12: {
                phone = phone + "097";
            }
            break;
            default:
                System.out.println("Error in generating phone number");
        }
        for(int i = 0; i <7 ; i++){
            phone = phone + rn.nextInt(9);
        }
        return phone;
    }

    public String generatePersonalID(){
        String personalID = null;
        long step = 1000000000;
        for(int i = 0; i < 10; i++){
            int value = rn.nextInt(9);
            if(value == 0){
                value = 1;
            }
            personalID = personalID + (step * value);
            step = step/10;
        }
        return personalID;
    }

    public String generatePasportNumber(){
        String pasportNumber = null;
        long step = 100000;
        for(int i = 0; i < 10; i++){
            int value = rn.nextInt(9);
            if(value == 0){
                value = 1;
            }
            pasportNumber = pasportNumber + (step * value);
            step = step/10;
        }
        return pasportNumber;
    }

    public String generatePasportSeria(){
        String pasportSeria = generateChar(25) + generateChar(25);
        return pasportSeria;
    }
    public String generateHouseNumber(){
        String houseNumber = rn.nextInt(150) + generateChar(6);
        return houseNumber;
    }
    public String generateChar(int value){
        String str = "";
            switch (rn.nextInt(value)) {
                case 0: {
                    str = "A";
                }
                break;
                case 1: {
                    str = "B";
                }
                break;
                case 2: {
                    str = "C";
                }
                break;
                case 3: {
                    str = "D";
                }
                break;
                case 4: {
                    str = "E";
                }
                break;
                case 5: {
                    str = "F";
                }
                break;
                case 6: {
                    str = "G";
                }
                break;
                case 7: {
                    str = "H";
                }
                break;
                case 8: {
                    str = "I";
                }
                break;
                case 9: {
                    str = "J";
                }
                break;
                case 10: {
                    str = "K";
                }
                break;
                case 11: {
                    str = "L";
                }
                break;
                case 12: {
                    str = "M";
                }
                break;
                case 13: {
                    str = "N";
                }
                break;
                case 14: {
                    str = "O";
                }
                break;
                case 15: {
                    str = "P";
                }
                break;
                case 16: {
                    str = "Q";
                }
                break;
                case 17: {
                    str = "R";
                }
                break;
                case 18: {
                    str = "S";
                }
                break;
                case 19: {
                    str = "T";
                }
                break;
                case 20: {
                    str = "U";
                }
                break;
                case 21: {
                    str = "V";
                }
                break;
                case 22: {
                    str = "W";
                }
                break;
                case 23: {
                    str = "X";
                }
                break;
                case 24: {
                    str =  "Y";
                }
                break;
                case 25: {
                    str = "Z";
                }
                break;
                default:
                    System.out.println("Error max value overflow");
            }
        return  str;
        }

}
