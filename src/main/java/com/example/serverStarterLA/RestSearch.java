package com.example.serverStarterLA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.serverStarterLA.POJO.Impianto;
import com.example.serverStarterLA.POJO.Intervento;
import com.example.serverStarterLA.POJO.Manutentore;
import com.example.serverStarterLA.POJO.cabinaRepository;
import com.example.serverStarterLA.POJO.dpiRepository;
import com.example.serverStarterLA.POJO.impiantoRepository;
import com.example.serverStarterLA.POJO.interventoRepository;
import com.example.serverStarterLA.POJO.localemacchinaRepository;
import com.example.serverStarterLA.POJO.manutentoreRepository;
import com.example.serverStarterLA.POJO.vanocorsaRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * La classe RestSearch raccoglie le funzioni relative alle query da eseguire per la ricerca nella app
 * 
 * @author Jacopo Favaro
 *
 */
@RestController
public class RestSearch {
	
	@Autowired
	manutentoreRepository mr;
	
	@Autowired
	impiantoRepository ir;
	
	@Autowired
	localemacchinaRepository lmr;
	
	@Autowired
	dpiRepository dpir;
	
	@Autowired
	vanocorsaRepository vcr;
	
	@Autowired
	cabinaRepository cr;
	
	@Autowired
	interventoRepository intr;
	
