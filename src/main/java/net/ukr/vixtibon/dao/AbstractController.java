package net.ukr.vixtibon.dao;

/**
 * Created by alex on 15/11/2016.
 */
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public abstract class AbstractController<E, K> {
    private Connection connection;
    private ConnectionPool connectionPool;

    public AbstractController() {
        connectionPool = new ConnectionPool(setConnectionParameters(),"com.mysql.jdbc.Driver",1);
        connection = connectionPool.getConnection();
    }
//  "jdbc:mysql://localhost/institute?user=javatest&password=testpass"
    public abstract List<E> getAll();
    public abstract boolean update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity) throws SQLException;

    public void returnConnectionInPool() {
        connectionPool.putback(connection);
    }

    private String setConnectionParameters(){
        String connectionParameters = "";
        String baseLocation = "";
        String user = "";
        String password = "";
        Properties properties = new Properties();

            try {
                InputStream input  = AbstractController.class.getClassLoader().getResourceAsStream("net\\ukr\\vixtibon\\dao\\config.properties");
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            baseLocation = properties.getProperty("baseLocation");
            user = properties.getProperty("user");
            password = properties.getProperty("password");


        connectionParameters = connectionParameters + baseLocation + "?user=" + user + "&password=" + password;
        return connectionParameters;
    }

    public void closeConnection(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException logOrIgnore) {
            } // nothing we can do
        }
    }

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    public int findFreeID(String tableName){
        int ID = 0;
        String FIND_FREE_ID_IN_TABLE_Statemet = "SELECT t1.id+1 AS Missing FROM "+tableName +" AS t1 LEFT JOIN "+tableName +" AS t2 ON t1.id+1 = t2.id WHERE t2.id IS NULL ORDER BY t1.id LIMIT 1;";
        PreparedStatement ps = getPrepareStatement(FIND_FREE_ID_IN_TABLE_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ID = rs.getInt(1);
            }
            rs.close();
            //System.out.println("findFreeID ID : " + ID);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return ID;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
