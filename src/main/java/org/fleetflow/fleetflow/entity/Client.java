package org.fleetflow.fleetflow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nom;
private String email;
private String telephone;
private String ville;

@OneToMany(mappedBy = "client")
private List<Livraison> livraisons;
}
