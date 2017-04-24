package edu.oswego.csc380_2;

import activities.RestaurantData;

/**
 * Created by James on 4/4/2017.
 */

public class User {
    String name, access, password;
    private String schedule[];

    public User(String name, String password, String access){
        this.name = name;
        this.access = access;
        this.password = password;
        schedule = new String[7];
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

    public String[] getSchedule(){
        return schedule;
    }

    public void setSchedule(int day, String f, String s){
        schedule[day] = RestaurantData.Instance().dateHelper(day) + f + " AM - " + s + " PM";
    }
}
