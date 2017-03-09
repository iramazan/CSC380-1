/**
 * Created by James on 2/22/2017.
 */
import java.lang.String;

//I just want to commit this stuff
public class Order {
    //Name of the order
    private String name;

    //Type of order
    private String type;

    //Enum identifier for the state of the order
    protected enum OrderStatus {STOPPED, STARTED, FINISHED};
    private OrderStatus orderStatus;

    //price of the order
    private double price;

    //global variable used to set the id of all orders
    protected static int idGlobal = 0;

    //id of the order
    private int id;

    //Initialize the order with an ID, and set the state to STOPPED
    public Order(){
        name = "";
        this.orderStatus = orderStatus.STOPPED;
        price = 0;
        id = -1;
        setID();
    }

    public Order(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.orderStatus = orderStatus.STOPPED;
        this.price = price;
        id = -1;
        setID();
    }
    //Return the name of the order
    public String getName(){
        return name;
    }

    //Return the type of the order
    public String getType(){
        return type;
    }

    //Return the status of the order
    public OrderStatus getStatus(){
        return orderStatus;
    }

    //return the price of the order
    public double getPrice(){
        return price;
    }

    //Return the ID of the order
    public int getID(){
        return id;
    }

    //Set the name of the order
    public void setName(String name){
        this.name = name;
    }

    //Set the type of the order
    public void setType(String type){
        this.type = type;
    }

    //Stop order
    public void stopOrder(){
        orderStatus = OrderStatus.STOPPED;
    }

    //Start order
    public void startOrder(){
        orderStatus = OrderStatus.STARTED;
    }

    //Finish order
    public void finishOrder(){
        orderStatus = OrderStatus.FINISHED;
    }

    //Set the price of the order
    public void setPrice(double price){
        if(price > 0) {
            this.price = price;
        }
        else{
            throw new IllegalArgumentException("Price cannot be less than 0.");
        }
    }

    //Set the ID of the order 1 higher then the previous ID
    public void setID(){
        id = idGlobal;
        idGlobal++;
    }
}
