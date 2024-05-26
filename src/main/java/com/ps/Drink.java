package com.ps;

public class Drink extends Product {
    private Sizes size;
    private DrinkFlavor flavor;

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    public void setFlavor(DrinkFlavor flavor) {
        this.flavor = flavor;
    }
}
