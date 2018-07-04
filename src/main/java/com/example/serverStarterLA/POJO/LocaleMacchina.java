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
 * La classe LocaleMacchina corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class LocaleMacchina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@ManyToOne
	Impianto impianto;
	
	String posizione;
	String chiavi_LM;
	String chiavi_rinvii;
	String luce_LM;
	String marca_QM;
	String tipologia_QM;
	String tipo_b_alrm_QM;
	String marca_GT;
	String tipologia_GT;
	String marca_centralina;
	String tipologia_centralina;
	String tipo_lim_vel;
	String marca_lim_vel;
	
	public LocaleMacchina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocaleMacchina(String posizione, String chiavi_LM, String chiavi_rinvii, String luce_LM, String marca_QM,
			String tipologia_QM, String tipo_b_alrm_QM, String marca_GT, String tipologia_GT, String marca_centralina,
			String tipologia_centralina, String tipo_lim_vel, String marca_lim_vel) {
		super();
		this.posizione = posizione;
		this.chiavi_LM = chiavi_LM;
		this.chiavi_rinvii = chiavi_rinvii;
		this.luce_LM = luce_LM;
		this.marca_QM = marca_QM;
		this.tipologia_QM = tipologia_QM;
		this.tipo_b_alrm_QM = tipo_b_alrm_QM;
		this.marca_GT = marca_GT;
		this.tipologia_GT = tipologia_GT;
		this.marca_centralina = marca_centralina;
		this.tipologia_centralina = tipologia_centralina;
		this.tipo_lim_vel = tipo_lim_vel;
		this.marca_lim_vel = marca_lim_vel;
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

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public String getChiavi_LM() {
		return chiavi_LM;
	}

	public void setChiavi_LM(String chiavi_LM) {
		this.chiavi_LM = chiavi_LM;
	}

	public String getChiavi_rinvii() {
		return chiavi_rinvii;
	}

	public void setChiavi_rinvii(String chiavi_rinvii) {
		this.chiavi_rinvii = chiavi_rinvii;
	}

	public String getLuce_LM() {
		return luce_LM;
	}

	public void setLuce_LM(String luce_LM) {
		this.luce_LM = luce_LM;
	}

	public String getMarca_QM() {
		return marca_QM;
	}

	public void setMarca_QM(String marca_QM) {
		this.marca_QM = marca_QM;
	}

	public String getTipologia_QM() {
		return tipologia_QM;
	}

	public void setTipologia_QM(String tipologia_QM) {
		this.tipologia_QM = tipologia_QM;
	}

	public String getTipo_b_alrm_QM() {
		return tipo_b_alrm_QM;
	}

	public void setTipo_b_alrm_QM(String tipo_b_alrm_QM) {
		this.tipo_b_alrm_QM = tipo_b_alrm_QM;
	}

	public String getMarca_GT() {
		return marca_GT;
	}

	public void setMarca_GT(String marca_GT) {
		this.marca_GT = marca_GT;
	}

	public String getTipologia_GT() {
		return tipologia_GT;
	}

	public void setTipologia_GT(String tipologia_GT) {
		this.tipologia_GT = tipologia_GT;
	}

	public String getMarca_centralina() {
		return marca_centralina;
	}

	public void setMarca_centralina(String marca_centralina) {
		this.marca_centralina = marca_centralina;
	}

	public String getTipologia_centralina() {
		return tipologia_centralina;
	}

	public void setTipologia_centralina(String tipologia_centralina) {
		this.tipologia_centralina = tipologia_centralina;
	}

	public String getTipo_lim_vel() {
		return tipo_lim_vel;
	}

	public void setTipo_lim_vel(String tipo_lim_vel) {
		this.tipo_lim_vel = tipo_lim_vel;
	}

	public String getMarca_lim_vel() {
		return marca_lim_vel;
	}

	public void setMarca_lim_vel(String marca_lim_vel) {
		this.marca_lim_vel = marca_lim_vel;
	}
	
	
	

}
