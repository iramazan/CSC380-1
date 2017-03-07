import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by James on 3/7/2017.
 * MenuTest class
 */
public class MenuTest {
    Menu testMenu;
    Order testOrder1;

    @Before
    public void setUp(){
        testMenu = new Menu();
        testOrder1 = new Order("Lobster", "Entree", 20.99);
    }

    @Test
    //add dish
    public void testAddDish(){
        assertEquals(true, testMenu.addDish(testOrder1));
    }

    @Test
    //remove dish
    public void testRemoveDish(){
        testMenu.addDish(testOrder1);
        assertEquals(true, testMenu.removeDish(testOrder1));
    }

    @Test
    //remove dish that doesn't exist
    public void testRemoveEmptyDish(){
        assertEquals(false, testMenu.removeDish(testOrder1));
    }

    @Test
    //should fail
    public void testAddSameDish(){
        testMenu.addDish(testOrder1);
        assertEquals(false, testMenu.addDish(testOrder1));
    }
}