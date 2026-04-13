package org.fleetflow.fleetflow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livraison")
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateLivraison;
    private String adresseDepart;
    private String adresseDestination;
    private String statut;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "chauffeur_id")
    private Chauffeur chauffeur;
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

}
