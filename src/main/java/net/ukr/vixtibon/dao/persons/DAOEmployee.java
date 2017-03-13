package net.ukr.vixtibon.dao.persons;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 12/12/2016.
 */
public class DAOEmployee extends AbstractController<Employee,Integer> {
    @Override
    public List<Employee> getAll() {
        return null;
    }

    public ArrayList<Employee> getAllByDepartmentID(int departmentID){
        String Select_All_Employees_Statemet = "SELECT * FROM employee WHERE departmentID="+ departmentID +";";
        ArrayList<Employee> employeeList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Employees_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setName(rs.getString(1));
                employee.setlastName(rs.getString(2));
                employee.setfathersName(rs.getString(3));
                employee.setPersonalID(rs.getString(4));
                employee.setSex(rs.getString(5));
                employee.setEmail(rs.getString(6));
                employee.setPhoneNumber(rs.getString(7));
                employee.setDateOfBorn(rs.getDate(8));
                employee.setAddress(rs.getString(9));
                employee.setPasport(rs.getString(10));
                employee.setLogin(rs.getString(11));
                employee.setOffice(rs.getString(12));
                employee.setID(rs.getInt(13));
                employee.setDepartmentID(rs.getInt(14));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return employeeList;
    }

    @Override
    public boolean update(Employee entity) {
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        String Update_Employee_Statemet = "UPDATE employee SET name='" +entity.getName()+ "',lastName='"+entity.getSecondName()+"'," +
                "fathersName='"+entity.getSurname()+"',personalID='"+entity.getPersonalID()+"',sex='"+entity.getSex()+"',email='"+entity.getEmail()+"'," +
                "phoneNumber='"+entity.getPhoneNumber()+"',dateOfBorn='"+sqlDate+"'," +
                "address='"+entity.getAddress()+"',pasport='"+entity.getPasport()+"',login='"+entity.getLogin()+"'," +
                "office='"+entity.getOffice()+"',ID='"+entity.getID()+"' WHERE ID=" + entity.getID() + ";";
        PreparedStatement ps = getPrepareStatement(Update_Employee_Statemet);
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

    public boolean updateEmployeeLocation(int departmentID, int employeeID) {
        String Update_Employee_Statemet = "UPDATE employee SET departmentID='" + departmentID + "' WHERE ID=" + employeeID + ";";
        PreparedStatement ps = getPrepareStatement(Update_Employee_Statemet);
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
    public Employee getEntityById(Integer id) {
        String Select_Employee_Statemet = "SELECT * FROM employee WHERE ID='"+ id +"';";
        Employee employee = new Employee();
        PreparedStatement ps = getPrepareStatement(Select_Employee_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                employee.setName(rs.getString(1));
                employee.setlastName(rs.getString(2));
                employee.setfathersName(rs.getString(3));
                employee.setPersonalID(rs.getString(4));
                employee.setSex(rs.getString(5));
                employee.setEmail(rs.getString(6));
                employee.setPhoneNumber(rs.getString(7));
                employee.setDateOfBorn(rs.getDate(8));
                employee.setAddress(rs.getString(9));
                employee.setPasport(rs.getString(10));
                employee.setLogin(rs.getString(11));
                employee.setOffice(rs.getString(12));
                employee.setID(rs.getInt(13));
                employee.setDepartmentID(rs.getInt(14));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return employee;
    }

    public  int getDepartmentIDByUsername(String username){
        String Select_DepartmentID_By_Username = "SELECT departmentID FROM employee WHERE login='" + username + "';";
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
        String Delete_Employee_Statement = "DELETE FROM employee WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_Employee_Statement);
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
    public boolean create(Employee entity) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        String Create_Employee_Statemet = "INSERT INTO employee (name,lastName,fathersName,personalID,sex,email,phoneNumber,dateOfBorn," +
                "address,passport,login,office,ID,departmentID) " +
                "VALUES ('" + entity.getName() + "','" + entity.getSecondName() + "','" + entity.getSurname() + "','"
                 + entity.getPersonalID() + "','" + entity.getSex() + "','" + entity.getEmail() + "','" +entity.getPhoneNumber()
                + "','" + sqlDate + "','" + entity.getAddress() + "','" + entity.getPasport() + "','" +
                entity.getLogin() + "','" + entity.getOffice() + "','" + findFreeID("employee") +"','" + entity.getDepartmentID()+"');";
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_Employee_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Employee_Statemet);
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

