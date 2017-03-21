import java.util.ArrayList;

/**
 * Created by James on 3/21/2017.
 */
public class Restaurant {
    ArrayList<Server> servers;
    Menu menu;
    ArrayList<Table> tables;
    String name, address;

    public Restaurant(String name, String address){
        this.name = name;
        this.address = address;

        servers = new ArrayList<Server>();
        menu = new Menu();
        tables = new ArrayList<Table>();
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public Menu getMenu(){
        return menu;
    }

    public ArrayList<Server> getServers(){
        return servers;
    }

    public ArrayList<Table> getTables(){
        return tables;
    }
}
