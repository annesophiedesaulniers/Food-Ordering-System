package org.anne_sophie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Customer customer = new Customer();
        boolean isAdminLoginSuccessful;
        boolean isCustomerLoginSuccessful;
        int loginChoice;
        while (true) {
            System.out.println("Welcome to Anne's Lounge!");
            System.out.println("Please log into the right account");
            System.out.println("Enter:");
            System.out.println("1. for admin login");
            System.out.println("2. for customer login");
            System.out.println("3. if you are a new customer");
            System.out.print("Enter your choice: ");
            loginChoice = scanner.nextInt();
            if (loginChoice == 1) {
                System.out.println("Please enter your username: ");
                Scanner scanner2 = new Scanner(System.in);
                String enteredUsername = scanner2.next();
                System.out.println("Please enter your password: ");
                Scanner scanner3 = new Scanner(System.in);
                String enteredPassword = scanner3.next();
                isAdminLoginSuccessful = admin.login(enteredUsername, enteredPassword);
                while (isAdminLoginSuccessful) {
                    System.out.println("Here is what you can do:");
                    System.out.println("1. Add a meal to the menu");
                    System.out.println("2. Add a dessert to the menu");
                    System.out.println("3. Remove a meal from the menu");
                    System.out.println("4. Remove a dessert from the menu");
                    System.out.println("5. Exit");
                    System.out.print("Enter what you would like to do: ");
                    int adminChoice = scanner.nextInt();
                    switch (adminChoice) {
                        case 1:
                            System.out.println("What is the name of the meal you would like to add to the menu (no spaces): ");
                            String mealToAdd = scanner.next();
                            scanner.nextLine();
                            System.out.println("How much do you want it to cost: ");
                            double priceOfMeal = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("What are the ingredients in it: ");
                            String[] ingredientsOfMeal = new String[]{scanner.nextLine()};
                            Admin.addMealToMenu(mealToAdd, priceOfMeal, ingredientsOfMeal);
                            break;
                        case 2:
                            System.out.println("What is the name of the dessert you would like to add to the menu (no spaces): ");
                            String dessertToAdd = scanner.next();
                            scanner.nextLine();
                            System.out.println("How much do you want it to cost: ");
                            double priceOfDessert = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("What are the ingredients in it: ");
                            String[] ingredientsOfDessert = new String[]{scanner.nextLine()};
                            Admin.addDessertToMenu(dessertToAdd, priceOfDessert, ingredientsOfDessert);
                            break;
                        case 3:
                            System.out.println("What is the name of the meal would you like to remove from the menu (no spaces): ");
                            String mealToRemove = scanner.next();
                            Admin.removeMealFromMenu(mealToRemove);
                            break;
                        case 4:
                            System.out.println("What dessert would you like to remove from the menu (no spaces): ");
                            String dessertToRemove = scanner.next();
                            Admin.removeDessertFromMenu(dessertToRemove);
                            break;
                        case 5:
                            System.out.println("Exiting. Goodbye admin");
                            isAdminLoginSuccessful = false;
                            break;
                    }
                }

            } else if (loginChoice == 2) {
                System.out.println("Please enter your username: ");
                String enteredUsername = scanner.next();
                System.out.println("Please enter your password: ");
                String enteredPassword = scanner.next();
                isCustomerLoginSuccessful = customer.login(enteredUsername, enteredPassword);
                while (isCustomerLoginSuccessful) {
                    System.out.println("Here is what you can do: ");
                    System.out.println("1. Display the menu");
                    System.out.println("2. Add a meal to your cart");
                    System.out.println("3. Add a dessert to your cart");
                    System.out.println("4. Remove a meal from your cart");
                    System.out.println("5. Remove a dessert from your cart");
                    System.out.println("6. Display affordable items");
                    System.out.println("7. Display ingredients of an item");
                    System.out.println("8. Display your order and price");
                    System.out.println("9. Pay for your order");
                    System.out.println("10. Exit");
                    System.out.println("Enter what you would like to do: ");
                    int customerChoice = scanner.nextInt();
                    switch (customerChoice) {
                        case 1:
                            Customer.displayMenu();
                            break;
                        case 2:
                            System.out.println("What meal would you like to add to your cart (no spaces): ");
                            String mealToAdd = scanner.next();
                            Customer.addMealToCart(mealToAdd);
                            break;
                        case 3:
                            System.out.println("What dessert would you like to add to your cart (no spaces): ");
                            String dessertToAdd = scanner.next();
                            Customer.addDessertToCart(dessertToAdd);
                            break;
                        case 4:
                            System.out.println("What meal would you like to remove from your cart (no spaces): ");
                            String mealToRemove = scanner.next();
                            Customer.removeMealFromCart(mealToRemove);
                            break;
                        case 5:
                            System.out.println("What dessert would you like to remove from your cart (no spaces): ");
                            String dessertToRemove = scanner.next();
                            Customer.removeDessertFromCart(dessertToRemove);
                            break;
                        case 6:
                            System.out.println("What is your budget: ");
                            double budget = scanner.nextDouble();
                            Customer.getAffordableItems(budget);
                            break;
                        case 7:
                            System.out.println("Which food item would you like to see the ingredients: ");
                            String itemToSeeIngredients = scanner.next();
                            Customer.displayIngredientsOfItem(itemToSeeIngredients);
                            break;
                        case 8:
                            Customer.displayOrder();
                            break;

                        case 9:
                            System.out.println("Would you like to add a tip? (eg: enter 15 for 15%)");
                            double tipPercent = scanner.nextDouble();
                            Customer.pay(tipPercent);
                            break;
                        case 10:
                            System.out.println("Exiting. Thank you!");
                            isCustomerLoginSuccessful = false;
                            break;
                    }
                }
            } else if (loginChoice == 3) {
                System.out.println("Enter a new username: ");
                String newUsername = scanner.next();
                System.out.println("Enter a new password: ");
                String newPassword = scanner.next();
                Customer.createAccount(newUsername, newPassword);
            } else System.out.println("Invalid choice, please try again");
        }
    }
}
