package net.ukr.vixtibon.dao.login;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.dao.AbstractController;
import net.ukr.vixtibon.login_body.LogInBody;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alex on 15/11/2016.
 */
public class DAOLogin extends AbstractController<LogInBody,Integer> {
    public static final String SELECT_ALL_LogIns = "SELECT * FROM LogInPass";
    @Override
    public List<LogInBody> getAll() {
        List<LogInBody> lst = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_LogIns);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LogInBody lib = new LogInBody();
                lib.setID(rs.getInt(1));
                lib.setLogIn(rs.getString(2));
                lib.setPassword(rs.getString(3));
                lib.setAccess(rs.getString(4));
                lib.setAccessID(rs.getInt(5));
                lst.add(lib);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return lst;
    }

    @Override
    public boolean update(LogInBody entity) {
        return false;
    }

    @Override
    public LogInBody getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(LogInBody entity) {
        changeIncorrectSymbols(entity);
        String Create_Login_loginpass_Statemet = "INSERT INTO loginpass (ID,login,password,access_type, accessID) VALUES " +
                "('"+findFreeID("loginpass")+"','"+entity.getLogIn()+"','"+entity.getPassword()+"','"+entity.getAccess()+"','" + entity.getAccessID() + "');";

        //QueryStack qs = new QueryStack();
        //qs.queries.add(Create_Login_loginpass_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Login_loginpass_Statemet);
        try {
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
    }

    public LogInBody getEntityByLogIn(String logIn) {
        String SELECT_LogInBody_BY_LogIn = "SELECT * FROM LogInPass WHERE LogIn='" + logIn +"'";
        LogInBody lib = new LogInBody();
        PreparedStatement ps = getPrepareStatement(SELECT_LogInBody_BY_LogIn);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                lib.setID(rs.getInt(1));
                lib.setLogIn(rs.getString(2));
                lib.setPassword(rs.getString(3));
                lib.setAccess(rs.getString(4));
                lib.setAccessID(rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
                if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return lib;
    }

    public boolean deleteDate(String tableName){
        String DELETE_DATE = "DELETE from " + tableName +";";
        PreparedStatement ps = getPrepareStatement(DELETE_DATE);
        try {
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
    }

    public  boolean createAdmin(){
        String Create_Login_loginpass_Statemet = "INSERT INTO loginpass (id,login,password,access_type) VALUES ('0','a','a','admin');";
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_Login_loginpass_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Login_loginpass_Statemet);
        try {
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
    }

    private void changeIncorrectSymbols(LogInBody entity){
        String[] incorrectSymbols = {"'"};
        for(String str: incorrectSymbols){
            entity.setLogIn(entity.getLogIn().replaceAll(str,"'" + str));
            entity.setPassword(entity.getPassword().replaceAll(str,"'" + str));
        }
    }
}
