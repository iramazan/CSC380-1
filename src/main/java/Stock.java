import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

public class Stock {

    private HashMap<String, Integer> ingredients; // Stock of ingredients in the restaurant
    private final String serFile; // Where is the serialized file located
    private int runningLow;

    // Helper function to modify ingredients hashmap.
    // Return false if doesn't contain ingredient.
    protected boolean modifyIngredients(String ingredient, int amount) {
        if(!ingredients.containsKey(ingredient)) { return false; }
        int total = ingredients.get(ingredient) + amount;
        if(total < 0) total = 0; // Ingredients cannot be less than 0
        ingredients.put(ingredient, total);
        return true;
    }

    public Stock(int runningLow) {
        ingredients = new HashMap<String, Integer>();
        serFile = "../../../stock.ser"; // Put in top level directory of project
        this.runningLow = runningLow;
    }

    // Add a specified number of an ingredient
    public void addIngredient(String ingredient, int amount) {
        if(ingredients.containsKey(ingredient))
            modifyIngredients(ingredient, amount);
        else ingredients.put(ingredient, amount);
    }

    // Remove a specified number of an ingredient.
    // Returns false if ingredient is not in hashmap
    public boolean removeIngredient(String ingredient, int amount) {
        if (ingredients.containsKey(ingredient)) {
            modifyIngredients(ingredient, amount * -1);
            return true;
        } else return false;
    }

    public Integer checkStock(String ingredient) {
        if(ingredients.containsKey(ingredient))
            return ingredients.get(ingredient);
        else return 0;
    }

    public String toString() {
        String returnString = "";
        Set<String> keySet = ingredients.keySet();
        for(String key : keySet) {
            returnString += key + " : " + ingredients.get(key) + "\n";
        }
        return returnString;
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
