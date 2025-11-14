package org.example.leetcode.config;

import org.example.leetcode.entity.Cart;

public record ProductAmountDiscountConfig(int target, double person) implements DiscountConfig {

    @Override
    public boolean condition(Cart cart) {
        return cart.getProductAmount() >= target;
    }

    @Override
    public int executeDiscount(Cart cart) {
        return (int) ((cart.getProductAmount() * person) + cart.getTransportation());
    }

}
