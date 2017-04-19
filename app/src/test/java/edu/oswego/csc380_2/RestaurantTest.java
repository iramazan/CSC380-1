package edu.oswego.csc380_2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by James on 3/21/2017.
 */
public class RestaurantTest {
    Restaurant testRestaurant;
    Order testOrder;

    @Before
    public void setup(){
        testRestaurant = new Restaurant("Name", "Address", "Doe",
                "John", 20.00f, 1234);
        testOrder = new Order("Name", "entree", 20.99);
    }

    @Test
    public void testGetName(){
        assertEquals("Name", testRestaurant.getName());
    }

    @Test
    public void testGetAddress(){
        assertEquals("Address", testRestaurant.getAddress());
    }

    //Test returning a dish based on its type
    @Test
    public void testGetFilledMenu(){
        Menu testMenu = new Menu();
        testMenu.addDish(testOrder);
        testRestaurant.getMenu().addDish(testOrder);

        assertEquals(testMenu.getEntrees(), testRestaurant.getMenu().getEntrees());
    }

    @Test
    public void testGetServers(){
        ArrayList<Server> servers = new ArrayList<Server>();
        assertEquals(servers, testRestaurant.getServers());
    }

    @Test
    public void testGetTables(){
        ArrayList<Table> testTables = new ArrayList<Table>();
        assertEquals(testTables, testRestaurant.getTables());
    }

}