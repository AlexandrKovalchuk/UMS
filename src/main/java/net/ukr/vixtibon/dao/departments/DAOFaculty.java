package net.ukr.vixtibon.dao.departments;

import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 29/11/2016.
 */
public class DAOFaculty  extends AbstractController<Faculty,Integer> {
    @Override
    public ArrayList<Faculty> getAll() {
        String Select_All_Faculties_Statemet = "SELECT * FROM faculty;";
        ArrayList<Faculty> facultyList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Faculties_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setID(rs.getInt(1));
                faculty.setLongName(rs.getString(2));
                faculty.setShortName(rs.getString(3));
                facultyList.add(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return facultyList;
    }

    @Override
    public boolean update(Faculty entity) {
        String Update_Faculty_Statemet = "UPDATE faculty SET longName='" + entity.getLongName() + "', shortName='"
                + entity.getShortName() + "' WHERE ID=" + entity.getID() + ";";
        PreparedStatement ps = getPrepareStatement(Update_Faculty_Statemet);
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

    @Override
    public Faculty getEntityById(Integer id) {
        String Select_Faculty_Statemet = "SELECT * FROM faculty WHERE ID='" + id + "';";
        Faculty faculty = new Faculty();
        PreparedStatement ps = getPrepareStatement(Select_Faculty_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                faculty.setID(rs.getInt(1));
                faculty.setLongName(rs.getString(2));
                faculty.setShortName(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return faculty;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_Faculty_Statement = "DELETE FROM faculty WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_Faculty_Statement);
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

    @Override
    public boolean create(Faculty entity){
        String Create_Faculty_Statemet = "INSERT INTO faculty (ID,longName,shortName) VALUES ('"+findFreeID("faculty")+"','"+entity.getLongName() + "','" + entity.getShortName()+"');";
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
