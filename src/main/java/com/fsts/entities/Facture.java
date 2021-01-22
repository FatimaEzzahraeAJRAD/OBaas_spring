package com.fsts.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "facture")
public class Facture implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int biller_Id;
	private String biller_Name;
	private float paid_amount;
	private Date date;
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Compte compte;
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(String biller_Name, float paid_amount, Date date) {
		super();
		this.biller_Name = biller_Name;
		this.paid_amount = paid_amount;
		this.date = date;
	}
	public int getBiller_Id() {
		return biller_Id;
	}
	public void setBiller_Id(int biller_Id) {
		this.biller_Id = biller_Id;
	}
	public String getBiller_Name() {
		return biller_Name;
	}
	public void setBiller_Name(String biller_Name) {
		this.biller_Name = biller_Name;
	}
	public float getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(float paid_amount) {
		this.paid_amount = paid_amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
