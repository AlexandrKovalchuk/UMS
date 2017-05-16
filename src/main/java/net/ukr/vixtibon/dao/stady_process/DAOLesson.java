package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.study_process.Lesson;
import net.ukr.vixtibon.dao.AbstractController;
import net.ukr.vixtibon.dao.persons.DAOTeacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOLesson extends AbstractController<Lesson,Integer> {
    @Override
    public List<Lesson> getAll() {
        return null;
    }

    @Override
    public boolean update(Lesson entity) {
        String disciplineID = "";
        String teacherID = "";

            disciplineID = disciplineID + entity.getDiscipline().getID();
            teacherID = teacherID + entity.getTeacher().getID();

        String Update_Group_Statemet = "UPDATE timetable SET disciplineID=" +disciplineID+ "" +
                ",teacherID="+teacherID+" WHERE ID=" + entity.getID() + ";";
        PreparedStatement ps = getPrepareStatement(Update_Group_Statemet);
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

    public boolean update(Lesson entity, boolean empty) {
        String disciplineID = "";
        String teacherID = "";
        if(empty){
            disciplineID = "NULL";
            teacherID = "NULL";
        }else{
            disciplineID = disciplineID + entity.getDiscipline().getID();
            teacherID = teacherID + entity.getTeacher().getID();
        }
        String Update_Group_Statemet = "UPDATE timetable SET disciplineID=" +disciplineID+ "" +
                ",teacherID="+teacherID+" WHERE ID=" + entity.getID() + ";";
        PreparedStatement ps = getPrepareStatement(Update_Group_Statemet);
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
    public Lesson getEntityById(Integer id) {

        String Select_getEntityById_Statemet = "SELECT * FROM timetable WHERE ID=" +id+ ";";
        PreparedStatement ps = getPrepareStatement(Select_getEntityById_Statemet);
        ResultSet rs = null;
        DAODiscipline daoDiscipline = new DAODiscipline();
        DAOTeacher daoTeacher = new DAOTeacher();
        Lesson lesson = new Lesson();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                lesson.setID(rs.getInt(1));
                lesson.setDayNumber(rs.getInt(2));
                lesson.setLessonNumberInDay(rs.getInt(3));
                lesson.setDepartmentID(rs.getInt(4));
                lesson.setGroupID(rs.getInt(5));
                if(!checkIfFieldNULL(id, "disciplineID")) {
                    lesson.setDiscipline(daoDiscipline.getEntityByIdNameOnly(rs.getInt(6)));
                }
                if(!checkIfFieldNULL(id, "teacherID")) {
                    lesson.setTeacher(daoTeacher.getEntityByIdNameAndSurnameOnly(rs.getInt(7)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        daoDiscipline.closeConnection();
        daoTeacher.closeConnection();
        return lesson;
    }

    public ArrayList<Lesson> getAllByDepartmentDayNumber(int departmentID, int dayNumber, int lessonNumber){
        String Select_getAllByDepartmentDayNumber_Statemet = "SELECT * FROM timetable WHERE departmentID=" +departmentID+ " and dayNumber=" + dayNumber +
                " and lessonNumberInDay=" + lessonNumber + ";";
        ArrayList<Lesson> lessons = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_getAllByDepartmentDayNumber_Statemet);
        ResultSet rs = null;
        DAODiscipline daoDiscipline = new DAODiscipline();
        DAOTeacher daoTeacher = new DAOTeacher();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setID(rs.getInt(1));
                lesson.setDayNumber(rs.getInt(2));
                lesson.setLessonNumberInDay(rs.getInt(3));
                lesson.setDepartmentID(rs.getInt(4));
                lesson.setGroupID(rs.getInt(5));
                if(!checkIfFieldNULL(lesson.getID(), "disciplineID")) {
                    lesson.setDiscipline(daoDiscipline.getEntityByIdNameOnly(rs.getInt(6)));
                }
                if(!checkIfFieldNULL(lesson.getID(), "teacherID")) {
                    lesson.setTeacher(daoTeacher.getEntityByIdNameAndSurnameOnly(rs.getInt(7)));
                }
                lessons.add(lesson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        daoDiscipline.closeConnection();
        daoTeacher.closeConnection();
        return lessons;
    }

    public ArrayList<Lesson> getAllByDepartmentID(int departmentID){
        String Select_getAllByDepartmentDayNumber_Statemet = "SELECT * FROM timetable WHERE departmentID=" +departmentID+ ";";
        ArrayList<Lesson> lessons = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_getAllByDepartmentDayNumber_Statemet);
        ResultSet rs = null;
        DAODiscipline daoDiscipline = new DAODiscipline();
        DAOTeacher daoTeacher = new DAOTeacher();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setID(rs.getInt(1));
                lesson.setDayNumber(rs.getInt(2));
                lesson.setLessonNumberInDay(rs.getInt(3));
                lesson.setDepartmentID(rs.getInt(4));
                lesson.setGroupID(rs.getInt(5));
                if(!checkIfFieldNULL(lesson.getID(), "disciplineID")) {
                    lesson.setDiscipline(daoDiscipline.getEntityByIdNameOnly(rs.getInt(6)));
                }
                if(!checkIfFieldNULL(lesson.getID(), "teacherID")) {
                    lesson.setTeacher(daoTeacher.getEntityByIdNameAndSurnameOnly(rs.getInt(7)));
                }
                lessons.add(lesson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        daoDiscipline.closeConnection();
        daoTeacher.closeConnection();
        return lessons;
    }

    public int getCountByDepartmentID(int departmentID){
        int count = 0;
        String Get_getCountByDepartmentID_Statement = "SELECT COUNT(*) FROM timetable WHERE departmentID=" + departmentID + ";";
        PreparedStatement ps = getPrepareStatement(Get_getCountByDepartmentID_Statement);
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
    public boolean delete(Integer id) {
        return false;
    }

    public boolean deleteByDepartmentID(Integer departmentID){
        String Delete_Lesson_Statement = "DELETE FROM timetable WHERE departmentID=" + departmentID + ";";
        PreparedStatement ps = getPrepareStatement(Delete_Lesson_Statement);
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
    public boolean create(Lesson entity) throws SQLException {
        String Create_Lesson_Statemet = "INSERT INTO timetable (id,dayNumber,lessonNumberInDay,departmentID, groupID) " +
                "VALUES ('" + findFreeID("timetable") + "','" + entity.getDayNumber()  + "','" + entity.getLessonNumberInDay() +
                "','" +entity.getDepartmentID()+ "','" + entity.getGroupID() +"');";
        //System.out.println(Create_Lesson_Statemet);
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_Lesson_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Lesson_Statemet);
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

    public boolean createFullData(Lesson entity) throws SQLException {
        String Create_Lesson_Statemet = "INSERT INTO timetable (id,dayNumber,lessonNumberInDay,departmentID, groupID, disciplineID, teacherID) " +
                "VALUES ('" + findFreeID("timetable") + "','" + entity.getDayNumber()  + "','" + entity.getLessonNumberInDay() +
                "','" +entity.getDepartmentID()+ "','" + entity.getGroupID() + "','" + entity.getDiscipline().getID() + "','" + entity.getTeacher().getID() +"');";
        System.out.println(Create_Lesson_Statemet);
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_Lesson_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Lesson_Statemet);
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

    public  boolean checkIfFieldNULL(int id,String fieldName){
        String Select_checkIfFielNULL_statement = "SELECT " +fieldName+ " FROM timetable WHERE id=" + id + " and " +fieldName+ " IS NULL;";
        boolean result = false;
        PreparedStatement ps = getPrepareStatement(Select_checkIfFielNULL_statement);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return result;
    }
}
