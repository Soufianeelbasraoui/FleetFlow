package org.fleetflow.fleetflow.mapper;

import org.fleetflow.fleetflow.dto.VehiculeDTO;
import org.fleetflow.fleetflow.entity.Vehicule;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    VehiculeDTO toDTO(Vehicule vehicule);

    Vehicule toEntity(VehiculeDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(VehiculeDTO dto, @MappingTarget Vehicule vehicule);
}