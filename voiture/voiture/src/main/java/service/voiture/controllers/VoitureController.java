package service.voiture.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import service.voiture.Client;
import service.voiture.VoitureApplication.ClientService;
import service.voiture.entities.Voiture;
import service.voiture.repositories.VoitureRepository;

@RestController
public class VoitureController {
	@Autowired
	VoitureRepository voitureRepository ;
	
	@Autowired
	ClientService cs;
	
	@GetMapping("/voitures")
	public List<Voiture> findAll(){
	List<Voiture> voitures =voitureRepository.findAll();
	for(Voiture c : voitures){
		long id=c.getId_client();
		Client client=cs.ClientById(id);
		c.setClient(client);
	}
	return voitures;
    }
	
	@GetMapping("/voiture/{id}")
	public Voiture findById (@PathVariable Long id) throws Exception{
    Voiture v=voitureRepository.findById(id).orElseThrow(()-> new Exception("Voiture inexistnt"));
    Client c=cs.ClientById(v.getId_client());
    v.setClient(c);
	return v;
	}
}
