package net.ukr.vixtibon.dao.departments;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 05/11/2016.
 */
public class DAODepartment extends AbstractController<Department,Integer> {
    @Override
    public List<Department> getAll() {
        String Select_All_Faculties_Statemet = "SELECT * FROM department;";
        ArrayList<Department> departmentList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Faculties_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
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
            closePrepareStatement(ps);
        }
        return departmentList;
    }

    public ArrayList<Department> getAllByfacultyID(int facultyID){
        String Select_All_Departments_Statemet = "SELECT * FROM department WHERE facultyID="+ facultyID +";";
        ArrayList<Department> departmentList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Departments_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
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
            closePrepareStatement(ps);
        }
        return departmentList;
    }

    @Override
    public boolean update(Department entity) {
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
            closePrepareStatement(ps);
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
            closePrepareStatement(ps);
        }
    }

    @Override
    public Department getEntityById(Integer id) {

        String Select_Faculty_Statemet = "SELECT * FROM department WHERE ID='" + id + "';";
        Department department = new Department();
        PreparedStatement ps = getPrepareStatement(Select_Faculty_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                department.setID(rs.getInt(1));
                department.setLongName(rs.getString(2));
                department.setShortName(rs.getString(3));
                department.setFacultyID(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
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
            closePrepareStatement(ps);
        }
    }

    @Override
    public boolean create(Department entity) throws SQLException {
        String Create_Faculty_Statemet = "INSERT INTO department (ID,longName,shortName, facultyID) VALUES ('"+findFreeID("department")+"','"+entity.getLongName() + "','" + entity.getShortName()+"','"+entity.getFacultyID()+"');";
        PreparedStatement ps = getPrepareStatement(Create_Faculty_Statemet);
        try {
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closePrepareStatement(ps);
        }
    }
}
