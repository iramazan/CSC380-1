import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by James on 3/7/2017.
 * MenuTest class
 */
public class MenuTest {
    Menu testMenu;
    Order testOrder1;
    Order testOrder2;
    Order testOrder3;

    @Before
    public void setUp(){
        testMenu = new Menu();
        testOrder1 = new Order("Sandwich", "Appetizer", 5.99);
        testOrder2 = new Order("Lobster", "Entree", 20.99);
        testOrder3 = new Order("Cake", "Dessert", 7.99);

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

    @Test
    public void testGetAppetizers(){
        testMenu.addDish(testOrder1);

        assertEquals(testOrder1, testMenu.getAppetizers().get(0));
    }

    @Test
    public void testGetEntrees(){
        testMenu.addDish(testOrder2);

        assertEquals(testOrder2, testMenu.getEntrees().get(0));
    }

    @Test
    public void testGetDesserts(){
        testMenu.addDish(testOrder3);

        assertEquals(testOrder3, testMenu.getDesserts().get(0));
    }
}