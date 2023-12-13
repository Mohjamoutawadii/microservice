package microservices.client.repositories;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import microservices.client.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	
}
