package org.example.leetcode.service;

import org.example.leetcode.entity.Cart;
import org.example.leetcode.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {


    @Autowired
    private ProductService productService;

    private Product createProduct(String pen, int price, int qty) {
        Product product = new Product();
        product.setName(pen);
        product.setPrice(price);
        product.setQty(qty);
        return product;
    }

    private Cart createCart(List<Product> items, int transportation) {
        Cart cart = new Cart();
        cart.setTransportation(transportation);
        cart.setItems(items);
        return cart;
    }

    @Test
    public void getTransportationTest() {
        Cart cart = createCart(
                List.of(
                        createProduct("pen", 10, 3),
                        createProduct("book", 500, 1)
                ), 80
        );
        int total = productService.getTotal(cart);
        assert (500 + 30) == total;
    }

    @Test
    public void getTotalDiscount5000Test() {
        Cart cart = createCart(
                List.of(
                        createProduct("pen", 10, 3),
                        createProduct("book", 500, 10))
                , 80);
        int total = productService.getTotal(cart);
        Assertions.assertEquals((80 + (5000 + 30) * 0.8), total);
    }

    @Test
    public void getTotalDiscount4000Test() {
        Cart cart = createCart(
                List.of(
                        createProduct("pen", 10, 3),
                        createProduct("book", 500, 8))
                , 80);
        int total = productService.getTotal(cart);
        Assertions.assertEquals((80 + (4000 + 30) * 0.9), total);
    }
    @Test
    public void getTotalTest() {
        Cart cart = createCart(
                List.of(
                        createProduct("pen", 10, 1),
                        createProduct("book", 500, 1))
                , 80);
        int total = productService.getTotal(cart);

        Assertions.assertEquals((80 + 500 + 10), total);

    }


}
