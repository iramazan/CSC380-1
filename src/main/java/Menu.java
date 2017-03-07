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

}
