package com.example.serverStarterLA.POJO;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * La classe Intervento corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class Intervento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@ManyToOne
	Impianto impianto;
	
	@ManyToOne
	Azienda azienda;
	
	@ManyToOne
	Manutentore manutentore;
	
	@NotNull
	String tipo;
	
	@NotNull
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	Date data;
	
	@NotNull
	@Column(columnDefinition="BOOL default 0")
	boolean closed;

	public Intervento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Intervento(@NotNull String tipo, @NotNull Date data, @NotNull boolean closed) {
		super();
		this.tipo = tipo;
		this.data = data;
		this.closed = closed;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Impianto getImpianto() {
		return impianto;
	}

	public Impianto setImpianto(Impianto impianto) {
			this.impianto = impianto;
		
		return impianto;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public Azienda setAzienda(Azienda azienda) {
			this.azienda = azienda;
		
		return azienda;
	}

	public Manutentore getManutentore() {
		return manutentore;
	}

	public Manutentore setManutentore(Manutentore manutentore) {
			this.manutentore = manutentore;
		
		return manutentore;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}


}
