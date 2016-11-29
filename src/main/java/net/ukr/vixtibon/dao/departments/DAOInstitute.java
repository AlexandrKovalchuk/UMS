package net.ukr.vixtibon.dao.departments;

import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.AbstractController;
import net.ukr.vixtibon.login_body.LogInBody;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 05/11/2016.
 */
public class DAOInstitute  extends AbstractController<Institute,Integer> {

    @Override
    public ArrayList<Institute> getAll() {
        String Select_All_Institutes_Statemet = "SELECT * FROM institute;";
        ArrayList<Institute> institutesList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Institutes_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Institute institute = new Institute();
                institute.setID(rs.getInt(1));
                institute.setLongName(rs.getString(2));
                institute.setShortName(rs.getString(3));
                institutesList.add(institute);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return institutesList;
    }

    public  ArrayList<Institute> getAllWithFaculties(){
        String Select_All_Institutes_Statemet = "SELECT * FROM institute;";
        ArrayList<Institute> institutesList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Institutes_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Institute institute = new Institute();
                institute.setID(rs.getInt(1));
                institute.setLongName(rs.getString(2));
                institute.setShortName(rs.getString(3));
                DAOFaculty daof = new DAOFaculty();
                institute.setFacultys(daof.getAllByInstituteID(institute.getID()));
                institutesList.add(institute);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return institutesList;
    }

    @Override
    public boolean update(Institute entity) {
        String Update_Institute_Statemet = "UPDATE institute SET longName='" + entity.getLongName() + "', shortName='"
                + entity.getShortName() + "' WHERE ID=" + entity.getID() + ";";
        PreparedStatement ps = getPrepareStatement(Update_Institute_Statemet);
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
    public Institute getEntityById(Integer id) {

        String Select_Institute_Statemet = "SELECT * FROM institute WHERE ID='" + id + "';";
        Institute institute = new Institute();
        PreparedStatement ps = getPrepareStatement(Select_Institute_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                institute.setID(rs.getInt(1));
                institute.setLongName(rs.getString(2));
                institute.setShortName(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return institute;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_Institute_Statement = "DELETE FROM institute WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_Institute_Statement);
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
    public boolean create(Institute entity) {
        String Create_Institute_Statemet = "INSERT INTO institute (ID,longName,shortName) VALUES ('"+findFreeID("institute")+"','"+entity.getLongName() + "','" + entity.getShortName()+"');";
        PreparedStatement ps = getPrepareStatement(Create_Institute_Statemet);
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
