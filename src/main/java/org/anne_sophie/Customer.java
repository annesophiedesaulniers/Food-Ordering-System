package org.anne_sophie;

import java.util.*;

/**
 * customer of the restaurant
 *
 * @author Anne-Sophie Desaulniers
 */
public class Customer implements Loginable {
    private static String username;
    private static String password;
    private static Map<String, String> accountInformation = new HashMap<>();

    private static Map<String, String> accounts = new HashMap<>();
    private static List<Food> order = new ArrayList<>();

    static {
        accounts.put("anneso", "anneso123");
        accounts.put("saku", "teacher");
    }

    /**
     * login for a customer
     *
     * @param enteredUsername the entered username
     * @param enteredPassword the entered password
     * @return if you logged in or not
     */
    @Override
    public boolean login(String enteredUsername, String enteredPassword) {
        try {
            String storedPassword = accounts.get(enteredUsername);
            if (storedPassword != null && storedPassword.equals(enteredPassword)) {
                System.out.println("Customer login successful! Welcome " + enteredUsername);
                return true;
            } else {
                System.out.println("Customer login failed. Invalid username or password. Please try again");
                return false;
            }
        } catch (Exception e) {
            System.out.println("An error occurred during login: " + e.getMessage());
            return false;
        }
    }
    public static boolean createAccount(String username, String password) {
        try {
            if (accounts.containsKey(username)) {
                System.out.println("Username '" + username + "' already exists. Please choose a different username.");
                return false; // Account creation failed
            } else {
                // Add the new username and password to the map
                accounts.put(username, password);
                System.out.println("Account created successfully. Welcome, " + username + "!");
                return true; // Account creation successful
            }
        } catch (Exception e) {
            System.out.println("An error occurred during account creation: " + e.getMessage());
            return false;
        }
    }

    public static void displayMenu() {
        System.out.println("Menu : ");
        System.out.println("Meals: ");
        for (Meal meal : Admin.getMenuMeals()) {
            System.out.println(meal.getName() + " $" + meal.getPrice());
        }
        System.out.println("Desserts: ");
        for (Dessert dessert : Admin.getMenuDesserts()) {
            System.out.println(dessert.getName() + " $" + dessert.getPrice());
        }
    }

    /**
     * add a meal to their cart
     * @param mealName name of the meal to add
     */
    public static void addMealToCart(String mealName) {
        boolean doesMealExist = false;
        List<Meal> menuMeals = Admin.getMenuMeals();
        for (Meal meal : menuMeals) {
            if (meal.getName().equalsIgnoreCase(mealName)) {
                order.add(meal);
                doesMealExist = true;
                System.out.println("Meal added to cart: " + mealName);
                break;
            }
        }
        if (!doesMealExist) {
            System.out.println("Meal '" + mealName + "' does not exist in the menu. Please try again.");
        }
    }
    /**
     * add a dessert to their cart
     * @param
     */
    public static void addDessertToCart(String dessertName) {
        boolean doesDessertExist = false;
        List<Dessert> menuDesserts = Admin.getMenuDesserts();
        for (Dessert dessert : menuDesserts) {
            if (dessert.getName().equalsIgnoreCase(dessertName)) {
                order.add(dessert);
                doesDessertExist = true;
                System.out.println("Dessert added to cart: " + dessertName);
                break;
            }
        }
        if (!doesDessertExist) {
            System.out.println("Dessert '" + dessertName + "' does not exist in the menu. Please try again.");
        }
    }

    /**
     * remove a meal from their cart
     * @param meal the meal to remove from their cart
     */
    public static void removeMealFromCart(String mealName) {
        boolean doesMealExist = false;
        List<Meal> menuMeals = Admin.getMenuMeals();
        for (Meal meal : menuMeals) {
            if (meal.getName().equalsIgnoreCase(mealName)) {
                order.remove(meal);
                doesMealExist = true;
                break; // Exiting the loop after removing the meal
            }
        }
        if (doesMealExist) {
            System.out.println("Meal removed from the cart: " + mealName);
        } else {
            System.out.println("Meal '" + mealName + "' not found in the cart.");
        }
    }

    /**
     * remove a dessert from their cart
     * @param dessert the dessert to remove from their cart
     */
    public static void removeDessertFromCart(String dessertName) {
        boolean doesDessertExist = false;
        List<Dessert> memuDeeserts = Admin.getMenuDesserts();
        for (Dessert dessert : memuDeeserts) {
            if (dessert.getName().equalsIgnoreCase(dessertName)) {
                order.remove(dessert);
                doesDessertExist = true;
                break; // Exiting the loop after removing the meal
            }
        }
        if (doesDessertExist) {
            System.out.println("Dessert removed from the cart: " + dessertName);
        } else {
            System.out.println("Dessert '" + dessertName + "' not found in the cart.");
        }
    }
    public static List<Food> getAffordableItems(double amount) {
        List<Food> affordableItems = new ArrayList<>();
        List<Meal> menuMeals = Admin.getMenuMeals();
        List<Dessert> menuDesserts = Admin.getMenuDesserts();
        System.out.println("With " + amount + "$, you can afford: ");

        for (Meal meal : menuMeals) {
            if (meal.getPrice() <= amount) {
                affordableItems.add(meal);
            }
        }
        for (Dessert dessert : menuDesserts) {
            if (dessert.getPrice() <= amount) {
                affordableItems.add(dessert);
            }
    }
        for (Food item : affordableItems) {
            System.out.println(item);
        }
        return affordableItems;
    }

    public static void displayIngredientsOfItem(String itemName) {
        List<Meal> menuMeals = Admin.getMenuMeals();
        List<Dessert> menuDesserts = Admin.getMenuDesserts();

        // Search for the item in the menu meals
        for (Meal meal : menuMeals) {
            if (meal.getName().equalsIgnoreCase(itemName)) {
                System.out.println("Ingredients for " + itemName + ":");
                for (String ingredient : meal.getIngredients()) {
                    System.out.println(ingredient);
                }
                return; // Exit the method after printing ingredients
            }
        }

        // Search for the item in the menu desserts
        for (Dessert dessert : menuDesserts) {
            if (dessert.getName().equalsIgnoreCase(itemName)) {
                System.out.println("Ingredients for " + itemName + ":");
                for (String ingredient : dessert.getIngredients()) {
                    System.out.println(ingredient);
                }
                return; // Exit the method after printing ingredients
            }
        }

        // If the item is not found in the menu
        System.out.println("Item '" + itemName + "' not found in the menu.");
    }
    /**
     * display the order with the total price
     */
    public static void displayOrder() {
        double total = 0;
        System.out.println("Order:");
        for (Food food : order) {
            food.displayInfo();
            total += food.price;
        }
        System.out.println("Total Price: $" + total);
    }

    /**
     * payment of their food
     */
    public static void pay() {
        double total = 0;
        for (Food food : order) {
            total += food.price;
        }
        System.out.println("Payment of " + total + " $ completed successfully");
        System.out.println("Thank you for your purchase! Enjoy!");
    }
}

