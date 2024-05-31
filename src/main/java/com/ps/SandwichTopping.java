package com.ps;

import java.util.Map;

public class SandwichTopping {
    private Toppings name;
    private Map<SandwichSize, Double> prices;

    public SandwichTopping(Toppings name, Map<SandwichSize, Double> prices) {
        this.name = name;
        this.prices = prices;
    }

    public Toppings getName() {
        return name;
    }

    public Map<SandwichSize, Double> getPrices() {
        return prices;
    }

    public String toString(SandwichSize sandwichSize) {
        return getName() + " topping: " + getPrices().get(sandwichSize);
    }
}