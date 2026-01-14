package org.example.strategy;

import org.example.model.Product;
import org.example.strategy.DiscountStrategy;
import org.springframework.stereotype.Component;

@Component
public class VipDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(Product product) {
        return product.getPrice() * 0.80;
    }
}