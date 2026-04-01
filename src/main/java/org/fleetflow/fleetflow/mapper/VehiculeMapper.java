package org.fleetflow.fleetflow.mapper;

import org.fleetflow.fleetflow.dto.VehiculeDTO;
import org.fleetflow.fleetflow.entity.Vehicule;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    VehiculeDTO toDTO(Vehicule vehicule);

    Vehicule toEntity(VehiculeDTO dto);

    List<VehiculeDTO> toDTOList(List<Vehicule> vehicules);

    List<Vehicule> toEntityList(List<VehiculeDTO> dtos);
}