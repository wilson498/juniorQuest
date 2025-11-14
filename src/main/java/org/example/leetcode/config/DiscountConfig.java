package org.example.leetcode.config;

import org.example.leetcode.entity.Cart;

public interface DiscountConfig {
    boolean condition(Cart cart);
    int executeDiscount(Cart cart);
}
