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
	private int account_Id;
	private String account_Name;
	private int account_number;
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	@OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
	private Collection<Service> services;
	@OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
	private Collection<Facture> factures;
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(String account_Name, int account_number) {
		super();
		this.account_Name = account_Name;
		this.account_number = account_number;
	}
	public int getAccount_Id() {
		return account_Id;
	}
	public void setAccount_Id(int account_Id) {
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
	
	
}
