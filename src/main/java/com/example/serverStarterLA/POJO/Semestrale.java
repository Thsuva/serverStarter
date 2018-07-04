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
 * La classe Semestrale corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class Semestrale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@ManyToOne
	Intervento intervento;
	
	String nome_cliente;
	String cognome_cliente;
	String lavoro_eseguito;
	boolean efficienza_paracadute;
	boolean efficienza_lim_velocita;
	boolean efficienza_dis_sicurezza;
	boolean efficienza_colleg_terra;
	boolean funi;
	boolean attacchi_funi;
	boolean isolamento_imp_elettrico;
	String osservazioni;
	
	public Semestrale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Semestrale(String nome_cliente, String cognome_cliente, String lavoro_eseguito,
			boolean efficienza_paracadute, boolean efficienza_lim_velocita, boolean efficienza_dis_sicurezza,
			boolean efficienza_colleg_terra, boolean funi, boolean attacchi_funi, boolean isolamento_imp_elettrico,
			String osservazioni) {
		super();
		this.nome_cliente = nome_cliente;
		this.cognome_cliente = cognome_cliente;
		this.lavoro_eseguito = lavoro_eseguito;
		this.efficienza_paracadute = efficienza_paracadute;
		this.efficienza_lim_velocita = efficienza_lim_velocita;
		this.efficienza_dis_sicurezza = efficienza_dis_sicurezza;
		this.efficienza_colleg_terra = efficienza_colleg_terra;
		this.funi = funi;
		this.attacchi_funi = attacchi_funi;
		this.isolamento_imp_elettrico = isolamento_imp_elettrico;
		this.osservazioni = osservazioni;
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

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getCognome_cliente() {
		return cognome_cliente;
	}

	public void setCognome_cliente(String cognome_cliente) {
		this.cognome_cliente = cognome_cliente;
	}

	public String getLavoro_eseguito() {
		return lavoro_eseguito;
	}

	public void setLavoro_eseguito(String lavoro_eseguito) {
		this.lavoro_eseguito = lavoro_eseguito;
	}

	public boolean isEfficienza_paracadute() {
		return efficienza_paracadute;
	}

	public void setEfficienza_paracadute(boolean efficienza_paracadute) {
		this.efficienza_paracadute = efficienza_paracadute;
	}

	public boolean isEfficienza_lim_velocita() {
		return efficienza_lim_velocita;
	}

	public void setEfficienza_lim_velocita(boolean efficienza_lim_velocita) {
		this.efficienza_lim_velocita = efficienza_lim_velocita;
	}

	public boolean isEfficienza_dis_sicurezza() {
		return efficienza_dis_sicurezza;
	}

	public void setEfficienza_dis_sicurezza(boolean efficienza_dis_sicurezza) {
		this.efficienza_dis_sicurezza = efficienza_dis_sicurezza;
	}

	public boolean isEfficienza_colleg_terra() {
		return efficienza_colleg_terra;
	}

	public void setEfficienza_colleg_terra(boolean efficienza_colleg_terra) {
		this.efficienza_colleg_terra = efficienza_colleg_terra;
	}

	public boolean isFuni() {
		return funi;
	}

	public void setFuni(boolean funi) {
		this.funi = funi;
	}

	public boolean isAttacchi_funi() {
		return attacchi_funi;
	}

	public void setAttacchi_funi(boolean attacchi_funi) {
		this.attacchi_funi = attacchi_funi;
	}

	public boolean isIsolamento_imp_elettrico() {
		return isolamento_imp_elettrico;
	}

	public void setIsolamento_imp_elettrico(boolean isolamento_imp_elettrico) {
		this.isolamento_imp_elettrico = isolamento_imp_elettrico;
	}

	public String getOsservazioni() {
		return osservazioni;
	}

	public void setOsservazioni(String osservazioni) {
		this.osservazioni = osservazioni;
	}
	

}
