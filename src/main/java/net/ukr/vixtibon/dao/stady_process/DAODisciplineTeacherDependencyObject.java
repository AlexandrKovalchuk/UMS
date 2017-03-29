package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.study_process.DisciplineTeacherDependencyObject;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 03/02/2017.
 */
public class DAODisciplineTeacherDependencyObject  extends AbstractController<DisciplineTeacherDependencyObject,Integer> {
    @Override
    public List<DisciplineTeacherDependencyObject> getAll() {
        return null;
    }

    public ArrayList<DisciplineTeacherDependencyObject> getAllByDisciplineID(int disciplineID){
        String Select_All_Discipline_Statemet = "SELECT * FROM disciplineTeacherDependency WHERE disciplineID="+ disciplineID +";";
        ArrayList<DisciplineTeacherDependencyObject> dtdos = new ArrayList<DisciplineTeacherDependencyObject>();
        PreparedStatement ps = getPrepareStatement(Select_All_Discipline_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                DisciplineTeacherDependencyObject dtdo = new DisciplineTeacherDependencyObject();
                dtdo.setId(rs.getInt(1));
                dtdo.setDisciplineID(rs.getInt(2));
                dtdo.setTeacherID(rs.getInt(3));
                dtdos.add(dtdo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }

        return dtdos;
    }

    public ArrayList<DisciplineTeacherDependencyObject> getAllByTeacherID(int teacherID){
        String Select_All_Teacher_Statemet = "SELECT * FROM disciplineTeacherDependency WHERE teacherID="+ teacherID +";";
        ArrayList<DisciplineTeacherDependencyObject> dtdos = new ArrayList<DisciplineTeacherDependencyObject>();
        PreparedStatement ps = getPrepareStatement(Select_All_Teacher_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                DisciplineTeacherDependencyObject dtdo = new DisciplineTeacherDependencyObject();
                dtdo.setId(rs.getInt(1));
                dtdo.setDisciplineID(rs.getInt(2));
                dtdo.setTeacherID(rs.getInt(3));
                dtdos.add(dtdo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }

        return dtdos;
    }

    public int getCountOfDependencyByDisciplineID(int disciplineID){
        int count = 0;
        String Get_CountOfDependencyByDisciplineID_Statement = "SELECT COUNT(*) FROM disciplineTeacherDependency WHERE disciplineID=" + disciplineID + ";";
        PreparedStatement ps = getPrepareStatement(Get_CountOfDependencyByDisciplineID_Statement);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return count;
    }

    @Override
    public boolean update(DisciplineTeacherDependencyObject entity) {
        return false;
    }

    @Override
    public DisciplineTeacherDependencyObject getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_disciplineTeacherDependency_Statement = "DELETE FROM disciplineTeacherDependency WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_disciplineTeacherDependency_Statement);
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
    public boolean create(DisciplineTeacherDependencyObject entity) throws SQLException {
        String Create_Discipline_Teacher_Dependency_Statemet = "INSERT INTO disciplineTeacherDependency (ID,disciplineID,teacherID) " +
                "VALUES ('"+findFreeID("disciplineTeacherDependency")+"','"+entity.getDisciplineID() + "','" + entity.getTeacherID()+"');";
        //System.out.println(Create_Discipline_Teacher_Dependency_Statemet);
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_Discipline_Teacher_Dependency_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Discipline_Teacher_Dependency_Statemet);
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
}
