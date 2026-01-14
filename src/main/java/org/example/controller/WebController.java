package org.example.controller;

import org.example.model.Product;
import org.example.model.StockInfo;
import org.example.service.ProductOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/web")
public class WebController {

    private final ProductOperations productOperations;


    public static String currentRole = "USER";

    public WebController(ProductOperations productOperations) {
        this.productOperations = productOperations;
    }


    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("products", productOperations.getAllProducts());
        model.addAttribute("role", currentRole);
        return "index";
    }


    @GetMapping("/switch-role")
    public String switchRole(@RequestParam String role) {
        currentRole = role;
        return "redirect:/web";
    }


    @PostMapping("/add")
    public String addProduct(@RequestParam String name,
                             @RequestParam Double price,
                             @RequestParam Integer quantity) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCreator("Web Interface");

        StockInfo stock = new StockInfo();
        stock.setQuantity(quantity);
        stock.setReorderThreshold(5);
        product.setStockInfo(stock);

        productOperations.saveProduct(product);

        return "redirect:/web";
    }


    @PostMapping("/sell/{id}")
    public String sellProduct(@PathVariable Long id, @RequestParam Integer quantitySold) {
        productOperations.getProductById(id).ifPresent(p -> {

            if (p.getStockInfo() != null) {
                int currentStock = p.getStockInfo().getQuantity();
                int newQty = currentStock - quantitySold;
                productOperations.updateStock(id, newQty);
            } else {
                System.err.println("Eroare: Produsul #" + id + " nu are informații de stoc!");
            }
        });
        return "redirect:/web";
    }


    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        try {

            productOperations.deleteProduct(id);
        } catch (Exception e) {
            System.err.println("Eroare la ștergere: " + e.getMessage());
        }
        return "redirect:/web";
    }
}