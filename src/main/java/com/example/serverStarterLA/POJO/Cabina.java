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
 * La classe Cabina corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class Cabina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@ManyToOne
	Impianto impianto;
	
	String materiale_porte;
	String tipo_porte;
	String contatti_sicurezza_porte;
	String tipo_luce_cab;
	String tipo_luce_em_cort;
	String tipo_pulsantiera;
	String tipo_comb_tel;
	String marca_comb_tel;
	String tipo_pattini_cab;
	String misure_est_pattini_cab;
	String misura_fg_pattini_cab;
	String note;
	
	public Cabina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cabina(String materiale_porte, String tipo_porte, String contatti_sicurezza_porte, String tipo_luce_cab,
			String tipo_luce_em_cort, String tipo_pulsantiera, String tipo_comb_tel, String marca_comb_tel,
			String tipo_pattini_cab, String misure_est_pattini_cab, String misura_fg_pattini_cab, String note) {
		super();
		this.materiale_porte = materiale_porte;
		this.tipo_porte = tipo_porte;
		this.contatti_sicurezza_porte = contatti_sicurezza_porte;
		this.tipo_luce_cab = tipo_luce_cab;
		this.tipo_luce_em_cort = tipo_luce_em_cort;
		this.tipo_pulsantiera = tipo_pulsantiera;
		this.tipo_comb_tel = tipo_comb_tel;
		this.marca_comb_tel = marca_comb_tel;
		this.tipo_pattini_cab = tipo_pattini_cab;
		this.misure_est_pattini_cab = misure_est_pattini_cab;
		this.misura_fg_pattini_cab = misura_fg_pattini_cab;
		this.note = note;
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

	public String getMateriale_porte() {
		return materiale_porte;
	}

	public void setMateriale_porte(String materiale_porte) {
		this.materiale_porte = materiale_porte;
	}

	public String getTipo_porte() {
		return tipo_porte;
	}

	public void setTipo_porte(String tipo_porte) {
		this.tipo_porte = tipo_porte;
	}

	public String getContatti_sicurezza_porte() {
		return contatti_sicurezza_porte;
	}

	public void setContatti_sicurezza_porte(String contatti_sicurezza_porte) {
		this.contatti_sicurezza_porte = contatti_sicurezza_porte;
	}

	public String getTipo_luce_cab() {
		return tipo_luce_cab;
	}

	public void setTipo_luce_cab(String tipo_luce_cab) {
		this.tipo_luce_cab = tipo_luce_cab;
	}

	public String getTipo_luce_em_cort() {
		return tipo_luce_em_cort;
	}

	public void setTipo_luce_em_cort(String tipo_luce_em_cort) {
		this.tipo_luce_em_cort = tipo_luce_em_cort;
	}

	public String getTipo_pulsantiera() {
		return tipo_pulsantiera;
	}

	public void setTipo_pulsantiera(String tipo_pulsantiera) {
		this.tipo_pulsantiera = tipo_pulsantiera;
	}

	public String getTipo_comb_tel() {
		return tipo_comb_tel;
	}

	public void setTipo_comb_tel(String tipo_comb_tel) {
		this.tipo_comb_tel = tipo_comb_tel;
	}

	public String getMarca_comb_tel() {
		return marca_comb_tel;
	}

	public void setMarca_comb_tel(String marca_comb_tel) {
		this.marca_comb_tel = marca_comb_tel;
	}

	public String getTipo_pattini_cab() {
		return tipo_pattini_cab;
	}

	public void setTipo_pattini_cab(String tipo_pattini_cab) {
		this.tipo_pattini_cab = tipo_pattini_cab;
	}

	public String getMisure_est_pattini_cab() {
		return misure_est_pattini_cab;
	}

	public void setMisure_est_pattini_cab(String misure_est_pattini_cab) {
		this.misure_est_pattini_cab = misure_est_pattini_cab;
	}

	public String getMisura_fg_pattini_cab() {
		return misura_fg_pattini_cab;
	}

	public void setMisura_fg_pattini_cab(String misura_fg_pattini_cab) {
		this.misura_fg_pattini_cab = misura_fg_pattini_cab;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	

}
