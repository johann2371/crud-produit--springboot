package com.cwa.crud_springboot;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * representation de ma classe
 */
@Entity
@Table(name="produits")
@Getter
@Setter


public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String nom;
    private String description;
    private String prix;

}
