package net.ukr.vixtibon.dao.persons;

import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @Override
    public boolean update(Employee entity) {
        return false;
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

