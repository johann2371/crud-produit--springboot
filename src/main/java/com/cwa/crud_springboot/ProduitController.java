package com.cwa.crud_springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Produit")
public class ProduitController {

    /**
     * Repository permettant d'accéder aux opérations CRUD sur l'entité Produit.
     */
    final ProduitRepository produitRepository;

    /**
     * Constructeur avec injection du repository Produit.
     *
     * @param produitRepository repository utilisé pour accéder aux données Produit
     */
    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    /**
     * Récupère la liste complète des produits disponibles.
     *
     * @return ResponseEntity contenant la liste des produits et le statut HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        return new ResponseEntity<>(produitRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Crée un nouveau produit dans la base de données.
     *
     * @param produit objet Produit envoyé dans le corps de la requête
     * @return ResponseEntity contenant le produit créé et le statut HTTP 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<Produit> createEtudiant(@RequestBody Produit produit) {
        Produit produitCreated = produitRepository.save(produit);
        return new ResponseEntity<>(produitCreated, HttpStatus.CREATED);
    }

    /**
     * Recherche un produit en fonction de son ID.
     *
     * @param id identifiant du produit recherché
     * @return ResponseEntity contenant le produit trouvé ou un statut HTTP 404 (NOT FOUND)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getEtudiantById(@PathVariable Long id) {
        Optional<Produit> produit = produitRepository.findById(id);

        if (produit.isPresent()) {
            return new ResponseEntity<>(produit.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Met à jour un produit existant en fonction de son ID.
     *
     * @param id      identifiant du produit à modifier
     * @param produit nouvelles valeurs du produit envoyées dans le corps de la requête
     * @return ResponseEntity contenant le produit mis à jour ou un statut HTTP 404 si non trouvé
     */
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateEtudiantById(@PathVariable Long id, @RequestBody Produit produit) {
        Optional<Produit> produitUpdated = produitRepository.findById(id);

        if (produitUpdated.isPresent()) {
            Produit produitUpdated1 = produitUpdated.get();
            produitUpdated1.setNom(produit.getNom());
            produitUpdated1.setDescription(produit.getDescription());
            produitUpdated1.setPrix(produit.getPrix());
            Produit produitUpdatedfinal = produitRepository.save(produitUpdated1);
            return new ResponseEntity<>(produitUpdatedfinal, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un produit de la base en fonction de son ID.
     *
     * @param id identifiant du produit à supprimer
     * @return ResponseEntity avec un statut 200 si supprimé, ou 404 si introuvable
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEtudiantById(@PathVariable Long id) {
        Optional<Produit> produit = produitRepository.findById(id);

        if (produit.isPresent()) {
            produitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
