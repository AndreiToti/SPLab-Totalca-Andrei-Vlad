package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer durationMonths;
    private String repairPolicy;
}