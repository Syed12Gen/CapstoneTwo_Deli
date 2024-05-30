package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> items = new ArrayList<>();
    private double total = 0.0;

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

    public void clearOrder() {
        items.clear();
        total = 0.0;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        for (Product item : items) {
            orderDetails.append(item.toString()).append("\n");
        }
        orderDetails.append("Total Price: $").append(total);
        return orderDetails.toString();
    }
}
