package servlets;

import java.util.Random;

/**
 * Created by alex on 14/07/2016.
 */
public class Session {
    private String sessionID = "";
    private String sessionType = "";


    public String getSessionID() {
        return sessionID;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public String sessionIDGenerator(){
        String ID = "";
        Random rg = new Random();
        String[] parts = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                          "1","2","3","4","5","6","7","8","9","0"};
        for(int i = 0; i < 8; i++){
            ID += parts[rg.nextInt(35)];
        }
        return  ID;
    }

    public void sessionInfo(){
        System.out.println("Session Info " + sessionID + " " + sessionType);
    }
}
