package org.fleetflow.fleetflow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    @NotBlank(message = "Le nom est obligatoire")
    private Long total;
    private Long Id;
    private String nom;
    @Email(message = "Email invalide")
    private String email;

    private String telephone;

    @NotBlank(message = "Ville est obligatoire")
    private String ville;
}