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
@Table(name = "service")
public class Service implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int request_Id;
	private String request_type;
	private Date date;
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Compte compte;
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Service(String request_type, Date date) {
		super();
		this.request_type = request_type;
		this.date = date;
	}
	public int getRequest_Id() {
		return request_Id;
	}
	public void setRequest_Id(int request_Id) {
		this.request_Id = request_Id;
	}
	public String getRequest_type() {
		return request_type;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	
}