	/**
	 * Ricerca un manutentore attraverso i parametri inseriti. Se non ho un risultato preciso ne ottengo uno approssimato
	 * 
	 * @param manutentore
	 * @return list oggetti manutentore
	 */
	@RequestMapping("/searchManutentoreByParams")
	List<Manutentore> searchManutentoreByParams(@RequestParam("manutentore") String manutentore) {
		
		ObjectMapper mapper = new ObjectMapper();
		Manutentore m = null;
		List<Manutentore> lm = null;

		try {
			m = mapper.readValue(manutentore, Manutentore.class);
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
		
		if (!m.getMatricola().equals("")) lm = mr.findByMatricola(m.getMatricola());
		
		else if (!m.getCognome().equals("")) {
			
			lm = mr.findByCognome(m.getCognome());
			
			if (!m.getNome().equals("")) {
				
				List<Manutentore> templm = new ArrayList();
				templm.addAll(lm);
				lm.clear();
				Iterator<Manutentore> im = templm.iterator();
				int i = 0;
				
				while(im.hasNext()) {

					Manutentore temp = im.next();

					if (temp.getNome().equals(m.getNome())) {
						lm.add(temp);
					}
						
					i++;
				}
				
				//se non trova corrispondenze do un risultato approssimato
				if (lm.size() == 0) lm.addAll(templm);				
			}

		}
		
		else if (!m.getNome().equals("")) {
			lm = mr.findByNome(m.getNome());
		}
		
		if (lm == null) System.out.println("E' null");
			
		return lm;
	}
	
	/**
	 * Ricerca un impianto attraverso i parametri inseriti. Se non ho un risultato preciso ne ottengo uno approssimato
	 * 
	 * @param impianto
	 * @return list oggetti impianto
	 */
	@RequestMapping("/searchImpiantoByParams")
	List<Impianto> searchImpiantoByParams(@RequestParam("impianto") String impianto) {
		
		ObjectMapper mapper = new ObjectMapper();
		Impianto imp = null;
		List<Impianto> limp = null;
		
		try {
			imp = mapper.readValue(impianto, Impianto.class);
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
		
		
		
		if (!imp.getNumero_impianto().equals("")) limp = ir.findByNumeroImpianto(imp.getNumero_impianto());
		
		else if (!imp.getNumero_matricola().equals("")) limp = ir.findByNumeroMatricola(imp.getNumero_matricola());


		else {
			
			if (!imp.getProvincia().equals("")) limp = ir.findByProvincia(imp.getProvincia());
			
			if (!imp.getCAP().equals("")) {
				
				if (limp == null || limp.size() == 0) limp = ir.findByCap(imp.getCAP());
				
				List<Impianto> templimp = new ArrayList();
				templimp.addAll(limp);
				limp.clear();
				Iterator<Impianto> iimp = templimp.iterator();
				int i = 0;
				
				while(iimp.hasNext()) {

					Impianto temp = iimp.next();

					if (temp.getCAP().equals(imp.getCAP())) {
						limp.add(temp);
					}
						
					i++;
				}
				
				//se non trova corrispondenze do un risultato approssimato
				if (limp.size() == 0) limp.addAll(templimp);	
			}
			
			if (!imp.getVia().equals("")) {
				
				if (limp == null  || limp.size() == 0) limp = ir.findByVia(imp.getVia());
				
				List<Impianto> templimp = new ArrayList();
				templimp.addAll(limp);
				limp.clear();
				Iterator<Impianto> iimp = templimp.iterator();
				int i = 0;
				
				while(iimp.hasNext()) {

					Impianto temp = iimp.next();

					if (temp.getVia().equals(imp.getVia())) {
						limp.add(temp);
					}
						
					i++;
				}
				
				//se non trova corrispondenze do un risultato approssimato
				if (limp.size() == 0) limp.addAll(templimp);	
			}
			
			if (!imp.getPortone().equals("")) {
				
				if (limp == null  || limp.size() == 0) limp = ir.findByPortone(imp.getPortone());
				
				List<Impianto> templimp = new ArrayList();
				templimp.addAll(limp);
				limp.clear();
				Iterator<Impianto> iimp = templimp.iterator();
				int i = 0;
				
				while(iimp.hasNext()) {

					Impianto temp = iimp.next();

					if (temp.getPortone().equals(imp.getPortone())) {
						limp.add(temp);
					}
						
					i++;
				}
				
				//se non trova corrispondenze do un risultato approssimato
				if (limp.size() == 0) limp.addAll(templimp);	
			}
			

		}

			
		return limp;
	}
	
	/**
	 * Ricerca un documento attraverso i parametri inseriti. Se non ho corrispondenze precise do un risultato
	 * approssimato
	 * 
	 * @param manutentore
	 * @param impianto
	 * @param documento
	 * @return list oggetti intervento
	 */
	@RequestMapping("/searchDocumentoByParams")
	List<Intervento> searchDocumentoByParams(@RequestParam("manutentore") String manutentore,@RequestParam("impianto") String impianto,
			@RequestParam("documento") String documento) {
		
		ObjectMapper mapper = new ObjectMapper();
		Impianto imp = null;
		Manutentore man = null;
		Intervento interv = null;
		List<Intervento> lint = null;

		try {
			imp = mapper.readValue(impianto, Impianto.class);
			man = mapper.readValue(manutentore, Manutentore.class);
			interv = mapper.readValue(documento, Intervento.class);
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
		
		if (interv.getData() != null && !interv.getData().toString().equals("")) {
			
			lint = intr.findByData(interv.getData());
			
			if (lint.size() == 0) lint = intr.findByTipo(interv.getTipo());
			
			else {
				List<Intervento> templint = new ArrayList();
				templint.addAll(lint);
				lint.clear();
				Iterator<Intervento> iint = templint.iterator();
				
				while(iint.hasNext()) {

					Intervento temp = iint.next();

					if (temp.getTipo().equals(interv.getTipo())) {
						lint.add(temp);
					}

				}
				
				//se non trova corrispondenze do un risultato approssimato
				if (lint.size() == 0) lint.addAll(templint);
			}

		}
		
		if (lint == null) lint = intr.findByTipo(interv.getTipo());
		
		if (lint.size() > 0) {
			
			if (man != null) {
				List<Intervento> templint = new ArrayList();
				templint.addAll(lint);
				lint.clear();
				Iterator<Intervento> iint = templint.iterator();
				
				while(iint.hasNext()) {

					Intervento temp = iint.next();

					if (temp.getManutentore() != null && temp.getManutentore().getId() == man.getId()) {
						lint.add(temp);
					}

				}
				
				//se non trova corrispondenze do un risultato approssimato
				if (lint.size() == 0) lint.addAll(templint);
			}
			
			if (imp != null) {
				List<Intervento> templint = new ArrayList();
				templint.addAll(lint);
				lint.clear();
				Iterator<Intervento> iint = templint.iterator();
				
				while(iint.hasNext()) {

					Intervento temp = iint.next();

					if (temp.getImpianto().getId() == imp.getId()) {
						lint.add(temp);
					}
						

				}
				
				//se non trova corrispondenze do un risultato approssimato
				if (lint.size() == 0) lint.addAll(templint);
			}

			
		}
		
		//prendo solo i documenti salvati definitivamente
		List<Intervento> templint = new ArrayList();
		templint.addAll(lint);
		lint.clear();
		Iterator<Intervento> iint = templint.iterator();
		
		while(iint.hasNext()) {

			Intervento temp = iint.next();

			if (temp.isClosed()) {
				lint.add(temp);
			}

		}

		return lint;
	}


}