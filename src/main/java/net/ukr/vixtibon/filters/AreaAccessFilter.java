package net.ukr.vixtibon.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter("/AreaAccessFilter")
public class AreaAccessFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AreaAccessFilter initialized");
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);

        HttpSession session = req.getSession(false);

        if(session != null) {
            Enumeration<String> names = session.getAttributeNames();
            boolean flag = ifParameterExist(names,"type");
            if (flag) {
                if(!(uri.endsWith("LogOutServlet"))) {
                    if ((session.getAttribute("type").equals("admin")) && !(uri.contains("/Admin/") || uri.endsWith("css") || uri.endsWith("jpg"))) {
                        this.context.log("Unauthorized access request");
                        req.setAttribute("result", "noAccessToArea");
                        req.getRequestDispatcher("/Admin/ActionResultPageController").forward(request, response);
                    } else if ((session.getAttribute("type").equals("employee")) && !(uri.contains("/Employee/") || uri.endsWith("css") || uri.endsWith("jpg"))) {
                        this.context.log("Unauthorized access request");
                        req.setAttribute("result", "noAccessToArea");
                        req.getRequestDispatcher("/Employee/ActionResultEmployeeMenuPageController").forward(request, response);
                    } else if ((session.getAttribute("type").equals("teacher")) && !(uri.contains("/Teacher/") || uri.endsWith("css") || uri.endsWith("jpg"))) {
                        this.context.log("Unauthorized access request");
                        req.setAttribute("result", "noAccessToArea");
                        req.getRequestDispatcher("/Teacher/ActionResultTeacherMenuPageController").forward(request, response);
                    } else if ((session.getAttribute("type").equals("student")) && !(uri.contains("/Student/") || uri.endsWith("css") || uri.endsWith("jpg"))) {
                        this.context.log("Unauthorized access request");
                        req.setAttribute("result", "noAccessToArea");
                        req.getRequestDispatcher("/Student/ActionResultStudentMenuPageController").forward(request, response);
                    } else {
                        chain.doFilter(request, response);
                    }
                }else{
                    chain.doFilter(request, response);
                }

            } else {
                chain.doFilter(request, response);
            }
        }else{
            chain.doFilter(request, response);
        }

    }

    public void destroy() {
        //close any resources here
    }

    public boolean ifParameterExist(Enumeration<String> array, String name){
        boolean flag = false;
        while (array.hasMoreElements()){
            if(name.equals(array.nextElement())){
                flag = true;
                break;
            }
        }
        return flag;
    }

}
