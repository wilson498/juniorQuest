package org.example.leetcode.service;

import org.example.leetcode.config.DiscountConfig;
import org.example.leetcode.config.ProductAmountDiscountConfig;
import org.example.leetcode.config.QtyAmountDiscountConfig;
import org.example.leetcode.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final List<DiscountConfig> configs = List.of(
            new ProductAmountDiscountConfig(5000, 0.8),
            new ProductAmountDiscountConfig(4000, 0.9),
            new QtyAmountDiscountConfig(3)
    );

    public int getTotal(Cart cart) {
        for (DiscountConfig config : configs) {
            if (config.condition(cart)) {
                return config.executeDiscount(cart);
            }
        }
        return cart.getProductAmount() + cart.getTransportation();
    }

}
