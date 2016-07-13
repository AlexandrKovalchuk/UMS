package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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
                       //System.out.println("doPost 5_3 User name and pass " +username+" "+password+" " + access);
                       if(access.equals("hr")){
                           levelPart += "Hello employee";
                           resp.sendRedirect("Employee/EmployeePage.html");
                           //System.out.println("access 1 " + levelPart);
                       }else if(access.equals("tc")){
                           levelPart += "Hello teacher";
                           //System.out.println("access 2 " + levelPart);
                       }else if(access.equals("st")){
                           levelPart += "Hello student";
                           //System.out.println("access 3 " + levelPart);
                       }else if(access.equals("ad")){
                           levelPart += "Hello admin";
                           resp.sendRedirect("Admin/AdminPage.html");
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
                       partofanswer = "incorrect login or password";
                       out.println();
                       System.out.println("doPost 8 ");

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

           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }

       answer = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
               "http://www.w3.org/TR/html4/loose.dtd\">\n" +
               "<html> \n" +
               "<head> \n" +
               "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
               "charset=ISO-8859-1\"> \n" +
               "<title> Crunchify.com JSP Servlet Example  </title> \n" +
               "</head> \n" +
               "<body> <div align='center'> \n" +
               "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
               partofanswer +
               "</font></body> \n" +
               "</html>";

       //out.println (answer);

       //System.out.println("RESULT do get 3" +username+" "+password);
          }




    }

