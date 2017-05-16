package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.StudentAttendanceObject;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class DAOStudentAttendance  extends AbstractController<StudentAttendanceObject,Integer> {
    @Override
    public List<StudentAttendanceObject> getAll() {
        return null;
    }

    public HashMap<Integer, StudentAttendanceObject> getAllByStudentID(int studentID){
        System.out.println("DAOStudentAttendance getAllByStudentID");
        String Select_getAllByStudentID_Statemet = "SELECT * FROM attendance WHERE studentID="+ studentID +";";
        HashMap<Integer, StudentAttendanceObject> saoList = new HashMap<>();
        PreparedStatement ps = getPrepareStatement(Select_getAllByStudentID_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentAttendanceObject sao = new StudentAttendanceObject();
                sao.setId(rs.getInt(1));
                sao.setDisciplineID(rs.getInt(2));
                sao.setStudentID(rs.getInt(3));
                DAODiscipline daodi = new DAODiscipline();
                Discipline discipline = daodi.getEntityById(sao.getDisciplineID());
                for(int i = 1; i <= discipline.getCountOfLessons(); i++){
                    sao.getAttendance().add(rs.getString(3 + i));
                }
                daodi.closeConnection();
                saoList.put(sao.getId(),sao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return saoList;
    }

    public HashMap<Integer, StudentAttendanceObject> getByStudentIDDisciplineID(int studentID, int disciplineID){
        System.out.println("DAOStudentAttendance getAllByStudentID");
        String Select_getAllByStudentID_Statemet = "SELECT * FROM attendance WHERE studentID="+ studentID +" and disciplineID=" + disciplineID+ ";";
        System.out.println("Select_getAllByStudentID_Statemet" + Select_getAllByStudentID_Statemet);
        HashMap<Integer, StudentAttendanceObject> saoList = new HashMap<>();
        PreparedStatement ps = getPrepareStatement(Select_getAllByStudentID_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentAttendanceObject sao = new StudentAttendanceObject();
                sao.setId(rs.getInt(1));
                sao.setDisciplineID(rs.getInt(2));
                sao.setStudentID(rs.getInt(3));
                DAODiscipline daodi = new DAODiscipline();
                Discipline discipline = daodi.getEntityById(sao.getDisciplineID());
                for(int i = 1; i <= discipline.getCountOfLessons(); i++){
                    sao.getAttendance().add(rs.getString(3 + i));
                }
                daodi.closeConnection();
                saoList.put(sao.getId(),sao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return saoList;
    }

    @Override
    public boolean update(StudentAttendanceObject entity) {
        String list = "";
        int counter = 1;
        for(String s: entity.getAttendance()){
            list = list + "lesson" + counter + "='"+ s +"'";
            if(entity.getAttendance().size() > counter){
                list = list + ",";
            }
            counter++;
        }
        String Update_StudentAttendanceObject_Statemet = "UPDATE attendance SET " + list + " WHERE ID=" + entity.getId() + ";";
        //System.out.println("Update_StudentAttendanceObject_Statemet " + Update_StudentAttendanceObject_Statemet);
        PreparedStatement ps = getPrepareStatement(Update_StudentAttendanceObject_Statemet);
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
    public StudentAttendanceObject getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_StudentProgress_Statement = "DELETE FROM attendance WHERE studentID=" + id + ";";
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
        //System.out.println(Create_StudentAttendanceObject_Statemet);
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_StudentAttendanceObject_Statemet);
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
