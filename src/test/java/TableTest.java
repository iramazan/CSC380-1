import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableTest {

    Table testTable;

    @Before
    public void setUp() throws Exception {
        testTable = new Table(0, 4);
    }

    // Seat a table with a legal number of people
    @Test
    public void testSeatTableLegal() throws Exception {
        testTable.seatTable(4);
        assertEquals(4,testTable.getSeatedCustomers());
    }

    // Seat a table with an illegal number of people
    @Test(expected=IllegalArgumentException.class)
    public void testSeatTableIllegal() throws Exception {
        testTable.seatTable(5);
    }

    // Free a table and test that customers are removed
    @Test
    public void testFreeTableRemovingCustomers() throws Exception {
        testTable.seatTable(3);
        testTable.freeTable();
        assertEquals(0,testTable.getSeatedCustomers());
    }

    // Free a table and test that table status is changed
    @Test
    public void testFreeTableChangeStatus() throws Exception {
        testTable.seatTable(3);
        testTable.freeTable();
        assertEquals(Table.TableStatus.DIRTY, testTable.getTableStatus());
    }

    // Generate a basic bill for the table
    // TODO: This test won't pass
    @Test
    public void testGenerateBill() throws Exception {
        testTable.seatTable(3);
        testTable.placeOrder();
        Bill bill = testTable.generateBill();
    }

    // Generate an evenly split bill
    // TODO: This test won't pass
    @Test
    public void testGenerateBillEvenSplit() throws Exception {
        testTable.seatTable(3);
        testTable.placeOrder();
        Bill bill = testTable.generateBillEvenSplit();
    }

    // Generate a bill split by dishes
    // TODO: This test won't pass
    @Test
    public void testGenerateBillSplitByDish() throws Exception {
        testTable.seatTable(3);
        testTable.placeOrder();
        Bill bill = testTable.generateBillSplitByDish();
    }

}