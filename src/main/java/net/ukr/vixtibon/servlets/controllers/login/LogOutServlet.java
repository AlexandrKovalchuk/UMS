package net.ukr.vixtibon.servlets.controllers.login;

import servlets.SessionsList;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by alex on 14/07/2016.
 */
public class LogOutServlet extends HttpServlet {
    SessionsList sl = new SessionsList();
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session=req.getSession();
        session.invalidate();
        try {
            req.getRequestDispatcher("index.html").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
