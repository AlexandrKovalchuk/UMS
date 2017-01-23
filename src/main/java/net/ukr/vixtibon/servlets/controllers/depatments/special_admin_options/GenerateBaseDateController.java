package net.ukr.vixtibon.servlets.controllers.depatments.special_admin_options;

import net.ukr.vixtibon.Generator;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.departments.DAOInstitute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alex on 20/01/2017.
 */
public class GenerateBaseDateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Generator generator = new Generator();
                boolean result = false;
                result = generator.generateDate();
                if(result){
                    request.setAttribute("result", "success");
                    request.setAttribute("menu", "admin");
                }else{
                    request.setAttribute("menu", "admin");
                    request.setAttribute("result", "unsuccess");
                }
                request.getRequestDispatcher("ActionResultPageController").forward(request, response);
    }
}
