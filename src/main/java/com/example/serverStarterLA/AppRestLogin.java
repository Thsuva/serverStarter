package com.example.serverStarterLA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.serverStarterLA.POJO.Manutentore;
import com.example.serverStarterLA.POJO.manutentoreRepository;

/**
 * La classe AppRestLogin raccoglie le funzioni relative alle query da eseguire per il login della app Android
 * 
 * @author Jacopo Favaro
 *
 */
@RestController
public class AppRestLogin {

	@Autowired
	manutentoreRepository mr;

	/**
	 * Effettua il check dei dati inseriti dal manutentore per effettuare il login
	 * 
	 * @param username
	 * @param password
	 * @return oggetto manutentore
	 */
	@RequestMapping("/doLoginManutentore")
	Manutentore doLoginManutentore(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		List<Manutentore> manutentore =  mr.findByMatricola(username);
		if(!manutentore.isEmpty() && manutentore.get(0).getPassword().equals(password)) {
			
			
			return manutentore.get(0);
			
		}else {//se non ho trovato corrispondenze, torno un manutentore con id = -1
			
			Manutentore temp = new Manutentore();
			temp.setId(-1);
			
			return temp;
		}
	}
	
	/**
	 * Effettua il controllo che l'id dell'utente loggato (salvato in Session nella app), corrisponda ad un id presente nel
	 * db. E' utile per effettuare un login automatico nel momento in cui l'utente non effettui esplicitamente il logout
	 * 
	 * @param id utente id
	 * @return oggetto manutentore
	 */
	@RequestMapping("/checkConsistence")
	Manutentore checkConsistence(@RequestParam("id") long id){
		
		List<Manutentore> manutentore =  mr.findById(id);
		if(!manutentore.isEmpty()) {
			
			return manutentore.get(0);
			
		}else {
			
			Manutentore temp = new Manutentore();
			temp.setId(-1);
			
			return temp;
		}
	}
	
}
