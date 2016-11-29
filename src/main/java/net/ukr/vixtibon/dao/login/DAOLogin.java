package net.ukr.vixtibon.dao.login;

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
        return false;
    }

    public LogInBody getEntityByLogIn(String logIn) {
        String SELECT_LogInBody_BY_LogIn = "SELECT * FROM LogInPass WHERE LogIn='" + logIn +"'";
        LogInBody lib = new LogInBody();
        PreparedStatement ps = getPrepareStatement(SELECT_LogInBody_BY_LogIn);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lib.setID(rs.getInt(1));
                lib.setLogIn(rs.getString(2));
                lib.setPassword(rs.getString(3));
                lib.setAccess(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return lib;
    }
}
