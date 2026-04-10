package org.fleetflow.fleetflow.repository;


import org.fleetflow.fleetflow.dto.ClientDTO;
import org.fleetflow.fleetflow.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
