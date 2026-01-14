package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StockInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private String warehouseLocation;
    private Integer reorderThreshold;
}