package net.ukr.vixtibon.dao.persons;

import net.ukr.vixtibon.base_objects.departments.Department;
import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        try {
            ResultSet rs = ps.executeQuery();
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
            closePrepareStatement(ps);
        }
        return employeeList;
    }

    @Override
    public boolean update(Employee entity) {
        String Update_Department_Statemet = "UPDATE employee SET name='" +entity.getName()+ "',lastName='"+entity.getSecondName()+"'," +
                "fathersName='"+entity.getSurname()+"',personalID='"+entity.getPersonalID()+"',sex='"+entity.getSex()+"',email='"+entity.getEmail()+"'," +
                "phoneNumber='"+entity.getPhoneNumber()+"',dateOfBorn='"+entity.getDateOfBorn()+"'," +
                "address='"+entity.getAddress()+"',pasport='"+entity.getPasport()+"',login='"+entity.getLogin()+"'," +
                "office='"+entity.getOffice()+"',ID='"+entity.getID()+"',departmentID='"+entity.getDepartmentID()+"' WHERE ID=" + entity.getID() + ";";
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

    @Override
    public Employee getEntityById(Integer id) {
        return null;
    }

    public  int getDepartmentIDByUsername(String username){
        String Select_DepartmentID_By_Username = "SELECT departmentID FROM employee WHERE login='" + username + "';";
        int departmentID = 0;
        PreparedStatement ps = getPrepareStatement(Select_DepartmentID_By_Username);
        try {
            ResultSet rs = ps.executeQuery();
            departmentID = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return departmentID;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Employee entity) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        String Create_Institute_Statemet = "INSERT INTO employee (name,lastName,fathersName,personalID,sex,email,phoneNumber,dateOfBorn," +
                "address,pasport,login,office,ID,departmentID) " +
                "VALUES ('" + entity.getName() + "','" + entity.getSecondName() + "','" + entity.getSurname() + "','"
                 + entity.getPersonalID() + "','" + entity.getSex() + "','" + entity.getEmail() + "','" +entity.getPhoneNumber()
                + "','" + sqlDate + "','" + entity.getAddress() + "','" + entity.getPasport() + "','" +
                entity.getLogin() + "','" + entity.getOffice() + "','" + findFreeID("employee") +"','" + entity.getDepartmentID()+"');";
        PreparedStatement ps = getPrepareStatement(Create_Institute_Statemet);
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

