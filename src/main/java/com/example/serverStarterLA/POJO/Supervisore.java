package com.example.serverStarterLA.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * La classe Supervisore corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class Supervisore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@NotNull
	@Column(unique = true)
	String matricola;
	
	@ManyToOne
	Azienda azienda;
	
	@NotNull
	String password;
	
	@NotNull
	String nome;
	
	@NotNull
	String cognome;

	public Supervisore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supervisore(@NotNull String matricola, @NotNull String password, @NotNull String nome,
			@NotNull String cognome) {
		super();
		this.matricola = matricola;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public Azienda setAzienda(Azienda azienda) {
			this.azienda = azienda;
		
		return azienda;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	

}
