package org.fleetflow.fleetflow.service;

import org.fleetflow.fleetflow.dto.ClientDTO;
import org.fleetflow.fleetflow.entity.Client;
import org.fleetflow.fleetflow.mapper.ClientMapper;
import org.fleetflow.fleetflow.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService clientService;

    @Test
    void ajouterClient() {
        ClientDTO clientDTO=new ClientDTO("soufiane", "test@mail.com", "060000", "Casa");
        Client client=new Client(1L,"soufiane", "test@mail.com", "060000", "Casa",null);

        Mockito.when(clientRepository.save(Mockito.any())).thenReturn(client);
        Mockito.when(clientMapper.toEntity(clientDTO)).thenReturn(client);
        Mockito.when(clientMapper.toDTO(client)).thenReturn(clientDTO);

        ClientDTO result=clientService.ajouterClient(clientDTO);

        assertEquals("soufiane",result.getNom());

    }

    @Test
    void ajouterClient_emailExiste() {
        ClientDTO clientDTO = new ClientDTO("soufiane", "test@mail.com", "060000", "Casa");

        Mockito.when(clientRepository.existsByEmail("test@mail.com")).thenReturn(true);

        RuntimeException exception=assertThrows(RuntimeException.class,()->{
          clientService.ajouterClient(clientDTO);
         });
        assertEquals("email deja existe", exception.getMessage());

        Mockito.verify(clientRepository,Mockito.never()).save(Mockito.any());
    }
}