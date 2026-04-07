package org.fleetflow.fleetflow.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculeDTO {

    @NotBlank(message = "La matricule est obligatoire")
    private String matricule;

    @NotBlank(message = "Le type de véhicule est obligatoire")
    private String typeVehicule;

    @Min(value = 1, message = "La capacité doit être supérieure à 0")
    @Max(value = 10000, message = "La capacité ne peut pas dépasser 10000")
    private int capacite;

    @NotBlank(message = "Le statut est obligatoire")
    private String statutVehicule;

    @NotBlank(message = "La permission est obligatoire")
    private String permisType;

    @NotNull(message = "La disponibilité est obligatoire")
    private Boolean disponible;
}