package net.ukr.vixtibon.dao.departments;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alex on 05/11/2016.
 */
public class DAOInstitute  extends AbstractController<Institute,Integer> {

    @Override
    public ArrayList<Institute> getAll() {
        String Select_All_Institutes_Statemet = "SELECT * FROM institute;";
        ArrayList<Institute> institutesList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Institutes_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
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
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return institutesList;
    }

    @Override
    public boolean update(Institute entity) {
        changeIncorrectSymbols(entity);
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
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
    }


    @Override
    public Institute getEntityById(Integer id) {

        String Select_Institute_Statemet = "SELECT * FROM institute WHERE ID='" + id + "';";
        Institute institute = new Institute();
        PreparedStatement ps = getPrepareStatement(Select_Institute_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                institute.setID(rs.getInt(1));
                institute.setLongName(rs.getString(2));
                institute.setShortName(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
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
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
    }

    @Override
    public boolean create(Institute entity) {
        changeIncorrectSymbols(entity);
        String Create_Institute_Statemet = "INSERT INTO institute (ID,longName,shortName) VALUES ('"+findFreeID("institute")+"','"+entity.getLongName() + "','" + entity.getShortName()+"');";
        //QueryStack qs = new QueryStack();
        //qs.queries.add(Create_Institute_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Institute_Statemet);
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
        String Create_NONE_Institute_Statemet = "INSERT INTO institute (ID,longName,shortName) VALUES ('0','NONE','NONE');";
        PreparedStatement ps = getPrepareStatement(Create_NONE_Institute_Statemet);
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

    private void changeIncorrectSymbols(Institute entity){
        String[] incorrectSymbols = {"'"};
        for(String str: incorrectSymbols){
            entity.setLongName(entity.getLongName().replaceAll(str,"'" + str));
            entity.setShortName(entity.getShortName().replaceAll(str,"'" + str));
        }
    }
}
