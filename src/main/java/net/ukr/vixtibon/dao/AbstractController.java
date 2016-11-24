package net.ukr.vixtibon.dao;

/**
 * Created by alex on 15/11/2016.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractController<E, K> {
    private Connection connection;
    private ConnectionPool connectionPool;

    public AbstractController() {
        connectionPool = new ConnectionPool("jdbc:mysql://localhost/institute?user=javatest&password=testpass","com.mysql.jdbc.Driver",10);
        connection = connectionPool.getConnection();
    }

    public abstract List<E> getAll();
    public abstract E update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity) throws SQLException;

    public void returnConnectionInPool() {
        connectionPool.putback(connection);
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
