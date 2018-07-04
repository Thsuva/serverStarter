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
 * La classe Impianto corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class Impianto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@NotNull
	@Column(unique = true)
	String numeroImpianto;
	
	@NotNull
	@Column(unique = true)
	String numeroMatricola;
	
	@ManyToOne
	Azienda azienda;
	
	@Column(columnDefinition="int default 0")
	int warning;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	Date lastUpdateWarning;
	
	String promemoria;
	boolean promemoria_on;
	String provincia;
	String cap;
	String via;
	String portone;
	
	public Impianto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Impianto(@NotNull String numero_impianto, @NotNull String numero_matricola, int warning,
			Date lastUpdateWarning, String promemoria, boolean promemoria_on, String provincia, String cAP, String via,
			String portone) {
		super();
		this.numeroImpianto = numero_impianto;
		this.numeroMatricola = numero_matricola;
		this.warning = warning;
		this.lastUpdateWarning = lastUpdateWarning;
		this.promemoria = promemoria;
		this.promemoria_on = promemoria_on;
		this.provincia = provincia;
		this.cap = cAP;
		this.via = via;
		this.portone = portone;
	}
	
	public Impianto(@NotNull String numero_impianto, @NotNull String numero_matricola,
			String promemoria, boolean promemoria_on, String provincia, String cAP, String via,
			String portone) {
		super();
		this.numeroImpianto = numero_impianto;
		this.numeroMatricola = numero_matricola;
		this.promemoria = promemoria;
		this.promemoria_on = promemoria_on;
		this.provincia = provincia;
		this.cap = cAP;
		this.via = via;
		this.portone = portone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero_impianto() {
		return numeroImpianto;
	}

	public void setNumero_impianto(String numero_impianto) {
		this.numeroImpianto = numero_impianto;
	}

	public String getNumero_matricola() {
		return numeroMatricola;
	}

	public void setNumero_matricola(String numero_matricola) {
		this.numeroMatricola = numero_matricola;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public Azienda setAzienda(Azienda azienda) {
			this.azienda = azienda;
		
		return azienda;
	}

	public int getWarning() {
		return warning;
	}

	public void setWarning(int warning) {
		this.warning = warning;
	}

	public Date getLastUpdateWarning() {
		return lastUpdateWarning;
	}

	public void setLastUpdateWarning(Date lastUpdateWarning) {
		this.lastUpdateWarning = lastUpdateWarning;
	}

	public String getPromemoria() {
		return promemoria;
	}

	public void setPromemoria(String promemoria) {
		this.promemoria = promemoria;
	}

	public boolean isPromemoria_on() {
		return promemoria_on;
	}

	public void setPromemoria_on(boolean promemoria_on) {
		this.promemoria_on = promemoria_on;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCAP() {
		return cap;
	}

	public void setCAP(String cAP) {
		cap = cAP;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getPortone() {
		return portone;
	}

	public void setPortone(String portone) {
		this.portone = portone;
	}
	
	

}
