package com.example.serverStarterLA.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * La classe Azienda corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class Azienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@NotNull
	@Column(unique = true)
	String codice_azienda;
	
	@NotNull
	String nome;

	public Azienda(@NotNull String codice_azienda, @NotNull String nome) {
		super();
		this.codice_azienda = codice_azienda;
		this.nome = nome;
	}

	public Azienda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodice_azienda() {
		return codice_azienda;
	}

	public void setCodice_azienda(String codice_azienda) {
		this.codice_azienda = codice_azienda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
