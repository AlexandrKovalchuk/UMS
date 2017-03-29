package net.ukr.vixtibon.login_body;

/**
 * Created by alex on 15/11/2016.
 */
public class LogInBody {
    private int ID = -1;
    private String logIn;
    private String password;
    private String access;
    private int accessID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public void setAccessID(int accessID) {
        this.accessID = accessID;
    }

    public int getID() {
        return ID;
    }

    public String getLogIn() {
        return logIn;
    }

    public String getPassword() {
        return password;
    }

    public String getAccess() {
        return access;
    }

    public int getAccessID() {
        return accessID;
    }
}
