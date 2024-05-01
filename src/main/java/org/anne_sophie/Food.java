package org.anne_sophie;

/**
 * food you can get at the restaurant
 *
 * @author Anne-Sophie Desaulniers
 */
public abstract class Food {
    String name;
    double price;
    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * display the information about the food item
     */
    public abstract void displayInfo();

    /**
     * display the ingredients of the food item
     */
    public abstract void displayIngredients();
}

class Meal extends Food {

    String[] ingredients;
    public Meal(String name, double price, String[] ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    /**
     * display the information about the meal
     */
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }

    /**
     * display the ingredients of the food item
     */
    @Override
    public void displayIngredients() {
        System.out.println("Ingredients:");
        for (String ingredient : ingredients) {
            System.out.println("- " + ingredient);
        }
    }
}

class Dessert extends Food {
    String[] ingredients;

    public Dessert(String name, double price, String[] ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    /**
     * display the information about the dessert
     */
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }

    /**
     * display the ingredients of the dessert
     */
    @Override
    public void displayIngredients() {
        System.out.println("Ingredients:");
        for (String ingredient : ingredients) {
            System.out.println("- " + ingredient);
        }
    }
}

