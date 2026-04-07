package org.fleetflow.fleetflow.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculeDTO {

    private String matricule;
    private String typeVehicule;
    private int capacite;
    private String statutVehicule;
    private String permisType;
    private Boolean disponible;
}