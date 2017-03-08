import java.util.ArrayList;

public class Server extends Employee {

    protected ArrayList<Table> tables;
    protected float tips;

    public Server(String lastName, String firstName, float salary) {
        super(lastName, firstName, salary);
        tables = new ArrayList<Table>();
        tips = 0;
    }

    // Getters
    public float getTips() {
        return tips;
    }

    // Setters
    public void setTips(float tips) {
        this.tips = tips;
    }

    // Add a table to this server's tables they are responsible for
    public void addTable(Table table) {
        tables.add(table);
    }

    // Remove a table by ID
    public void removeTable(int tableID) {
        for(Table t : tables) {
            if(tableID == t.getId()) {
                tables.remove(t);
                return;
            }
        }
        // Tried to remove a table that this server does not have, throw exception
        throw new UnsupportedOperationException("Table with ID " + tableID + " is not allocated to this server.");
    }

    // TODO: How should paychecks be handled?
    public void printPaycheck() {
    }
}
