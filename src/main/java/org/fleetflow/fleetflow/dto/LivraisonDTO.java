package org.fleetflow.fleetflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
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
    @NotBlank(message = "chauffeur id obligatoire")
    private Long chauffeurId;
    @NotBlank(message = "vehicule id est obigatoire")
    private Long vehiculeId;
}