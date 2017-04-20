package edu.oswego.csc380_2;
import android.app.Application;
import android.widget.ArrayAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by James on 4/18/2017.
 */

public class RestaurantData{
    ArrayList<User> users;
    ArrayList<Table> tables;
    ArrayList<Order> orders;
    ArrayList<Order> appetizersMenu;
    ArrayList<Order> entreesMenu;
    ArrayList<Order> dessertsMenu;

    private static RestaurantData instance;
    private String username;
    //no outer class can initialize this class's object
    private RestaurantData() {
        users = new ArrayList<>();
        tables = new ArrayList<>();
        orders = new ArrayList<>();
        appetizersMenu = new ArrayList<>();
        entreesMenu = new ArrayList<>();
        dessertsMenu = new ArrayList<>();
    }

    public static RestaurantData Instance()
    {
        //if no instance is initialized yet then create new instance
        //else return stored instance
        if (instance == null)
        {
            instance = new RestaurantData();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public ArrayList<Table> getTables(){
        return tables;
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public ArrayList<Order> getAppetizersMenu(){
        return appetizersMenu;
    }

    public ArrayList<Order> getEntreesMenu(){
        return entreesMenu;
    }

    public ArrayList<Order> getDessertsMenu(){
        return dessertsMenu;
    }

    public boolean removeItem(ArrayList<Order> menu, String name){
        for(Order o: menu){
            if(o.getName().equals(name)){
                menu.remove(o);
                return true;
            }
        }
        return false;
    }

    public boolean addItem(ArrayList<Order> menu, Order o){
        if(!menu.contains(o)){
            menu.add(o);
            return true;
        }
        return false;
    }

    public void addUser(String username, String password, String access){
        User u = new User(username, password, access);
        users.add(u);
    }



    public void createUsers(InputStream i) {
        Scanner scan = new Scanner(i);
        while(scan.hasNextLine()) {
            String name = scan.nextLine();
            String pass = scan.nextLine();
            String access = scan.nextLine();
            User u = new User(name, pass, access);
            users.add(u);
        }
    }

    public void createMenu(InputStream a, InputStream e, InputStream d){
        Scanner scan = new Scanner(a);
        while(scan.hasNextLine()){
            String oName = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            Order app = new Order(oName, "appetizer", price);
            appetizersMenu.add(app);
        }
        scan.close();
        scan = new Scanner(e);
        while(scan.hasNextLine()){
            String oName = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            Order ent = new Order(oName, "entree", price);
            entreesMenu.add(ent);
        }
        scan.close();
        scan = new Scanner(d);
        while(scan.hasNextLine()){
            String oName = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            Order des = new Order(oName, "dessert", price);
            dessertsMenu.add(des);
        }
    }

    public void createTables(InputStream t){
        Scanner scan = new Scanner(t);
        while(scan.hasNextLine()){
            int tableId = Integer.parseInt(scan.nextLine());
            int tableCap = Integer.parseInt(scan.nextLine());
            Table table = new Table(tableId, tableCap);
            tables.add(table);
        }
    }
}
