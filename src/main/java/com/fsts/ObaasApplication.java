package com.fsts;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.fsts.dao.ClientRepository;
import com.fsts.dao.CompteRepository;
import com.fsts.dao.FactureRepository;
import com.fsts.dao.ServiceRepository;
import com.fsts.entities.Client;
import com.fsts.entities.Compte;
import com.fsts.entities.Facture;
import com.fsts.entities.Service;

@SpringBootApplication
public class ObaasApplication implements CommandLineRunner {
	/*@Autowired
    private ClientRepository clientRepository;
	@Autowired
    private CompteRepository compteRepository;
	@Autowired
    private FactureRepository factureRepository;
	@Autowired
    private ServiceRepository serviceRepository;*/
	
	public static void main(String[] args) {
		SpringApplication.run(ObaasApplication.class, args);
		final String uri = "http://localhost:8085/clients";
		 
	    //TODO: Autowire the RestTemplate in all the examples
		/*
		 * RestTemplate restTemplate = new RestTemplate();
		 * 
		 * String result = restTemplate.getForObject(uri, String.class);
		 * 
		 * System.out.println(result);
		 */
	
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	Client c1 = clientRepository.save(new Client("Nora","123456","0615889933","rappahnour@gmail.com"));
	     
		Compte cpt1 = compteRepository.save(new Compte("compte1",10001,c1));
		
		factureRepository.save(new Facture("facture1",11052,new Date(),cpt1));
		serviceRepository.save(new Service("chequier",new Date(),cpt1));*/
		
		
	}
	
	    

}
