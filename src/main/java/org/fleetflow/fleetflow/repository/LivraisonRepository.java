package org.fleetflow.fleetflow.repository;

public interface LivraisonRepository {
import org.fleetflow.fleetflow.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository extends JpaRepository<Livraison ,Long> {
}
