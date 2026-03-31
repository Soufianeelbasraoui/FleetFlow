package org.fleetflow.fleetflow.repository;

public interface ClientRepository {
import org.fleetflow.fleetflow.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
