package venus.ventes.iwa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import venus.ventes.iwa1.model.Produit;

import java.util.List;
import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID> {

    List<Produit> findByCategorieNom(String nomCat);
}
