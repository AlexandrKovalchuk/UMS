package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.StudentAttendanceObject;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by alex on 18/02/2017.
 */
public class DAOStudentAttendance  extends AbstractController<StudentAttendanceObject,Integer> {
    @Override
    public List<StudentAttendanceObject> getAll() {
        return null;
    }

    @Override
    public boolean update(StudentAttendanceObject entity) {
        return false;
    }

    @Override
    public StudentAttendanceObject getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    public int getCountByDisciplineID(int disciplineID){
        int count = 0;
        String Get_CountByDisciplineID_Statement = "SELECT COUNT(*) FROM attendance WHERE disciplineID=" + disciplineID + ";";
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
    public boolean create(StudentAttendanceObject entity) throws SQLException {
        String Create_StudentAttendanceObject_Statemet = "INSERT INTO attendance (id,disciplineID, studentID) " +
                "VALUES ('" + findFreeID("attendance") + "','" + entity.getDisciplineID()  + "','" + entity.getStudentID() + "');";
        PreparedStatement ps = getPrepareStatement(Create_StudentAttendanceObject_Statemet);
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
