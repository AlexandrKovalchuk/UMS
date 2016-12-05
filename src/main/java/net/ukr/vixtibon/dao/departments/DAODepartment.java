package net.ukr.vixtibon.dao.departments;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by alex on 05/11/2016.
 */
public class DAODepartment extends AbstractController<Department,Integer> {
    @Override
    public List<Department> getAll() {
        return null;
    }

    @Override
    public boolean update(Department entity) {
        return false;
    }

    @Override
    public Department getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Department entity) throws SQLException {
        String Create_Faculty_Statemet = "INSERT INTO department (ID,longName,shortName, facultyID) VALUES ('"+findFreeID("department")+"','"+entity.getLongName() + "','" + entity.getShortName()+"','"+entity.getFacultyID()+"');";
        PreparedStatement ps = getPrepareStatement(Create_Faculty_Statemet);
        try {
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(ps);
        }
    }
}
