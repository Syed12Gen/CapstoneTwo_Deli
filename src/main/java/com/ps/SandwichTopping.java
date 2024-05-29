package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SandwichTopping {
    private String name;
    private String type;
    private Map<SandwichSize, Double> prices;

    // Constructor
    public SandwichTopping(String name, String type, Map<SandwichSize, Double> prices) {
        this.name = name;
        this.type = type;
        this.prices = prices;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<SandwichSize, Double> getPrices() {
        return prices;
    }

    public void setPrices(Map<SandwichSize, Double> prices) {
        this.prices = prices;
    }

    public String toString(SandwichSize sandwichSize) {
        return getName() + " topping: " + getPrices().get(sandwichSize);
    }
}
