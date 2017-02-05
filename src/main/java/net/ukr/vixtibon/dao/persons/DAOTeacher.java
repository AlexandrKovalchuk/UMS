package net.ukr.vixtibon.dao.persons;

import net.ukr.vixtibon.base_objects.persons.Employee;
import net.ukr.vixtibon.base_objects.persons.Teacher;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.DisciplineTeacherDependencyObject;
import net.ukr.vixtibon.dao.AbstractController;
import net.ukr.vixtibon.dao.stady_process.DAODisciplineTeacherDependencyObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 05/11/2016.
 */
public class DAOTeacher extends AbstractController<Teacher,Integer> {
    @Override
    public List<Teacher> getAll() {
        return null;
    }

    @Override
    public boolean update(Teacher entity) {
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        String Update_Teacher_Statemet = "UPDATE teacher SET name='" +entity.getName()+ "',lastName='"+entity.getSecondName()+"'," +
                "fathersName='"+entity.getSurname()+"',personalID='"+entity.getPersonalID()+"',sex='"+entity.getSex()+"',email='"+entity.getEmail()+"'," +
                "phoneNumber='"+entity.getPhoneNumber()+"',dateOfBorn='"+sqlDate+"'," +
                "address='"+entity.getAddress()+"',pasport='"+entity.getPasport()+"',login='"+entity.getLogin()+"'," +
                "office='"+entity.getOffice()+"level='"+entity.getLevel()+"',ID='"+entity.getID()+"' WHERE ID=" + entity.getID() + ";";
        PreparedStatement ps = getPrepareStatement(Update_Teacher_Statemet);
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

    public boolean updateTeacherLocation(int departmentID, int teacherID) {
        String Update_Teacher_Statemet = "UPDATE teacher SET departmentID='" + departmentID + "' WHERE ID=" + teacherID + ";";
        PreparedStatement ps = getPrepareStatement(Update_Teacher_Statemet);
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
    public Teacher getEntityById(Integer id) {
        String Select_Teacher_Statemet = "SELECT * FROM teacher WHERE ID='"+ id +"';";
        Teacher teacher = new Teacher();
        PreparedStatement ps = getPrepareStatement(Select_Teacher_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                teacher.setName(rs.getString(1));
                teacher.setlastName(rs.getString(2));
                teacher.setfathersName(rs.getString(3));
                teacher.setPersonalID(rs.getString(4));
                teacher.setSex(rs.getString(5));
                teacher.setEmail(rs.getString(6));
                teacher.setPhoneNumber(rs.getString(7));
                teacher.setDateOfBorn(rs.getDate(8));
                teacher.setAddress(rs.getString(9));
                teacher.setPasport(rs.getString(10));
                teacher.setLogin(rs.getString(11));
                teacher.setOffice(rs.getString(12));
                teacher.setLevel(rs.getString(13));
                teacher.setID(rs.getInt(14));
                teacher.setDepartmentID(rs.getInt(15));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return teacher;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_Teacher_Statement = "DELETE FROM teacher WHERE ID=" + id + ";";

        DAODisciplineTeacherDependencyObject ddtdo = new DAODisciplineTeacherDependencyObject();
        ArrayList<DisciplineTeacherDependencyObject> dtdos = ddtdo.getAllByTeacherID(id);
        for(DisciplineTeacherDependencyObject dtdo: dtdos){
            ddtdo.delete(dtdo.getId());
        }
        ddtdo.closeConnection();

        PreparedStatement ps = getPrepareStatement(Delete_Teacher_Statement);
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
    public boolean create(Teacher entity) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        int entityID = findFreeID("teacher");
        String Create_Teacher_Statemet = "INSERT INTO teacher (name,lastName,fathersName,personalID,sex,email,phoneNumber,dateOfBorn," +
                "address,passport,login,office,level,ID,departmentID) " +
                "VALUES ('" + entity.getName() + "','" + entity.getSecondName() + "','" + entity.getSurname() + "','"
                + entity.getPersonalID() + "','" + entity.getSex() + "','" + entity.getEmail() + "','" +entity.getPhoneNumber()
                + "','" + sqlDate + "','" + entity.getAddress() + "','" + entity.getPasport() + "','" +
                entity.getLogin() + "','" + entity.getOffice() + "','" + entity.getLevel() + "','" + entityID +"','" + entity.getDepartmentID()+"');";


        DAODisciplineTeacherDependencyObject ddtdo = new DAODisciplineTeacherDependencyObject();
        for (Discipline d: entity.getDisciplines()){
            DisciplineTeacherDependencyObject dtdo = new DisciplineTeacherDependencyObject();
            dtdo.setDisciplineID(d.getID());
            dtdo.setTeacherID(entityID);
            ddtdo.create(dtdo);
        }
        ddtdo.closeConnection();

        PreparedStatement ps = getPrepareStatement(Create_Teacher_Statemet);
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
