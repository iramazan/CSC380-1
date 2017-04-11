import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class OwnerTest {

    Owner owner;
    ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        owner = new Owner("Doe", "John", 200.00f, 1234);
    }

    @Test
    public void observerEventTest() throws Exception {
        System.setOut(new PrintStream(outStream));
        Stock stock = Stock.getInstance();
        stock.addObserver(owner);
        stock.addIngredient("Octopus", 4);
        assertEquals("[Octopus]\n", outStream.toString());
    }
}
