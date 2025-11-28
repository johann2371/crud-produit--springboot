package com.cwa.crud_springboot.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Schema(description = "identifiant unique" , example="1")
    private Long id;

    @Schema(description="nom de produit" , example="bonbon")
    private String name;

    @Schema(description = "prix du produit", example = "1000f")
    private double price;

   @Schema(description = "quantité en stock")
    private int quantity;
}
