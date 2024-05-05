package org.anne_sophie;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * admin of the restaurant
 *
 * @author Anne-Sophie Desaulniers
 */
class Admin implements Loginable {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static List<Meal> menuMeals;
    private static List<Dessert> menuDesserts;
    private double totalSales;

    public Admin() {
        this.menuMeals = new ArrayList<>();
        this.menuDesserts = new ArrayList<>();
        this.totalSales = totalSales;
    }

    public static List<Meal> getMenuMeals() {
        return menuMeals;
    }

    public static List<Dessert> getMenuDesserts() {
        return menuDesserts;
    }

    /**
     * login for admin
     *
     * @param enteredUsername the entered username
     * @param enteredPassword the entered password
     * @return
     */
    @Override
    public boolean login(String enteredUsername, String enteredPassword) {
        if (ADMIN_USERNAME.equals(enteredUsername) && ADMIN_PASSWORD.equals(enteredPassword)) {
            System.out.println("Admin logged in successfully! Welcome admin!");
            return true;
        } else {
            System.out.println("Admin login failed, please try again");
        }
        return false;
    }

    /**
     * add a meal to the menu
     *
     */
    public static void addMealToMenu(String name, double price, String[] ingredients) {
        for (Meal meal : menuMeals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                System.out.println("Meal " + name + " already exists. Try another meal");
                return;
            }
        }
        Meal newMeal = new Meal(name, price, ingredients);
        menuMeals.add(newMeal);
        System.out.println("Meal added to the menu: " + newMeal.name + " for " + newMeal.price + " $ containing " + Arrays.toString(newMeal.ingredients));
        updateMenuFile();
    }

    /**
     * remove a meal from the menu
     *
     */
    public static void removeMealFromMenu(String name) {
        Iterator<Meal> iterator = menuMeals.iterator();
        while (iterator.hasNext()) {
            Meal meal = iterator.next();
            if (meal.getName().equalsIgnoreCase(name)) {
                // Remove the meal from the menu
                iterator.remove();
                System.out.println("Meal '" + name + "' removed from the menu successfully.");
                updateMenuFile();
                return;
            }
        }
        // If the meal with the specified name is not found
        System.out.println("Meal '" + name + "' not found in the menu, Please try a different meal.");
    }

    /**
     * add a dessert to the menu
     *
     */
    public static void addDessertToMenu(String name, double price, String[] ingredients) {
        for (Dessert dessert : menuDesserts) {
            if (dessert.getName().equalsIgnoreCase(name)) {
                System.out.println("Dessert " + name + " already exists. Try another dessert");
                return;
            }
        }
        Dessert newDessert = new Dessert(name, price, ingredients);
        menuDesserts.add(newDessert);
        System.out.println("Dessert added to the menu: " + newDessert.name + " for " + newDessert.price + " $ containing " + Arrays.toString(newDessert.ingredients));
        updateMenuFile();
    }

    /**
     * remove a dessert from the menu
     *
     * @param name the name of the dessert ot remove from the menu
     */
    public static void removeDessertFromMenu(String name) {
        Iterator<Dessert> iterator = menuDesserts.iterator();
        while (iterator.hasNext()) {
            Dessert dessert = iterator.next();
            if (dessert.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Dessert '" + name + "' removed from the menu successfully.");
                updateMenuFile();
                return;
            }
        }
        System.out.println("Dessert '" + name + "' not found in the menu, Please try a different meal.");
    }
    public static void displayMenu() {
        System.out.println("Menu: ");
        System.out.println("Meals: ");
        for (Meal meal : menuMeals) {
            System.out.println(meal.getName() + " $" + meal.getPrice());
        }
        System.out.println("Dessert: ");
        for (Dessert dessert : menuDesserts) {
            System.out.println(dessert.getName()  + " $" + dessert.getPrice());
        }
    }
    public List<String> getIngredients(String itemName) {
        for (Meal meal : menuMeals) {
            if (meal.getName().equalsIgnoreCase(itemName)) {
                return List.of(meal.getIngredients());
            }
        }
        for (Dessert dessert : menuDesserts) {
            if (dessert.getName().equalsIgnoreCase(itemName)) {
                return List.of(dessert.getIngredients());
            }
        }
        System.out.println(itemName + " not found in the menu. Please try again");
        return null;
    }

    public static void updateMenuFile() {
        try (FileWriter writer = new FileWriter("menu.txt")) {
            writer.write("Menu:\n");
            System.out.println();
            writer.write("Meals:\n");
            for (Meal meal : menuMeals) {
                writer.write("Meal: " + meal.getName() + "\nPrice: $" + meal.getPrice() + "\n");
                writer.write("Ingredients: ");
                for (String ingredient : meal.getIngredients()) {
                    writer.write(ingredient + ", ");
                }
                writer.write("\n");
            }
            writer.write("Desserts:\n");
            for (Dessert dessert : menuDesserts) {
                writer.write("Dessert: " + dessert.getName() + "\nPrice: $" + dessert.getPrice() + "\n");
                writer.write("Ingredients: ");
                for (String ingredient : dessert.getIngredients()) {
                    writer.write(ingredient + ", ");
                }
                writer.write("\n");
            }
            System.out.println("Menu file updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the menu file: " + e.getMessage());
        }
    }
}

