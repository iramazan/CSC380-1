import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by James on 3/7/2017.
 */
public class MenuTest {
    Menu testMenu;
    Order testOrder1;

    @Before
    public void setUp(){
        testMenu = new Menu();
        testOrder1 = new Order("Lobster", 20.99);
    }

    @Test
    //add appetizer
    public void testAddAppetizer(){
        assertEquals(true, testMenu.addAppetizer(testOrder1));
    }

    @Test
    //remove appetizer
    public void testRemoveAppetizer(){
        testMenu.addAppetizer(testOrder1);
        assertEquals(true, testMenu.removeAppetizer(testOrder1));
    }

    @Test
    //remove appetizer that doesnt exist
    public void testRemoveEmptyAppetizer(){
        assertEquals(false, testMenu.removeAppetizer(testOrder1));
    }

    @Test
    //should fail
    public void testAddSameAppetizer(){
        testMenu.addAppetizer(testOrder1);
        assertEquals(false, testMenu.addAppetizer(testOrder1));
    }

    @Test
    //add entree
    public void testAddEntree(){
        assertEquals(true, testMenu.addEntree(testOrder1));
    }

    @Test
    //remove an entree
    public void testRemoveEntree(){
        testMenu.addEntree(testOrder1);
        assertEquals(true, testMenu.removeEntree(testOrder1));
    }

    @Test
    //remove an entree that doesnt exist
    public void testRemoveEmptyEntree(){
        assertEquals(false, testMenu.removeEntree(testOrder1));
    }

    @Test
    //should fail
    public void testAddSameEntree(){
        testMenu.addEntree(testOrder1);
        assertEquals(false, testMenu.addEntree(testOrder1));
    }

    @Test
    //add dessert
    public void testAddDesserts(){
        assertEquals(true, testMenu.addDessert(testOrder1));
    }

    @Test
    //remove a dessert
    public void testRemoveDessert(){
        testMenu.addDessert(testOrder1);
        assertEquals(true, testMenu.removeDessert(testOrder1));
    }

    @Test
    //remove dessert that is not in the list
    public void testRemoveEmptyDessert(){
        assertEquals(false, testMenu.removeDessert(testOrder1));
    }

    @Test
    //should fail
    public void testAddSameDessert(){
        testMenu.addDessert(testOrder1);
        assertEquals(false, testMenu.addDessert(testOrder1));
    }
}