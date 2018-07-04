package com.example.serverStarterLA;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.serverStarterLA.POJO.Impianto;
import com.example.serverStarterLA.POJO.Intervento;
import com.example.serverStarterLA.POJO.biennaleRepository;
import com.example.serverStarterLA.POJO.chiamataRepository;
import com.example.serverStarterLA.POJO.impiantoRepository;
import com.example.serverStarterLA.POJO.interventoRepository;
import com.example.serverStarterLA.POJO.ordinarioRepository;
import com.example.serverStarterLA.POJO.semestraleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * La classe AppRestSearch raccoglie le funzioni relative alle query da eseguire per la ricerca dati della app Android
 * 
 * @author Jacopo Favaro
 *
 */
@RestController
public class AppRestSearch {

	
	@Autowired
	interventoRepository intr;
	
	@Autowired
	impiantoRepository ir;
	
	@Autowired
	chiamataRepository chr;
	
	@Autowired
	ordinarioRepository orr;
	
	@Autowired
	semestraleRepository sr;
	
	@Autowired
	biennaleRepository br;
	
	
	/**
	 * Trova gli interventi da mostrare nella homepage della app android
	 * 
	 * @param data data di oggi
	 * @return arraylist di oggetti intervento
	 */
	@RequestMapping("/findInterventiMese")
	ArrayList<Intervento> findInterventiMese(@RequestParam("data_oggi") String data) {

		Date date = Date.valueOf(data);
		
		return intr.findAllValid(date);
	}
	
	/**
	 * Trova gli impianti che devono generare un warning nella homepage della app
	 * 
	 * @return arraylist di oggetti impianto
	 */
	@RequestMapping("/findImpiantiWarning")
	ArrayList<Impianto> findImpiantiWarning() {

		ArrayList<Impianto> impianti = new ArrayList<>();
		impianti.addAll(ir.findAllValidByWarning(3));
		
		return impianti;
	}

	/**
	 * Effettua la ricerca di un documento di un intervento entro un determinato range temporale
	 * 
	 * @param id_m id manutentore
	 * @param id_i id impianto
	 * @param data data iniziale
	 * @param dataEnd data finale
	 * @param tipo tipologia
	 * @return list di oggetti intervento
	 */
	@RequestMapping("/appSearchDocumentoByParams")
	List<Intervento> searchDocumentoByParams(@RequestParam("manutentore_id") long id_m,
			@RequestParam("impianto_id") long id_i,@RequestParam("data_doc") String data,@RequestParam("data_doc_end") String dataEnd,
			@RequestParam("tipo_doc") String tipo) {
		
		List<Intervento> lint = null;
		
		lint = intr.findAllValidByParams(id_m,id_i,data,dataEnd,tipo);
		
		//se non ho trovato nulla il problema potrebbe essere che il documento non è stato compilato dal manutentore
		//di cui passo l'id, per cui effettuo la ricerca senza considerare il manutentore
		if (lint.isEmpty()) {
			lint = intr.findAllValidByParamsManNull(id_i,data,dataEnd,tipo);
			
			//se trovo qualcosa...
			if (!lint.isEmpty()) {
				List<Intervento> temp = new ArrayList<>();
				temp.addAll(lint);
				lint.clear();
				
				//...considero solo gli interventi con manutentore = null
				for (int i = 0;i<lint.size();i++) {
					
					if (temp.get(i).getManutentore() == null) lint.add(temp.get(i));
					
				}
				
				return lint;
			}
			
			else {
				lint.clear();
				return lint;
			}
		}

		else
			return lint;
	}
	
	/**
	 * Ritorna un oggetto di tipo "tipo", in base all'intervento di cui si passa l'id
	 * 
	 * @param tipo
	 * @param id intervento id
	 * @return stringa contenente un oggetto di tipo "tipo"
	 */
	@RequestMapping("/searchDatiIntByTipo")
	String searchDatiIntByTipo(@RequestParam("tipo") String tipo,@RequestParam("id") long id) {
		
		String res="";
		
		switch(tipo) {
		
			case "A CHIAMATA": {
				//trasformo il mio object in una stringa json
				ObjectMapper mapper = new ObjectMapper();
				try {
					res = mapper.writeValueAsString(chr.findByInterventoId(id).get(0));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "ORDINARIO": {
				//trasformo il mio object in una stringa json
				ObjectMapper mapper = new ObjectMapper();
				try {
					res = mapper.writeValueAsString(orr.findByInterventoId(id).get(0));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "SEMESTRALE": {
				//trasformo il mio object in una stringa json
				ObjectMapper mapper = new ObjectMapper();
				try {
					res = mapper.writeValueAsString(sr.findByInterventoId(id).get(0));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			default: break;
			
		
		}
		
		return res;
	}
	

}