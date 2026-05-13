package venus.ventes.iwa1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom;
    @OneToMany(mappedBy ="categorie", cascade = CascadeType.ALL )
    List<Produit> produits;
}
//cat.getProduits()
