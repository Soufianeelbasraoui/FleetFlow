// LivraisonService.java
package org.fleetflow.fleetflow.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.fleetflow.fleetflow.dto.LivraisonDTO;
import org.fleetflow.fleetflow.entity.Chauffeur;
import org.fleetflow.fleetflow.entity.Livraison;
import org.fleetflow.fleetflow.entity.Vehicule;
import org.fleetflow.fleetflow.mapper.LivraisonMapper;
import org.fleetflow.fleetflow.repository.ChauffeurRepository;
import org.fleetflow.fleetflow.repository.LivraisonRepository;
import org.fleetflow.fleetflow.repository.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivraisonService {

    private final LivraisonRepository livraisonRepository;
    private final LivraisonMapper livraisonMapper;
    private final ChauffeurRepository chauffeurRepository;
    private final VehiculeRepository vehiculeRepository;

    public LivraisonDTO creerLivraison(LivraisonDTO dto) {
        Livraison livraison = livraisonMapper.toEntity(dto);
        return livraisonMapper.toDTO(livraisonRepository.save(livraison));
    }

    // Assign driver and vehicle to an existing delivery
    public LivraisonDTO assignerChauffeurEtVehicule(Long id, Long chauffeurId, Long vehiculeId) {
        Livraison livraison = livraisonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livraison introuvable avec l'id : " + id));

        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId)
                .orElseThrow(() -> new EntityNotFoundException("Chauffeur introuvable avec l'id : " + chauffeurId));

        Vehicule vehicule = vehiculeRepository.findById(vehiculeId)
                .orElseThrow(() -> new EntityNotFoundException("VÃ©hicule introuvable avec l'id : " + vehiculeId));

        livraison.setChauffeur(chauffeur);
        livraison.setVehicule(vehicule);

        return livraisonMapper.toDTO(livraisonRepository.save(livraison));
    }

    // Change delivery status
    public LivraisonDTO changerStatut(Long id, String statut) {
        Livraison livraison = livraisonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livraison introuvable avec l'id : " + id));
        livraison.setStatut(statut);
        return livraisonMapper.toDTO(livraisonRepository.save(livraison));
    }

    public List<LivraisonDTO> listerLivraisons() {
        return livraisonRepository.findAll()
                .stream()
                .map(livraisonMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<LivraisonDTO> listerParStatut(String statut) {
        return livraisonRepository.findByStatut(statut)
                .stream()
                .map(livraisonMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<LivraisonDTO> listerParClient(Long clientId) {
        return livraisonRepository.findByClientId(clientId)
                .stream()
                .map(livraisonMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<LivraisonDTO> listerEntreDeuxDates(LocalDate debut, LocalDate fin) {
        return livraisonRepository.findByDateLivraisonBetween(debut, fin)
                .stream()
                .map(livraisonMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<LivraisonDTO> listerParVilleDestination(String ville) {
        return livraisonRepository.findByVilleDestination(ville)
                .stream()
                .map(livraisonMapper::toDTO)
                .collect(Collectors.toList());
    }
}