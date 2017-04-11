package edu.oswego.csc380_2;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by James on 2/23/2017.
 */

//Still want to commit
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
        assertEquals(5, testBill.splitBillByNumber(4), 0);
    }

    //Should fail with exception IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testSetAmountException(){
        testBill.setAmount(-15.99);
    }


}