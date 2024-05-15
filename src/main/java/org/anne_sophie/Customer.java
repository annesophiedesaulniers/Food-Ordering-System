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
     * @return if you successfully logged in or not
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

    /**
     * creates an account if you are a new customer
     *
     * @param username your desired username
     * @param password your desired password
     * @return if the account was created successfully or not
     */
    public static boolean createAccount(String username, String password) {
        try {
            if (accounts.containsKey(username)) {
                System.out.println("Username '" + username + "' already exists. Please choose a different username.");
                return false;
            } else {
                accounts.put(username, password);
                System.out.println("Account created successfully. Welcome, " + username + "!");
                return true;
            }
        } catch (Exception e) {
            System.out.println("An error occurred during account creation: " + e.getMessage());
            return false;
        }
    }

    /**
     * displays the menu for the customer
     */
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
     * adds a meal to their cart
     *
     * @param mealName the name of the meal to add
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
     * adds a dessert to their cart
     *
     * @param dessertName the name of the dessert to add
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
     * removes a meal from their cart
     *
     * @param mealName the name of the meal to remove from the cart
     */
    public static void removeMealFromCart(String mealName) {
        boolean doesMealExist = false;
        List<Meal> menuMeals = Admin.getMenuMeals();
        for (Meal meal : menuMeals) {
            if (meal.getName().equalsIgnoreCase(mealName)) {
                order.remove(meal);
                doesMealExist = true;
                break;
            }
        }
        if (doesMealExist) {
            System.out.println("Meal removed from the cart: " + mealName);
        } else {
            System.out.println("Meal '" + mealName + "' not found in the cart.");
        }
    }

    /**
     * removes a dessert from their cart
     *
     * @param dessertName the name of the dessert to remove
     */
    public static void removeDessertFromCart(String dessertName) {
        boolean doesDessertExist = false;
        List<Dessert> memuDeeserts = Admin.getMenuDesserts();
        for (Dessert dessert : memuDeeserts) {
            if (dessert.getName().equalsIgnoreCase(dessertName)) {
                order.remove(dessert);
                doesDessertExist = true;
                break;
            }
        }
        if (doesDessertExist) {
            System.out.println("Dessert removed from the cart: " + dessertName);
        } else {
            System.out.println("Dessert '" + dessertName + "' not found in the cart.");
        }
    }

    /**
     * gets the items you can afford based on your budget
     *
     * @param amount the budget you have to spend
     * @return the items you can afford
     */
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

    /**
     * displays the ingredients of a food item
     *
     * @param itemName the name of the food item
     */
    public static void displayIngredientsOfItem(String itemName) {
        List<Meal> menuMeals = Admin.getMenuMeals();
        List<Dessert> menuDesserts = Admin.getMenuDesserts();

        for (Meal meal : menuMeals) {
            if (meal.getName().equalsIgnoreCase(itemName)) {
                System.out.println("Ingredients for " + itemName + ": ");
                for (String ingredient : meal.getIngredients()) {
                    System.out.println(ingredient);
                }
                return;
            }
        }

        for (Dessert dessert : menuDesserts) {
            if (dessert.getName().equalsIgnoreCase(itemName)) {
                System.out.println("Ingredients for " + itemName + ": ");
                for (String ingredient : dessert.getIngredients()) {
                    System.out.println(ingredient);
                }
                return;
            }
        }

        System.out.println("Item '" + itemName + "' not found in the menu.");
    }

    /**
     * displays the order with the total price
     */
    public static void displayOrder() {
        double subtotal = 0;
        System.out.println("Order:");
        for (Food food : order) {
            food.displayInfo();
            subtotal += food.price;
        }
        System.out.println("Subtotal Price: $" + subtotal);
    }

    /**
     * payment of their food
     */
    public static void pay(double tipPercent) {
        double subtotal = 0;
        for (Food food : order) {
            food.displayInfo();
            subtotal += food.price;
        }
        double taxAmount = 0.15 * subtotal;
        double total = subtotal + taxAmount;
        double tipAmount = 0;
        if (tipPercent > 0) {
            tipAmount = tipPercent * subtotal / 100;
            total += tipAmount;
        }
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Tax (15%%): $%.2f\n", taxAmount);
        System.out.printf("Tip: $%.2f\n", tipAmount);
        System.out.printf("Total: $%.2f\n", total);
        System.out.printf("Successful payment of $%.2f\n", total);
        System.out.println("Thank you for your purchase! Enjoy!");
    }
}
