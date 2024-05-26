package com.ps;

import java.util.List;

public class Sandwich extends Product{
    private  BreadType breadType;
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
}
