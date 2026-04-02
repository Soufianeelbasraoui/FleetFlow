package org.fleetflow.fleetflow.mapper;

import org.fleetflow.fleetflow.dto.ChauffeurDTO;
import org.fleetflow.fleetflow.entity.Chauffeur;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ChauffeurMapper {

    ChauffeurDTO toDTO(Chauffeur chauffeur);

    Chauffeur toEntity(ChauffeurDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(ChauffeurDTO dto, @MappingTarget Chauffeur chauffeur);
}