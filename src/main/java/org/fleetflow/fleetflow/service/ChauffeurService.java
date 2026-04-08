package org.fleetflow.fleetflow.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.fleetflow.fleetflow.dto.ChauffeurDTO;
import org.fleetflow.fleetflow.entity.Chauffeur;
import org.fleetflow.fleetflow.mapper.ChauffeurMapper;
import org.fleetflow.fleetflow.repository.ChauffeurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChauffeurService {

    private final ChauffeurRepository chauffeurRepository;
    private final ChauffeurMapper chauffeurMapper;

    public ChauffeurDTO ajouterChauffeur(ChauffeurDTO dto) {
        Chauffeur chauffeur = chauffeurMapper.toEntity(dto);
        return chauffeurMapper.toDTO(chauffeurRepository.save(chauffeur));
    }

    public ChauffeurDTO modifierChauffeur(Long id, ChauffeurDTO dto) {
        Chauffeur chauffeur = chauffeurRepository.findById(id).orElse(null);
        chauffeurMapper.updateEntityFromDTO(dto, chauffeur);
        return chauffeurMapper.toDTO(chauffeurRepository.save(chauffeur));
    }

    public void supprimerChauffeur(Long id) {
        if (!chauffeurRepository.existsById(id)) {
            throw new EntityNotFoundException("Chauffeur introuvable avec l'id : " + id);
        }
        chauffeurRepository.deleteById(id);
    }
    public List<ChauffeurDTO> listerChauffeurs(){
        return chauffeurMapper.toDtoList(chauffeurRepository.findAll());
    }

public List<ChauffeurDTO> listerChauffeursDisponibles(){
        return chauffeurMapper.toDtoList(chauffeurRepository.findByAvailableTrue());
}
}