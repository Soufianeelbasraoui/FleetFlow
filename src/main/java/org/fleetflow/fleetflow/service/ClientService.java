package org.fleetflow.fleetflow.service;

import lombok.RequiredArgsConstructor;
import org.fleetflow.fleetflow.entity.Client;
import org.fleetflow.fleetflow.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }
    public Client saveClient(Client client){
        return clientRepository.save(client);
    };
    public void deletClient(Long id){
        clientRepository.deleteById(id);
    }
    public Client updateClient(Long id,Client client){
      Client c=findById(id);
      c.setNom(client.getNom());
      c.setVille(client.getVille());
      c.setTelephone(client.getTelephone());
      c.setEmail(client.getEmail());
      return  clientRepository.save(c);
    }

    private Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
