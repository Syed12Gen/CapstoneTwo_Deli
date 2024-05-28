package com.ps;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class OrderScreen {
    private Scanner scanner = new Scanner(System.in);
    // Initialize the order list to store products
    private List<Product> order = new ArrayList<>();

    // Define static instances of SandwichTopping
    private static final SandwichTopping LETTUCE = new SandwichTopping("Lettuce", "Vegetable", new HashMap<>());
    private static final SandwichTopping TOMATO = new SandwichTopping("Tomato", "Vegetable", new HashMap<>());
    private static final SandwichTopping ONION = new SandwichTopping("Onion", "Vegetable", new HashMap<>());
    private static final SandwichTopping CHEESE = new SandwichTopping("Cheese", "Dairy", new HashMap<>());
    private static final SandwichTopping BACON = new SandwichTopping("Bacon", "Meat", new HashMap<>());

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
        System.out.println("Select the type of bread for your sandwich:");
        System.out.println("1. WHITE");
        System.out.println("2. WHEAT");
        System.out.println("3. RYE");
        System.out.println("4. WRAP");
        int breadChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (breadChoice) {
            case 1: return BreadType.WHITE;
            case 2: return BreadType.WHEAT;
            case 3: return BreadType.RYE;
            case 4: return BreadType.WRAP;
            default: throw new IllegalArgumentException("Invalid choice");
        }
    }

    //Prompts the user to select the sandwich size. Placeholder!
    private SandwichSize selectSandwichSize() {
        System.out.println("Select the size of your sandwich:");
        System.out.println("1. FOUR_INCH");
        System.out.println("2. SIX_INCH");
        System.out.println("3. TWELVE_INCH");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (sizeChoice) {
            case 1: return SandwichSize.FOUR_INCH;
            case 2: return SandwichSize.EIGHT_INCH;
            case 3: return SandwichSize.TWELVE_INCH;
            default: throw new IllegalArgumentException("Invalid choice");
        }
    }

     // Prompts the user to select toppings. Placeholder!
    private List<SandwichTopping> selectToppings() {
        List<SandwichTopping> toppings;
        while (true) {
            toppings = new ArrayList<>();
            System.out.println("Select a topping to add:");
            System.out.println("1. LETTUCE");
            System.out.println("2. TOMATO");
            System.out.println("3. ONION");
            System.out.println("4. CHEESE");
            System.out.println("5. BACON");
            int toppingChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            SandwichTopping selectedTopping;
            switch (toppingChoice) {
                case 1:
                    selectedTopping = LETTUCE;
                    break;
                case 2:
                    selectedTopping = TOMATO;
                    break;
                case 3:
                    selectedTopping = ONION;
                    break;
                case 4:
                    selectedTopping = CHEESE;
                    break;
                case 5:
                    selectedTopping = BACON;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid choice");
            }

            toppings.add(selectedTopping);

            System.out.println("Would you like to add another topping? (yes/no)");
            String another = scanner.nextLine();
            if (!another.equalsIgnoreCase("yes")) {
                break;
            }
        }
        return toppings;
    }


    // Prompts the user if they want the sandwich toasted. Placeholder!
    private boolean isToasted() {
        System.out.println("Would you like your sandwich toasted? (yes/no)");
        String toastedChoice = scanner.nextLine();
        return toastedChoice.equalsIgnoreCase("yes");
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
