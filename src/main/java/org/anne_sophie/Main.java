package org.anne_sophie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Meal spaguettiAndMeatballs = new Meal("Spaguetti and meatballs", 15.50, new String[]{"Spaguetti", "Tomato sauce", "Beef"});
        Meal rigatoniBolognese = new Meal("Rigatoni bolognese", 13.20, new String[] {"Rigatoni", "Tomato sauce", "Meat"});
        Dessert chocolateCake = new Dessert("Chocolate cake", 7.25, new String[]{"Flour", "Eggs", "Sugar", "Cocoa"});
        Dessert tiramisu = new Dessert("Tiramisu", 6.99, new String[] {"Cream", "Sugar", "Coffee"});
        System.out.println("Please log in in the right account");
        System.out.println("Enter:");
        System.out.println("1. for admin login");
        System.out.println("2. for customer login");
        Scanner scanner1 = new Scanner(System.in);
        int loginChoice = scanner1.nextInt();
        System.out.println("Please enter your user name: ");
        Scanner scanner2 = new Scanner(System.in);
        String enteredUsername = scanner2.next();
        System.out.println("Please enter your password: ");
        Scanner scanner3 = new Scanner(System.in);
        String enteredPassword = scanner3.next();
        if (loginChoice == 1) {
         //   Loginable adminLogin = new Admin("admin", "admin123");
            if (enteredUsername.equals("admin") && enteredPassword.equals("admin123")) {
                System.out.println("Admin login successful! Welcome admin");
            } else System.out.println("Admin login failed, please try again");
          //  if (adminLogin.login("admin", "admin123")) {
                System.out.println("Admin login successful! Welcome admin");
                System.out.println("Enter what you would like to do: ");
                System.out.println("1. Add a meal to the menu");
                System.out.println("2. Add a dessert to the menu");
                System.out.println("3. Remove a meal from the menu");
                System.out.println("4. Remove a dessert from the menu");
                System.out.println("5. Display the sales to a file");
                Scanner scanner4 = new Scanner(System.in);
                int adminChoice = scanner4.nextInt();
                switch (adminChoice) {
                    case 1:
                        System.out.println("What meal would you like to add to the menu (no spaces): ");
                        Scanner scanner5 = new Scanner(System.in);
                        String mealToAdd = scanner5.next();
                        if (mealToAdd.equalsIgnoreCase("spaguettiAndMeatballs")) {
                            Admin.addMealToMenu(spaguettiAndMeatballs);
                        } else if (mealToAdd.equalsIgnoreCase("rigatoniBolognese")) {
                            Admin.addMealToMenu(rigatoniBolognese);
                        } else System.out.println("Meal chosen does not exist, please try again");
                        break;
                    case 2:
                        System.out.println("What dessert would you like to add to the menu (no spaces): ");
                        Scanner scanner6 = new Scanner(System.in);
                        String dessertToAdd = scanner6.next();
                        if (dessertToAdd.equalsIgnoreCase("chocolateCake")) {
                            Admin.addDessertToMenu(chocolateCake);
                        } else if (dessertToAdd.equalsIgnoreCase("tiramisu")) {
                            Admin.addDessertToMenu(tiramisu);
                        } else System.out.println("Dessert chosen does not exist, please try again");
                        break;
                    case 3:
                        System.out.println("What meal would you like to remove from the menu (no spaces): ");
                        Scanner scanner7 = new Scanner(System.in);
                        String mealToRemove = scanner7.next();
                        if (mealToRemove.equalsIgnoreCase("spaguettiAndMeatballs")) {
                            Admin.removeMealFromMenu(spaguettiAndMeatballs);
                        } else if (mealToRemove.equalsIgnoreCase("rigatoniBolognese")) {
                            Admin.removeMealFromMenu(rigatoniBolognese);
                        } else System.out.println("Meal chosen does not exist, please try again");
                        break;
                    case 4:
                        System.out.println("What dessert would you like to remove from the menu (no spaces): ");
                        Scanner scanner8 = new Scanner(System.in);
                        String dessertToRemove = scanner8.next();
                        if (dessertToRemove.equalsIgnoreCase("chocolateCake")) {
                            Admin.removeDessertFromMenu(chocolateCake);
                        } else if (dessertToRemove.equalsIgnoreCase("tiramisu")) {
                            Admin.removeDessertFromMenu(tiramisu);
                        } else System.out.println("Dessert chosen does not exist, please try again");
                        break;
                    case 5:
                        Admin.displaySalesToFile();
                        break;
                }
            } //else {
                //System.out.println("Admin login failed, please try again");
           // }
     //   }
        if (loginChoice == 2) {
            Loginable customer = new Customer("customer", "customer123");
            if (customer.login("customer", "customer123")) {
                System.out.println("Customer login successful! Welcome customer");
                System.out.println("Enter what you would like to do: ");
                System.out.println("1. Add a meal to your cart");
                System.out.println("2. Add a dessert to your cart");
                System.out.println("3. Remove a meal from your cart");
                System.out.println("4. Remove a dessert from your cart");
                System.out.println("5. Display your order and price");
                System.out.println("6. Pay for your order");
                Scanner scanner9 = new Scanner(System.in);
                int customerChoice = scanner9.nextInt();
                switch (customerChoice) {
                    case 1:
                        System.out.println("What meal would you like to add to your cart (no spaces): ");
                        Scanner scanner10 = new Scanner(System.in);
                        String mealToAdd = scanner10.next();
                        if (mealToAdd.equalsIgnoreCase("spaguettiAndMeatballs")) {
                            Customer.addMealToCart(spaguettiAndMeatballs);
                        } else if (mealToAdd.equalsIgnoreCase("rigatoniBolognese")) {
                            Customer.addMealToCart(rigatoniBolognese);
                        } else System.out.println("Meal chosen does not exist, please try again");
                        break;
                    case 2:
                        System.out.println("What dessert would you like to add to your cart (no spaces): ");
                        Scanner scanner11 = new Scanner(System.in);
                        String dessertToAdd = scanner11.next();
                        if (dessertToAdd.equalsIgnoreCase("chocolateCake")) {
                            Customer.addDessertToCart(chocolateCake);
                        } else if (dessertToAdd.equalsIgnoreCase("tiramisu")) {
                            Customer.addDessertToCart(tiramisu);
                        } else System.out.println("Dessert chosen does not exist, please try again");
                        break;
                    case 3:
                        System.out.println("What meal would you like to remove from your cart (no spaces): ");
                        Scanner scanner12 = new Scanner(System.in);
                        String mealToRemove = scanner12.next();
                        if (mealToRemove.equalsIgnoreCase("spaguettiAndMeatballs")) {
                            Customer.removeMealFromCart(spaguettiAndMeatballs);
                        } else if (mealToRemove.equalsIgnoreCase("rigatoniBolognese")) {
                            Customer.removeMealFromCart(rigatoniBolognese);

                        } else System.out.println("Meal chosen does not exist, please try again");
                        break;
                    case 4:
                        System.out.println("What dessert would you like to remove from your cart (no spaces): ");
                        Scanner scanner13 = new Scanner(System.in);
                        String dessertToRemove = scanner13.next();
                        if (dessertToRemove.equalsIgnoreCase("chocolateCake")) {
                            Customer.removeDessertFromCart(chocolateCake);
                        } else if (dessertToRemove.equalsIgnoreCase("tiramisu")) {
                            Customer.removeDessertFromCart(tiramisu);
                        } else System.out.println("Dessert chosen does not exist, please try again");
                        break;
                    case 5:
                        Customer.displayOrder();
                        break;

                    case 6:
                        Customer.pay();
                        break;
                }
            } else {
                System.out.println("Customer login failed, please try again");
            }
    }
    }
}