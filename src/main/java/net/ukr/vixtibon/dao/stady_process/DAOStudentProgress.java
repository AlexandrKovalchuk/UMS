package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.StudentAttendanceObject;
import net.ukr.vixtibon.base_objects.study_process.StudentProgressObject;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alex on 19/02/2017.
 */
public class DAOStudentProgress  extends AbstractController<StudentProgressObject,Integer> {
    @Override
    public List<StudentProgressObject> getAll() {
        return null;
    }

    public HashMap<Integer, StudentProgressObject> getAllByStudentID(int studentID){
        System.out.println("DAOStudentProgress getAllByStudentID");
        String Select_getAllByStudentID_Statemet = "SELECT * FROM progress WHERE studentID="+ studentID +";";
        HashMap<Integer, StudentProgressObject> spoList = new HashMap<>();
        PreparedStatement ps = getPrepareStatement(Select_getAllByStudentID_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentProgressObject spo = new StudentProgressObject();
                spo.setId(rs.getInt(1));
                spo.setDisciplineID(rs.getInt(2));
                spo.setStudentID(rs.getInt(3));
                spo.setExamResult(rs.getString(4));
                DAODiscipline daodi = new DAODiscipline();
                Discipline discipline = new Discipline();
                discipline = daodi.getEntityById(spo.getDisciplineID());
                for(int i = 1; i <= discipline.getCountOfLessons(); i++){
                    spo.getProgress().add(rs.getString(5 + i));
                }
                daodi.closeConnection();
                spoList.put(spo.getId(),spo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return spoList;
    }

    @Override
    public boolean update(StudentProgressObject entity) {
        return false;
    }

    @Override
    public StudentProgressObject getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_StudentProgress_Statement = "DELETE FROM progress WHERE studentID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_StudentProgress_Statement);
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

    public int getCountByDisciplineID(int disciplineID){
        int count = 0;
        String Get_CountByDisciplineID_Statement = "SELECT COUNT(*) FROM progress WHERE disciplineID=" + disciplineID + ";";
        PreparedStatement ps = getPrepareStatement(Get_CountByDisciplineID_Statement);
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
    public boolean create(StudentProgressObject entity) throws SQLException {
        String Create_StudentProgressObject_Statemet = "INSERT INTO progress (id,disciplineID, studentID) " +
                "VALUES ('" + findFreeID("progress") + "','" + entity.getDisciplineID()  + "','" + entity.getStudentID() + "');";
        PreparedStatement ps = getPrepareStatement(Create_StudentProgressObject_Statemet);
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
