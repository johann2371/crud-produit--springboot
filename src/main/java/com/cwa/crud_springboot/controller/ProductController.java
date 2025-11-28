package com.cwa.crud_springboot.controller;

import com.cwa.crud_springboot.entity.Product;
import com.cwa.crud_springboot.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping

    @Operation(
            summary="Lister toute les taches",
            description="obtenir la liste de tout les produits"
    )
    @ApiResponses({
            @ApiResponse(responseCode="200", description="Liste récupérer avec sucess"),
            @ApiResponse(responseCode = "400",description = "aucune liste dans la bd")
    })

    public List<Product> getAll() {
        return service.findAll();
    }



    @GetMapping("/{id}")

    @Operation(summary="obtenir une produit par son id")

    @ApiResponses({
            @ApiResponse(responseCode="200", description="produit ajouter"),
            @ApiResponse(responseCode="400", description="produit non trouvé")
    })


    public Product getOne(@Parameter(description="id du produit") @PathVariable Long id) {

        return service.findById(id);
    }

    @Operation(summary=" ajouter un produit")
    @ApiResponses({
        @ApiResponse(responseCode="200",description="produit ajouter avec success"),
        @ApiResponse(responseCode="400",description="echec de l'ajout")
            })

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }


    @Operation(summary = "modifier une produit en fonction de son id")
    @ApiResponses({

            @ApiResponse(responseCode = "200",description = "produit trouvé et modifer avec success"),
            @ApiResponse(responseCode = "400",description = "produit non trouvé")

    })
    @PutMapping("/{id}")
    public Product update( @Parameter(description = "id du produit que l'on recherche") @PathVariable Long id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @Operation(summary="suppression d'un produit")
    @ApiResponses({
            @ApiResponse(responseCode="200", description = "produit supprimer"),
            @ApiResponse(responseCode= "400" ,description = "echec suppression")
    })

    @DeleteMapping("/{id}")
    public void delete(@Parameter(description="id du produit qu'on veut supprimer")  @PathVariable Long id) {
        service.delete(id);
    }
}
