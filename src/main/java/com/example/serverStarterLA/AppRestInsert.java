package com.example.serverStarterLA;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.serverStarterLA.POJO.Biennale;
import com.example.serverStarterLA.POJO.Chiamata;
import com.example.serverStarterLA.POJO.Impianto;
import com.example.serverStarterLA.POJO.Intervento;
import com.example.serverStarterLA.POJO.Ordinario;
import com.example.serverStarterLA.POJO.Semestrale;
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
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * La classe AppRestInsert raccoglie le funzioni relative alle query da eseguire per l'inserimento dati della app Android
 * 
 * @author Jacopo Favaro
 *
 */
@RestController
public class AppRestInsert {
	
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
	 * Effettua l'udate dei dati di un intervento
	 * 
	 * @param intervento
	 * @param int_data data intervento
	 * @param impianto
	 * @return
	 */
	@RequestMapping("/updateDataInt")
	Chiamata updateDataInt(@RequestParam("intervento") String intervento,@RequestParam("int_data") String int_data,@RequestParam("impianto") String impianto) {
		
		ObjectMapper mapper = new ObjectMapper();
		Intervento interv = null;
		Intervento intSaved = null;
		Chiamata savedCh = null;
		long chId = -1;
		try {
			interv = mapper.readValue(intervento, Intervento.class);
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
		
		Impianto impiantoNew = null;

		try {
			impiantoNew = mapper.readValue(impianto, Impianto.class);
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
		

		ir.save(impiantoNew);
		
		//se l'intervento è del tipo a chiamata cerco se sia già presente
		if (interv.getTipo().equals("A CHIAMATA")) {
			ArrayList<Intervento> temp = intr.findAllValidByDataImpTipo(interv.getData(),interv.getImpianto().getId());
			
			//se è presente...
			if (!temp.isEmpty()) {
				
				//...e se non è già stato chiuso, prendo il suo id in modo da poterlo sovrascrivere
				if (!temp.get(0).isClosed()) {
					interv.setId(temp.get(0).getId());
					chId = chr.findByInterventoId(interv.getId()).get(0).getId();
					
				} else return new Chiamata();//altrimenti ritorno un oggetto vuoto
				
			}
				
		}
		
		//se l'intervento è chiuso, e non si tratta di uno a chiamata...
		if (!interv.getTipo().equals("A CHIAMATA") && interv.isClosed()) {
			Calendar cal = Calendar.getInstance();
			Date date = interv.getImpianto().getLastUpdateWarning();
			cal.setTime(date);
			cal.add(Calendar.MONTH, 1);
			date = new Date(cal.getTimeInMillis());
			
			//...se l'ultima volta che ho aggiornato lastupdatewarning  è più di un mese prima rispetto alla
			//data dell'intervento, azzero warning
			if (intr.findIntInMese(date, interv.getId()).isEmpty()) {
				Impianto imp = ir.findById(interv.getImpianto().getId()).get(0);
				
				imp.setWarning(0);
				
				ir.save(imp);
			}
		}
			
		intSaved = intr.save(interv);

		//a seconda del tipo di intervento compio diverse azioni
		switch (interv.getTipo()) {
			case "A CHIAMATA": {
				Chiamata ch = null;
				
				try {
					ch = mapper.readValue(int_data, Chiamata.class);
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
				ch.setIntervento(intSaved);
				
				//se l'intervento esisteva già, setto il suo id nel mio oggetto, in modo da poterlo
				//sovrascrivere
				if (chId != -1) ch.setId(chId);
				
				savedCh = chr.save(ch);
				
				//se l'intervento è chiuso...
				if (interv.isClosed()) {
					Calendar cal = Calendar.getInstance();
					Date date = interv.getImpianto().getLastUpdateWarning();
					cal.setTime(date);
					cal.add(Calendar.MONTH, 1);
					date = new Date(cal.getTimeInMillis());
					
					//...se l'ultima volta che ho aggiornato lastupdatewarning  è meno di un mese prima rispetto alla
					//data dell'intervento, incremento warning (vedi DRS)
					if (!intr.findIntInMese(date, interv.getId()).isEmpty()) {
						
						Impianto imp = ir.findById(interv.getImpianto().getId()).get(0);
						imp.setLastUpdateWarning(interv.getData());
						
						int temp = imp.getWarning()+1;
						
						imp.setWarning(temp);
						
						ir.save(imp);
					}
					
					//...altrimenti setto warning a 1
					else {
						Impianto imp = ir.findById(interv.getImpianto().getId()).get(0);
						imp.setLastUpdateWarning(interv.getData());
						imp.setWarning(1);
						
						ir.save(imp);
					}
				}
				
				
				
				break;
			}
			case "ORDINARIO": {
				Ordinario ord = null;
				try {
					ord = mapper.readValue(int_data, Ordinario.class);
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
				
				orr.save(ord);
				
				//se l'intervento ordinario è chiuso...
				if (interv.isClosed()) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(interv.getData());
					int i = 0;
					boolean ctrl = false;
					
					//...genero automaticamente il successivo...
					while (i < 3 && !ctrl) {
						cal.add(Calendar.MONTH, 1);
						cal.set(Calendar.DAY_OF_MONTH, 1);
						Date dataStart = new Date(cal.getTimeInMillis());
						
						cal.set(Calendar.DAY_OF_MONTH,Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
						Date dataEnd = new Date(cal.getTimeInMillis());

						//...controllo che nel mese in cui lo andrò a posizionare
						//non sia già presente un intervento semestrale o biennale per quell'impianto e, solo in questo caso,
						//lo creo, altrimenti continuo la ricerca
						if (intr.findTipoIntInMese(dataEnd, dataStart, "SEMESTRALE",interv.getImpianto().getId()).isEmpty() &&
								intr.findTipoIntInMese(dataEnd, dataStart, "BIENNALE",interv.getImpianto().getId()).isEmpty()) {
							Ordinario nuovoOrd = new Ordinario();
							Intervento nuovoInt = new Intervento();
							Intervento saved = new Intervento();
							cal.setTime(interv.getData());
							cal.add(Calendar.MONTH, i+1);
							System.out.println("Giro: "+(i+1));
							nuovoInt.setData(new Date(cal.getTimeInMillis()));
							nuovoInt.setClosed(false);
							nuovoInt.setTipo("ORDINARIO");
							nuovoInt.setAzienda(interv.getAzienda());
							nuovoInt.setImpianto(interv.getImpianto());
							
							saved = intr.save(nuovoInt);
							
							nuovoOrd.setIntervento(saved);
							orr.save(nuovoOrd);
							ctrl = true;
						}
						i++;
					}
					
				}

				break;
			}
			case "SEMESTRALE": {
				Semestrale sem = null;
				try {
					sem = mapper.readValue(int_data, Semestrale.class);
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
				sr.save(sem);
				
				//se l'intervento semestrale è chiuso...
				if (interv.isClosed()) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(interv.getData());

						cal.add(Calendar.MONTH, 6);
						cal.set(Calendar.DAY_OF_MONTH, 1);
						Date dataStart = new Date(cal.getTimeInMillis());
						
						cal.set(Calendar.DAY_OF_MONTH,Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
						Date dataEnd = new Date(cal.getTimeInMillis());

						//...ne genero uno nuovo controllando che nel mese in cui lo andrò a posizionare non sia già presente
						//un intervento biennale...
						if (intr.findTipoIntInMese(dataEnd, dataStart, "BIENNALE",interv.getImpianto().getId()).isEmpty()) {
							Semestrale nuovoSem = new Semestrale();
							Intervento nuovoInt = new Intervento();
							Intervento saved = new Intervento();
							cal.setTime(interv.getData());
							cal.add(Calendar.MONTH, 6);
							
							nuovoInt.setData(new Date(cal.getTimeInMillis()));
							nuovoInt.setClosed(false);
							nuovoInt.setTipo("SEMESTRALE");
							nuovoInt.setAzienda(interv.getAzienda());
							nuovoInt.setImpianto(interv.getImpianto());
							
							saved = intr.save(nuovoInt);
							
							nuovoSem.setIntervento(saved);
							sr.save(nuovoSem);
						} else {//...altrimenti il semestrale viene rinviato di altri 6 mesi
							Semestrale nuovoSem = new Semestrale();
							Intervento nuovoInt = new Intervento();
							Intervento saved = new Intervento();
							cal.setTime(interv.getData());
							cal.add(Calendar.MONTH, 12);
							
							nuovoInt.setData(new Date(cal.getTimeInMillis()));
							nuovoInt.setClosed(false);
							nuovoInt.setTipo("SEMESTRALE");
							nuovoInt.setAzienda(interv.getAzienda());
							nuovoInt.setImpianto(interv.getImpianto());
							
							saved = intr.save(nuovoInt);
							
							nuovoSem.setIntervento(saved);
							sr.save(nuovoSem);
						}

					
				}
				
				break;
			}
			case "BIENNALE": {
				
				//se l'intervento biennale è chiuso ne genero uno nuovo
				if (interv.isClosed()) {
					Calendar cal = Calendar.getInstance();
					Biennale nuovoBie = new Biennale();
					Intervento nuovoInt = new Intervento();
					Intervento saved = new Intervento();
					cal.setTime(interv.getData());
					cal.add(Calendar.YEAR, 2);
					
					nuovoInt.setData(new Date(cal.getTimeInMillis()));
					nuovoInt.setClosed(false);
					nuovoInt.setTipo("BIENNALE");
					nuovoInt.setAzienda(interv.getAzienda());
					nuovoInt.setImpianto(interv.getImpianto());
					
					saved = intr.save(nuovoInt);
					
					nuovoBie.setIntervento(saved);
					br.save(nuovoBie);	
				}
				
				break;
			}
			default: break;
		}
		
		//impedisco alla funzione chiamata dalla app di andare in onFailure, inviando un oggetto vuoto invece che un
		//eventuale puntatore a null
		if (savedCh == null) savedCh = new Chiamata();
		
		return savedCh;
		
	}


}