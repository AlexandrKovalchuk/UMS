package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.study_process.DayRequirementsObject;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by alex on 24/02/2017.
 */
public class DAODayRequirements  extends AbstractController<DayRequirementsObject,Integer> {
    @Override
    public List<DayRequirementsObject> getAll() {
        return null;
    }

    @Override
    public boolean update(DayRequirementsObject entity) {
        return false;
    }

    public boolean updateCounts(DayRequirementsObject entity){
        String Update_Counts_Statemet = "UPDATE dayRequirements SET countOfDaysInWeek='" + entity.getCountOfDaysInWeek() + "" +
                "SET countOfLessonsInADay='" + entity.getCountOfLessonsInADay() +
                "' WHERE departmentID=" + entity.getDepartmentID() + ";";
        PreparedStatement ps = getPrepareStatement(Update_Counts_Statemet);
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

    public boolean updateLessonArray(DayRequirementsObject entity){
        String array = "SET ";
        int count = 1;

        for(String s : entity.getLessonsTime()){
            array = array + "lesson" + count + "='" + s +"'";
            if(count == entity.getLessonsTime().size()){
                array = array + " ";
            }else{
                array = array + ", ";
            }
            count++;
        }
        //System.out.println(array);
        String Update_LessonArray_Statemet = "UPDATE dayRequirements " + array +
                " WHERE departmentID=" + entity.getDepartmentID() + ";";
        //System.out.println(Update_LessonArray_Statemet);
        QueryStack qs = new QueryStack();
        qs.queries.add(Update_LessonArray_Statemet);
        PreparedStatement ps = getPrepareStatement(Update_LessonArray_Statemet);
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
    public DayRequirementsObject getEntityById(Integer id) {
        return null;
    }

    public DayRequirementsObject getEntityByDepartmentID (int departmentID){
        String Select_EntityByDepartmentID_Statemet = "SELECT * FROM dayRequirements WHERE departmentID='"+ departmentID +"';";
        DayRequirementsObject dayRequirementsObject = new DayRequirementsObject();
        PreparedStatement ps = getPrepareStatement(Select_EntityByDepartmentID_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                dayRequirementsObject.setID(rs.getInt(1));
                dayRequirementsObject.setDepartmentID(rs.getInt(2));
                dayRequirementsObject.setCountOfDaysInWeek(rs.getInt(3));
                dayRequirementsObject.setCountOfLessonsInADay(rs.getInt(4));
                for(int i = 1; i < dayRequirementsObject.getCountOfLessonsInADay()+1; i++){
                    dayRequirementsObject.getLessonsTime().add(rs.getString(4 + i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return dayRequirementsObject;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    public int getCountOfDayRequirements(int departmentID){
        int count = 0;
        String Get_CountOfDependencyByDisciplineID_Statement = "SELECT COUNT(*) FROM dayRequirements WHERE departmentID=" + departmentID + ";";
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
    public boolean create(DayRequirementsObject entity) throws SQLException {
        String Create_DayRequirements_Statemet = "INSERT INTO dayRequirements (id,departmentID,countOfDaysInWeek,countOfLessonsInADay) " +
                "VALUES ('" + findFreeID("dayRequirements") + "','" + entity.getDepartmentID()  + "','" + entity.getCountOfDaysInWeek() +
                "','" +entity.getCountOfLessonsInADay()+ "');";
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_DayRequirements_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_DayRequirements_Statemet);
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
