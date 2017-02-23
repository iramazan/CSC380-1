import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by James on 2/23/2017.
 */
public class BillTest {
    Bill testBill;

    @Before
    public void setup(){
        testBill = new Bill();
    }

    @Test
    public void testGetAmount(){
        assertEquals(0.00, testBill.getAmount(), 0);
    }

    @Test
    public void testSetAmount(){
        testBill.setAmount(20.99);
        assertEquals(20.99, testBill.getAmount(), 0);
    }

    @Test
    public void testSplitBill(){
        testBill.setAmount(20);
        assertEquals(5, testBill.splitBill(4), 0);
    }

}