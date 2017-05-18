package net.ukr.vixtibon.dao.departments;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alex on 05/11/2016.
 */
public class DAODepartment extends AbstractController<Department,Integer> {
    @Override
    public ArrayList<Department> getAll() {
        String Select_All_Faculties_Statemet = "SELECT * FROM department;";
        ArrayList<Department> departmentList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Faculties_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setID(rs.getInt(1));
                department.setLongName(rs.getString(2));
                department.setShortName(rs.getString(3));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return departmentList;
    }

    public ArrayList<Department> getAllByfacultyID(int facultyID){
        String Select_All_Departments_Statemet = "SELECT * FROM department WHERE facultyID="+ facultyID +";";
        ArrayList<Department> departmentList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Departments_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setID(rs.getInt(1));
                department.setLongName(rs.getString(2));
                department.setShortName(rs.getString(3));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return departmentList;
    }

    @Override
    public boolean update(Department entity) {
        changeIncorrectSymbols(entity);
        String Update_Department_Statemet = "UPDATE department SET longName='" + entity.getLongName() + "', shortName='"
                + entity.getShortName() + "' WHERE ID=" + entity.getID() + ";";
        PreparedStatement ps = getPrepareStatement(Update_Department_Statemet);
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

    public boolean updateDepartmentLocation(int facultyID, int departmentID) {
        String Update_Faculty_Statemet = "UPDATE department SET facultyID='" + facultyID + "' WHERE ID=" + departmentID + ";";
        PreparedStatement ps = getPrepareStatement(Update_Faculty_Statemet);
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
    public Department getEntityById(Integer id) {
        String Select_Faculty_Statemet = "SELECT * FROM department WHERE ID='" + id + "';";
        Department department = new Department();
        PreparedStatement ps = getPrepareStatement(Select_Faculty_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                department.setID(rs.getInt(1));
                department.setLongName(rs.getString(2));
                department.setShortName(rs.getString(3));
                department.setFacultyID(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return department;
    }

    @Override
    public boolean delete(Integer id) {

        String Delete_department_Statement = "DELETE FROM department WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_department_Statement);
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
    public boolean create(Department entity) throws SQLException {
        changeIncorrectSymbols(entity);
        String Create_Department_Statemet = "INSERT INTO department (ID,longName,shortName, facultyID) VALUES ('"+findFreeID("department")+"','"+entity.getLongName() + "','" + entity.getShortName()+"','"+entity.getFacultyID()+"');";

        //QueryStack qs = new QueryStack();
        //qs.queries.add(Create_Department_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Department_Statemet);
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
        String Create_NONE_Department_Statemet = "INSERT INTO department (ID,longName,shortName,facultyID) VALUES ('0','NONE','NONE','0');";
        PreparedStatement ps = getPrepareStatement(Create_NONE_Department_Statemet);
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

    private void changeIncorrectSymbols(Department entity){
        String[] incorrectSymbols = {"'"};
        for(String str: incorrectSymbols){
            entity.setLongName(entity.getLongName().replaceAll(str,"'" + str));
            entity.setShortName(entity.getShortName().replaceAll(str,"'" + str));
        }
    }
}
