package org.example.strategy;
import org.example.model.Product;

public interface DiscountStrategy {
    double applyDiscount(Product product);
}