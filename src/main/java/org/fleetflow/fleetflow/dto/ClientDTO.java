package org.fleetflow.fleetflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private String nom;
    private String email;
    private String telephone;
    private String ville;
}