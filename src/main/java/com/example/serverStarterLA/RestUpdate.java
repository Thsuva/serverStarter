package com.example.serverStarterLA;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.serverStarterLA.POJO.Azienda;
import com.example.serverStarterLA.POJO.Biennale;
import com.example.serverStarterLA.POJO.Cabina;
import com.example.serverStarterLA.POJO.DPI;
import com.example.serverStarterLA.POJO.Impianto;
import com.example.serverStarterLA.POJO.Intervento;
import com.example.serverStarterLA.POJO.LocaleMacchina;
import com.example.serverStarterLA.POJO.Manutentore;
import com.example.serverStarterLA.POJO.Ordinario;
import com.example.serverStarterLA.POJO.Semestrale;
import com.example.serverStarterLA.POJO.VanoCorsa;
import com.example.serverStarterLA.POJO.biennaleRepository;
import com.example.serverStarterLA.POJO.cabinaRepository;
import com.example.serverStarterLA.POJO.chiamataRepository;
import com.example.serverStarterLA.POJO.dpiRepository;
import com.example.serverStarterLA.POJO.impiantoRepository;
import com.example.serverStarterLA.POJO.interventoRepository;
import com.example.serverStarterLA.POJO.localemacchinaRepository;
import com.example.serverStarterLA.POJO.manutentoreRepository;
import com.example.serverStarterLA.POJO.noteRepository;
import com.example.serverStarterLA.POJO.ordinarioRepository;
import com.example.serverStarterLA.POJO.semestraleRepository;
import com.example.serverStarterLA.POJO.vanocorsaRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * La classe RestUpdate raccoglie le funzioni relative alle query da eseguire per l'update dei dati della app
 * 
 * @author Jacopo Favaro
 *
 */
@RestController
public class RestUpdate {
	
	@Autowired
	manutentoreRepository mr;
	
	@Autowired
	impiantoRepository ir;
	
	@Autowired
	interventoRepository intr;
	
	@Autowired
	localemacchinaRepository lmr;
	
	@Autowired
	dpiRepository dpir;
	
	@Autowired
	vanocorsaRepository vcr;
	
	@Autowired
	cabinaRepository cr;
	
	@Autowired
	chiamataRepository chr;
	
	@Autowired
	ordinarioRepository orr;
	
	@Autowired
	semestraleRepository sr;
	
	@Autowired
	biennaleRepository br;
	
	@Autowired
	noteRepository nr;
	
