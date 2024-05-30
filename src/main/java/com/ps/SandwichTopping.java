package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SandwichTopping {
    private String name;
    private Toppings topping;
    private Map<SandwichSize, Double> prices;

    // Constructor
    public SandwichTopping(Toppings topping, Map<SandwichSize, Double> prices) {
        this.name = topping.name();
        this.topping = topping;
        this.prices = prices;

    }

    public Toppings getTopping() {
        return topping;
    }

    public String getName() {
        return name;
    }

    public Map<SandwichSize, Double> getPrices() {
        return prices;
    }

    public String toString(SandwichSize sandwichSize) {
        return getName() + " topping: " + getPrices().get(sandwichSize);
    }
}