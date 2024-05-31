package com.ps;

import java.util.List;

public class Sandwich extends Product {
    protected BreadType breadType;
    protected SandwichSize size;
    protected List<SandwichTopping> toppings;
    protected boolean toasted;

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

    @Override
    public String toString() {
        // Return a concise description of the sandwich
        return breadType.toString() + (toasted ? " toasted" : "") + " sandwich " + size.toString();
    }

    // Method to calculate the total price of the sandwich
    public double calculateTotalPrice() {
        double basePrice = getBasePrice();
        double toppingTotal = 0.0;
        for (SandwichTopping topping : toppings) {
            Double price = topping.getPrices().get(size);
            if (price != null) {
                toppingTotal += price;
            }
        }
        return basePrice + toppingTotal;
    }

    // Method to get the base price based on the size of the sandwich
    double getBasePrice() {
        switch (size) {
            case FOUR_INCH: return 5.50;
            case EIGHT_INCH: return 7.00;
            case TWELVE_INCH: return 8.50;
            default: return 0.0;
        }
    }

}