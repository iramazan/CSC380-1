import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ServerTest {

    Server testServer;
    Table table0;
    Table table1;

    @Before
    public void setUp() throws Exception {
        Order.idGlobal = 0;
        testServer = new Server("Doe", "John", 10.00f);
        table0 = new Table(0, 5);
        table1 = new Table(1, 4);
    }

    // Test successfully removing a table if it is the only table for that server
    @Test
    public void removeTableSuccessTest() throws Exception {
        testServer.addTable(table0);
        testServer.removeTable(0);
        assertTrue(testServer.tables.isEmpty());
    }

    // Test successfully removing a table if the server has other tables
    @Test
    public void removeTableMultipleTest() throws Exception {
        testServer.addTable(table0);
        ArrayList<Table> expectedTables = new ArrayList<Table>(testServer.tables);
        testServer.addTable(table1);
        testServer.removeTable(1);
        assertArrayEquals(expectedTables.toArray(), testServer.tables.toArray());
    }

    // Test remove table if server does not have the table
    @Test(expected=UnsupportedOperationException.class)
    public void removeTableExceptionTest() throws Exception {
        testServer.addTable(table0);
        testServer.removeTable(1);
    }

    // Test Viewing data on a table
    @Test
    public void getTableDataTest() throws Exception {
        testServer.addTable(table0);
        table0.seatTable(3);
        table0.placeOrder("Baked Potato", "Appetizer", 4.50f);
        table0.placeOrder("Steak", "Entree", 9.00f);
        table0.placeOrder("Iced Tea", "Drink", 2.00f);
        assertEquals("Table ID = 0\n# of Seated Customers = 3" +
                        "\nOrder 0: Baked Potato; Appetizer; STOPPED" +
                        "\nOrder 1: Steak; Entree; STOPPED" +
                        "\nOrder 2: Iced Tea; Drink; STOPPED",
                testServer.getTableData(0));
    }

    // Test viewing data on a table the server is not responsible for
    @Test(expected=UnsupportedOperationException.class)
    public void getTableDataExceptionTest() throws Exception {
        testServer.addTable(table0);
        table0.seatTable(3);
        table0.placeOrder("Baked Potato", "food", 4.50f);
        table0.placeOrder("Steak", "food", 9.00f);
        table0.placeOrder("Iced Tea", "Drink", 2.00f);
        testServer.getTableData(1);
    }
}
