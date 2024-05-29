package com.ps;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        System.out.println("2. EIGHT_INCH");
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

   // Prompts the user to add a drink to the order.
    private void  addDrink() {
        // Call the method to create a drink
        Drink drink = createDrink();
        // Add the drink to the beginning of the order list
        order.add(0, drink);
        System.out.println("Drink added to the order.");
    }

    /**The createDrink method will guide the user through selecting the option like:
     * "drink size" and "flavor". It also sets the price based on the size. */
    private Drink createDrink() {
        Drink drink = new Drink();

        // Select drink size
        Sizes size = selectDrinkSize();
        drink.setSize(size);

        // Select drink flavor
        DrinkFlavor flavor = selectDrinkFlavor();
        drink.setFlavor(flavor);

        // Set the price based on the size
        double price = getDrinkPrice(size);
        drink.setPrice(price);

        return drink;

    }

    // Prompts the user to select the drink size.
    private Sizes selectDrinkSize() {
        System.out.println("Select the size of your drink:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (sizeChoice) {
            case 1: return Sizes.SMALL;
            case 2: return Sizes.MEDIUM;
            case 3: return Sizes.LARGE;
            default: throw new IllegalArgumentException("Invalid choice");
        }
    }

    // Prompts the user to select the drink flavor.
    private DrinkFlavor selectDrinkFlavor() {
        System.out.println("Select the flavor of your drink:");
        System.out.println("1. Pineapple");
        System.out.println("2. Orange");
        System.out.println("3. Mixed fruit");
        int flavorChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (flavorChoice) {
            case 1: return DrinkFlavor.PINEAPPLE;
            case 2: return DrinkFlavor.ORANGE;
            case 3: return DrinkFlavor.MIXED_FRUIT;
            default: throw new IllegalArgumentException("Invalid choice");
        }
    }

    // Returns the price of the drink based on the size.
    private double getDrinkPrice(Sizes size) {
        switch (size) {
            case SMALL: return 2.00;
            case MEDIUM: return 2.50;
            case LARGE: return 3.00;
            default: throw new IllegalArgumentException("Invalid size");
        }
    }

    // Prompts the user to add chips to the order.
    private void addChips() {
        // Call the method to create chips
        Chips chips = createChips();
        // Add the chips to the beginning of the order list
        order.add(0, chips);
        System.out.println("Chips added to the order.");
    }

    /** The createChips method will guide the user through selecting the option like:
     * "chips size". It also sets the price based on the size. */
    private Chips createChips() {
        Chips chips = new Chips();

        // Select chips size
        Sizes size = selectChipsSize();
        chips.setSize(size);

        // Set the price based on the size
        double price = getChipsPrice(size);
        chips.setPrice(price);

        return chips;
    }

    // Prompts the user to select the chips size.
    private Sizes selectChipsSize() {
        System.out.println("Select the size of your chips:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (sizeChoice) {
            case 1: return Sizes.SMALL;
            case 2: return Sizes.MEDIUM;
            case 3: return Sizes.LARGE;
            default: throw new IllegalArgumentException("Invalid choice");
        }
    }

    // Returns the price of the chips based on the size.
    private double getChipsPrice(Sizes size) {
        switch (size) {
            case SMALL: return 1.00;
            case MEDIUM: return 1.50;
            case LARGE: return 2.00;
            default: throw new IllegalArgumentException("Invalid size");
        }
    }

    // Prompts the user checkout the order.
    private void  checkout() {
        // 1. Gather Order Details
        StringBuilder orderDetails = new StringBuilder();
        double totalPrice = 0.0;

        orderDetails.append("Receipt:\n")
                .append("------------------------------------------------\n");

        for (Product item : order) {
            orderDetails.append(item.toString()).append("\n");
            totalPrice += item.getPrice();
        }

        orderDetails.append("------------------------------------------------\n")
                .append("Total Price: $").append(totalPrice).append("\n");

        // 2. Display Order Details
        System.out.println(orderDetails.toString());

        // 3. Ask for Confirmation
        System.out.println("Do you want to confirm the order? (yes/no)");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            // 4. Generate Receipt
            String receipt = orderDetails.toString();

            // 5. Save Receipt
            String dateTime = getCurrentDateTime();
            String fileName = "receipts/" + dateTime + ".txt";
            saveToFile(fileName, receipt);

            // 6. Print Confirmation
            System.out.println("Order completed! Your receipt has been saved as " + fileName + ".");

            // 7. Clear the order list to start fresh
            order.clear();
        } else {
            // Call the cancelOrder method
            cancelOrder();
        }

        // Return to the home screen
        HomeScreen.main(new String[0]);
    }

    // Returns the current date and time as a string in the format yyyyMMdd-HHmmss.
    private String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    //  Saves the given content to a file with the specified file name.
    private void saveToFile(String fileName, String content) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        } catch (IOException e) {
            System.err.println("Error: Unable to save receipt to file " + fileName);
        }
    }

    // Cancels the order and returns to the home screen.
    private void cancelOrder() {
        System.out.println("Order cancelled. Returning to the home screen.");

        // Clear the order list to discard the current order
        order.clear();
    }


}
