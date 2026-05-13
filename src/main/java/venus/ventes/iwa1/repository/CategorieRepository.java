package venus.ventes.iwa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import venus.ventes.iwa1.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Categorie findByNom(String nomCat);
}
