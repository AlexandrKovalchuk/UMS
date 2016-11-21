package net.ukr.vixtibon;

/**
 * Created by alex on 26/01/2016.
 */
public class LogInSettings {
    private String login;
    private String password;
    private String level;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getLevel() {
        return level;
    }
}
