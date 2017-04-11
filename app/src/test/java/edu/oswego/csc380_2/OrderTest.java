package edu.oswego.csc380_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by James on 2/22/2017.
 *
 * import static org.junit.Assert.*;
 */

//I'm about to commit finally
public class OrderTest {
    Order testOrder;

    @Before
    public void setup(){
        testOrder = new Order();
    }

    @Test
    public void testGetName(){
        String name = "";
        assertEquals(name, testOrder.getName());
    }

    @Test
    public void testNameSet(){
        testOrder.setName("Lobster");
        String orderName = testOrder.getName();
        assertEquals("Lobster", testOrder.getName());
    }

    @Test
    public void testGetType(){
        testOrder.setType("Entree");
        assertEquals("Entree", testOrder.getType());
    }

    @Test
    public void testGetStatus(){
        assertEquals(Order.OrderStatus.STOPPED, testOrder.getStatus());
    }

    @Test
    public void testStart(){
        testOrder.startOrder();
        assertEquals(Order.OrderStatus.STARTED, testOrder.getStatus());
    }

    @Test
    public void testStop(){
        testOrder.stopOrder();
        assertEquals(Order.OrderStatus.STOPPED, testOrder.getStatus());
    }

    @Test
    public void testFinished(){
        testOrder.finishOrder();
        assertEquals(Order.OrderStatus.FINISHED, testOrder.getStatus());
    }

    @Test
    public void testGetPrice(){
        double price = 0;
        assertEquals(price, testOrder.getPrice(), 0);
    }

    @Test
    public void testPriceSet(){
        testOrder.setPrice(20.35);
        double price = testOrder.getPrice();
        assertEquals(20.35, price, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPriceSetException(){
        testOrder.setPrice(-15.99);
    }

    @Test
    public void testGetID(){
        int id = testOrder.getID()+1;
        Order testOrder = new Order();
        assertEquals(id, testOrder.getID());
    }

    @Test
    public void testSetID(){
        int expectedID = testOrder.getID() + 1;
        testOrder.setID();
        int id = testOrder.getID();
        assertEquals(expectedID, id);
    }
}