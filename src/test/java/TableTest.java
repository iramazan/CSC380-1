import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableTest {

    Table testTable;

    @Before
    public void setUp() throws Exception {
        testTable = new Table(0, 4);
    }

    @Test
    public void testSeatTableLegal() throws Exception {
        testTable.seatTable(4);
        assertEquals(4,testTable.getSeatedCustomers());
    }

    @Test
    public void testFreeTable() throws Exception {
        testTable.freeTable();
        assertEquals(0,testTable.getSeatedCustomers());
    }
}