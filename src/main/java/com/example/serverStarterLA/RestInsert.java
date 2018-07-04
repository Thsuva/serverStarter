package com.example.serverStarterLA;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.serverStarterLA.POJO.Azienda;
import com.example.serverStarterLA.POJO.Biennale;
import com.example.serverStarterLA.POJO.Cabina;
import com.example.serverStarterLA.POJO.Chiamata;
import com.example.serverStarterLA.POJO.DPI;
import com.example.serverStarterLA.POJO.Impianto;
import com.example.serverStarterLA.POJO.Intervento;
import com.example.serverStarterLA.POJO.LocaleMacchina;
import com.example.serverStarterLA.POJO.Manutentore;
import com.example.serverStarterLA.POJO.Note;
import com.example.serverStarterLA.POJO.Ordinario;
import com.example.serverStarterLA.POJO.Semestrale;
import com.example.serverStarterLA.POJO.Supervisore;
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
 * La classe RestInsert raccoglie le funzioni relative alle query da eseguire per l'inserimento dati della app
 * 
 * @author Jacopo Favaro
 *
 */
@RestController
public class RestInsert {
	
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
	noteRepository nr;
	
	@Autowired
	biennaleRepository br;

	/**
	 * Effettua l'inserimento di un nuovo manutentore
	 * 
	 * @param matricola
	 * @param name
	 * @param surname
	 * @param password
	 * @param tempAZ string che contiene oggetto azienda manutentore
	 * @param tempSUP string che contiene oggetto supervisore manutentore
	 */
	@RequestMapping("/addManutentore")
	void generateManutentore(@RequestParam("matricola") String matricola,
			@RequestParam("nome") String name,
			@RequestParam("cognome") String surname,
			@RequestParam("password") String password,
			@RequestParam("az") String tempAZ,
			@RequestParam("sup") String tempSUP) {
		
		Manutentore m = new Manutentore(matricola,password,name,surname);
		
		ObjectMapper mapper = new ObjectMapper();
		Azienda azienda = null;
		Supervisore supervisore = null;
		try {
			azienda = mapper.readValue(tempAZ, Azienda.class);
			supervisore = mapper.readValue(tempSUP, Supervisore.class);
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
		
		m.setAzienda(azienda);
		m.setSupervisore(supervisore);
		
		mr.save(m);
	}
	
	/**
	 * Effettua l'inserimento di un nuovo impianto, con tutti i relativi dati
	 * 
	 * @param ni numero impianto
	 * @param nm numero matricola
	 * @param p provincia
	 * @param cap cap
	 * @param via via/piazza
	 * @param portone portone
	 * @param tempAZ string che contiene oggetto azienda manutentore
	 * @param tempDPI string che contiene oggetto DPI
	 * @param tempLM string che contiene oggetto LocaleMacchina
	 * @param tempVC string che contiene oggetto VanoCorsa
	 * @param tempCAB string che contiene oggetto Cabina
	 * @param ordinario string che contiene oggetto Ordinario
	 * @param semestrale string che contiene oggetto Semestrale
	 * @param biennale string che contiene oggetto Biennale
	 */
	@RequestMapping("/addImpianto")
	void generateImpianto(@RequestParam("ni") String ni,
			@RequestParam("nm") String nm,
			@RequestParam("p") String p,
			@RequestParam("cap") String cap,
			@RequestParam("via") String via,
			@RequestParam("portone") String portone,
			@RequestParam("az") String tempAZ,
			@RequestParam("dpi")String tempDPI,
			@RequestParam("lm")String tempLM,
			@RequestParam("vc")String tempVC,
			@RequestParam("cab")String tempCAB,
			@RequestParam("ordinario")String ordinario,
			@RequestParam("semestrale")String semestrale,
			@RequestParam("biennale")String biennale){
		
		//trasformo la stringa json nel mio object desiderato
		ObjectMapper mapper = new ObjectMapper();
		Azienda azienda = null;
		DPI dpi = null;
		LocaleMacchina lm = null;
		VanoCorsa vc = null;
		Cabina cab = null;
		try {
			azienda = mapper.readValue(tempAZ, Azienda.class);
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
		impianto.setAzienda(azienda);
		
		ir.save(impianto);
		
		List<Impianto> imp =  ir.findByNumeroImpianto(ni);
		if(ni.isEmpty()) {
			
			System.out.println("Non e' possibile.");
			
		}else {
			System.out.println("/addImpianto id: "+imp.get(0).getId());
		}
		
		dpi.setImpianto(imp.get(0));
		lm.setImpianto(imp.get(0));
		vc.setImpianto(imp.get(0));
		cab.setImpianto(imp.get(0));
		dpir.save(dpi);
		lmr.save(lm);
		vcr.save(vc);
		cr.save(cab);
		
		Intervento interv = new Intervento();
		Date dt = null;
			dt = Date.valueOf(ordinario);
			interv.setData(dt);
			interv.setClosed(false);
			interv.setTipo("ORDINARIO");
			interv.setAzienda(imp.get(0).getAzienda());
			interv.setImpianto(imp.get(0));
			
			Intervento saved = intr.save(interv);
			
			
			Ordinario ord = new Ordinario();
			ord.setIntervento(saved);
			orr.save(ord);

		
		Intervento intervs = new Intervento();
		Date dts = null;

			dts = Date.valueOf(semestrale);
			intervs.setData(dts);
			intervs.setClosed(false);
			intervs.setTipo("SEMESTRALE");
			intervs.setAzienda(imp.get(0).getAzienda());
			intervs.setImpianto(imp.get(0));
			
			saved = intr.save(intervs);
			
			Semestrale sem = new Semestrale();
			sem.setIntervento(saved);
			sr.save(sem);
		
		Intervento intervb = new Intervento();
		Date dtb = null;

			dtb = Date.valueOf(biennale);
			intervb.setData(dtb);
			intervb.setClosed(false);
			intervb.setTipo("BIENNALE");
			intervb.setAzienda(imp.get(0).getAzienda());
			intervb.setImpianto(imp.get(0));
			
			saved = intr.save(intervb);
			
			Biennale bie = new Biennale();
			bie.setIntervento(saved);
			br.save(bie);
	}
	
	/**
	 * Effettua l'aggiunta di note ad un intervento concluso
	 * 
	 * @param note
	 */
	@RequestMapping("/addNote")
	void generateNote(@RequestParam("note") String note) {
		
		ObjectMapper mapper = new ObjectMapper();
		Note n = null;
		try {
			n = mapper.readValue(note, Note.class);
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
		
		List<Note> notes =  nr.findByInterventoId(n.getIntervento().getId());
		
		//se non sono già presenti note, salva normalmente...
		if(notes.isEmpty()) {

			nr.save(n);
			
		}else {//...altrimenti le sovrascrive

			String testo = n.getTesto();
			n = notes.get(0);
			n.setTesto(testo);
			n.setData(null);
			
			nr.save(n);
		}
		
	}
	
	/**
	 * Effettua la ricerca di un manutentore in base alla matricola
	 * 
	 * @param matricola
	 * @return
	 */
	@RequestMapping("/searchManutentore")
	String searchMatricolaManutentore(@RequestParam("matricola") String matricola) {
		
		List<Manutentore> manutentore =  mr.findByMatricola(matricola);
		if(manutentore.isEmpty()) {

			return matricola;
			
		}else {
			return null;
		}
	}
	
	/**
	 * Ricerca un impianto in base al numero impianto ed il numero matricola
	 * 
	 * @param ni numero impianto
	 * @param nm numero matricola
	 * @return string messaggio da stampare
	 */
	@RequestMapping("/searchImpianto")
	String searchImpianto(@RequestParam("ni") String ni,@RequestParam("nm") String nm) {
		
		String res = "";
		List<Impianto> impianto =  ir.findByNumeroImpianto(ni);
		
		if(impianto.isEmpty()) {
			impianto =  ir.findByNumeroMatricola(nm);
			
			if (!impianto.isEmpty()) res = "Numero matricola gia' utilizzato";
			
		}else {
			int size = impianto.size();
			impianto.addAll(ir.findByNumeroMatricola(nm));
			
			if (size < impianto.size()) res = "Numero impianto e numero matricola gia' utilizzati";
			
			else res = "Numero impianto gia' utilizzato";
		}
		
		return res;
	}
	
	/**
	 * Ricerca eventuali note già presenti per un intervento
	 * 
	 * @param id_intervento
	 * @return string contenente oggetto note
	 */
	@RequestMapping("/searchNote")
	String searchNote(@RequestParam("id_intervento") long id_intervento) {
		
		List<Note> notes =  nr.findByInterventoId(id_intervento);
		
		if(notes.isEmpty()) {

			return "";
			
		}else {
			//trasformo il mio object in una stringa json
			String temp = "";
			ObjectMapper mapper = new ObjectMapper();
			try {
				temp = mapper.writeValueAsString(notes.get(0));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return temp;
		}
	}
	
	/**
	 * Ricerca un intervento tramite tipo ed id
	 * 
	 * @param id
	 * @param tipo
	 * @return string contenente oggetto di tipo x
	 */
	@RequestMapping("/searchInterventoByType")
	String searchInterventoByType(@RequestParam("intervento_id") long id,@RequestParam("tipo") String tipo) {
		
		Chiamata ch = null;
		Ordinario or = null;
		Semestrale se = null;
		
		switch(tipo) {
		case "A CHIAMATA": {
			ch = chr.findByInterventoId(id).get(0);
			//trasformo il mio object in una stringa json
			String temp = "";
			ObjectMapper mapper = new ObjectMapper();
			try {
				temp = mapper.writeValueAsString(ch);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return temp;
		}
			
		case "ORDINARIO": {
			or = orr.findByInterventoId(id).get(0);
			//trasformo il mio object in una stringa json
			String temp = "";
			ObjectMapper mapper = new ObjectMapper();
			try {
				temp = mapper.writeValueAsString(or);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return temp;
		}
			
		case "SEMESTRALE": {
			se = sr.findByInterventoId(id).get(0);
			//trasformo il mio object in una stringa json
			String temp = "";
			ObjectMapper mapper = new ObjectMapper();
			try {
				temp = mapper.writeValueAsString(se);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return temp;
		}
		default:
			break;
		}
		
		
		return "";
	}

}