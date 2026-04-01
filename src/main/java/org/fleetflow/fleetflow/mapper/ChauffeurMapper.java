package org.fleetflow.fleetflow.mapper;

import org.fleetflow.fleetflow.dto.ChauffeurDTO;
import org.fleetflow.fleetflow.entity.Chauffeur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChauffeurMapper {

    ChauffeurDTO toDTO(Chauffeur chauffeur);

    Chauffeur toEntity(ChauffeurDTO dto);

    List<ChauffeurDTO> toDTOList(List<Chauffeur> chauffeurs);

    List<Chauffeur> toEntityList(List<ChauffeurDTO> dtos);
}
