package venus.ventes.iwa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import venus.ventes.iwa1.model.Produit;

import java.util.UUID;

public interface ProduitRepository extends JpaRepository<Produit, UUID> {

}
