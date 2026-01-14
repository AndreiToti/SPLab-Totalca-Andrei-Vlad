package org.example.service;

import org.example.controller.WebController;
import org.example.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductSecurityProxy implements ProductOperations {

    private final ProductService realService;

    public ProductSecurityProxy(ProductService realService) {
        this.realService = realService;
    }

    @Override
    public Product saveProduct(Product product) {
        if ("ADMIN".equals(WebController.currentRole)) {
            return realService.saveProduct(product);
        }
        System.err.println("PROXY: Doar ADMIN-ul poate adauga produse!");
        return product;
    }

    @Override
    public List<Product> getAllProducts() {

        return realService.getAllProducts();
    }

    @Override
    public void deleteProduct(Long id) {
        if ("ADMIN".equals(WebController.currentRole)) {
            realService.deleteProduct(id);
        } else {
            System.err.println("PROXY: Acces interzis pentru stergere!");
        }
    }

    @Override
    public Product updateStock(Long productId, Integer newQuantity) {
        return realService.updateStock(productId, newQuantity);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        System.out.println("Proxy: Logare acces pentru produsul cu ID: " + id);
        return realService.getProductById(id);
    }


}