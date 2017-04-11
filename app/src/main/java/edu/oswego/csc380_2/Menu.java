package edu.oswego.csc380_2;

import java.util.ArrayList;

/**
 * Created by James on 3/7/2017
 * Menu class
 */
public class Menu {
    private ArrayList<Order> dishes;

    public Menu(){
        dishes = new ArrayList<Order>();
    }

    public boolean addDish(Order o){
        if(!dishes.contains(o)){
            dishes.add(o);
            return true;
        }
        return false;
    }

    public boolean removeDish(Order o){
        if(dishes.contains(o)){
            dishes.remove(o);
            return true;
        }
        return false;
    }


    public ArrayList<Order> getAppetizers(){
        ArrayList<Order> appetizers = new ArrayList<Order>();
        for(int i = 0; i < dishes.size(); i++){
            if(dishes.get(i).getType().equalsIgnoreCase("appetizer")){
                appetizers.add(dishes.get(i));
            }
        }
        return appetizers;
    }


    public ArrayList<Order> getEntrees(){
        ArrayList<Order> entrees = new ArrayList<Order>();
        for(int i = 0; i < dishes.size(); i++){
            if(dishes.get(i).getType().equalsIgnoreCase("entree")){
                entrees.add(dishes.get(i));
            }
        }
        return entrees;
    }


    public ArrayList<Order> getDesserts(){
        ArrayList<Order> desserts = new ArrayList<Order>();
        for(int i = 0; i < dishes.size(); i++){
            if(dishes.get(i).getType().equalsIgnoreCase("dessert")){
                desserts.add(dishes.get(i));
            }
        }
        return desserts;
    }

}
