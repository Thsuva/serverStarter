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
 * La classe Ordinario corrisponde in tutto e per tutto all'omonima tabella presente sul db, ed è munita di getter e setter
 * 
 * @author Jacopo Favaro
 *
 */
@Entity
public class Ordinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@ManyToOne
	Intervento intervento;
	
	boolean pul_fossa;
	boolean pul_tetto;
	boolean pul_LM;
	boolean pul_argano;
	boolean livelli;
	boolean reg_freno;
	boolean ctrl_pul_QM;
	boolean rinvii;
	boolean olio_guide;
	boolean olio_CP;
	boolean luminose;
	boolean contatti_portine;
	String altro;
	
	public Ordinario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ordinario(boolean pul_fossa, boolean pul_tetto, boolean pul_LM, boolean pul_argano, boolean livelli,
			boolean reg_freno, boolean ctrl_pul_QM, boolean rinvii, boolean olio_guide, boolean olio_CP,
			boolean luminose, boolean contatti_portine, String altro) {
		super();
		this.pul_fossa = pul_fossa;
		this.pul_tetto = pul_tetto;
		this.pul_LM = pul_LM;
		this.pul_argano = pul_argano;
		this.livelli = livelli;
		this.reg_freno = reg_freno;
		this.ctrl_pul_QM = ctrl_pul_QM;
		this.rinvii = rinvii;
		this.olio_guide = olio_guide;
		this.olio_CP = olio_CP;
		this.luminose = luminose;
		this.contatti_portine = contatti_portine;
		this.altro = altro;
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

	public boolean isPul_fossa() {
		return pul_fossa;
	}

	public void setPul_fossa(boolean pul_fossa) {
		this.pul_fossa = pul_fossa;
	}

	public boolean isPul_tetto() {
		return pul_tetto;
	}

	public void setPul_tetto(boolean pul_tetto) {
		this.pul_tetto = pul_tetto;
	}

	public boolean isPul_LM() {
		return pul_LM;
	}

	public void setPul_LM(boolean pul_LM) {
		this.pul_LM = pul_LM;
	}

	public boolean isPul_argano() {
		return pul_argano;
	}

	public void setPul_argano(boolean pul_argano) {
		this.pul_argano = pul_argano;
	}

	public boolean isLivelli() {
		return livelli;
	}

	public void setLivelli(boolean livelli) {
		this.livelli = livelli;
	}

	public boolean isReg_freno() {
		return reg_freno;
	}

	public void setReg_freno(boolean reg_freno) {
		this.reg_freno = reg_freno;
	}

	public boolean isCtrl_pul_QM() {
		return ctrl_pul_QM;
	}

	public void setCtrl_pul_QM(boolean ctrl_pul_QM) {
		this.ctrl_pul_QM = ctrl_pul_QM;
	}

	public boolean isRinvii() {
		return rinvii;
	}

	public void setRinvii(boolean rinvii) {
		this.rinvii = rinvii;
	}

	public boolean isOlio_guide() {
		return olio_guide;
	}

	public void setOlio_guide(boolean olio_guide) {
		this.olio_guide = olio_guide;
	}

	public boolean isOlio_CP() {
		return olio_CP;
	}

	public void setOlio_CP(boolean olio_CP) {
		this.olio_CP = olio_CP;
	}

	public boolean isLuminose() {
		return luminose;
	}

	public void setLuminose(boolean luminose) {
		this.luminose = luminose;
	}

	public boolean isContatti_portine() {
		return contatti_portine;
	}

	public void setContatti_portine(boolean contatti_portine) {
		this.contatti_portine = contatti_portine;
	}

	public String getAltro() {
		return altro;
	}

	public void setAltro(String altro) {
		this.altro = altro;
	}
	

}
