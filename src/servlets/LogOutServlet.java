package servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 14/07/2016.
 */
public class LogOutServlet extends HttpServlet {
    SessionsList sl = new SessionsList();
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        Cookie[] cookies = req.getCookies();
        System.out.println("LogOutServlet doGet 1 ");
        for(int i = 0; i < cookies.length ; i++){
            Cookie cookie = cookies[i];
            System.out.println("LogOutServlet doGet 2 ");
            if(cookie.getName().equals("SessionID")){
                System.out.println("LogOutServlet doGet 3 ");
                sl.sessionsList.remove(cookie.getValue());
                cookie.setValue("0");
                resp.addCookie(cookie);
                resp.sendRedirect("index.html");
                break;
            }
        }
    }
}
