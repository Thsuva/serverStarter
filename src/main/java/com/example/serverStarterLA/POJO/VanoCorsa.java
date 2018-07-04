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
 * La classe VanoCorsa corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class VanoCorsa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@ManyToOne
	Impianto impianto;
	
	String marca_serrature;
	String tipo_serrature;
	String pos_serrature;
	String tipo_porte;
	String materiale_porte;
	String marca_pulsantiere;
	String tipo_pulsantiere;
	String luminose_pulsantiere;
	String linee_elettriche_vano;
	String tipo_alrm;
	String quantita_alrm;
	String pos_alrm;
	String tipo_int_FM_PT;
	String tipo_puls_sgancio_PT;
	String misura_vetro_puls_sgancio_PT;
	String tipo_PC;
	String misura_fg_db_PC;
	String n_bord_PC;
	
	public VanoCorsa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VanoCorsa(String marca_serrature, String tipo_serrature, String pos_serrature, String tipo_porte,
			String materiale_porte, String marca_pulsantiere, String tipo_pulsantiere, String luminose_pulsantiere,
			String linee_elettriche_vano, String tipo_alrm, String quantita_alrm, String pos_alrm,
			String tipo_int_FM_PT, String tipo_puls_sgancio_PT, String misura_vetro_puls_sgancio_PT, String tipo_PC,
			String misura_fg_db_PC, String n_bord_PC) {
		super();
		this.marca_serrature = marca_serrature;
		this.tipo_serrature = tipo_serrature;
		this.pos_serrature = pos_serrature;
		this.tipo_porte = tipo_porte;
		this.materiale_porte = materiale_porte;
		this.marca_pulsantiere = marca_pulsantiere;
		this.tipo_pulsantiere = tipo_pulsantiere;
		this.luminose_pulsantiere = luminose_pulsantiere;
		this.linee_elettriche_vano = linee_elettriche_vano;
		this.tipo_alrm = tipo_alrm;
		this.quantita_alrm = quantita_alrm;
		this.pos_alrm = pos_alrm;
		this.tipo_int_FM_PT = tipo_int_FM_PT;
		this.tipo_puls_sgancio_PT = tipo_puls_sgancio_PT;
		this.misura_vetro_puls_sgancio_PT = misura_vetro_puls_sgancio_PT;
		this.tipo_PC = tipo_PC;
		this.misura_fg_db_PC = misura_fg_db_PC;
		this.n_bord_PC = n_bord_PC;
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

	public String getMarca_serrature() {
		return marca_serrature;
	}

	public void setMarca_serrature(String marca_serrature) {
		this.marca_serrature = marca_serrature;
	}

	public String getTipo_serrature() {
		return tipo_serrature;
	}

	public void setTipo_serrature(String tipo_serrature) {
		this.tipo_serrature = tipo_serrature;
	}

	public String getPos_serrature() {
		return pos_serrature;
	}

	public void setPos_serrature(String pos_serrature) {
		this.pos_serrature = pos_serrature;
	}

	public String getTipo_porte() {
		return tipo_porte;
	}

	public void setTipo_porte(String tipo_porte) {
		this.tipo_porte = tipo_porte;
	}

	public String getMateriale_porte() {
		return materiale_porte;
	}

	public void setMateriale_porte(String materiale_porte) {
		this.materiale_porte = materiale_porte;
	}

	public String getMarca_pulsantiere() {
		return marca_pulsantiere;
	}

	public void setMarca_pulsantiere(String marca_pulsantiere) {
		this.marca_pulsantiere = marca_pulsantiere;
	}

	public String getTipo_pulsantiere() {
		return tipo_pulsantiere;
	}

	public void setTipo_pulsantiere(String tipo_pulsantiere) {
		this.tipo_pulsantiere = tipo_pulsantiere;
	}

	public String getLuminose_pulsantiere() {
		return luminose_pulsantiere;
	}

	public void setLuminose_pulsantiere(String luminose_pulsantiere) {
		this.luminose_pulsantiere = luminose_pulsantiere;
	}

	public String getLinee_elettriche_vano() {
		return linee_elettriche_vano;
	}

	public void setLinee_elettriche_vano(String linee_elettriche_vano) {
		this.linee_elettriche_vano = linee_elettriche_vano;
	}

	public String getTipo_alrm() {
		return tipo_alrm;
	}

	public void setTipo_alrm(String tipo_alrm) {
		this.tipo_alrm = tipo_alrm;
	}

	public String getQuantita_alrm() {
		return quantita_alrm;
	}

	public void setQuantita_alrm(String quantita_alrm) {
		this.quantita_alrm = quantita_alrm;
	}

	public String getPos_alrm() {
		return pos_alrm;
	}

	public void setPos_alrm(String pos_alrm) {
		this.pos_alrm = pos_alrm;
	}

	public String getTipo_int_FM_PT() {
		return tipo_int_FM_PT;
	}

	public void setTipo_int_FM_PT(String tipo_int_FM_PT) {
		this.tipo_int_FM_PT = tipo_int_FM_PT;
	}

	public String getTipo_puls_sgancio_PT() {
		return tipo_puls_sgancio_PT;
	}

	public void setTipo_puls_sgancio_PT(String tipo_puls_sgancio_PT) {
		this.tipo_puls_sgancio_PT = tipo_puls_sgancio_PT;
	}

	public String getMisura_vetro_puls_sgancio_PT() {
		return misura_vetro_puls_sgancio_PT;
	}

	public void setMisura_vetro_puls_sgancio_PT(String misura_vetro_puls_sgancio_PT) {
		this.misura_vetro_puls_sgancio_PT = misura_vetro_puls_sgancio_PT;
	}

	public String getTipo_PC() {
		return tipo_PC;
	}

	public void setTipo_PC(String tipo_PC) {
		this.tipo_PC = tipo_PC;
	}

	public String getMisura_fg_db_PC() {
		return misura_fg_db_PC;
	}

	public void setMisura_fg_db_PC(String misura_fg_db_PC) {
		this.misura_fg_db_PC = misura_fg_db_PC;
	}

	public String getN_bord_PC() {
		return n_bord_PC;
	}

	public void setN_bord_PC(String n_bord_PC) {
		this.n_bord_PC = n_bord_PC;
	}
	
	

}
