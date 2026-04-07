// ClientService.java
package org.fleetflow.fleetflow.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.fleetflow.fleetflow.dto.ClientDTO;
import org.fleetflow.fleetflow.entity.Client;
import org.fleetflow.fleetflow.mapper.ClientMapper;
import org.fleetflow.fleetflow.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientDTO ajouterClient(ClientDTO dto) {
        Client client = clientMapper.toEntity(dto);
        return clientMapper.toDTO(clientRepository.save(client));
    }

    public ClientDTO modifierClient(Long id, ClientDTO dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable avec l'id : " + id));
        clientMapper.updateEntityFromDTO(dto, client);
        return clientMapper.toDTO(clientRepository.save(client));
    }

    public void supprimerClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client introuvable avec l'id : " + id);
        }
        clientRepository.deleteById(id);
    }

    public List<ClientDTO> listerClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable avec l'id : " + id));
        return clientMapper.toDTO(client);
    }
}