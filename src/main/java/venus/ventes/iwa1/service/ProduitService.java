package venus.ventes.iwa1.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import venus.ventes.iwa1.model.CategorieStats;
import venus.ventes.iwa1.model.Produit;
import venus.ventes.iwa1.repository.ProduitRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProduitService {
    final ProduitRepository produitRepository;
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public List<Produit> getAllProduits(int page,int size) {
        Pageable pageable = PageRequest.of(page,size);
        return produitRepository.findAll(pageable).getContent();
    }

    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public boolean deleteProduit(UUID id) {
        produitRepository.deleteById(id);
        return !produitRepository.existsById(id);
    }

    public List<CategorieStats> getNombreByCategorie() {
        return produitRepository.findCountByCategorie();
    }
}
