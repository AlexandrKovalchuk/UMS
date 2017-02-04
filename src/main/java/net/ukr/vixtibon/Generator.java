package net.ukr.vixtibon;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.Group;
import net.ukr.vixtibon.dao.departments.DAODepartment;
import net.ukr.vixtibon.dao.departments.DAOFaculty;
import net.ukr.vixtibon.dao.departments.DAOInstitute;
import net.ukr.vixtibon.dao.login.DAOLogin;
import net.ukr.vixtibon.dao.persons.DAOEmployee;
import net.ukr.vixtibon.login_body.LogInBody;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by akovalchuk on 5/21/2015.
 */
public class Generator {
    private ArrayList<String> FemaleNames = openStringsArray("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\FemaleNames.txt");
    private ArrayList<String> MaleNames = openStringsArray("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\MaleNames.txt");
    private ArrayList<String> FemaleSurnames = openStringsArray("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\FemaleSurnames.txt");
    private ArrayList<String> MaleSurnames = openStringsArray("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\MaleSurnames.txt");
    private ArrayList<String> FemaleFathersNames = openStringsArray("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\FemaleFathersNames.txt");
    private ArrayList<String> MaleFathersNames = openStringsArray("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\MaleFathersNames.txt");

    private ArrayList<String> City = openStringsArray("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\City.txt");
    private ArrayList<String> gumvs = openStringsArray("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\gumvs.txt");
    private ArrayList<String> Street = openStringsArray("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\Street.txt");
    private ArrayList<String> month = openStringsArray("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\month.txt");

    int insrituteIDCounter = 1;
    int facultyIDCounter = 1;
    int chairIDCounter = 1;
    int groupIDCounter = 1;

    int studentIDCounter = 1;
    int emploeeIDCounter = 1;
    int teacherIDCounter = 1;

    int disciplineIDCounter = 1;
    int timeTableIDcounter = 1;


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


    Random rn = new Random();
    Calendar semesterStart = Calendar.getInstance();

           // new Date(2,2,2016);//new Date(generateDay(), randomInt(), generateBirthYear(course));
    Calendar semesterEnd = Calendar.getInstance();
           // new Date(29,5,2016);//new Date(generateDay(), randomInt(), generateBirthYear(course));


