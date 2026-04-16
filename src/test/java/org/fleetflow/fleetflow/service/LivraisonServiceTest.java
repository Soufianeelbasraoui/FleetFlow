package org.fleetflow.fleetflow.service;

import com.mysql.cj.xdevapi.Client;
import org.fleetflow.fleetflow.dto.LivraisonDTO;
import org.fleetflow.fleetflow.entity.Chauffeur;
import org.fleetflow.fleetflow.entity.Livraison;
import org.fleetflow.fleetflow.entity.Vehicule;
import org.fleetflow.fleetflow.mapper.LivraisonMapper;
import org.fleetflow.fleetflow.repository.ChauffeurRepository;
import org.fleetflow.fleetflow.repository.ClientRepository;
import org.fleetflow.fleetflow.repository.LivraisonRepository;
import org.fleetflow.fleetflow.repository.VehiculeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class LivraisonServiceTest {

    @Mock
    LivraisonRepository livraisonRepository;
    @Mock
    LivraisonMapper livraisonMapper;
    @Mock
    ChauffeurRepository chauffeurRepository;
    @Mock
    VehiculeRepository vehiculeRepository;
    @InjectMocks
    LivraisonService livraisonService;
    @Test
    void creerLivraison() {
        LivraisonDTO livraisonDTOS=new LivraisonDTO( LocalDate.of(2026, 4, 15),"casa","oudeZem","EN_ATTENTE",1L,2L,3L);
        Livraison livraisons=new Livraison();
        livraisons.setId(1L);
        livraisons.setDateLivraison(LocalDate.of(2026, 4, 15));
        livraisons.setStatut("EN_ATTENTE");
        Mockito.when(livraisonRepository.save(Mockito.any())).thenReturn(livraisons);
        Mockito.when(livraisonMapper.toDTO(livraisons)).thenReturn(livraisonDTOS);
        Mockito.when(livraisonMapper.toEntity(livraisonDTOS)).thenReturn(livraisons);

        LivraisonDTO resultDto=livraisonService.creerLivraison(livraisonDTOS);
        assertEquals("EN_ATTENTE",resultDto.getStatut());
        Mockito.verify(livraisonRepository).save(Mockito.any());
    }


    @Test
    void assignerChauffeurEtVehicule() {
        Long livraisonId = 1L;
        Long chauffeurId = 2L;
        Long vehiculeId = 3L;

        Livraison livraison=new Livraison();
        livraison.setId(livraisonId);
        Chauffeur chauffeur=new Chauffeur();
        chauffeur.setId(chauffeurId);
        Vehicule vehicule=new Vehicule();
        vehicule.setId(vehiculeId);

        LivraisonDTO livraisonDTO=new LivraisonDTO();
        livraisonDTO.setChauffeurId(chauffeurId);
        livraisonDTO.setVehiculeId(vehiculeId);

        Mockito.when(livraisonRepository.findById(livraisonId)).thenReturn(Optional.of(livraison));
        Mockito.when(chauffeurRepository.findById(chauffeurId)).thenReturn(Optional.of(chauffeur));
        Mockito.when(vehiculeRepository.findById(vehiculeId)).thenReturn(Optional.of(vehicule));
        Mockito.when(livraisonRepository.save(Mockito.any())).thenReturn(livraison);
        Mockito.when(livraisonMapper.toDTO(livraison)).thenReturn(livraisonDTO);
        LivraisonDTO result = livraisonService.assignerChauffeurEtVehicule(livraisonId, chauffeurId, vehiculeId);

        assertNotNull(result);
        assertEquals(chauffeurId, result.getChauffeurId());
        assertEquals(vehiculeId, result.getVehiculeId());
        Mockito.verify(livraisonRepository).save(Mockito.any());
    }

    @Test
    void changerStatut() {

        Long livraisonId = 1L;

        Livraison livraison = new Livraison();
        livraison.setId(livraisonId);
        livraison.setStatut("EN_ATTENTE");

        LivraisonDTO livraisonDTO = new LivraisonDTO();
        livraisonDTO.setStatut("LIVREE");

        Mockito.when(livraisonRepository.findById(livraisonId)).thenReturn(Optional.of(livraison));
        Mockito.when(livraisonRepository.save(Mockito.any())).thenReturn(livraison);

        Mockito.when(livraisonMapper.toDTO(livraison)).thenReturn(livraisonDTO);
        LivraisonDTO result = livraisonService.changerStatut(livraisonId, "LIVREE");

        assertEquals("LIVREE", result.getStatut());

        Mockito.verify(livraisonRepository).save(Mockito.any());
    }
}