package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.QueryStack;
import net.ukr.vixtibon.base_objects.study_process.DisciplineDepartmentDependencyObject;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAODisciplineDepartmentDependency extends AbstractController<DisciplineDepartmentDependencyObject,Integer> {
    @Override
    public List<DisciplineDepartmentDependencyObject> getAll() {
        return null;
    }

    public DisciplineDepartmentDependencyObject getByDisciplineIDDepartmentID(int disciplineID, int departmentID){
        String Select_All_Discipline_Statemet = "SELECT * FROM disciplineDepartmentDependency WHERE disciplineID="+ disciplineID +" and departmentID="+ departmentID +";";
        PreparedStatement ps = getPrepareStatement(Select_All_Discipline_Statemet);
        DisciplineDepartmentDependencyObject dddo = new DisciplineDepartmentDependencyObject();
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                dddo.setID(rs.getInt(1));
                dddo.setDisciplineID(rs.getInt(2));
                dddo.setDepartmentID(rs.getInt(3));
                dddo.setCourseNumber(rs.getInt(4));
                dddo.setSemesterNumber(rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return dddo;
    }

    public ArrayList<DisciplineDepartmentDependencyObject> getAllByDisciplineIDDepartmentID(int disciplineID, int departmentID){
        String Select_All_Discipline_Statemet = "SELECT * FROM disciplineDepartmentDependency WHERE disciplineID="+ disciplineID +" and departmentID="+ departmentID +";";
        ArrayList<DisciplineDepartmentDependencyObject> dddos = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_Discipline_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                DisciplineDepartmentDependencyObject dddo = new DisciplineDepartmentDependencyObject();
                dddo.setID(rs.getInt(1));
                dddo.setDisciplineID(rs.getInt(2));
                dddo.setDepartmentID(rs.getInt(3));
                dddo.setCourseNumber(rs.getInt(4));
                dddo.setSemesterNumber(rs.getInt(5));
                dddos.add(dddo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }

        return dddos;
    }

    public ArrayList<DisciplineDepartmentDependencyObject> getAllByDepartmentID(int departmentID){
        String Select_All_DisciplineDepartmentDependencyObject_Statemet = "SELECT * FROM disciplineDepartmentDependency WHERE departmentID="+ departmentID +";";
        ArrayList<DisciplineDepartmentDependencyObject> dtdos = new ArrayList<>();
        PreparedStatement ps = getPrepareStatement(Select_All_DisciplineDepartmentDependencyObject_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                DisciplineDepartmentDependencyObject dtdo = new DisciplineDepartmentDependencyObject();
                dtdo.setID(rs.getInt(1));
                dtdo.setDisciplineID(rs.getInt(2));
                dtdo.setDepartmentID(rs.getInt(3));
                dtdo.setCourseNumber(rs.getInt(4));
                dtdo.setSemesterNumber(rs.getInt(5));
                dtdos.add(dtdo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return dtdos;
    }

    public ArrayList<DisciplineDepartmentDependencyObject> getAllByDepartmentIDCourseAndSemectesrNumber(int departmentID,int courseNumber, int semesterNumber){
        String Select_All_DisciplineDepartmentDependency_Statemet = "SELECT * FROM disciplineDepartmentDependency " +
                "WHERE (departmentID="+ departmentID +" AND courseNumber="+ courseNumber +" AND semesterNumber="+ semesterNumber +");";
        ArrayList<DisciplineDepartmentDependencyObject> dtdos = new ArrayList<>();
        System.out.println(Select_All_DisciplineDepartmentDependency_Statemet);
        PreparedStatement ps = getPrepareStatement(Select_All_DisciplineDepartmentDependency_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                DisciplineDepartmentDependencyObject dtdo = new DisciplineDepartmentDependencyObject();
                dtdo.setID(rs.getInt(1));
                dtdo.setDisciplineID(rs.getInt(2));
                dtdo.setDepartmentID(rs.getInt(3));
                dtdo.setCourseNumber(rs.getInt(4));
                dtdo.setSemesterNumber(rs.getInt(5));
                dtdos.add(dtdo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return dtdos;
    }

    public int getCountOfDependencyByDisciplineID(int disciplineID){
        int count = 0;
        String Get_CountOfDependencyByDisciplineID_Statement = "SELECT COUNT(*) FROM disciplineDepartmentDependency WHERE disciplineID=" + disciplineID + ";";
        PreparedStatement ps = getPrepareStatement(Get_CountOfDependencyByDisciplineID_Statement);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return count;
    }

    public int getCountOfDependencyByDepartmentID(int departmentID){
        int count = 0;
        String Get_CountOfDependencyByDisciplineID_Statement = "SELECT COUNT(*) FROM disciplineDepartmentDependency WHERE departmentID=" + departmentID + ";";
        PreparedStatement ps = getPrepareStatement(Get_CountOfDependencyByDisciplineID_Statement);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
            if (ps != null) try { ps.close(); } catch (SQLException logOrIgnore) {}
        }
        return count;
    }

    @Override
    public boolean update(DisciplineDepartmentDependencyObject entity) {
        String Update_DisciplineDepartmentDependency_Statemet = "UPDATE disciplineDepartmentDependency SET courseNumber='" +entity.getCourseNumber()+ "" +
                "',semesterNumber='"+entity.getSemesterNumber()+"'  WHERE ID="+entity.getID()+ ";";
        PreparedStatement ps = getPrepareStatement(Update_DisciplineDepartmentDependency_Statemet);
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
    public DisciplineDepartmentDependencyObject getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        String Delete_disciplineDepartmentDependency_Statement = "DELETE FROM disciplineDepartmentDependency WHERE ID=" + id + ";";
        PreparedStatement ps = getPrepareStatement(Delete_disciplineDepartmentDependency_Statement);
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
    public boolean create(DisciplineDepartmentDependencyObject entity) throws SQLException {
        String Create_DisciplineDepartmentDependency_Statemet = "INSERT INTO disciplineDepartmentDependency " +
                "(ID,disciplineID,departmentID,courseNumber,semesterNumber) " +
                "VALUES ('"+findFreeID("disciplineDepartmentDependency")+"','"+entity.getDisciplineID() + "','" + entity.getDepartmentID()+"','" +
                 + entity.getCourseNumber()+"','" + entity.getSemesterNumber()+"');";
        //System.out.println(Create_DisciplineDepartmentDependency_Statemet);
        QueryStack qs = new QueryStack();
        qs.queries.add(Create_DisciplineDepartmentDependency_Statemet);
        PreparedStatement ps = getPrepareStatement(Create_DisciplineDepartmentDependency_Statemet);
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
