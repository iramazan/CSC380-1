package edu.oswego.csc380_2;

/**
 * Created by James on 4/4/2017.
 */

public class User {
    String name, access, password;

    public User(String name, String password, String access){
        this.name = name;
        this.access = access;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getAccess(){
        return access;
    }

    public String getPassword(){
        return password;
    }

    public void setAccess(String access){
        this.access = access;
    }
}
