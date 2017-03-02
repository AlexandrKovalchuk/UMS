package net.ukr.vixtibon.servlets.controllers.login;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by alex on 14/07/2016.
 */
public class LogOutServlet extends HttpServlet {
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
