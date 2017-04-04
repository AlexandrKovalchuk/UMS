package net.ukr.vixtibon.dao.persons;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.persons.Student;
import net.ukr.vixtibon.base_objects.study_process.Discipline;
import net.ukr.vixtibon.base_objects.study_process.StudentAttendanceObject;
import net.ukr.vixtibon.base_objects.study_process.StudentProgressObject;
import net.ukr.vixtibon.dao.AbstractController;
import net.ukr.vixtibon.dao.stady_process.DAOGroup;
import net.ukr.vixtibon.dao.stady_process.DAOStudentAttendance;
import net.ukr.vixtibon.dao.stady_process.DAOStudentProgress;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 05/11/2016.
 */
public class DAOStudent extends AbstractController<Student,Integer> {
    @Override
    public List<Student> getAll() {
        return null;
    }

    public ArrayList<Student> getAllByGroupID(int groupID){
        String Select_All_Students_Statemet = "SELECT * FROM student WHERE groupID="+ groupID +";";
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
        changeIncorrectSymbols(entity);
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        String Update_Student_Statemet = "UPDATE student SET name='" +entity.getName()+ "',lastName='"+entity.getSecondName()+"'," +
                "fathersName='"+entity.getSurname()+"',personalID='"+entity.getPersonalID()+"',sex='"+entity.getSex()+"',email='"+entity.getEmail()+"'," +
                "phoneNumber='"+entity.getPhoneNumber()+"',dateOfBorn='"+sqlDate+"'," +
                "address='"+entity.getAddress()+"',passport='"+entity.getPasport()+"',login='"+entity.getLogin()+"'," +
                "indexBook='"+entity.getIndexBook()+"' WHERE ID=" + entity.getID() + ";";
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
        String Update_Student_Statemet = "UPDATE student SET groupID='" + groupID + "' WHERE ID=" + studentID + ";";
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

    public  int getDepartmentIDByUserID(int userID){
        String Select_DepartmentID_By_Username = "SELECT groupID FROM student WHERE ID=" + userID + ";";
        int departmentID = 0;
        PreparedStatement ps = getPrepareStatement(Select_DepartmentID_By_Username);
        //System.out.println("Select_DepartmentID_By_Username " + Select_DepartmentID_By_Username);
        DAOGroup daoGroup = new DAOGroup();
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            if(rs.next() == true){
                departmentID = daoGroup.getDepartmentIDByGroupID(rs.getInt(1));
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
        DAOStudentProgress daop = new DAOStudentProgress();
        DAOStudentAttendance daoa = new DAOStudentAttendance();
        String Delete_Student_Statement = "DELETE FROM student WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_Student_Statement);
        daoa.delete(id);
        daop.delete(id);
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
        changeIncorrectSymbols(entity);
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        int id = findFreeID("student");
        String Create_Student_Statemet = "INSERT INTO student (name,lastName,fathersName,personalID,sex,email,phoneNumber,dateOfBorn," +
                "address,passport,login,indexBook,ID,groupID) " +
                "VALUES ('" + entity.getName() + "','" + entity.getSecondName() + "','" + entity.getSurname() + "','"
                + entity.getPersonalID() + "','" + entity.getSex() + "','" + entity.getEmail() + "','" +entity.getPhoneNumber()
                + "','" + sqlDate + "','" + entity.getAddress() + "','" + entity.getPasport() + "','" +
                entity.getLogin() + "','" + entity.getIndexBook() + "','" + id +"','" + entity.getGroupID()+"');";
        //System.out.println(Create_Student_Statemet);
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_Student_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_Student_Statemet);

        DAOStudentAttendance daosa = new DAOStudentAttendance();
        DAOStudentProgress daosp = new DAOStudentProgress();
        for(Map.Entry<Integer, Discipline> h: entity.getDisciplines().entrySet()){
            StudentAttendanceObject sao = new StudentAttendanceObject();
            StudentProgressObject spo = new StudentProgressObject();

            sao.setDisciplineID(h.getValue().getID());
            sao.setStudentID(id);
            daosa.create(sao);

            spo.setStudentID(id);
            spo.setDisciplineID(h.getValue().getID());
            daosp.create(spo);

        }
        daosa.closeConnection();
        daosp.closeConnection();
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

    private void changeIncorrectSymbols(Student entity){
        String[] incorrectSymbols = {"'"};
        for(String str: incorrectSymbols){
            entity.setName(entity.getName().replaceAll(str,"'" + str));
            entity.setlastName(entity.getSurname().replaceAll(str,"'" + str));
            entity.setfathersName(entity.getSecondName().replaceAll(str,"'" + str));
            entity.setPersonalID(entity.getPersonalID().replaceAll(str,"'" + str));
            entity.setEmail(entity.getEmail().replaceAll(str,"'" + str));
            entity.setPhoneNumber(entity.getPhoneNumber().replaceAll(str,"'" + str));
            entity.setAddress(entity.getAddress().replaceAll(str,"'" + str));
            entity.setPasport(entity.getPasport().replaceAll(str,"'" + str));
            entity.setLogin(entity.getLogin().replaceAll(str,"'" + str));
            entity.setIndexBook(entity.getIndexBook().replaceAll(str,"'" + str));
        }
    }
}
