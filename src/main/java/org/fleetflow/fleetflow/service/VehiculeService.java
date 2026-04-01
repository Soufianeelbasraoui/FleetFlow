package org.fleetflow.fleetflow.service;

import lombok.RequiredArgsConstructor;
import org.fleetflow.fleetflow.entity.Vehicule;
import org.fleetflow.fleetflow.repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public Vehicule addVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    public Vehicule updateVehicule(Long id, Vehicule updatedVehicule) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule not found"));

        vehicule.setMatricule(updatedVehicule.getMatricule());
        vehicule.setTypeVehicule(updatedVehicule.getTypeVehicule());
        vehicule.setCapacite(updatedVehicule.getCapacite());
        vehicule.setStatutVehicule(updatedVehicule.getStatutVehicule());
        vehicule.setPermisType(updatedVehicule.getPermisType());
        vehicule.setDisponible(updatedVehicule.getDisponible());

        return vehiculeRepository.save(vehicule);
    }

    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }

    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    public List<Vehicule> getVehiculesByStatut(String statut) {
        return vehiculeRepository.findByStatutVehicule(statut);
    }

    public List<Vehicule> getVehiculesByCapacite(int capacite) {
        return vehiculeRepository.findByCapaciteGreaterThan(capacite);
    }
    public List<Vehicule> getVehiculesDisponibles() {
        return vehiculeRepository.findByDisponibleTrue();
    }
}