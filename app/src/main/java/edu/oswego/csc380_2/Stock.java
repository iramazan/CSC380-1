import java.io.*;
import java.util.*;

public class Stock extends Observable {

    protected HashMap<String, Integer> ingredients; // Stock of ingredients in the restaurant
    protected final String serFile; // Where is the serialized file located
    private int runningLow;
    private static Stock instance;

    // Helper function to modify ingredients hashmap.
    // Return false if doesn't contain ingredient.
    protected boolean modifyIngredients(String ingredient, int amount) {
        if(!ingredients.containsKey(ingredient)) { return false; }
        int total = ingredients.get(ingredient) + amount;
        if(total < 0) total = 0; // Ingredients cannot be less than 0
        ingredients.put(ingredient, total);
        return true;
    }

    private Stock() {
        ingredients = new HashMap<String, Integer>();
        serFile = "src/main/resources/stock.ser"; // Put in resources directory of project
    }

    public static synchronized Stock getInstance() {
        if(instance == null) {
            instance = new Stock();
            File configFile = new File("src/main/resources/stock_config");
            int configRunningLow;
            try {
                Scanner sc = new Scanner(configFile);
                configRunningLow = sc.nextInt();
            } catch (FileNotFoundException e) {
                System.out.println("Configuration file for Stock not found. Using default value of 5.");
                configRunningLow = 5;
            }
            instance.setRunningLow(configRunningLow);
        }
        return instance;
    }

    public int getRunningLow() {
        return runningLow;
    }

    public void setRunningLow(int runningLow) {
        this.runningLow = runningLow;
    }

    // Add a specified number of an ingredient
    public void addIngredient(String ingredient, int amount) {
        if(ingredients.containsKey(ingredient))
            modifyIngredients(ingredient, amount);
        else ingredients.put(ingredient, amount);
        setChanged();
        notifyObservers();
    }

    // Remove a specified number of an ingredient.
    // Returns false if ingredient is not in hashmap
    public boolean removeIngredient(String ingredient, int amount) {
        if (ingredients.containsKey(ingredient)) {
            modifyIngredients(ingredient, amount * -1);
            setChanged();
            notifyObservers();
            return true;
        } else return false;
    }

    public Integer checkStock(String ingredient) {
        if(ingredients.containsKey(ingredient))
            return ingredients.get(ingredient);
        else return 0;
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();
        Set<String> keySet = ingredients.keySet();
        for(String key : keySet) {
            returnString.append(key + " : " + ingredients.get(key) + "\n");
        }
        return returnString.toString();
    }

    // Return any ingredients that are running low
    public Optional<ArrayList<String>> warnRunningLow() {
        Set<String> keySet = ingredients.keySet(); // Keys in the hashmap
        ArrayList<String> returnArray = new ArrayList<>();
        for (String key : keySet) {
            if(ingredients.get(key) <= runningLow)
                returnArray.add(key);
        }

        if(returnArray.isEmpty())
            return Optional.empty();
        else return Optional.of(returnArray);
    }

    // Serialize the hash table. Return true if successful.
    public boolean serialize() {
        try {
            FileOutputStream fileOut = new FileOutputStream(serFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(ingredients);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Deserialize the hash table. Return true if successful.
    public boolean deserialize() {
        try {
            FileInputStream fileIn = new FileInputStream(serFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ingredients = (HashMap<String, Integer>) in.readObject();
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
