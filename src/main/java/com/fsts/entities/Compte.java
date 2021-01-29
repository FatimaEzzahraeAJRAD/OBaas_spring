package com.fsts.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "compte")
public class Compte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long account_Id;
	private String account_Name;
	private int account_number;
	private float solde;
	//private float balance;
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;

	/*
	 * @OneToMany(mappedBy="compte",fetch=FetchType.LAZY) private
	 * Collection<Service> services;
	 */
	/*
	 * @OneToMany(mappedBy="compte",fetch=FetchType.LAZY) private
	 * Collection<Facture> nomfactures;
	 */
	 
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Compte(String account_Name, int account_number, float solde,Client client) {
		super();
		this.account_Name = account_Name;
		this.account_number = account_number;
		this.solde = solde;
		this.client = client;
		
	}

	public Long getAccount_Id() {
		return account_Id;
	}
	public void setAccount_Id(Long account_Id) {
		this.account_Id = account_Id;
	}
	public String getAccount_Name() {
		return account_Name;
	}
	public void setAccount_Name(String account_Name) {
		this.account_Name = account_Name;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	 
	 
	
	
	
}
