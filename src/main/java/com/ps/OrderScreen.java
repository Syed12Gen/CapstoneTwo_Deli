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

    /** The addSandwich method will guide the user through the process of creating a sandwich,
     * and then add the created sandwich to the order list.
     */
    private void  addSandwich() {
        // Call the method to create a sandwich
       Sandwich sandwich = createSandwich();
       // Add the sandwich to the beginning of the order list
        order.add(0, sandwich);
        System.out.println("Sandwich added to the order.");
    }

    /** The createSandwich method will guide the user through selecting the option like:
     *  bread type, sandwich size, and toppings for the sandwich.
    */
    private Sandwich createSandwich() {
        Sandwich sandwich = new Sandwich();

        // Step 1: Select bread type
        BreadType breadType = selectBreadType();
        sandwich.setBreadType(breadType);

        // Step 2: Select sandwich size
        SandwichSize size = selectSandwichSize();
        sandwich.setSize(size);

        // Step 3: Add toppings
        List<SandwichTopping> toppings = selectToppings();
        sandwich.setToppings(toppings);

        // Step 4: Ask if toasted
        boolean toasted = isToasted();
        sandwich.setToasted(toasted);

        return sandwich;
    }

    // Prompts the user to select the bread type.Placeholder!
    private BreadType selectBreadType() {
        return BreadType.WHITE;
    }

    //Prompts the user to select the sandwich size. Placeholder!
    private SandwichSize selectSandwichSize() {
        return SandwichSize.EIGHT_INCH;
    }

     // Prompts the user to select toppings. Placeholder!
    private List<SandwichTopping> selectToppings() {
        return new ArrayList<>();
    }

    // Prompts the user if they want the sandwich toasted. Placeholder!
    private boolean isToasted() {
        return false;
    }

    // Prompts the user to add drink.
    private void  addDrink() {
        System.out.println("Add Drink method called.");
    }

    // Prompts the user to add chips.
    private void addChips() {
        System.out.println("Add Chips method called.");
    }

    // Prompts the user checkout the order.
    private void  checkout() {
        System.out.println("Checkout method called.");
    }

    // Prompts the user to cancel the order
    private void cancelOrder() {
        System.out.println("Cancel Order method called.");
    }
}
