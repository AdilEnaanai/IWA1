package venus.ventes.iwa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import venus.ventes.iwa1.model.CategorieStats;
import venus.ventes.iwa1.model.Produit;

import java.util.List;
import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID> {

    List<Produit> findByCategorieNom(String nomCat);

    @Query("select P.categorie.nom as nomCat,count(P) as produitCount from Produit P group by P.categorie.nom")
    List<CategorieStats> findCountByCategorie();
}
