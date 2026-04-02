package org.fleetflow.fleetflow.mapper;

import org.fleetflow.fleetflow.dto.ClientDTO;
import org.fleetflow.fleetflow.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO clientDTO);
    List<ClientDTO> toDTOs(List<Client> clients);
    List<Client>  toEntities(List<ClientDTO> clientDTOS);
}
