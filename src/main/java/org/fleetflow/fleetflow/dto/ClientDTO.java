package org.fleetflow.fleetflow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "le ville est obligatoire")
    private String telephone;
    @NotBlank(message = "Le nom est obligatoire")
    private String ville;
}