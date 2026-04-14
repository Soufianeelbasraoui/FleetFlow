package org.fleetflow.fleetflow.repository;

import org.fleetflow.fleetflow.entity.Client;
import org.fleetflow.fleetflow.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

    List<Livraison> findByStatut(String statut);

    List<Livraison> findByClientId(Long clientId);

    @Query("SELECT l FROM Livraison l WHERE l.dateLivraison BETWEEN :debut AND :fin")
    List<Livraison> findByDateLivraisonBetween(@Param("debut") LocalDate debut,
                                               @Param("fin")   LocalDate fin);

    @Query("SELECT l FROM Livraison l WHERE l.adresseDestination LIKE %:ville%")
    List<Livraison> findByVilleDestination(@Param("ville") String ville);

    Long countLivraisonByClient(Long Id);
}