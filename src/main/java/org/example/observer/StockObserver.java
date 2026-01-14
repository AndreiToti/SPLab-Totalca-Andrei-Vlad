package org.example.observer;

import org.example.model.Product;
import org.springframework.stereotype.Component;

@Component
public class StockObserver {

    public void update(Product product) {
        if (product.getStockInfo() != null &&
                product.getStockInfo().getQuantity() <= product.getStockInfo().getReorderThreshold()) {

            System.out.println("!!! ALERTĂ OBSERVER !!!");
            System.out.println("Produsul: " + product.getName() + " a scăzut sub pragul de alertă!");
            System.out.println("Stoc actual: " + product.getStockInfo().getQuantity());
            System.out.println("-------------------------");
        }
    }
}