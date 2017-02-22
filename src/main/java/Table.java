import java.util.ArrayList;

public class Table {

    // Assigned ID for this table
    private int id;

    // Enumerated type indicating if the table is available for seating
    private enum TableStatus {FREE, OCCUPIED, DIRTY}

    // Status of the table
    private TableStatus tableStatus;

    // Number of people at the table. An empty table will have zero.
    private int seatedCustomers;

    // Seating capactiy of the table
    private int seatingCapacity;

    // Orders this table has made
    private ArrayList<Order> orders;

    public int getId() {
        return id;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public int getSeatedCustomers() {
        return seatedCustomers;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }

    public void setSeatedCustomers(int seatedCustomers) {
        this.seatedCustomers = seatedCustomers;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    // Initialize table with an ID
    public Table(int id, int seatingCapacity) {
        this.id = id;
        this.seatingCapacity = seatingCapacity;
        this.tableStatus = TableStatus.FREE;
        this.seatedCustomers = 0;
    }

    // Seat a group of customers at this table
    public void seatTable(int seatedCustomers) {
        this.tableStatus = TableStatus.OCCUPIED;

        if(this.seatingCapacity <= seatedCustomers)
            this.seatedCustomers = seatedCustomers;
        else
            throw new IllegalArgumentException("Number of seated customers must be less than the tables seating capacity");

        this.orders = new ArrayList<Order>();
    }

    // Free the table
    public void freeTable() {
        this.orders = null;
        this.seatedCustomers = 0;
        this.tableStatus = TableStatus.DIRTY;
    }

}
