package servlets;

import net.ukr.vixtibon.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by alex on 06/06/2016.
 */
public class FormReaderServlet extends HttpServlet {
    public QuerySet qs = new QuerySet();
    String tableNameParameter = null;
    String operation = null;

    protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System. out .println("FormReaderServlet dopost method in" );
        tableNameParameter = request.getParameter("tableNameParameter");
        operation = request.getParameter("operation");
        System. out .println("FormReaderServlet dopost 1 " + tableNameParameter);
        Enumeration paramNames = request.getParameterNames();
        DataBaseDriver d = new DataBaseDriver();
        int LocationID = 0;
        boolean success = false;


        if(tableNameParameter.equals("Institute")) {
            String longName = "";
            String shortName = "";
            int ID = 0;
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String paramValue = new String(request.getParameter(paramName).getBytes("iso-8859-1"),"UTF-8");
                if(paramName.equals("longName")){
                    longName = paramValue;
                }else if(paramName.equals("shortName")){
                    shortName = paramValue;
                }else if(paramName.equals("ID")){
                    ID = Integer.parseInt(paramValue);
                }

                System.out.println("FormReaderServlet dopost 2 i counter " + paramName + " " + paramValue);
            }

            if(operation.equals("create")) {
                ID = d.findFreeID("Institute");
            }

