package org.example.leetcode.product.config;

import org.example.leetcode.product.entity.Cart;

public interface DiscountConfig {
    boolean condition(Cart cart);
    int executeDiscount(Cart cart);
}
