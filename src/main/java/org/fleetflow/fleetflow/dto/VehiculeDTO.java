package org.fleetflow.fleetflow.dto;

import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculeDTO {
    private Long id;
    private String matricule;
    private String typeVehicule;
    private int capacite;
    private String statutVehicule;
    private String permisType;
    private Boolean disponible;
}