package venus.ventes.iwa1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Produit {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String nom;
    float prix;
    @ManyToOne(cascade = CascadeType.ALL)
    Categorie categorie;
}
