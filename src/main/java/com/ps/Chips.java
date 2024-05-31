package com.ps;

public class Chips extends Product{
    private Sizes size;

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size + " chips: ";
    }
}