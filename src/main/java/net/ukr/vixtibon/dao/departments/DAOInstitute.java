package net.ukr.vixtibon.dao.departments;

import net.ukr.vixtibon.base_objects.departments.Institute;
import net.ukr.vixtibon.dao.AbstractController;
import net.ukr.vixtibon.login_body.LogInBody;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by alex on 05/11/2016.
 */
public class DAOInstitute  extends AbstractController<Institute,Integer> {

    @Override
    public List<Institute> getAll() {
        return null;
    }

    @Override
    public Institute update(Institute entity) {
        return null;
    }

    @Override
    public Institute getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Institute entity) {
        String Create_Institute_Statemet = "INSERT INTO institute (ID,longName,shortName) VALUES ('"+findFreeID()+"','"+entity.getLongName() + "','" + entity.getShortName()+"');";
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

    public int findFreeID(){
        int ID = 1;
        int previous = 0;
        boolean flag = false;
        String FIND_FREE_ID_IN_TABLE_Statemet = "SELECT  ID FROM institute;";
        PreparedStatement ps = getPrepareStatement(FIND_FREE_ID_IN_TABLE_Statemet);
        try {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if((rs.getInt("ID")-previous)>1){
                    ID = previous + 1;
                    flag = true;
                    break;
                }else{
                    previous = rs.getInt("ID");
                    flag = false;
                    continue;
                }
            }
            if(!flag) {
                ID = previous + 1;
            }
            rs.close();
            System.out.println("findFreeID ID : " + ID);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return ID;
    }
}
