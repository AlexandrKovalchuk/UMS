package net.ukr.vixtibon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 04/11/2015.
 */
public class UsersStatuses {
    private static HashMap<String, String> users = new HashMap<String, String>();

    public String getUserStatus(String username){
        String status = null;
        status = users.get(username);
        return status;
    }
    public void setUserStatus(String username, String status){
        users.put(username, status);
    }
    public List<String> getUsersList(){
        List usersList = new ArrayList();
        for(Map.Entry<String,String> entry: users.entrySet()){
            usersList.add(entry.getKey());
        }
        return usersList;
    }
    public void showInfo(){
        System.out.println("users " + users.toString());
    }


}
