package net.ukr.vixtibon.dao.persons;

import net.ukr.vixtibon.QueryStack;
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

    public ArrayList<Teacher> getAllByDepartmentID(int departmentID){
        String Select_All_Teachers_Statemet = "SELECT * FROM teacher WHERE departmentID="+ departmentID +";";
        ArrayList<Teacher> teacherList = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Teachers_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
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
                teacherList.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return teacherList;
    }

    @Override
    public boolean update(Teacher entity){
        changeIncorrectSymbols(entity);
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        String Update_Teacher_Statemet = "UPDATE teacher SET name='" +entity.getName()+ "',lastName='"+entity.getSecondName()+"'," +
                "fathersName='"+entity.getSurname()+"',personalID='"+entity.getPersonalID()+"',sex='"+entity.getSex()+"',email='"+entity.getEmail()+"'," +
                "phoneNumber='"+entity.getPhoneNumber()+"',dateOfBorn='"+sqlDate+"'," +
                "address='"+entity.getAddress()+"',passport='"+entity.getPasport()+"',login='"+entity.getLogin()+"'," +
                "office='"+entity.getOffice()+"',level='"+entity.getLevel()+"',ID='"+entity.getID()+"' WHERE ID=" + entity.getID() + ";";
        System.out.println(Update_Teacher_Statemet);

        DAODisciplineTeacherDependencyObject ddtdo = new DAODisciplineTeacherDependencyObject();
        ArrayList<DisciplineTeacherDependencyObject> dtdos = ddtdo.getAllByTeacherID(entity.getID());

        for(DisciplineTeacherDependencyObject dtdo: dtdos){
            ddtdo.delete(dtdo.getId());
        }

        for(Discipline discipline: entity.getDisciplines()){
            DisciplineTeacherDependencyObject dtdo = new  DisciplineTeacherDependencyObject();
            dtdo.setTeacherID(entity.getID());
            dtdo.setDisciplineID(discipline.getID());
            try {
                ddtdo.create(dtdo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ddtdo.closeConnection();

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

    public  int getDepartmentIDByUsername(String username){
        String Select_DepartmentID_By_Username = "SELECT departmentID FROM teacher WHERE login='" + username + "';";
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

    public  int getIDbyUserName(String username){
        String Select_DepartmentID_By_Username = "SELECT ID FROM teacher WHERE login='" + username + "';";
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

    public Teacher getEntityByIdNameAndSurnameOnly(Integer id) {
        String Select_Teacher_Statemet = "SELECT ID, name, lastName, fathersName FROM teacher WHERE ID='"+ id +"';";
        Teacher teacher = new Teacher();
        PreparedStatement ps = getPrepareStatement(Select_Teacher_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                teacher.setID(rs.getInt(1));
                teacher.setName(rs.getString(2));
                teacher.setlastName(rs.getString(3));
                teacher.setfathersName(rs.getString(4));
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
        changeIncorrectSymbols(entity);
        java.sql.Date sqlDate = new java.sql.Date(entity.getDateOfBorn().getTime());
        int entityID = findFreeID("teacher");
        String Create_Teacher_Statemet = "INSERT INTO teacher (name,lastName,fathersName,personalID,sex,email,phoneNumber,dateOfBorn," +
                "address,passport,login,office,level,ID,departmentID) " +
                "VALUES ('" + entity.getName() + "','" + entity.getSecondName() + "','" + entity.getSurname() + "','"
                + entity.getPersonalID() + "','" + entity.getSex() + "','" + entity.getEmail() + "','" +entity.getPhoneNumber()
                + "','" + sqlDate + "','" + entity.getAddress() + "','" + entity.getPasport() + "','" +
                entity.getLogin() + "','" + entity.getOffice() + "','" + entity.getLevel() + "','" + entityID +"','" + entity.getDepartmentID()+"');";


        QueryStack qs = new QueryStack();
        qs.queries.add(Create_Teacher_Statemet);
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

    private void changeIncorrectSymbols(Teacher entity){
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
            entity.setOffice(entity.getOffice().replaceAll(str,"'" + str));
            entity.setLevel(entity.getLevel().replaceAll(str,"'" + str));
        }
    }
}
