package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.base_objects.study_process.DisciplineDepartmentDependencyObject;
import net.ukr.vixtibon.base_objects.study_process.DisciplineTeacherDependencyObject;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 07/02/2017.
 */
public class DAODisciplineDepartmentDependency extends AbstractController<DisciplineDepartmentDependencyObject,Integer> {
    @Override
    public List<DisciplineDepartmentDependencyObject> getAll() {
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

    public ArrayList<DisciplineDepartmentDependencyObject> getAllByDepartmentID(int departmentID){
        String Select_All_DisciplineDepartmentDependencyObject_Statemet = "SELECT * FROM disciplineDepartmentDependencyObject WHERE departmentID="+ departmentID +";";
        ArrayList<DisciplineDepartmentDependencyObject> dtdos = new ArrayList<DisciplineDepartmentDependencyObject>();
        PreparedStatement ps = getPrepareStatement(Select_All_DisciplineDepartmentDependencyObject_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                DisciplineDepartmentDependencyObject dtdo = new DisciplineDepartmentDependencyObject();
                dtdo.setID(rs.getInt(1));
                dtdo.setDisciplineID(rs.getInt(2));
                dtdo.setDepaptmentID(rs.getInt(3));
                dtdo.setCourseNumber(rs.getInt(4));
                dtdo.setSemesterNumber(rs.getInt(5));
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

    public ArrayList<DisciplineDepartmentDependencyObject> getAllByDepartmentIDCourseAndSemectesrNumber(int departmentID,int coutseNumber, int semesterNumber){
        String Select_All_DisciplineDepartmentDependencyObject_Statemet = "SELECT * FROM disciplineDepartmentDependencyObject " +
                "WHERE (departmentID="+ departmentID +" AND coutseNumber="+ coutseNumber +" AND semesterNumber="+ semesterNumber +";";
        ArrayList<DisciplineDepartmentDependencyObject> dtdos = new ArrayList<DisciplineDepartmentDependencyObject>();
        PreparedStatement ps = getPrepareStatement(Select_All_DisciplineDepartmentDependencyObject_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                DisciplineDepartmentDependencyObject dtdo = new DisciplineDepartmentDependencyObject();
                dtdo.setID(rs.getInt(1));
                dtdo.setDisciplineID(rs.getInt(2));
                dtdo.setDepaptmentID(rs.getInt(3));
                dtdo.setCourseNumber(rs.getInt(4));
                dtdo.setSemesterNumber(rs.getInt(5));
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

    @Override
    public boolean update(DisciplineDepartmentDependencyObject entity) {
        return false;
    }

    @Override
    public DisciplineDepartmentDependencyObject getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_disciplineDepartmentDependency_Statement = "DELETE FROM disciplineDepartmentDependency WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_disciplineDepartmentDependency_Statement);
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
    public boolean create(DisciplineDepartmentDependencyObject entity) throws SQLException {
        String Create_DisciplineDepartmentDependency_Statemet = "INSERT INTO disciplineDepartmentDependency " +
                "(ID,disciplineID,depaptmentID,courseNumber,semesterNumber) " +
                "VALUES ('"+findFreeID("disciplineDepartmentDependency")+"','"+entity.getDisciplineID() + "','" + entity.getDepaptmentID()+"','" +
                 + entity.getDepaptmentID()+"','" + entity.getDepaptmentID()+"');";
        PreparedStatement ps = getPrepareStatement(Create_DisciplineDepartmentDependency_Statemet);
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
