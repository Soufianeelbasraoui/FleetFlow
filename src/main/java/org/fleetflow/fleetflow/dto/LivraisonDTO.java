package org.fleetflow.fleetflow.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LivraisonDTO {
    private Long id;
    private LocalDate dateLivraison;
    private String adresseDepart;
    private String adresseDestination;
    private String statut;

    private Long clientId;
    private Long vehiculeId;
    private Long chauffeurId;

}
