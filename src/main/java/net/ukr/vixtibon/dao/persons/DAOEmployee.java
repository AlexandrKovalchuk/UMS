package net.ukr.vixtibon.dao.persons;

import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Employee entity) throws SQLException {
        /*String Create_Institute_Statemet = "INSERT INTO employee (name,lastName,fathersName,personalID,sex,email,phoneNumber,dateOfBorn," +
                "address,pasport,login,office,ID,chairID) " +
                "VALUES ('" + entity.getName() + "," + entity.getSecondName() + "," + entity.getSurname() + ","
                 + entity.getPersonalID() + "," + entity.getSex() + "," + entity.getEmail() + "," +entity.getPhoneNumber()
                + "," + +findFreeID("employee")+"','"+entity.getLongName() + "','" + entity.getShortName()+"');";
        PreparedStatement ps = getPrepareStatement(Create_Institute_Statemet);
        try {
            //ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
           // closePrepareStatement(ps);
        }*/
        return true;
    }
}

