package servlets;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 14/07/2016.
 */
public class SessionsList {
    public static Map<String, Session> sessionsList = new HashMap<>();

    public String sessionControl(Cookie[] cookies,String type){
        String result = "";
        if(cookies.length == 0){
            System.out.println("cookies absent ");
            result = "/LogIn.jsp";
        }else{
            for(int i = 0; i < cookies.length ; i++){
                Cookie cookie = cookies[i];
                if(cookie.getName().equals("SessionID")){
                    cookie.getValue();
                    if(sessionsList.containsKey(cookie.getValue())){
                        if(sessionsList.get(cookie.getValue()).getSessionType().equals(type)){
                            result = "success";
                        }else{
                            System.out.println("appropriate session type absent ");
                            result = "/index.html";
                        }
                    }else{
                        System.out.println("appropriate session ID absent in list cookie ");
                        result = "/LogIn.jsp";
                    }
                    break;
                }else{
                    System.out.println("appropriate cookie absent ");
                    result = "/LogIn.jsp";
                }
            }
        }
        return result;
    }

    public  Session getSession(Cookie[] cookies){
        Session s = new Session();
        System.out.println("getSession 1");
        if(cookies.length == 0){
            System.out.println("cookies absent 1");
            return  null;
        }else{
            System.out.println("getSession 2");
            for(int i = 0; i < cookies.length ; i++){
                Cookie cookie = cookies[i];
                System.out.println("getSession 3");
                if(cookie.getName().equals("SessionID")){
                    //cookie.getValue();
                    System.out.println("getSession 4");
                    System.out.println("cookies present 2 " + cookie.getValue());
                    if(sessionsList.containsKey(cookie.getValue())){
                            s = sessionsList.get(cookie.getValue());
                        s.sessionInfo();
                            return  s;

                    }else{
                        System.out.println("appropriate session ID absent in list cookie ");
                        return  null;
                    }
                }else{
                    System.out.println("appropriate cookie absent ");
                    continue;
                }
            }
        }
        return s;
    }
}
