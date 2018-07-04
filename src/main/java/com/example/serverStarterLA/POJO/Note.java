package com.example.serverStarterLA.POJO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * La classe Note corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@ManyToOne
	Supervisore supervisore;
	
	@ManyToOne
	Intervento intervento;
	
	@NotNull
	String testo;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	Date data;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(@NotNull String testo, @NotNull Date data) {
		super();
		this.testo = testo;
		this.data = data;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Supervisore getSupervisore() {
		return supervisore;
	}

	public Supervisore setSupervisore(Supervisore supervisore) {
			this.supervisore = supervisore;
		
		return supervisore;
	}

	public Intervento getIntervento() {
		return intervento;
	}

	public Intervento setIntervento(Intervento intervento) {
			this.intervento = intervento;
		
		return intervento;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	

}
