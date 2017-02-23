
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
    public void testGetStatus(){
        assertEquals(Order.OrderStatus.STOPPED, testOrder.getStatus());
    }

    /*
    @Test
    public void testSetStatus(){
        testOrder.setStatus(Order.OrderStatus.STARTED);
        //OrderStatus status = (OrderTest)testOrder.getStatus();
        assertEquals(Order.OrderStatus.STARTED, testOrder.getStatus());
    }
    */

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