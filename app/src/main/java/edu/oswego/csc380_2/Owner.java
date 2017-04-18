import java.io.*;
import java.util.*;

public class Owner extends Employee implements Observer {

    protected String serFile;
    private HashMap<String, Finance> finance;

    @Override
    public void printPaycheck() {
        //TODO
    }

    public Owner(String lastName, String firstName, float salary, int pin) {
        super(lastName, firstName, salary, pin);
        finance = new HashMap<>();
        serFile = "src/main/resources/finance.ser";
    }

    @Override
    public void update(Observable observable, Object o) {
        Stock stockUpdate = (Stock) observable;
        Optional<ArrayList<String>> runningLow = stockUpdate.warnRunningLow();
        if(runningLow.isPresent()) {
            System.out.println(runningLow.get().toString());
        }
    }

    // Add a new finance database. Return true if successful.
    // Return false if name is already taken
    public boolean addFinance(String name) {
        if(!finance.containsKey(name)) {
            finance.put(name, new Finance(name));
            return true;
        }
        else return false;
    }

    // Remove a finance database. Return true if successful.
    // Return false if it didn't exist.
    public boolean removeFinance(String name) {
        if(!finance.containsKey(name)) {
            finance.remove(name);
            return true;
        }
        else return false;
    }

    // Return finance database specified by name
    public Optional<Finance> getFinance(String name) {
        return Optional.ofNullable(finance.get(name));
    }

    // list finance databases available
    public String listFinance() {
        Set<String> keySet = finance.keySet();
        StringBuilder returnString = new StringBuilder();
        for(String k : keySet) {
            returnString.append(k + ", ");
        }
        int length = returnString.length();
        returnString.delete(length-2, length);
        returnString.append("\n");
        return returnString.toString();
    }

    // Serialize the hash table. Return true if successful.
    public boolean serializeFinance() {
        try {
            FileOutputStream fileOut = new FileOutputStream(serFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(finance);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Deserialize the hash table. Return true if successful.
    public boolean deserializeFinance() {
        try {
            FileInputStream fileIn = new FileInputStream(serFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            finance = (HashMap<String, Finance>) in.readObject();
            in.close();
            fileIn.close();
            return true;
        } catch (IOException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
