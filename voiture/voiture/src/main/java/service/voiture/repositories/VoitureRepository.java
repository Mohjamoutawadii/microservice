package service.voiture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import service.voiture.entities.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
