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
    private String TypeVehicule;
    private int capacite;
    private String StatutVehicule;
    private String permisType;
    private Boolean disponible;
}