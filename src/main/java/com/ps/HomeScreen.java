package com.ps;

import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Sandwich Shop!");
            System.out.println("1. New Order");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (choice == 1) {
                OrderScreen orderScreen = new OrderScreen();
                orderScreen.startOrder(); // Start a new order
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
