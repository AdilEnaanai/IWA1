package venus.ventes.iwa1.controller;

import org.springframework.web.bind.annotation.*;
import venus.ventes.iwa1.model.Categorie;
import venus.ventes.iwa1.model.Produit;
import venus.ventes.iwa1.service.CategorieService;
import venus.ventes.iwa1.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("ventes")
public class CategorieController {
    final CategorieService categorieService;
    private final ProduitService produitService;

    public CategorieController(CategorieService categorieService, ProduitService produitService) {
        this.categorieService = categorieService;
        this.produitService = produitService;
    }

    @GetMapping("categories")
    public List<Categorie> categorie(){
        return categorieService.getAllCategorie();
    }

    @PostMapping("categories")
    public Categorie categorie(@RequestBody Categorie categorie) {
        return categorieService.addCategorie(categorie);
    }

    @DeleteMapping("categories/{id}")
    public void deleteCategorie(Integer id) {
        categorieService.deleteCategorie(id);
    }

    @PostMapping("categories/{nomCat}/produits")
    public Produit addProduitToCategorie(@PathVariable String nomCat,@RequestBody Produit produit){
        Categorie categorie= categorieService.getCategorieByNom(nomCat);
        produit.setCategorie(categorie);
        return produitService.addProduit(produit);
    }

    @GetMapping("categories/{nomCat}/produits")
    public List<Produit> produitsCategorie(@PathVariable String nomCat){
        return categorieService.getAllProduitsFromCategorie(nomCat);
    }
}
