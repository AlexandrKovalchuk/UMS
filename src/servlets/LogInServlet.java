package servlets;

import net.ukr.vixtibon.DataBaseDriver;
import net.ukr.vixtibon.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by alex on 10/30/2015.
 */
public class LogInServlet extends HttpServlet {
    String username = null;
    String password = null;
    String access = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input

    }

   public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
       String answer = null;
       String partofanswer = null;
       System.out.println("RESULT do get 1" +username+" "+password);
       username = req.getParameter("username");
       password = req.getParameter("password");
       System.out.println("RESULT do get 2" +username+" "+password);
       PrintWriter out = resp.getWriter();

       DataBaseDriver d = new DataBaseDriver();

       try {
           System.out.println("doPost 3 ");
           BufferedReader f = new BufferedReader(new FileReader("C:\\Users\\alex\\IdeaProjects\\UMS\\UMS\\login_password.txt"));
           System.out.println("doPost 4 ");
           String line;
           boolean present = false;
           String[] logPas;
           while((line = f.readLine())!=null){
               System.out.println("doPost 5 " + line);
               logPas = line.split(" ");
               System.out.println("doPost 5_1 " +logPas[0]+" "+logPas[1]+" "+logPas[2]);
               System.out.println("doPost 5_2 User name and pass " +username+" "+password+" " + access);
               if(username.equals(logPas[0])){
                   System.out.println("doPost 6 ");
                   present = true;
                   if(password.equals(logPas[1])){
                       //wellcome user page load
                       access = logPas[2];
                       String levelPart = "";

                       Session s = new Session();
                       SessionsList sl = new SessionsList();
                       String ID = s.sessionIDGenerator();
                       boolean flag = true;

                       while(flag){
                           if(sl.sessionsList.containsKey(ID)){
                               ID = s.sessionIDGenerator();
                           }else{
                               flag = false;
                           }
                       }


                       //System.out.println("doPost 5_3 User name and pass " +username+" "+password+" " + access);
                       if(access.equals("hr")){
                           levelPart += "Hello employee";
                           s.setSessionID(ID);
                           s.setSessionType("employee");
                           ArrayList<Employee> e = d.getDateEmployee("SELECT chairID, login, ID  FROM employee WHERE login='" + username +"'");
                           s.setAreaAccessID(e.get(0).getChairID());
                           sl.sessionsList.put(s.getSessionID(),s);
                           Cookie cookie = new Cookie("SessionID", s.getSessionID());
                           resp.addCookie(cookie);
                           resp.sendRedirect("Employee/EmployeePage.jsp");
                           //System.out.println("access 1 " + levelPart);
                       }else if(access.equals("tc")){
                           levelPart += "Hello teacher";
                           s.setSessionID(ID);
                           s.setSessionType("teacher");
                           sl.sessionsList.put(s.getSessionID(),s);
                           Cookie cookie = new Cookie("SessionID", s.getSessionID());
                           resp.addCookie(cookie);
                           resp.sendRedirect("Teacher/TeacherPage.jsp");
                           //System.out.println("access 2 " + levelPart);
                       }else if(access.equals("st")){
                           levelPart += "Hello student";
                           s.setSessionID(ID);
                           s.setSessionType("student");
                           sl.sessionsList.put(s.getSessionID(),s);
                           Cookie cookie = new Cookie("SessionID", s.getSessionID());
                           resp.addCookie(cookie);
                           resp.sendRedirect("Student/StudentPage.jsp");
                           //System.out.println("access 3 " + levelPart);
                       }else if(access.equals("ad")){
                           levelPart += "Hello admin";
                           s.setSessionID(ID);
                           s.setSessionType("admin");
                           sl.sessionsList.put(s.getSessionID(),s);
                           Cookie cookie = new Cookie("SessionID", s.getSessionID());
                           resp.addCookie(cookie);
                           resp.sendRedirect("Admin/AdminPage.jsp");
                           //System.out.println("access 4 " + levelPart);
                       }
                       partofanswer = "!" + levelPart + " <br> " +
                               "Username: " + username + " <br> " +
                               "Password: " + password;
                       out.println();
                       //System.out.println("doPost 7 ");
                       //UsersStatuses us = new UsersStatuses();
                       //System.out.println("doPost 7_1 ");
                       //us.setUserStatus(username,"online");
                       //System.out.println("doPost 7_2 ");
                       //us.toString();
                       //System.out.println("doPost 7_3 ");
                       break;
                   }else{
                       //incorrect password page load
                       resp.sendRedirect("LogIn.jsp?message=wrongLogin");

                       break;
                   }
               }else{
                   System.out.println("doPost 9 ");
                   //continue;

               }

           }
           if(!present){
               //this user absent in system try again page
               partofanswer = "this user absent in base";
               out.println();
               System.out.println("doPost 10 ");
               resp.sendRedirect("LogIn.jsp?message=wrongLogin");

           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
          }




    }

