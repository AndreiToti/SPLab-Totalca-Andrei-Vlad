package org.example.service;

import org.example.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductOperations {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    void deleteProduct(Long id);


    Product updateStock(Long productId, Integer newQuantity);
}