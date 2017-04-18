import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Optional;

import static org.junit.Assert.*;


public class FinanceTest {

    Finance finance;
    String historyID;

    @Before
    public void setUp() throws Exception {
        finance = new Finance("one");

        GregorianCalendar cal = new GregorianCalendar();
        int month = cal.get(GregorianCalendar.MONTH);
        int year = cal.get(GregorianCalendar.YEAR);
        switch(month) {
            case 0:  historyID = "dec" + year;
                break;
            case 1:  historyID = "jan" + year;
                break;
            case 2:  historyID = "feb" + year;
                break;
            case 3:  historyID = "mar" + year;
                break;
            case 4:  historyID = "apr" + year;
                break;
            case 5:  historyID = "may" + year;
                break;
            case 6:  historyID = "jun" + year;
                break;
            case 7:  historyID = "jul" + year;
                break;
            case 8:  historyID = "aug" + year;
                break;
            case 9:  historyID = "sep" + year;
                break;
            case 10: historyID = "oct" + year;
                break;
            case 11: historyID = "nov" + year;
                break;
            default: throw new Exception("This month doesn't exist.");
        }
    }

    @Test
    public void moveToHistoryTest() throws Exception {
        finance.setProfit(1200d);
        finance.setEmployeePay(400d);
        finance.setIngredients(200d);
        finance.setProperty(500d);
        finance.setMisc(50d);
        finance.moveToHistory();
        assertEquals("[" + historyID + "]", finance.history.keySet().toString());
    }

    @Test
    public void getHistoryValidTest() throws Exception {
        finance.setProfit(1200d);
        finance.setEmployeePay(400d);
        finance.setIngredients(200d);
        finance.setProperty(500d);
        finance.setMisc(50d);
        finance.moveToHistory();
        String expected = "Profit: 1200.0, Employee Data: 400.0, " +
                "Ingredients: 200.0, Property: 500.0, Misc: 50.0";
        assertEquals(expected, finance.getHistory(historyID).get());
    }

    @Test
    public void getHistoryInvalidTest() throws Exception {
        finance.setProfit(1200d);
        finance.setEmployeePay(400d);
        finance.setIngredients(200d);
        finance.setProperty(500d);
        finance.setMisc(50d);
        finance.moveToHistory();
        Optional<String> returnStuff = finance.getHistory("jan2015");
        assertFalse(returnStuff.isPresent());
    }

    @Test
    public void listHistoryTest() throws Exception {
        finance.setProfit(1200d);
        finance.setEmployeePay(400d);
        finance.setIngredients(200d);
        finance.setProperty(500d);
        finance.setMisc(50d);
        finance.moveToHistory();
        String expected = historyID + "\n";
        assertEquals(expected, finance.listHistory());
    }
}
