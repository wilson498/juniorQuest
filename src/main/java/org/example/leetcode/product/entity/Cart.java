package org.example.leetcode.product.entity;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private int transportation;
    private List<Product> items;


    public int getProductAmount() {
        int total = 0;
        for (Product product : items) {
            total += product.getPrice() * product.getQty();
        }
        return total;
    }


    public int getQtyAmount() {
        int qty = 0;
        for (Product p : items) {
            qty += p.getQty();
        }
        return qty;
    }

}
