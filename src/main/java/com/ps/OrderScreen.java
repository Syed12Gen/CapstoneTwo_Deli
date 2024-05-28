package com.ps;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class OrderScreen {
    private Scanner scanner = new Scanner(System.in);
    // Initialize the order list to store products
    private List<Product> order = new ArrayList<>();

    /**
     * This method initiates the order process.
     * It allows the user to add sandwiches, drinks, or chips to the order,
     * checkout, or cancel the order.
     */
    public void startOrder() {
        while (true) {
            // Display the order screen menu options
            System.out.println("Order Screen:");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            // Handle user's choice
            if (choice == 1) {
                addSandwich();
            } else if (choice == 2) {
                addDrink();
            } else if (choice == 3) {
                addChips();
            } else if (choice == 4) {
                checkout();
                break; // End the order process after checkout
            } else if (choice == 0) {
                cancelOrder();
                break; // Cancel the order and go back to the home screen
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void  addSandwich() {
        System.out.println("Add Sandwich method called.");
    }
    private void  addDrink() {
        System.out.println("Add Drink method called.");
    }
    private void addChips() {
        System.out.println("Add Chips method called.");
    }
    private void  checkout() {
        System.out.println("Checkout method called.");
    }
    private void cancelOrder() {
        System.out.println("Cancel Order method called.");
    }
}
