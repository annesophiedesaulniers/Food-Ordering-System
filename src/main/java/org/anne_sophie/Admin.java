package org.anne_sophie;

import java.util.ArrayList;
import java.util.List;

/**
 * admin of the restaurant
 *
 * @author Anne-Sophie Desaulniers
 */
class Admin implements Loginable {
    private static String username = null;
    private static String password = null;
    private static List<Meal> menuMeals;
    private static List<Dessert> menuDesserts;
    private double totalSales;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.menuMeals = new ArrayList<>();
        this.menuDesserts = new ArrayList<>();
        this.totalSales = 0;
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
        if (username.equals(enteredUsername) && password.equals(enteredPassword)) {
            System.out.println("Admin logged in successfully!");
        } else {
            System.out.println("Admin login failed");
        }
        return false;
    }

    /**
     * add a meal to the menu
     * @param meal the desired meal to add
     */
    public static void addMealToMenu(Meal meal) {
        menuMeals.add(meal);
        System.out.println("Meal added to the menu: " + meal.name);
    }

    /**
     * remove a meal from the menu
     * @param meal the meal to remove from the menu
     */
    public static void removeMealFromMenu(Meal meal) {
        if (menuMeals.remove(meal)) {
            System.out.println("Meal removed from the menu: " + meal.name);
        } else {
            System.out.println("Meal not found in the menu: " + meal.name);
        }
    }

    /**
     * add a dessert to the menu
     * @param dessert the desired dessert to add
     */
    public static void addDessertToMenu(Dessert dessert) {
        menuDesserts.add(dessert);
        System.out.println("Dessert added to the menu: " + dessert.name);
    }

    /**
     * remove a dessert from the menu
     * @param dessert the dessert to remove from the menu
     */
    public static void removeDessertFromMenu(Dessert dessert) {
        if (menuDesserts.remove(dessert)) {
            System.out.println("Dessert removed from the menu: " + dessert.name);
        } else {
            System.out.println("Dessert not found in the menu: " + dessert.name);
        }
    }

    public static void recordSale() {

    }

    public static void displaySalesToFile() {

    }
}
