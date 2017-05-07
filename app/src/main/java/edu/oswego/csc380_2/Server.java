package edu.oswego.csc380_2;

import java.util.ArrayList;

public class Server extends Employee {

    protected ArrayList<Table> tables;
    protected float tips;

    public Server(String lastName, String firstName, float salary, int pin) {
        super(lastName, firstName, salary, pin);
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

    public String getTableData(int id) {
        Table table = null;
        // Get the correct table
        for(Table t : tables) {
            if(t.getId() == id)
                table = t;
        }
        // Throw exception if table is not found
        if(table == null) {
            throw new UnsupportedOperationException("Table with ID " + id + " is not allocated to this server.");
        }

        // Create data string
        String returnString = "";
        returnString += "Table ID = " + table.getId();
        returnString += "\n# of Seated Customers = " + table.getSeatedCustomers();
        for(Order o : table.getOrders()) {
            returnString += "\nOrder " + o.getID() + ": " + o.getName() +
                    "; " + o.getType() + "; " + o.getStatus();
        }
        return returnString;
    }
}
