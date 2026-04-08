package org.fleetflow.fleetflow.service;

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


    public LivraisonDTO assignerChauffeurEtVehicule(Long id, Long chauffeurId, Long vehiculeId) {
        Livraison livraison = livraisonRepository.findById(id).orElse(null);
        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId).orElse(null);
        Vehicule vehicule = vehiculeRepository.findById(vehiculeId).orElse(null);
        livraison.setChauffeur(chauffeur);
        livraison.setVehicule(vehicule);
        return livraisonMapper.toDTO(livraisonRepository.save(livraison));
    }

    public LivraisonDTO changerStatut(Long id, String statut) {
        Livraison livraison = livraisonRepository.findById(id).orElse(null);
        livraison.setStatut(statut);
        return livraisonMapper.toDTO(livraisonRepository.save(livraison));
    }

public List<LivraisonDTO> listerLivraisons(){
        return livraisonMapper.toDtoList(livraisonRepository.findAll());
}

public List<LivraisonDTO> listerParStatut(String statut){
        return livraisonMapper.toDtoList(livraisonRepository.findByStatut(statut));
}

    public List<LivraisonDTO> listerParClient(Long clientId){
        return livraisonMapper.toDtoList(livraisonRepository.findByClientId(clientId));
    }

    public List<LivraisonDTO> listerEntreDeuxDates(LocalDate debut,LocalDate fin){
        return livraisonMapper.toDtoList(livraisonRepository.findByDateLivraisonBetween(debut,fin));
    }

    public List<LivraisonDTO> listerParVilleDestination(String ville){
      return livraisonMapper.toDtoList(livraisonRepository.findByVilleDestination(ville));
    }


}