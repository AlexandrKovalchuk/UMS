package net.ukr.vixtibon.dao;

/**
 * Created by alex on 15/11/2016.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractController<E, K> {
    private Connection connection;
    private ConnectionPool connectionPool;

    public AbstractController() {
        connectionPool = new ConnectionPool("jdbc:mysql://localhost/institute?user=javatest&password=testpass","com.mysql.jdbc.Driver",1);
        connection = connectionPool.getConnection();
    }

    public abstract List<E> getAll();
    public abstract boolean update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity) throws SQLException;

    public void returnConnectionInPool() {
        connectionPool.putback(connection);
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
        int ID = 1;
        int previous = 0;
        boolean flag = false;
        String FIND_FREE_ID_IN_TABLE_Statemet = "SELECT  ID FROM "+tableName +";";
        PreparedStatement ps = getPrepareStatement(FIND_FREE_ID_IN_TABLE_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if((rs.getInt("ID")-previous)>1){
                    ID = previous + 1;
                    flag = true;
                    break;
                }else{
                    previous = rs.getInt("ID");
                    flag = false;
                    continue;
                }
            }
            if(!flag) {
                ID = previous + 1;
            }
            rs.close();
            System.out.println("findFreeID ID : " + ID);
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
