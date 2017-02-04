package net.ukr.vixtibon.dao.stady_process;

import net.ukr.vixtibon.base_objects.study_process.DisciplineTeacherDependencyObject;
import net.ukr.vixtibon.dao.AbstractController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 03/02/2017.
 */
public class DAODisciplineTeacherDependencyObject  extends AbstractController<DAODisciplineTeacherDependencyObject,Integer> {
    @Override
    public List<DAODisciplineTeacherDependencyObject> getAll() {
        return null;
    }

    public ArrayList<DisciplineTeacherDependencyObject> getAllByDisciplineID(int disciplineID){
        String Select_All_Discipline_Statemet = "SELECT * FROM disciplineTeacherDependency WHERE disciplineID="+ disciplineID +";";
        ArrayList<DisciplineTeacherDependencyObject> dtdos = new ArrayList<DisciplineTeacherDependencyObject>();
        PreparedStatement ps = getPrepareStatement(Select_All_Discipline_Statemet);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                DisciplineTeacherDependencyObject dtdo = new DisciplineTeacherDependencyObject();
                dtdo.setId(rs.getInt(1));
                dtdo.setDisciplineID(rs.getInt(2));
                dtdo.setTeacherID(rs.getInt(3));
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

    @Override
    public boolean update(DAODisciplineTeacherDependencyObject entity) {
        return false;
    }

    @Override
    public DAODisciplineTeacherDependencyObject getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(DAODisciplineTeacherDependencyObject entity) throws SQLException {
        return false;
    }
}
