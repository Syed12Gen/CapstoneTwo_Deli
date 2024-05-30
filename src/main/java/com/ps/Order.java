package com.ps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> items = new ArrayList<>();

    private double total = 0.0;

    private LocalDateTime orderedAt;

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

public void printReceipt() {
    String receiptName = orderedAt.format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"));
    File receiptFile = new File(receiptName + ".txt");
    try {
        BufferedWriter writer = new BufferedWriter(new PrintWriter(receiptFile));
        writer.write(this.toString());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}
