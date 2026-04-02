package org.fleetflow.fleetflow.mapper;

import org.fleetflow.fleetflow.dto.LivraisonDTO;
import org.fleetflow.fleetflow.entity.Livraison;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface LivraisonMapper {

    @Mapping(source = "client.id",    target = "clientId")
    @Mapping(source = "chauffeur.id", target = "chauffeurId")
    @Mapping(source = "vehicule.id",  target = "vehiculeId")
    LivraisonDTO toDTO(Livraison livraison);

    @Mapping(source = "clientId",    target = "client.id")
    @Mapping(source = "chauffeurId", target = "chauffeur.id")
    @Mapping(source = "vehiculeId",  target = "vehicule.id")
    Livraison toEntity(LivraisonDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "clientId",    target = "client.id")
    @Mapping(source = "chauffeurId", target = "chauffeur.id")
    @Mapping(source = "vehiculeId",  target = "vehicule.id")
    void updateEntityFromDTO(LivraisonDTO dto, @MappingTarget Livraison livraison);
}
