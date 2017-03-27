import java.util.HashMap;

public class Stock {

    private HashMap<String, Integer> ingredients; // Stock of ingredients in the restaurant

    // Helper function to modify ingredients hashmap.
    // Return false if doesn't contain ingredient.
    protected boolean modifyIngredients(String ingredient, int amount) {
        if(!ingredients.containsKey(ingredient)) { return false; }
        int total = ingredients.get(ingredient) + amount;
        if(total < 0) total = 0; // Ingredients cannot be less than 0
        ingredients.put(ingredient, total);
        return true;
    }

    public Stock() {
        ingredients = new HashMap<String, Integer>();
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

    public Integer checkStock(String ingredient) { return ingredients.get(ingredient); }

}
