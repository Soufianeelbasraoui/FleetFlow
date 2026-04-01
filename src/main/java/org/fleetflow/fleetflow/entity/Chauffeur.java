package org.fleetflow.fleetflow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chauffeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String telephone;
    private String licenseType;
    private Boolean available;

    @OneToMany(mappedBy = "chauffeur")
    private List<Livraison> liveries;
}
