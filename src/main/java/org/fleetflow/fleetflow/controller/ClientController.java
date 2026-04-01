package org.fleetflow.fleetflow.controller;
import lombok.AllArgsConstructor;
import org.fleetflow.fleetflow.entity.Client;
import org.fleetflow.fleetflow.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<Client> getAllClient(){
        return clientService.findAllClients();
    }
    @PostMapping
    public Client addClient(Client client){
        return  clientService.saveClient(client);
    }
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id,@RequestBody Client client){
        return clientService.updateClient(id,client);
    }

    @DeleteMapping("/{id}")
    public void deletClient(@PathVariable Long id){
        clientService.deletClient(id);
    }
}
