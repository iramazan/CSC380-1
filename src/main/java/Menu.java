import java.util.ArrayList;

/**
 * Created by James on 3/7/2017
 * Menu class
 */
public class Menu {
    private ArrayList<Order> appetizers;
    private ArrayList<Order> entrees;
    private ArrayList<Order> desserts;

    public Menu(){
        appetizers = new ArrayList<Order>();
        entrees = new ArrayList<Order>();
        desserts = new ArrayList<Order>();
    }

    public boolean addAppetizer(Order o){
        if(!appetizers.contains(o)) {
            appetizers.add(o);
            return true;
        }
        return false;
    }

    public boolean removeAppetizer(Order o){
        if(appetizers.contains(o)){
            appetizers.remove(o);
        }
        return false;
   }

    public boolean addEntree(Order o){
        if(!entrees.contains(o)) {
            entrees.add(o);
            return true;
        }
        return false;
    }

    public boolean removeEntree(Order o){
        if(entrees.contains(o)){
            entrees.remove(o);
        }
        return false;
    }

    public boolean addDessert(Order o){
        if(!desserts.contains(o)) {
            desserts.add(o);
            return true;
        }
        return false;
    }

    public boolean removeDessert(Order o){
        if(desserts.contains(o)){
            desserts.remove(o);
        }
        return false;
    }

}
