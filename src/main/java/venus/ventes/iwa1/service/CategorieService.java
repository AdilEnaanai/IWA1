package venus.ventes.iwa1.service;

import org.springframework.stereotype.Service;
import venus.ventes.iwa1.model.Categorie;
import venus.ventes.iwa1.model.Produit;
import venus.ventes.iwa1.repository.CategorieRepository;
import venus.ventes.iwa1.repository.ProduitRepository;

import java.util.List;

@Service
public class CategorieService {
    final CategorieRepository categorieRepository;
    private final ProduitService produitService;
    private final ProduitRepository produitRepository;

    public CategorieService(CategorieRepository categorieRepository, ProduitService produitService, ProduitRepository produitRepository) {
        this.categorieRepository = categorieRepository;
        this.produitService = produitService;
        this.produitRepository = produitRepository;
    }
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public void deleteCategorie(Integer id) {
         categorieRepository.deleteById(id);
    }

    public Categorie getCategorieByNom(String nomCat) {
        return categorieRepository.findByNom(nomCat);
    }

    public List<Produit> getAllProduitsFromCategorie(String nomCat) {
        return produitRepository.findByCategorieNom(nomCat);
    }
}
