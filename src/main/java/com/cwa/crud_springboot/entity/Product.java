package com.cwa.crud_springboot.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product") 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identifiant unique", example = "1")
    private Long id;

    @Schema(description = "Nom du produit", example = "Bonbon")
    private String name;

    @Schema(description = "Prix du produit", example = "1000f")
    private double price;

    @Schema(description = "Quantité en stock", example = "10")
    private int quantity;
}
