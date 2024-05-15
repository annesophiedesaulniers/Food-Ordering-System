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

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

/**
 * meal you can get at the restaurant
 *
 * @author Anne-Sophie Desaulniers
 */
class Meal extends Food {
    String[] ingredients;
    public Meal(String name, double price, String[] ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * displays the information about the meal
     */
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }

    /**
     * displays the ingredients of the meal
     */
    @Override
    public void displayIngredients() {
        System.out.println("Ingredients:");
        for (String ingredient : ingredients) {
            System.out.println("- " + ingredient);
        }
    }

    public String getName() {
        return super.getName();
    }
    public double getPrice() {
        return super.getPrice();
    }
}

/**
 * dessert you can get at the restaurant
 *
 * @author Anne-Sophie Desaulniers
 */
class Dessert extends Food {
    String[] ingredients;

    public Dessert(String name, double price, String[] ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    public String[] getIngredients() {
        return ingredients;
    }
    public String getName() {
        return super.getName();
    }
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return "Dessert{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * displays the information about the dessert
     */
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }

    /**
     * displays the ingredients of the dessert
     */
    @Override
    public void displayIngredients() {
        System.out.println("Ingredients:");
        for (String ingredient : ingredients) {
            System.out.println("- " + ingredient);
        }
    }
}
