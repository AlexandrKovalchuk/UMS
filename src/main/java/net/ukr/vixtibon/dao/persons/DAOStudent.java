package net.ukr.vixtibon.dao.persons;

import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 05/11/2016.
 */
public class DAOStudent extends AbstractController<Student,Integer> {
    @Override
    public List<Student> getAll() {
        return null;
    }

    public ArrayList<Student> getAllByGroupID(int groupID){
        String Select_All_Students_Statemet = "SELECT * FROM student WHERE departmentID="+ groupID +";";
        ArrayList<Student> studentList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Students_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString(1));
                student.setlastName(rs.getString(2));
                student.setfathersName(rs.getString(3));
                student.setPersonalID(rs.getString(4));
                student.setSex(rs.getString(5));
                student.setEmail(rs.getString(6));
                student.setPhoneNumber(rs.getString(7));
                student.setDateOfBorn(rs.getDate(8));
                student.setAddress(rs.getString(9));
                student.setPasport(rs.getString(10));
                student.setLogin(rs.getString(11));
                student.setIndexBook(rs.getString(12));
                student.setID(rs.getInt(13));
                student.setGroupID(rs.getInt(14));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return studentList;
    }

    @Override
    public boolean update(Student entity) {
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        String Update_Student_Statemet = "UPDATE student SET name='" +entity.getName()+ "',lastName='"+entity.getSecondName()+"'," +
                "fathersName='"+entity.getSurname()+"',personalID='"+entity.getPersonalID()+"',sex='"+entity.getSex()+"',email='"+entity.getEmail()+"'," +
                "phoneNumber='"+entity.getPhoneNumber()+"',dateOfBorn='"+sqlDate+"'," +
                "address='"+entity.getAddress()+"',pasport='"+entity.getPasport()+"',login='"+entity.getLogin()+"'," +
                "indexBook='"+entity.getIndexBook()+"',ID='"+entity.getID()+"' WHERE ID=" + entity.getID() + ";";
        PreparedStatement ps = getPrepareStatement(Update_Student_Statemet);
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

    public boolean updateStudentLocation(int groupID, int studentID) {
        String Update_Student_Statemet = "UPDATE student SET departmentID='" + groupID + "' WHERE ID=" + studentID + ";";
        PreparedStatement ps = getPrepareStatement(Update_Student_Statemet);
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
    public Student getEntityById(Integer id) {
        String Select_All_Students_Statemet = "SELECT * FROM student WHERE ID='"+ id +"';";
        Student student = new Student();
        PreparedStatement ps = getPrepareStatement(Select_All_Students_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                student.setName(rs.getString(1));
                student.setlastName(rs.getString(2));
                student.setfathersName(rs.getString(3));
                student.setPersonalID(rs.getString(4));
                student.setSex(rs.getString(5));
                student.setEmail(rs.getString(6));
                student.setPhoneNumber(rs.getString(7));
                student.setDateOfBorn(rs.getDate(8));
                student.setAddress(rs.getString(9));
                student.setPasport(rs.getString(10));
                student.setLogin(rs.getString(11));
                student.setIndexBook(rs.getString(12));
                student.setID(rs.getInt(13));
                student.setGroupID(rs.getInt(14));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return student;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_Student_Statement = "DELETE FROM student WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_Student_Statement);
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
    public boolean create(Student entity) throws SQLException {
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        String Create_Student_Statemet = "INSERT INTO student (name,lastName,fathersName,personalID,sex,email,phoneNumber,dateOfBorn," +
                "address,passport,login,indexBook,ID,groupID) " +
                "VALUES ('" + entity.getName() + "','" + entity.getSecondName() + "','" + entity.getSurname() + "','"
                + entity.getPersonalID() + "','" + entity.getSex() + "','" + entity.getEmail() + "','" +entity.getPhoneNumber()
                + "','" + sqlDate + "','" + entity.getAddress() + "','" + entity.getPasport() + "','" +
                entity.getLogin() + "','" + entity.getIndexBook() + "','" + findFreeID("student") +"','" + entity.getGroupID()+"');";
        PreparedStatement ps = getPrepareStatement(Create_Student_Statemet);
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
