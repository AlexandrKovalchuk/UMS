package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.study_process.Group;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 04/02/2017.
 */
public class DAOGroup  extends AbstractController<Group,Integer> {
    @Override
    public List<Group> getAll() {
        return null;
    }

    public ArrayList<Group> getAllByDepartmentID(int departmentID){
        String Select_All_Group_Statemet = "SELECT * FROM gtgroup WHERE departmentID="+ departmentID +";";
        ArrayList<Group> groupList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Group_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setID(rs.getInt(1));
                group.setFullGroupName(rs.getString(2));
                group.setCourseNumber(rs.getInt(3));
                group.setDepartmentID(rs.getInt(4));
                groupList.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return groupList;
    }

    public ArrayList<Group> getAllByDepartmentID(int departmentID, int courseNumber){
        String Select_All_Group_Statemet = "SELECT * FROM gtgroup WHERE departmentID="+ departmentID +" and courseNumber ="+courseNumber+";";
        ArrayList<Group> groupList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Group_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setID(rs.getInt(1));
                group.setFullGroupName(rs.getString(2));
                group.setCourseNumber(rs.getInt(3));
                group.setDepartmentID(rs.getInt(4));
                groupList.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return groupList;
    }

    @Override
    public boolean update(Group entity) {
        changeIncorrectSymbols(entity);
        String Update_Group_Statemet = "UPDATE gtgroup SET fullGroupName='" +entity.getFullGroupName()+ "" +
                "',courseNumber='"+entity.getCourseNumber()+"'," +
                "departmentID='"+entity.getDepartmentID()+"' WHERE ID=" + entity.getID() + ";";
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

    public boolean updateGroupLocation(int departmentID, int groupID) {
        String Update_Group_Statemet = "UPDATE gtgroup SET departmentID='" + departmentID + "' WHERE ID=" + groupID + ";";
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
    public Group getEntityById(Integer id) {
        //System.out.println("Integer id: " + id);
        String Select_Group_Statemet = "SELECT * FROM gtgroup WHERE ID='"+ id +"';";
        Group group = new Group();
        PreparedStatement ps = getPrepareStatement(Select_Group_Statemet);
        //System.out.println("Statemet: " + Select_Group_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                group.setID(rs.getInt(1));
                group.setFullGroupName(rs.getString(2));
                group.setCourseNumber(rs.getInt(3));
                group.setDepartmentID(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return group;
    }

    public int getCountOfGroupsByDepartmentID(int departmentID){
        int count = 0;
        String Get_CountOfDependencyByDisciplineID_Statement = "SELECT COUNT(*) FROM gtgroup WHERE departmentID=" + departmentID + ";";
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

    public  int getDepartmentIDByGroupID(int groupID){
        String Select_DepartmentID_By_Username = "SELECT departmentID FROM gtgroup WHERE ID=" + groupID + ";";
        int departmentID = 0;
        PreparedStatement ps = getPrepareStatement(Select_DepartmentID_By_Username);
        //System.out.println("Select_DepartmentID_By_Username " + Select_DepartmentID_By_Username);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            if(rs.next() == true){
                departmentID = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return departmentID;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_Group_Statement = "DELETE FROM gtgroup WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_Group_Statement);
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
    public boolean create(Group entity) throws SQLException {
        changeIncorrectSymbols(entity);
        String Create_Group_Statemet = "INSERT INTO gtgroup (id,fullGroupName,courseNumber,departmentID) " +
                "VALUES ('" + findFreeID("gtgroup") + "','" + entity.getFullGroupName() + "','" + entity.getCourseNumber() + "','"
                 + entity.getDepartmentID() + "');";
        //System.out.println(Create_Group_Statemet);
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_Group_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Group_Statemet);
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

    private void changeIncorrectSymbols(Group entity){
        String[] incorrectSymbols = {"'"};
        for(String str: incorrectSymbols){
            entity.setFullGroupName(entity.getFullGroupName().replaceAll(str,"'" + str));
        }
    }
}
