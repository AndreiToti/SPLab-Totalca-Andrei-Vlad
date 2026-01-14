package org.example.controller;

import org.example.model.Product;
import org.example.service.ProductOperations;
import org.example.strategy.NoDiscount;
import org.example.strategy.VipDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Injectăm interfața, nu clasa concretă. Spring va alege Proxy-ul.
    private final ProductOperations productOperations;

    @Autowired
    public ProductController(ProductOperations productOperations) {
        this.productOperations = productOperations;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productOperations.saveProduct(product);
    }

    // Exemplu de folosire a Proxy-ului pentru ștergere securizată
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productOperations.deleteProduct(id);
        return "Cerere de ștergere procesată.";
    }

    // Exemplu de folosire a Strategy pentru preț
    @GetMapping("/{id}/calculate-vip")
    public Double getVipPrice(@PathVariable Long id) {
        // Aici ai aduce produsul din DB, am pus un exemplu generic
        Product product = new Product();
        product.setPrice(100.0);

        VipDiscount vipStrategy = new VipDiscount();
        return vipStrategy.applyDiscount(product);
    }

    @GetMapping("/test-strategy")
    public String testStrategy() {
        Product p = new Product();
        p.setPrice(1000.0);

        VipDiscount vip = new VipDiscount();
        NoDiscount none = new NoDiscount();

        return "Pret normal: " + none.applyDiscount(p) +
                " | Pret VIP: " + vip.applyDiscount(p);
    }
    @PutMapping("/{id}/sell")
    public String sellProduct(@PathVariable Long id, @RequestParam Integer quantitySold) {

        Product product = productOperations.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Produsul cu ID-ul " + id + " nu exista!"));


        int currentStock = product.getStockInfo().getQuantity();
        int newStock = currentStock - quantitySold;


        productOperations.updateStock(id, newStock);

        return "Vanzare reusita! Stoc vechi: " + currentStock + " | Stoc nou: " + newStock;
    }

    @GetMapping("/{id}/price-check")
    public String checkPrices(@PathVariable Long id) {
        Product product = productOperations.getProductById(id).get();


        VipDiscount vipStrategy = new VipDiscount();
        NoDiscount normalStrategy = new NoDiscount();

        return "Produs: " + product.getName() +
                " | Pret Intreg: " + normalStrategy.applyDiscount(product) +
                " | Pret cu reducere VIP: " + vipStrategy.applyDiscount(product);
    }
}