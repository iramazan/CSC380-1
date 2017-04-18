import java.util.ArrayList;

/**
 * Created by James on 3/21/2017.
 */
public class Restaurant {
    private ArrayList<Server> servers;
    private Owner owner;
    private Menu menu;
    private ArrayList<Table> tables;
    private String name, address;

    public Restaurant(String name, String address, String ownerLastName,String ownerFirstName,
                      float ownerSalary, int ownerPin) {
        this.name = name;
        this.address = address;

        servers = new ArrayList<Server>();
        owner = new Owner(ownerLastName, ownerFirstName, ownerSalary, ownerPin);
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

    // Serialize components. Return true if successful.
    public boolean serialize() {
        boolean stockSuccess = Stock.getInstance().serialize();
        boolean financeSuccess = owner.serializeFinance();
        return stockSuccess && financeSuccess;
    }

    // Deserialize components. Return true if successful.
    public boolean deserialize() {
        boolean stockSuccess = Stock.getInstance().deserialize();
        boolean financeSuccess = owner.deserializeFinance();
        return stockSuccess && financeSuccess;
    }
}
