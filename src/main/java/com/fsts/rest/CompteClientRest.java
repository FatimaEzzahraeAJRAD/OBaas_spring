package com.fsts.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsts.dao.ClientRepository;
import com.fsts.dao.CompteRepository;
import com.fsts.dao.FactureRepository;
import com.fsts.dao.ServiceRepository;
import com.fsts.entities.Client;
import com.fsts.entities.Compte;
import com.fsts.entities.Facture;
import com.fsts.entities.Service;

@RestController
@CrossOrigin("*")
public class CompteClientRest {

	@Autowired
	ClientRepository rep;
	@Autowired
	CompteRepository crep;
	@Autowired
	FactureRepository frep;
	@Autowired
	ServiceRepository srep;
	@GetMapping("clients")
	public List<Client> listeClient(){
		return rep.findAll();
	}
	@GetMapping("comptes")
	public List<Compte> listeCompte(){
		return crep.findAll();
	}
	
	@GetMapping("comptes/{id}")
	public Optional<Compte> getCompteById(@PathVariable("id") long id) {
		return crep.findById(id);
	}
	@GetMapping("clients/{id}")
	public Optional<Client> getClientById(@PathVariable("id") long id) {
		return rep.findById(id);
	}
	@GetMapping("factures")
	public List<Facture> listeFacture(){
		return frep.findAll();
	}
	@GetMapping("services")
	public List<Service> listeService(){
		return srep.findAll();
	}
	@GetMapping("factures/{id}")
	public Optional<Facture> getFactureById(@PathVariable("id") long id) {
		return frep.findById(id);
	}
	@GetMapping("services/{id}")
	public Optional<Service> getServiceById(@PathVariable("id") long id) {
		return srep.findById(id);
	}
	  int i = 0;
	 @PostMapping("ajouterClient") 
	  public Client ajouterClient(@RequestBody Client c) {
		 i=i+1;
		 Random rand = new Random(); 
		 int numcpte = rand.nextInt(10000000);
		 rep.save(c);
		 Compte cpt = crep.save(new Compte("compte"+i,numcpte,100000,c));
		 Facture f1 = new Facture("facture1",0,null,cpt);
		 Facture f2 = new Facture ("facture2",0,null,cpt);
		 frep.save(f1);
		 frep.save(f2);
		 Service s = new Service("nouvelle demande de chéquier",null,cpt);
		 srep.save(s);
		 return c;
		}
	 @PutMapping("factures")
	 public Facture payerFacture(@RequestBody Facture f) {
		 Compte c = f.getCompte();
		 float solde = c.getSolde();
		 f.setDate(new Date());
		if (solde > f.getPaid_amount())
		{
			float solderestant = solde-f.getPaid_amount();
			c.setSolde(solderestant);
		    crep.save(c);	
		}
		 return frep.save(f);
	 }
	 @PutMapping("services")
	 public Service demanderService(@RequestBody Service s) {
		 s.setDate(new Date());
		 return srep.save(s);
	 }
	 @DeleteMapping("comptes/{id}")
	    public void supprimerComptes(@PathVariable("id") long id) {
	    	Optional<Compte> e = getCompteById(id);
	        List<Facture> factures = listeFacture();
	        List <Service> services = listeService();
	         for(Facture f : factures) {
	        	 if (f.getCompte().getAccount_Id() == id)
	        		 frep.delete(f);
	         }
	         for(Service s : services) {
	        	 if (s.getCompte().getAccount_Id() == id)
	        		 srep.delete(s);
	         }
	    	
	    	crep.delete(e.get());
	    	//rep.delete(e.get().getClient());
	    	
	    	
	    }
	 
	 
}
