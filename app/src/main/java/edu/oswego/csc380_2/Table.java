package edu.oswego.csc380_2;

import java.util.ArrayList;

public class Table {

    // Assigned ID for this table
    private int id;

    // Enumerated type indicating if the table is available for seating
    protected enum TableStatus {FREE, OCCUPIED, DIRTY}

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

    public ArrayList<Order> getOrders() { return orders; }

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
        if(this.seatingCapacity >= seatedCustomers) {
            this.seatedCustomers = seatedCustomers;
            this.tableStatus = TableStatus.OCCUPIED;
            this.orders = new ArrayList<Order>();
        }
        else
            throw new IllegalArgumentException("Number of seated customers must be less than the tables seating capacity");
    }

    // Place an order for a dish
    public void placeOrder(String name, String type, double price) {
        if(this.getTableStatus() == TableStatus.OCCUPIED)
            orders.add(new Order(name, type, price));
        else
            throw new IllegalStateException("Orders cannot be placed for an unoccupied table");
    }

    // Free the table
    public void freeTable() {
        this.orders = null;
        this.seatedCustomers = 0;
        this.tableStatus = TableStatus.DIRTY;
    }

    //Clean the table
    public void cleanTable(){
        freeTable();
        this.tableStatus = TableStatus.FREE;
    }

    // Generate a single Bill
    public Bill generateBill() {
        Bill bill = new Bill();
        double prices = 0;
        for(Order o : orders)
            prices += o.getPrice();
        bill.setAmount(prices);
        return bill;
    }

    public ArrayList<Bill> generateBillEvenSplit(int n) {
        double totalPrice = 0;
        ArrayList<Bill> bills = new ArrayList<Bill>();

        for(Order o : orders)
            totalPrice += o.getPrice();
        double individualPrices = totalPrice / n;

        for(int i = 0; i < n; i++) {
            Bill bill = new Bill();
            bill.setAmount(individualPrices);
            bills.add(bill);
        }
        return bills;
    }

    public String toString() {
        if (tableStatus == TableStatus.DIRTY){
            return "ID:"+ " " + id + " \n" + "DIRTY";
        }
        else if(tableStatus == TableStatus.OCCUPIED){
            return "ID:"+ " " + id + " \n" + "OCCUPIED";
        }
        else{
            return "ID:"+ " " + id + " \n" + "FREE: " + seatingCapacity + " SEATS";
        }

    }

}
