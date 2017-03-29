package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alex on 15/11/2016.
 */
public class DAODiscipline  extends AbstractController<Discipline,Integer> {
    @Override
    public ArrayList<Discipline> getAll() {
        String Select_Disciplines_Statemet = "SELECT * FROM discipline;";
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        PreparedStatement ps = getPrepareStatement(Select_Disciplines_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setID(rs.getInt(1));
                discipline.setNameOfDiscipline(rs.getString(2));
                discipline.setCountOfLessons(rs.getInt(3));
                discipline.setExam(rs.getString(4));
                disciplines.add(discipline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return disciplines;
    }

    @Override
    public boolean update(Discipline entity) {
        changeIncorrectSymbols(entity);
        String Update_Discipline_Statemet = "UPDATE discipline SET nameOfDiscipline='" +entity.getNameOfDiscipline()+ "" +
                "',countOfLessons='"+entity.getCountOfLessons()+"" +
                "',exam='"+entity.isExam()+"'  WHERE ID="+entity.getID()+ ";";
        PreparedStatement ps = getPrepareStatement(Update_Discipline_Statemet);
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

    public boolean updateDisciplineLocation(int departmentID, int disciplineID) {
        String Update_Discipline_Statemet = "UPDATE discipline SET departmentID='" + departmentID + "' WHERE ID=" + disciplineID + ";";
        PreparedStatement ps = getPrepareStatement(Update_Discipline_Statemet);
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
    public Discipline getEntityById(Integer id) {
        String Select_Discipline_Statemet = "SELECT * FROM discipline WHERE ID='"+ id +"';";
        Discipline discipline = new Discipline();
        PreparedStatement ps = getPrepareStatement(Select_Discipline_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                discipline.setID(rs.getInt(1));
                discipline.setNameOfDiscipline(rs.getString(2));
                discipline.setCountOfLessons(rs.getInt(3));
                discipline.setExam(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return discipline;
    }

    public Discipline getEntityByIdNameOnly(Integer id) {
        String Select_Discipline_Statemet = "SELECT ID, nameOfDiscipline FROM discipline WHERE ID='"+ id +"';";
        Discipline discipline = new Discipline();
        PreparedStatement ps = getPrepareStatement(Select_Discipline_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                discipline.setID(rs.getInt(1));
                discipline.setNameOfDiscipline(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return discipline;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_Discipline_Statement = "DELETE FROM discipline WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_Discipline_Statement);
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
    public boolean create(Discipline entity) throws SQLException {
        changeIncorrectSymbols(entity);
        String Create_Discipline_Statemet = "INSERT INTO discipline (id,nameOfDiscipline," +
                "countOfLessons,exam) " +
                "VALUES ('" + findFreeID("discipline") + "','" + entity.getNameOfDiscipline()  + "','" + entity.getCountOfLessons() + "','" +entity.isExam()
                + "');";
        //System.out.println(Create_Discipline_Statemet);
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_Discipline_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Discipline_Statemet);
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

    private void changeIncorrectSymbols(Discipline entity){
        String[] incorrectSymbols = {"'"};
        for(String str: incorrectSymbols){
            entity.setNameOfDiscipline(entity.getNameOfDiscipline().replaceAll(str,"'" + str));
        }
    }
}
