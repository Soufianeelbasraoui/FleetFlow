package org.fleetflow.fleetflow.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.fleetflow.fleetflow.dto.VehiculeDTO;
import org.fleetflow.fleetflow.entity.Vehicule;
import org.fleetflow.fleetflow.mapper.VehiculeMapper;
import org.fleetflow.fleetflow.repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

    public VehiculeDTO ajouterVehicule(VehiculeDTO dto) {
        Vehicule vehicule = vehiculeMapper.toEntity(dto);
        return vehiculeMapper.toDTO(vehiculeRepository.save(vehicule));
    }

    public VehiculeDTO modifierVehicule(Long id, VehiculeDTO dto) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Véhicule introuvable avec l'id : " + id)
                );
        vehiculeMapper.updateEntityFromDTO(dto, vehicule);
        return vehiculeMapper.toDTO(vehiculeRepository.save(vehicule));
    }


    public void supprimerVehicule(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new EntityNotFoundException("Véhicule introuvable avec l'id : " + id);
        }
        vehiculeRepository.deleteById(id);
    }

    public List<VehiculeDTO>listerVehicules(){
        return vehiculeMapper.toDtoList(vehiculeRepository.findAll());
    }

public List<VehiculeDTO> listerParStatut(String statut){
        return vehiculeMapper.toDtoList(vehiculeRepository.findByStatutVehicule(statut));
}

public List<VehiculeDTO> listerParCapaciteSuperieure(int capacite){
        return vehiculeMapper.toDtoList(vehiculeRepository.findByCapaciteGreaterThan(capacite));
}
}