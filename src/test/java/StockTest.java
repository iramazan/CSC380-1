import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.*;

public class StockTest {

    Stock stock = Stock.getInstance();

    @Before
    public void setUp() throws Exception {
        Stock.getInstance().addIngredient("Lettuce", 12);
        Stock.getInstance().addIngredient("Tomato", 9);
        Stock.getInstance().addIngredient("Steak", 22);
        Stock.getInstance().addIngredient("Potato", 17);
    }

    @After
    public void tearDown() throws Exception {
        stock.ingredients = new HashMap<String, Integer>();
    }

    @Test
    public void modifyIngredientsContainsTest() throws Exception {
        stock.modifyIngredients("Tomato", 4);
        assertEquals(13, (int)stock.checkStock("Tomato"));
    }

    @Test
    public void modifyIngredientsNotContainsTest() throws Exception {
        boolean returnValue = stock.modifyIngredients("Carrot", 37);
        assertFalse(returnValue);
    }

    @Test
    public void modifyIngredientsNegativeTest() throws Exception {
        stock.modifyIngredients("Steak", 25 * -1);
        assertEquals(0, (int)stock.checkStock("Steak"));
    }

    @Test
    public void addIngredientExistingTest() throws Exception {
        stock.addIngredient("Steak", 5);
        assertEquals(27, (int)stock.checkStock("Steak"));
    }

    @Test
    public void addIngredientNewTest() throws Exception {
        stock.addIngredient("Lemon", 7);
        assertEquals(7, (int)stock.checkStock("Lemon"));
    }

    @Test
    public void removeIngredientSuccessTest() throws Exception {
        stock.removeIngredient("Potato", 7);
        assertEquals(10, (int)stock.checkStock("Potato"));
    }

    @Test
    public void removeIngredientFailureTest() throws Exception {
        boolean returnValue = stock.removeIngredient("Lemon", 23);
        assertFalse(returnValue);
    }

    @Test
    public void warnRunningLowYesTest() throws Exception {
        stock.addIngredient("Pickle", 3);
        stock.modifyIngredients("Tomato", -4);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Pickle", "Tomato"));
        assertEquals(expected, stock.warnRunningLow().get());
    }

    @Test
    public void warnRunningLowNoTest() throws Exception {
        assertFalse(stock.warnRunningLow().isPresent());
    }
}
