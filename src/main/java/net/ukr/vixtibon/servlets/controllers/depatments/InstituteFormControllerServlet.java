package net.ukr.vixtibon.servlets.controllers.depatments;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 08/11/2016.
 */
public class InstituteFormControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("operationType").equals(null)){
            request.getRequestDispatcher("Admin/OperationsInstitute.jsp").forward(request, response);
        }
    }
}
