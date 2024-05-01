package org.anne_sophie;

import java.util.ArrayList;
import java.util.List;

/**
 * customer of the restaurant
 *
 * @author Anne-Sophie Desaulniers
 */
public class Customer implements Loginable {
    private static String username;
    private static String password;
    private static List<Food> order = new ArrayList<>();

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.order = new ArrayList<>();
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
        if (username.equals(enteredUsername) && password.equals(enteredPassword)) {
            System.out.println("Customer login successful");
        } else {
            System.out.println("Customer login failed");
        }
        return false;
    }

    /**
     * add a meal to their cart
     * @param meal the desired meal to add
     */
    public static void addMealToCart(Meal meal) {
        order.add(meal);
        System.out.println("Meal added to order: " + meal.name);
    }

    /**
     * add a dessert to their cart
     * @param dessert the desired dessert to add
     */
    public static void addDessertToCart(Dessert dessert) {
        order.add(dessert);
        System.out.println("Dessert added to order: " + dessert.name);
    }

    /**
     * remove a meal from their cart
     * @param meal the meal to remove from their cart
     */
    public static void removeMealFromCart(Meal meal) {
        if (order.remove(meal)) {
            System.out.println("Food item removed from order: " + meal.name);
        } else {
            System.out.println("Food item not found in order: " + meal.name);
        }
    }

    /**
     * remove a dessert from their cart
     * @param dessert the dessert to remove from their cart
     */
    public static void removeDessertFromCart(Dessert dessert) {
        if (order.remove(dessert)) {
            System.out.println("Food item removed from order: " + dessert.name);
        } else {
            System.out.println("Food item not found in order: " + dessert.name);
        }
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