    public boolean generateDate(){
        DAOInstitute daoInstitute = new DAOInstitute();
        DAOFaculty daoFaculty = new DAOFaculty();
        DAODepartment daoDepartment = new DAODepartment();
        DAOEmployee daoEmployee = new DAOEmployee();
        DAOLogin daoLogin = new DAOLogin();
        boolean result = true;
        daoInstitute.createNONE();
        daoFaculty.createNONE();
        daoDepartment.createNONE();
        daoLogin.createAdmin();
        daoInstitute.create(generateInstitute("Київський Політехнічний Інститут", "КПИ"));
        ArrayList<Faculty> faculties = openFacultys("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\Facultys.txt",1);
        for (Faculty f: faculties){
            daoFaculty.create(f);
        }

        faculties = daoFaculty.getAll();

        ArrayList<Department> departments = new ArrayList<Department>();

        for (Faculty f: faculties){
            if(f.getID() == 0){
                continue;
            }
            departments = openDepartments("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\" + f.getShortName(),f.getID());
            System. out .println("f.getShortName() " + f.getShortName() + " ID " + f.getID());
            for (Department d: departments){
                try {
                    daoDepartment.create(d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        departments = daoDepartment.getAll();

        for(Department d: departments){
            System.out.println("d.getID() :" + d.getID());
            if(d.getID() == 0){
                continue;
            }else {
                d.setEmployees(generateEmployeesList(d.getID()));
                System.out.println("d.getEmployees().size() :" + d.getEmployees().size());
                for (Employee e : d.getEmployees()) {
                    LogInBody lb = new LogInBody();
                    lb.setAccess("employee");
                    lb.setPassword(e.generatePassword());
                    lb.setLogIn(e.getLogin());
                    daoLogin.create(lb);
                    try {
                        daoEmployee.create(e);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

        daoEmployee.closeConnection();
        daoDepartment.closeConnection();
        daoDepartment.closeConnection();
        daoFaculty.closeConnection();
        daoInstitute.closeConnection();
        return result;
    }
    public boolean deleteDate(){
        DAOLogin daoLogin = new DAOLogin();
        boolean result = true;
        String[] tables = {"institute","faculty","department","employee","loginpass"};
        for(int i=0; i<tables.length; i++){
            result = daoLogin.deleteDate(tables[i]);
            if(tables[i].equals("loginpass")){
                daoLogin.createAdmin();
            }
            if(result == false){
                break;
            }
        }
        return result;
    }

public void setupBase(String[] list) {
    System.out.println("setupBase");
    for (String s : list) {
    }
}

private Institute generateInstitute(String longName, String shortName){
    Institute institute = new Institute();
    institute.setLongName(longName);
    institute.setShortName(shortName);
    return institute;
}

    private Faculty ganerateFaculty(String longName, String shortName, int instituteID){
        Faculty faculty = new Faculty();
        faculty.setLongName(longName);
        faculty.setShortName(shortName);
        faculty.setInstituteID(instituteID);
        return faculty;
    }

    private  Department generateDepartment(String longName, String shortName, int facultyID){
        Department department = new Department();
        department.setLongName(longName);
        department.setShortName(shortName);
        department.setFacultyID(facultyID);
        return department;
    }

    private Employee generateEmployee(int departmentID){
        Employee employee = new Employee();
        employee.setSex(rn.nextBoolean()?"m":"f");
        if(employee.getSex().equals("m")){
            employee.setName(MaleNames.get(rn.nextInt(MaleNames.size()-1)));
            employee.setlastName(MaleSurnames.get(rn.nextInt(MaleSurnames.size()-1)));
            employee.setfathersName(MaleFathersNames.get(rn.nextInt(MaleFathersNames.size()-1)));
        }else{
            employee.setName(FemaleNames.get(rn.nextInt(FemaleNames.size()-1)));
            employee.setlastName(FemaleSurnames.get(rn.nextInt(FemaleSurnames.size()-1)));
            employee.setfathersName(FemaleFathersNames.get(rn.nextInt(FemaleFathersNames.size()-1)));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        int day = rn.nextInt(30)+1;
        int month = rn.nextInt(11)+1;
        int year = rn.nextInt(39)+1956;
        if(month == 2){
            if(day > 28){
                day = 28;
            }
        }
        String dateInString = ""+day +"-"+month +"-"+year+" 10:20:56";
        System.out.println("dateInString : " + dateInString);
        Date date = new Date();
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setDateOfBorn(date);
        employee.setPersonalID(generatePersonalID());
        employee.setEmail(generateEmail(employee.getName(), employee.getSecondName()));
        employee.setPhoneNumber(generatePhoneNumber());
        employee.setAddress(generatePostIndex()+ " " + City.get(rn.nextInt(City.size() - 1)) + " " + Street.get(rn.nextInt(Street.size() - 1))
                + " " + rn.nextInt(100)  + ", " + rn.nextInt(300));
        employee.setPasport(generatePasportSeria() + generatePasportNumber() + " " + gumvs.get(rn.nextInt(gumvs.size() - 1)));
        employee.setOffice("HR");
        employee.setLogin(employee.getEmail());
        employee.setDepartmentID(departmentID);
        return employee;
    }

    private String generateEmail(String name, String lastName){
        String email = "";
        String[] domens = {"gmx.de", "hotmail.de", "live.de", "online.de", "t-online.de" /* T-Mobile */, "web.de",
                           "hotmail.fr", "live.fr", "laposte.net", "yahoo.fr", "wanadoo.fr", "orange.fr", "gmx.fr",
                           "btinternet.com", "virginmedia.com", "blueyonder.co.uk", "freeserve.co.uk", "live.co.uk",
                           "ntlworld.com", "o2.co.uk", "orange.net", "sky.com", "talktalk.co.uk", "tiscali.co.uk",
                           "virgin.net", "wanadoo.co.uk", "bt.com"};
        email = toLatinConverter(name) + toLatinConverter(lastName) + "@" + domens[rn.nextInt(domens.length-1)];
        return email;
    }

    private ArrayList<Employee> generateEmployeesList(int departmentID){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        int employeesCOUNT = rn.nextInt(4) + 1;

        System.out.println("employeesCOUNT" + employeesCOUNT);
        System.out.println("departmentID" + departmentID);

        for(int i = 0; i < employeesCOUNT; i++){
            employees.add(generateEmployee(departmentID));
        }
        return employees;
    }
    private ArrayList<Faculty> openFacultys(String name, int instID){
        ArrayList<Faculty> faculties = new ArrayList<>();
        try(BufferedReader f =new BufferedReader(new FileReader(name))){
            String str = "";
            for(;(str = f.readLine())!=null;) {
                String[] parts = str.split(" - ");
                faculties.add(ganerateFaculty(parts[0],parts[1],instID));
            }
            return faculties;
        } catch(IOException e){
            System. out .println("ERROR openFacultys");
            return null;
        }
    }

    private  ArrayList<Department> openDepartments(String facultyShortName, int facultyID){
        ArrayList<Department> departments = new ArrayList<>();
        System. out .println(facultyShortName + ".txt");
        try(BufferedReader f =new BufferedReader(new FileReader(facultyShortName + ".txt"))){

            String str = "";
            for(;(str = f.readLine())!=null;) {
                System. out .println(str);
                String[] parts = str.split(" - ");
                //System. out .println("openDepartments : " + parts[0] + " " + parts[1] + " " + instID);
                departments.add(generateDepartment(parts[0], parts[1], facultyID));
            }
            return departments;
        } catch(IOException e){
            System. out .println("ERROR openDepartments");
            return null;
        }
    }

    public void runGenerator() throws UnsupportedEncodingException {
        //set semecter period
        semesterStart.set(2016,8,1);
        semesterEnd.set(2017,0,30);

        //setup data base
        setupBase(tapleParametersList);

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
            //System. out .println("groupsGenerator 4");
            //System. out .println("groupsGenerator 5");
            //System. out .println("groupsGenerator 6");
            //System. out .println("groupsGenerator 7");
            //System. out .println("groupsGenerator 8");
            //group.groupTimeTable.timeTableCreator(semesterStart,semesterEnd);
            //System. out .println("groupsGenerator 9");
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
        String personalID = "";
        for(int i = 0; i < 10; i++){
            int dig = rn.nextInt(9);
            if(i==0){
                if(dig == 0){
                    dig = dig +1;
                }
            }
            personalID = personalID + dig;
        }
        System.out.println("personalID :" + personalID);
        return personalID;
    }

    public String generatePasportNumber(){
        String pasportNumber = "";
        for(int i = 0; i < 6; i++){
            int value = rn.nextInt(9);
            if(value == 0){
                value = 1;
            }
            pasportNumber = pasportNumber + value;
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
