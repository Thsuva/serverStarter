package com.example.serverStarterLA.POJO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * La classe Chiamata corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class Chiamata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@ManyToOne
	Intervento intervento;
	
	
	
	String lavoro_eseguito;

	public Chiamata(String lavoro_eseguito) {
		super();
		this.lavoro_eseguito = lavoro_eseguito;
	}

	public Chiamata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Intervento getIntervento() {
		return intervento;
	}

	public Intervento setIntervento(Intervento intervento) {
			this.intervento = intervento;
		
		return intervento;
	}
	
	public String getLavoro_eseguito() {
		return lavoro_eseguito;
	}

	public void setLavoro_eseguito(String lavoro_eseguito) {
		this.lavoro_eseguito = lavoro_eseguito;
	}
	

}
