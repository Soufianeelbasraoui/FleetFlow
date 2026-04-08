package org.fleetflow.fleetflow.mapper;

import org.fleetflow.fleetflow.dto.ChauffeurDTO;
import org.fleetflow.fleetflow.entity.Chauffeur;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChauffeurMapper {

    ChauffeurDTO toDTO(Chauffeur chauffeur);
     List<ChauffeurDTO> toDtoList(List<Chauffeur> chauffeurs);
    Chauffeur toEntity(ChauffeurDTO dto);

    List<ChauffeurDTO> toDTOs(List<Chauffeur> chauffeur);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(ChauffeurDTO dto, @MappingTarget Chauffeur chauffeur);
}