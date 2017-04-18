import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
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

    @Test
    public void listFinanceTest() throws Exception {
        owner.addFinance("one");
        owner.addFinance("two");
        owner.addFinance("three");
        assertEquals("one, two, three\n", owner.listFinance());
    }

    @Test
    public void serializeFinanceTest() throws Exception {
        owner.addFinance("one");
        owner.addFinance("two");
        owner.addFinance("three");
        owner.serializeFinance();
        File serFile = new File(owner.serFile);
        assertTrue(serFile.exists());
        serFile.delete();
    }

    @Test
    public void deserializeFinanceTest() throws Exception {
        owner.addFinance("one");
        owner.addFinance("two");
        owner.addFinance("three");
        owner.serializeFinance();
        owner = new Owner("Smith", "John", 150.00f, 1235);
        owner.deserializeFinance();
        new File(owner.serFile).delete();
        assertEquals("one, two, three\n", owner.listFinance());
    }
}
