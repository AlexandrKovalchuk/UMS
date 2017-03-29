package net.ukr.vixtibon.dao.departments;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alex on 29/11/2016.
 */
public class DAOFaculty  extends AbstractController<Faculty,Integer> {
    @Override
    public ArrayList<Faculty> getAll() {
        String Select_All_Faculties_Statemet = "SELECT * FROM faculty;";
        ArrayList<Faculty> facultyList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Faculties_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
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
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return facultyList;
    }

    @Override
    public boolean update(Faculty entity) {
        changeIncorrectSymbols(entity);
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
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
    }

    public boolean updateFacultyLocation(int instituteID, int facultyID) {
        String Update_Faculty_Statemet = "UPDATE faculty SET instituteID='" + instituteID + "' WHERE ID=" + facultyID + ";";
        PreparedStatement ps = getPrepareStatement(Update_Faculty_Statemet);
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

    @Override
    public Faculty getEntityById(Integer id) {
        String Select_Faculty_Statemet = "SELECT * FROM faculty WHERE ID='" + id + "';";
        Faculty faculty = new Faculty();
        PreparedStatement ps = getPrepareStatement(Select_Faculty_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                faculty.setID(rs.getInt(1));
                faculty.setLongName(rs.getString(2));
                faculty.setShortName(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
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
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
    }

    @Override
    public boolean create(Faculty entity){
        changeIncorrectSymbols(entity);
        String Create_Faculty_Statemet = "INSERT INTO faculty (ID,longName,shortName, instituteID) VALUES ('"+findFreeID("faculty")+"','"+entity.getLongName() + "','" + entity.getShortName()+"','"+entity.getInstituteID()+"');";
        //System.out.println(Create_Faculty_Statemet);
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_Faculty_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Faculty_Statemet);
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

    public  boolean createNONE(){
        String Create_NONE_faculty_Statemet = "INSERT INTO faculty (ID,longName,shortName,instituteID) VALUES ('0','NONE','NONE','0');";
        PreparedStatement ps = getPrepareStatement(Create_NONE_faculty_Statemet);
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

    public ArrayList<Faculty> getAllByInstituteID(int instituteID){
        String Select_All_Faculties_Statemet = "SELECT * FROM faculty WHERE instituteID="+ instituteID +";";
        ArrayList<Faculty> facultiesList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Faculties_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Faculty faculty = new Faculty();
                faculty.setID(rs.getInt(1));
                faculty.setLongName(rs.getString(2));
                faculty.setShortName(rs.getString(3));
                facultiesList.add(faculty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return facultiesList;
    }

    private void changeIncorrectSymbols(Faculty entity){
        String[] incorrectSymbols = {"'"};
        for(String str: incorrectSymbols){
            entity.setLongName(entity.getLongName().replaceAll(str,"'" + str));
            entity.setShortName(entity.getShortName().replaceAll(str,"'" + str));
        }
    }
}
