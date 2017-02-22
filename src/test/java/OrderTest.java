
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by James on 2/22/2017.
 *
 * import static org.junit.Assert.*;
 */
public class OrderTest {
    Order testOrder = new Order();

    @Test
    public void testGetName(){
        String name = "";
        assertEquals(name, testOrder.getName());
    }

    @Test
    public void testNameSet(){
        testOrder.setName("Lobster");
        String orderName = testOrder.getName();
        assertEquals("Lobster", orderName);
    }

    @Test
    public void testGetStatus(){
        String status = "";
        assertEquals(status, testOrder.getStatus());
    }

    @Test
    public void testSetStatus(){
        testOrder.setStatus("In Progress");
        String status = testOrder.getStatus();
        assertEquals("In Progress", status);
    }

    @Test
    public void testGetPrice(){
        double price = 0;
        assertEquals(price, testOrder.getPrice());
    }

    @Test
    public void testPriceSet(){
        testOrder.setPrice(20.35);
        double price = testOrder.getPrice();
        assertEquals(20.35, price);
    }

    @Test
    public void testGetID(){
        int id = -1;
        assertEquals(id, testOrder.getID());
    }

    @Test
    public void testSetID(){
        testOrder.setID();
        int id = testOrder.getID();
        assertEquals(1, id);
    }



}