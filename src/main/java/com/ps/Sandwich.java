package com.ps;

import java.util.List;

public class Sandwich extends Product {
    private BreadType breadType;
    private SandwichSize size;
    private List<SandwichTopping> toppings;
    private boolean toasted;

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public List<SandwichTopping> getToppings() {
        return toppings;
    }

    public void setToppings(List<SandwichTopping> toppings) {
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        // R1: Append the bread type
        stringBuilder.append(breadType.toString()).append(" ");

        // R2: Append toasted status
        if (toasted) {
            stringBuilder.append("toasted ");
        }

        // R3: Append sandwich size
        stringBuilder.append("sandwich ").append(size.toString()).append(": ");

        // R4: Calculate the total price
        double basePrice = getPrice();
        double toppingTotal = 0.0;
        for (SandwichTopping topping : toppings) {
            Double price = topping.getPrices().get(size);
            if (price != null) {
                toppingTotal += price;
            }
        }
        double totalPrice = basePrice + toppingTotal;
        stringBuilder.append(totalPrice).append("\n");

        // R5: Append the base sandwich price
        stringBuilder.append("Base sandwich: ").append(basePrice).append("\n");

        // R6: Append each topping and its price
        for (SandwichTopping topping : toppings) {
            Double toppingPrice = topping.getPrices().get(size);
            if (toppingPrice == null) {
                toppingPrice = 0.0;
            }
            stringBuilder.append(" ").append(topping.getName()).append(": ").append(toppingPrice).append("\n");
        }
        return stringBuilder.toString();
    }
}