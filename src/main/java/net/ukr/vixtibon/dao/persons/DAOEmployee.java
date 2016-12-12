package net.ukr.vixtibon.dao.persons;

import net.ukr.vixtibon.base_objects.departments.Faculty;
import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.dao.AbstractController;

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
        return false;
    }
}
