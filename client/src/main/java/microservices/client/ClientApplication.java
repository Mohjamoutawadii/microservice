package microservices.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import microservices.client.entities.Client;
import microservices.client.repositories.ClientRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	@Bean
	CommandLineRunner initializeBaseH2(ClientRepository clientRepository) {
	        return args -> {
	            clientRepository.save(new Client(1L, "Mohja Moutawadii", 23F));
	            clientRepository.save(new Client(2L, "Ayoub Mechkour", 22F));
	            clientRepository.save(new Client(3L, "Fatima Chebbaki", 22F));
	        };
	    }
	 
	

}