	/**
	 * Effettua l'update dei dati di un manutentore
	 * 
	 * @param tempM string che contiene oggetto manutentore
	 */
	@RequestMapping("/updateManutentore")
	void updateManutentore(@RequestParam("manutentore") String tempM) {
		
		//trasformo la stringa json nel mio object desiderato
		ObjectMapper mapper = new ObjectMapper();
		Manutentore m = null;
		try {
				m = mapper.readValue(tempM, Manutentore.class);
			} catch (JsonParseException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		mr.save(m);

	}
	
	/**
	 * Ritorna un oggetto intervento ordinario partendo dall'id dell'impianto
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOrdinarioByImpId")
	Ordinario findOrdinarioByImpId(@RequestParam("id") long id) {
		
		
		ArrayList<Intervento> interventi = new ArrayList<>();
		interventi = intr.findAllValidById(id);
		
		return orr.findByInterventoId(interventi.get(2).getId()).get(0);
	}
	
	/**
	 * Ritorna un oggetto intervento semestrale partendo dall'id dell'impianto
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findSemestraleByImpId")
	Semestrale findSemestraleByImpId(@RequestParam("id") long id) {
		
		
		ArrayList<Intervento> interventi = new ArrayList<>();
		interventi = intr.findAllValidById(id);
		
		return sr.findByInterventoId(interventi.get(1).getId()).get(0);
	}
	
	/**
	 * Ritorna un oggetto intervento biennale partendo dall'id dell'impianto
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findBiennaleByImpId")
	Biennale findBiennaleByImpId(@RequestParam("id") long id) {
		
		
		ArrayList<Intervento> interventi = new ArrayList<>();
		interventi = intr.findAllValidById(id);
		
		return br.findByInterventoId(interventi.get(0).getId()).get(0);
	}
	
	/**
	 * Effettua la ricerca dei dati dei DPI di un impianto
	 * 
	 * @param id impianto id
	 * @return string contenente oggetto dpi
	 */
	@RequestMapping("/findDPIById")
	String findDPIById(@RequestParam("id") long id) {
		
		DPI dpi = dpir.findByImpiantoId(id).get(0);
		//trasformo il mio object in una stringa json
		String temp = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			temp = mapper.writeValueAsString(dpi);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}
	
	/**
	 * Effettua la ricerca dei dati del locale macchina di un impianto
	 * 
	 * @param id impianto id
	 * @return string contenente oggetto LocaleMacchina
	 */
	@RequestMapping("/findLMById")
	String findLMById(@RequestParam("id") long id) {
		
		LocaleMacchina lm = lmr.findByImpiantoId(id).get(0);
		//trasformo il mio object in una stringa json
		String temp = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			temp = mapper.writeValueAsString(lm);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}
	
	/**
	 * Effettua la ricerca dei dati del vano corsa di un impianto
	 * 
	 * @param id impianto id
	 * @return string contenente oggetto VanoCorsa
	 */
	@RequestMapping("/findVCById")
	String findVCById(@RequestParam("id") long id) {
		
		VanoCorsa vc = vcr.findByImpiantoId(id).get(0);
		//trasformo il mio object in una stringa json
		String temp = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			temp = mapper.writeValueAsString(vc);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}
	
	/**
	 * Effettua la ricerca dei dati della cabina di un impianto
	 * 
	 * @param id impianto id
	 * @return string contenente oggetto Cabina
	 */
	@RequestMapping("/findCabinaById")
	String findCabinaById(@RequestParam("id") long id) {
		
		Cabina cab = cr.findByImpiantoId(id).get(0);
		//trasformo il mio object in una stringa json
		String temp = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			temp = mapper.writeValueAsString(cab);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}
	
	/**
	 * Effettua l'update dei dati di un impianto
	 * 
	 * @param id impianto id
	 * @param ni numero impianto
	 * @param nm numero matricola
	 * @param p provincia
	 * @param cap cap
	 * @param via via/piazza
	 * @param portone portone
	 * @param az_id long che contiene l'id dell'azienda del manutentore
	 * @param dpi string che contiene oggetto DPI
	 * @param lm string che contiene oggetto LocaleMacchina
	 * @param vc string che contiene oggetto VanoCorsa
	 * @param cab string che contiene oggetto Cabina
	 * @param ordinario string che contiene oggetto Ordinario
	 * @param semestrale string che contiene oggetto Semestrale
	 * @param biennale string che contiene oggetto Biennale
	 */
	@RequestMapping("/updateImpianto")
	void updateImpianto(@RequestParam("id") long id,
			@RequestParam("ni") String ni,
			@RequestParam("nm") String nm,
			@RequestParam("p") String p,
			@RequestParam("cap") String cap,
			@RequestParam("via") String via,
			@RequestParam("portone") String portone,
			@RequestParam("az_id") long az_id,
			@RequestParam("dpi")String tempDPI,
			@RequestParam("lm")String tempLM,
			@RequestParam("vc")String tempVC,
			@RequestParam("cab")String tempCAB,
			@RequestParam("ordinario")String ordinario,
			@RequestParam("semestrale")String semestrale,
			@RequestParam("biennale")String biennale) {
		
		//trasformo la stringa json nel mio object desiderato
		ObjectMapper mapper = new ObjectMapper();
		DPI dpi = null;
		LocaleMacchina lm = null;
		VanoCorsa vc = null;
		Cabina cab = null;
		try {
			dpi = mapper.readValue(tempDPI, DPI.class);
			lm = mapper.readValue(tempLM, LocaleMacchina.class);
			vc = mapper.readValue(tempVC, VanoCorsa.class);
			cab = mapper.readValue(tempCAB, Cabina.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Impianto impianto = new Impianto(ni,nm,"",false,p,cap,via,portone);
		Azienda a = new Azienda();
		a.setId(az_id);
		impianto.setAzienda(a);
		impianto.setId(id);
		
		ir.save(impianto);
		
		dpi.setImpianto(impianto);
		lm.setImpianto(impianto);
		vc.setImpianto(impianto);
		cab.setImpianto(impianto);
		dpir.save(dpi);
		lmr.save(lm);
		vcr.save(vc);
		cr.save(cab);
			
			
		ArrayList<Intervento> interventi = intr.findAllValidById(impianto.getId());
		
		Date dt = null;
		
		dt = Date.valueOf(ordinario);
		interventi.get(2).setData(dt);
		intr.save(interventi.get(2));
		
		dt = Date.valueOf(semestrale);
		interventi.get(1).setData(dt);
		intr.save(interventi.get(1));
		
		dt = Date.valueOf(biennale);
		interventi.get(0).setData(dt);
		intr.save(interventi.get(0));
		
	}
	

}