            System.out.println("FormReaderServlet dopost 2  institute value " + ID);
            Institute i = new Institute(longName,shortName,ID,tableNameParameter);
            qs = i.qs;

        }else if(tableNameParameter.equals("chair")){
            String longName = "";
            String shortName = "";
            int facultyID = 0 ;
            int ID = 0;
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String paramValue = new String(request.getParameter(paramName).getBytes("iso-8859-1"),"UTF-8");

                if(paramName.equals("longName")){
                    longName = paramValue;
                }else if(paramName.equals("shortName")){
                    shortName = paramValue;
                }else if(paramName.equals("facultyID")){
                    facultyID = Integer.parseInt(paramValue);
                    LocationID = facultyID;
                }
                System.out.println("FormReaderServlet dopost 2 i counter " + paramName + " " + paramValue);
            }
            ID= d.findFreeID("chair");

            Chair c = new Chair(longName, shortName,ID, facultyID, tableNameParameter);
            qs = c.qs;
            System.out.println("chair done ");
        }else if(tableNameParameter.equals("faculty")) {
            System.out.println("FormReaderServlet dopost 2 i Faculty " );
            String longName = "";
            String shortName = "";
            int instituteID = 0;
            int ID = 0;
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String paramValue = new String(request.getParameter(paramName).getBytes("iso-8859-1"),"UTF-8");
                if (paramName.equals("longName")) {
                    longName = paramValue;
                } else if (paramName.equals("shortName")) {
                    shortName = paramValue;
                } else if (paramName.equals("instituteID")) {
                    instituteID = Integer.parseInt(paramValue);
                    LocationID = instituteID;
                }
            }
            ID = d.findFreeID("faculty");

            Faculty f = new Faculty(longName, shortName,ID, tableNameParameter,instituteID);

            qs = f.qs;
        }else if(tableNameParameter.equals("employee")) {
            System.out.println("FormReaderServlet dopost Employee 1 ");
            String name = "";
            String secondName = "";
            String surname = "";
            String personalID = "";
            String sex = "";
            String email = "";
            String phoneNumber = "";
            String address = "";
            String pasport = "";
            String office = "";
            int chairID = 0;
            int ID = 0;
            int bday = 0;
            int bmonth = 0;
            int byear = 0;
            System.out.println("FormReaderServlet dopost Employee 2 ");
            while (paramNames.hasMoreElements()) {
                System.out.println("FormReaderServlet dopost Employee 3 ");
                String paramName = (String) paramNames.nextElement();
                String paramValue = new String(request.getParameter(paramName).getBytes("iso-8859-1"),"UTF-8");
                if (paramName.equals("name")) {
                    name = paramValue;
                } else if (paramName.equals("lastName")) {
                    secondName = paramValue;
                }else if (paramName.equals("fathersName")) {
                    surname = paramValue;
                }else if (paramName.equals("personalID")) {
                    personalID = paramValue;
                }else if (paramName.equals("sex")) {
                    sex = paramValue;
                }else if (paramName.equals("email")) {
                    email = paramValue;
                }else if (paramName.equals("phoneNumber")) {
                    phoneNumber = paramValue;
                }else if (paramName.equals("country")) {
                    address += paramValue + " ";
                }else if (paramName.equals("city")) {
                    address += paramValue + " ";
                }else if (paramName.equals("street")) {
                    address += paramValue + " ";
                }else if (paramName.equals("house")) {
                    address += paramValue + " ";
                }else if (paramName.equals("appartment")) {
                    address += paramValue + " ";
                }else if (paramName.equals("postIndex")) {
                    address += paramValue + " ";
                }else if (paramName.equals("seria")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("number")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("whereIssued")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("issuedByWhom")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("day")) {
                    pasport += paramValue + "/";
                }else if (paramName.equals("month")) {
                    pasport += paramValue + "/";
                }else if (paramName.equals("year")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("office")) {
                    office = paramValue;
                }else if (paramName.equals("chairID")) {
                    chairID = Integer.parseInt(paramValue);
                    LocationID = chairID;
                }else if (paramName.equals("bday")) {
                    bday = Integer.parseInt(paramValue);
                }else if (paramName.equals("bmonth")) {
                    bmonth = Integer.parseInt(paramValue);
                }else if (paramName.equals("byear")) {
                    byear = Integer.parseInt(paramValue);
                }
                System.out.println("FormReaderServlet dopost 2 i counter " + paramName + " " + paramValue);
            }
            System.out.println("FormReaderServlet dopost Employee 4 ");
            Calendar mc = Calendar.getInstance();
            mc.set(byear, bmonth, bday);
            ID = d.findFreeID("employee");

            Employee e = new Employee(ID,name, secondName, surname, personalID, sex, email, phoneNumber,
                    mc, address, pasport, office, chairID);
            qs = e.qs;
        }else if(tableNameParameter.equals("Teacher")) {
            String name = "";
            String secondName = "";
            String surname = "";
            String personalID = "";
            String sex = "";
            String email = "";
            String phoneNumber = "";
            String address = "";
            String pasport = "";
            String office = "";
            String level = "";
            String faculty = "";
            String chair = "";
            int chairID = 0;
            int ID = 0;
            int bday = 0;
            int bmonth = 0;
            int byear = 0;
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String paramValue = new String(request.getParameter(paramName).getBytes("iso-8859-1"),"UTF-8");
                if (paramName.equals("name")) {
                    name = paramValue;
                } else if (paramName.equals("lastName")) {
                    secondName = paramValue;
                }else if (paramName.equals("fathersName")) {
                    surname = paramValue;
                }else if (paramName.equals("personalID")) {
                    personalID = paramValue;
                }else if (paramName.equals("sex")) {
                    sex = paramValue;
                }else if (paramName.equals("email")) {
                    email = paramValue;
                }else if (paramName.equals("phoneNumber")) {
                    phoneNumber = paramValue;
                }else if (paramName.equals("country")) {
                    address += paramValue + " ";
                }else if (paramName.equals("city")) {
                    address += paramValue + " ";
                }else if (paramName.equals("street")) {
                    address += paramValue + " ";
                }else if (paramName.equals("house")) {
                    address += paramValue + " ";
                }else if (paramName.equals("appartment")) {
                    address += paramValue + " ";
                }else if (paramName.equals("postIndex")) {
                    address += paramValue + " ";
                }else if (paramName.equals("seria")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("number")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("whereIssued")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("issuedByWhom")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("day")) {
                    pasport += paramValue + "/";
                }else if (paramName.equals("month")) {
                    pasport += paramValue + "/";
                }else if (paramName.equals("year")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("office")) {
                    office = paramValue;
                }else if (paramName.equals("faculty")) {
                    faculty = paramValue;
                }else if (paramName.equals("chair")) {
                    chair = paramValue;
                }else if (paramName.equals("chairID")) {
                    chairID = Integer.parseInt(paramValue);
                }else if (paramName.equals("bday")) {
                    bday = Integer.parseInt(paramValue);
                }else if (paramName.equals("bmonth")) {
                    bmonth = Integer.parseInt(paramValue);
                }else if (paramName.equals("byear")) {
                    byear = Integer.parseInt(paramValue);
                }else if (paramName.equals("level")) {
                    level = paramValue;
                }
                System.out.println("FormReaderServlet dopost 2 i counter " + paramName + " " + paramValue);
            }
            Calendar mc = Calendar.getInstance();
            mc.set(byear, bmonth, bday);
            ID = d.findFreeID("teacher");
            Teacher t = new Teacher(ID,name, secondName,  surname,  personalID,  sex,  email,  phoneNumber,
                    mc,  address,  pasport,  office, level,  faculty,  chair,  chairID);


            qs = t.qs;
        }else if(tableNameParameter.equals("Student")) {
            String name = "";
            String secondName = "";
            String surname = "";
            String personalID = "";
            String sex = "";
            String email = "";
            String phoneNumber = "";
            String address = "";
            String pasport = "";
            String office = "";
            String level = "";
            String faculty = "";
            String chair = "";
            String chairID = "";
            int bday = 0;
            int bmonth = 0;
            int byear = 0;
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String paramValue = new String(request.getParameter(paramName).getBytes("iso-8859-1"),"UTF-8");
                if (paramName.equals("name")) {
                    name = paramValue;
                } else if (paramName.equals("lastName")) {
                    secondName = paramValue;
                }else if (paramName.equals("fathersName")) {
                    surname = paramValue;
                }else if (paramName.equals("personalID")) {
                    personalID = paramValue;
                }else if (paramName.equals("sex")) {
                    sex = paramValue;
                }else if (paramName.equals("email")) {
                    email = paramValue;
                }else if (paramName.equals("phoneNumber")) {
                    phoneNumber = paramValue;
                }else if (paramName.equals("country")) {
                    address += paramValue + " ";
                }else if (paramName.equals("city")) {
                    address += paramValue + " ";
                }else if (paramName.equals("street")) {
                    address += paramValue + " ";
                }else if (paramName.equals("house")) {
                    address += paramValue + " ";
                }else if (paramName.equals("appartment")) {
                    address += paramValue + " ";
                }else if (paramName.equals("postIndex")) {
                    address += paramValue + " ";
                }else if (paramName.equals("seria")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("number")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("whereIssued")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("issuedByWhom")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("day")) {
                    pasport += paramValue + "/";
                }else if (paramName.equals("month")) {
                    pasport += paramValue + "/";
                }else if (paramName.equals("year")) {
                    pasport += paramValue + " ";
                }else if (paramName.equals("office")) {
                    office = paramValue;
                }else if (paramName.equals("faculty")) {
                    faculty = paramValue;
                }else if (paramName.equals("chair")) {
                    chair = paramValue;
                }else if (paramName.equals("chairID")) {
                    chairID = paramValue;
                }else if (paramName.equals("bday")) {
                    bday = Integer.parseInt(paramValue);
                }else if (paramName.equals("bmonth")) {
                    bmonth = Integer.parseInt(paramValue);
                }else if (paramName.equals("byear")) {
                    byear = Integer.parseInt(paramValue);
                }else if (paramName.equals("level")) {
                    level = paramValue;
                }
                System.out.println("FormReaderServlet dopost 2 i counter " + paramName + " " + paramValue);
            }
            /*
            Calendar mc = Calendar.getInstance();
            mc.set(byear, bmonth, bday);
            Student s = new Student(name, secondName,  surname,  personalID, sex, email, phoneNumber,
                    mc, address, pasport, office, level, faculty, chair, chairID);

                                   (name, secondName, surname, personalID, sex, email, phoneNumber,
                    mc, address, pasport, String faculty, String indexBook, String fullIdentifier,
            int index, ArrayList<Discipline> disciplines, String chairID, String groupID)


            qs = t.qs;
            */
        }
        qs.showSet();

        if(operation.equals("create")){
            success = d.stringProcessor(d.insertQuery(qs));
        }else if(operation.equals("update")) {
            QuerySet qsToUpdate = new QuerySet();
            QuerySet qsNotModyfied = new QuerySet();
            String tnp = request.getParameter("tableNameParameter");
            int ID = Integer.parseInt(request.getParameter("ID"));
            if(tnp.equals("institute")){
                ArrayList<Institute> i = d.getDateInstitute("SELECT longName, shortName, ID FROM institute WHERE ID =" + ID);
                qsNotModyfied = i.get(0).qs;
                

            }
            d.updateQuery(qsToUpdate,tnp,ID);
            success = d.stringProcessor(d.updateQuery(qsToUpdate));
        }else if(operation.equals("move")){
            int idToChange = 0;
            if(request.getParameter("tableNameParameter").equals("faculty")){
                idToChange = Integer.parseInt(request.getParameter("instituteID"));
            }else if(request.getParameter("tableNameParameter").equals("chair")){
                idToChange = Integer.parseInt(request.getParameter("facultyID"));
            }else if(request.getParameter("tableNameParameter").equals("employee")){
                idToChange = Integer.parseInt(request.getParameter("chairID"));
            }else if(request.getParameter("tableNameParameter").equals("discipline")){
                idToChange = Integer.parseInt(request.getParameter("chairID"));
            }else if(request.getParameter("tableNameParameter").equals("teacher")){
                idToChange = Integer.parseInt(request.getParameter("chairID"));
            }else if(request.getParameter("tableNameParameter").equals("timetable")){
                idToChange = Integer.parseInt(request.getParameter("chairID"));
            }else if(request.getParameter("tableNameParameter").equals("group")){
                idToChange = Integer.parseInt(request.getParameter("chairID"));
            }else if(request.getParameter("tableNameParameter").equals("student")){
                idToChange = Integer.parseInt(request.getParameter("groupID"));
            }
            System.out.println("idToChange   " + idToChange);

            success = d.moveItem(request.getParameter("tableNameParameter"),Integer.parseInt(request.getParameter("id")),idToChange);

        }else if(operation.equals("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            success = d.deleteItem(request.getParameter("tableNameParameter"),id);
            if(request.getParameter("tableNameParameter").equals("Institute")){
                d.stringProcessor("UPDATE faculty SET instituteID = '0' WHERE instituteID ='" + id + "';");
            }else if(request.getParameter("tableNameParameter").equals("faculty")){
                d.stringProcessor("UPDATE chair SET facultyID = '0' WHERE facultyID ='" + id + "';");
            }else if(request.getParameter("tableNameParameter").equals("chair")){
                d.stringProcessor("UPDATE emploee SET chairID = '0' WHERE chairID ='" + id + "';");
                d.stringProcessor("UPDATE teacher SET chairID = '0' WHERE chairID ='" + id + "';");
                d.stringProcessor("UPDATE discipline SET chairID = '0' WHERE chairID ='" + id + "';");
                d.stringProcessor("UPDATE group SET chairID = '0' WHERE chairID ='" + id + "';");
            }
        }
        if(success){
            if(operation.equals("create")){
                response.sendRedirect("Admin/ActionResult.jsp?result=success"+"&type=" +
                        (tableNameParameter.equals("Institute")?"Institute":"")+
                        (tableNameParameter.equals("chair")?"chair":"")+
                        (tableNameParameter.equals("employee")?"employee":"")+
                        (tableNameParameter.equals("faculty")?"faculty":"")+
                        "&action=create" + "&locationID=" + LocationID);
            }else if(operation.equals("update")){
                response.sendRedirect("Admin/ActionResult.jsp?result=success"+"&type=" +
                        (tableNameParameter.equals("Institute")?"Institute":"")+
                        (tableNameParameter.equals("chair")?"chair":"")+
                        (tableNameParameter.equals("employee")?"employee":"")+
                        (tableNameParameter.equals("faculty")?"faculty":"")+
                        "&action=update" + "&locationID=" + LocationID);
            }else if(operation.equals("move")){
                response.sendRedirect("Admin/ActionResult.jsp?result=success"+"&type=" +
                        (tableNameParameter.equals("Institute")?"Institute":"")+
                        (tableNameParameter.equals("chair")?"chair":"")+
                        (tableNameParameter.equals("employee")?"employee":"")+
                        (tableNameParameter.equals("faculty")?"faculty":"")+
                        "&action=move" + "&locationID=" + LocationID);
            }else if(operation.equals("delete")){
                response.sendRedirect("Admin/ActionResult.jsp?result=success"+"&type=" +
                        (tableNameParameter.equals("Institute")?"Institute":"")+
                        (tableNameParameter.equals("chair")?"chair":"")+
                        (tableNameParameter.equals("employee")?"employee":"")+
                        (tableNameParameter.equals("faculty")?"faculty":"")+
                        "&action=delete" + "&locationID=" + LocationID);
            }
        }else if(!success){
            if(operation.equals("create")){
                response.sendRedirect("Admin/ActionResult.jsp?result=unsuccess"+"&type=" +
                        (tableNameParameter.equals("Institute")?"Institute":"")+
                        (tableNameParameter.equals("chair")?"chair":"")+
                        (tableNameParameter.equals("employee")?"employee":"")+
                        (tableNameParameter.equals("faculty")?"faculty":"")+
                        "&action=create" + "&locationID=" + LocationID);
            }else if(operation.equals("update")){
                response.sendRedirect("Admin/ActionResult.jsp?result=success"+"&type=" +
                        (tableNameParameter.equals("Institute")?"Institute":"")+
                        (tableNameParameter.equals("chair")?"chair":"")+
                        (tableNameParameter.equals("employee")?"employee":"")+
                        (tableNameParameter.equals("faculty")?"faculty":"")+
                        "&action=update" + "&locationID=" + LocationID);
            }else if(operation.equals("delete")){
                response.sendRedirect("Admin/ActionResult.jsp?result=success"+"&type=" +
                        (tableNameParameter.equals("Institute")?"Institute":"")+
                        (tableNameParameter.equals("chair")?"chair":"")+
                        (tableNameParameter.equals("employee")?"employee":"")+
                        (tableNameParameter.equals("faculty")?"faculty":"")+
                        "&action=delete" + "&locationID=" + LocationID);
            }
        }
    }

}
