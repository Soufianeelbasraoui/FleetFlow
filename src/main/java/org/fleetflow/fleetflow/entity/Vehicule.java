package org.fleetflow.fleetflow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricule;
    private String typeVehicule;
    private int capacite;
    private String statutVehicule;
    private String permisType;
    private Boolean disponible;

    @OneToMany(mappedBy = "vehicule")
    private List<Livraison> livraisons;
}