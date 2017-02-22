/**
 * Created by James on 2/22/2017.
 */
import java.lang.String;

public class Order {
    private String name, status;
    private double price;
    private static int idGlobal = 1;
    private int id;

    public Order(){
        name = "";
        status = "";
        price = 0;
        id = -1;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getStatus(){
        return status;
    }

    public double getPrice(){
        return price;
    }

    public int getID(){
        return id;
    }

    public void setID(){
        id = idGlobal;
        idGlobal++;
    }
}
