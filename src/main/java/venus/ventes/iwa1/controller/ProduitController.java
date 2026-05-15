package venus.ventes.iwa1.controller;

import org.springframework.web.bind.annotation.*;
import venus.ventes.iwa1.model.CategorieStats;
import venus.ventes.iwa1.model.Produit;
import venus.ventes.iwa1.service.ProduitService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("ventes")
public class ProduitController {
    final ProduitService produitService;
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("produits")
    public List<Produit> getAllProduits(@RequestParam int page, @RequestParam int size) {
        return produitService.getAllProduits(page,size);
    }

    @DeleteMapping("produits/{id}")
    public boolean deleteProduit(@PathVariable UUID id) {
        return produitService.deleteProduit(id);
    }

    @GetMapping("categorie/produit/nombre")
    public List<CategorieStats> getNombreByCategorie() {
       return produitService.getNombreByCategorie();
    }
}

