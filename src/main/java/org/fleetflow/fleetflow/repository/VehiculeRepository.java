package org.fleetflow.fleetflow.repository;


import org.fleetflow.fleetflow.entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
    List<Vehicule> findByStatus(String status);

    List<Vehicule> findByCapacityGreaterThan(Double capacity);

    List<Vehicule> findByStatutVehicule(String statut);
    List<Vehicule> findByCapaciteGreaterThan(int capacite);
    List<Vehicule> findByDisponibleTrue();

}
