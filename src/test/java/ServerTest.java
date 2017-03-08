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
        testServer = new Server("Doe", "John", 10.0f);
        table0 = new Table(0, 5);
        table1 = new Table(1, 4);
    }

    // Test Successfully adding new tables
    @Test
    public void addTableTest() throws Exception {
        testServer.addTable(table0);
        assertTrue(testServer.tables.contains(table0));
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

}
