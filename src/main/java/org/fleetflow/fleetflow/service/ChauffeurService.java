package org.fleetflow.fleetflow.service;

import lombok.RequiredArgsConstructor;
import org.fleetflow.fleetflow.entity.Chauffeur;
import org.fleetflow.fleetflow.repository.ChauffeurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChauffeurService {

    private final ChauffeurRepository chauffeurRepository;

    public Chauffeur addChauffeur(Chauffeur chauffeur){
        return chauffeurRepository.save(chauffeur);
    }

    public void UpdateChauffeur(){

    }
    public void deleteChauffeurById(Long id){
        chauffeurRepository.deleteById(id);
    }

    public List<Chauffeur> getAllChauffeur(){
        return chauffeurRepository.findAll();
    }

    public List<Chauffeur> getAvailableChauffeur(){
        return chauffeurRepository.findByAvailableTrue();
    }

}
