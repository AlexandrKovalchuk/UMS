package net.ukr.vixtibon.base_objects.persons;

import net.ukr.vixtibon.ClassReadyForTest;
import net.ukr.vixtibon.QueryBean;
import net.ukr.vixtibon.QuerySet;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by akovalchuk on 5/21/2015.
 */
@ClassReadyForTest
public abstract class Person implements Serializable {
    private int ID;
    private String name;// Name of discipline: contain only Space, A-Z, a-z, �-�, �-� and "-" symbol, limit 20 symbols
    private String lastName;// Name of discipline: contain only Space, A-Z, a-z, �-�, �-� and "-" symbol, limit 30 symbols
    private String fathersName;// Name of discipline: contain only Space, A-Z, a-z, �-�, �-� and "-" symbol, limit 20 symbols
    private String personalID;// Can contain fixed count of digits, no negative numbers, no "0"
    private String sex;// Can contain only M, m, F, f
    private String email;// Need to find standarts for email, should contain "@" and "." in correct order
    private String phoneNumber;//have some questions
    private Date dateOfBorn ;
    private String address;
    private String pasport;
    private String login = "";
    private static final long serialVersionUID = 1L;

    public QuerySet qs = new QuerySet();

    public Person() {

    }


    public Date getDateOfBorn() {
        return dateOfBorn;
    }

    public void  setDateOfBorn(int day, int month, int year){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String dateInString = "" + day + "/" + month + "/" + year +"";
        try {
            this.dateOfBorn = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Calendar stringToDate(String str){
        Calendar outdate = Calendar.getInstance();
        String[] splitedData = new String[3];
        int i = 0;
        System.out.println("stringToDate " + i );
        for(String input: str.split("#")){
            splitedData[i] = input;
            System.out.println("stringToDate " + i + " " + splitedData[i]);
            i++;
        }
        outdate.set(Integer.parseInt(splitedData[2]), Integer.parseInt(splitedData[1]), Integer.parseInt(splitedData[0]));
        return outdate;
    }


    public String generatePassword(){
        String pass = "";
        Random rn = new Random();
        String[] Symbols = {"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m",
                            "Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M",
                            "1","2","3","4","5","6","7","8","9","0","!","$","&","#","@"};
        for(int i = 0; i < 8 ; i++){
            pass += Symbols[rn.nextInt(Symbols.length-1)];
        }
        return  pass;
    }

    public String getFirstLetter(String s){
        //System.out.println("getFirstLetter " + s);
        String l = "";
        if(s.length()!=0){
            l = s.substring(0,1);
        }else{
            l += "A";
        }
        return l;
    }

    public void updateQuerySetParameter(String key, String update){
        QueryBean qb = new QueryBean();
        if(qs.getSet().containsKey(key)) {
            qb.setTableName(qs.getSet().get(key).getTableName());
            qb.setFieldName(qs.getSet().get(key).getFieldName());

        }else{
            qb.setTableName(null);
            qb.setFieldName(key);
        }
        qb.setFieldData(update);
        qs.add(qb);
    }

    public void setAddress(String address) {
        this.address = address;
        updateQuerySetParameter("address",address);
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
        updateQuerySetParameter("pasport",pasport);
    }

    public void setName(String name) {
        this.name = name;
        updateQuerySetParameter("name",name);
    }

    public void setlastName(String secondName) {
        this.lastName = secondName;
        updateQuerySetParameter("lastName",secondName);
    }

    public void setfathersName(String surname) {
        this.fathersName = surname;
        updateQuerySetParameter("fathersName",surname);
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
        updateQuerySetParameter("personalID",personalID);
    }

    public void setSex(String sex) {
        this.sex = sex;
        String set = "" + sex;
        updateQuerySetParameter("sex",set);
    }

    public void setEmail(String email) {
        this.email = email;
        updateQuerySetParameter("email",email);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        updateQuerySetParameter("phoneNumber",phoneNumber);
    }

    public String getAddress() {
        return address;
    }

    public String getPasport() {
        return pasport;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return lastName;
    }

    public String getSurname() {
        return fathersName;
    }

    public String getPersonalID() {
        return personalID;
    }

    public String getSex() {
        return sex;
    }
}
