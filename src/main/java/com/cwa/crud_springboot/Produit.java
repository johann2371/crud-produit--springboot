package com.cwa.crud_springboot;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Représente un produit dans l'application CRUD.
 * Cette entité est mappée à la table "produits" dans la base de données.
 * Elle contient les informations principales d'un produit telles que
 * l'identifiant, le nom, la description et le prix.
 */
@Entity
@Table(name = "produits")
@Getter
@Setter
public class Produit {

    /**
     * Identifiant unique du produit.
     * Généré automatiquement par la base de données.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nom du produit.
     */
    private String nom;

    /**
     * Description détaillée du produit.
     */
    private String description;

    /**
     * Prix du produit.
     * Stocké sous forme de chaîne de caractères (à convertir si nécessaire en BigDecimal pour calculs précis).
     */
    private String prix;
}
