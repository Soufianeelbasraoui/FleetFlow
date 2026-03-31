package org.fleetflow.fleetflow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicule {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricule;
    private String TypeVehicule;
    private int capacite;
    private String StatutVehicule;
    private String permisType;
    private Boolean disponible;

    @OneToMany(mappedBy = "vehicule")
    private List<Livraison> livraisons;


}
