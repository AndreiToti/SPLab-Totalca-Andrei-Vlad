package org.example.service;

import org.example.model.Product;
import org.example.observer.StockObserver;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductOperations {


    private final ProductRepository repository;
    private final StockObserver stockObserver;


    @Autowired
    public ProductService(ProductRepository repository, StockObserver stockObserver) {
        this.repository = repository;
        this.stockObserver = stockObserver;
    }

    @Override
    public Product saveProduct(Product product) {
        Product savedProduct = repository.save(product);
        stockObserver.update(savedProduct);
        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Product updateStock(Long productId, Integer newQuantity) {
        Product product = repository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produsul cu ID " + productId + " nu există"));


        if (newQuantity < 0) {
            System.err.println("EROARE: Stoc insuficient pentru " + product.getName());
            return product;
        }

        if (product.getStockInfo() != null) {
            product.getStockInfo().setQuantity(newQuantity);
        }

        Product savedProduct = repository.save(product);
        stockObserver.update(savedProduct);
        return savedProduct;
    }
}