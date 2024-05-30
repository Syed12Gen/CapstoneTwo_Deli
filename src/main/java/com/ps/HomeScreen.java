package com.ps;

import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // // Display the home screen menu options
            System.out.println("Welcome to the Sandwich Shop!");
            System.out.println("1. New Order");
            System.out.println("0. Exit\n");
            System.out.print("Select an option: ");
            //Reads an integer input
            int choice = scanner.nextInt();
            // Consume the leftover newline character
            scanner.nextLine();

            if (choice == 1) {
                // Prompt for customer information
                System.out.print("\nEnter your name: ");
                String name = scanner.nextLine();
                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                // Create a Customer object
                Customer customer = new Customer(name, email);

                // Creates a new instance of the OrderScreen class, allowing us to use its methods.
                OrderScreen orderScreen = new OrderScreen(customer);
                // Calls the startOrder method on the OrderScreen object
                orderScreen.startOrder();
            } else if (choice == 0) {
                System.out.println("Thank you for visiting! Goodbye!");
                break; // Exit the loop and end the program
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close(); // Close the scanner
    }
}
