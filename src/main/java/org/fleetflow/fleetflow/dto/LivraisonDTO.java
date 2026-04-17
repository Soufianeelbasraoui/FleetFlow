package org.fleetflow.fleetflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonDTO {
    @NotNull(message = "date livraison obligatoire")
    private LocalDate dateLivraison;

    @NotBlank(message = "adresse Depart obligatoire")
    private String adresseDepart;

    @NotBlank(message = "adresse destination est obligatoire")
    private String adresseDestination;

    @NotBlank(message = "statut obligatoire")
    private String statut;
    @NotNull(message = "id client est obligatoire")
    private Long clientId;
    @NotNull(message = "chauffeur id obligatoire")
    private Long chauffeurId;
    @NotNull(message = "vehicule id est obigatoire")
    private Long vehiculeId;
}