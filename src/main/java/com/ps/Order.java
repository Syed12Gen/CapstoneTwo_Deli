package com.ps;
import java.util.List;

public class Order {
    private List<Product> items;
    private double total;

    public List<Product> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public void addItem(Product item) {
        items.add(item);
        total += item.getPrice();
    }
}
