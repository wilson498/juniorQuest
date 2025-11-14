package org.example.leetcode.config;

import org.example.leetcode.entity.Cart;

public record QtyAmountDiscountConfig(int target) implements DiscountConfig {

    @Override
    public boolean condition(Cart cart) {
        return cart.getQtyAmount() >= target;
    }

    @Override
    public int executeDiscount(Cart cart) {
        return cart.getProductAmount();
    }
}
